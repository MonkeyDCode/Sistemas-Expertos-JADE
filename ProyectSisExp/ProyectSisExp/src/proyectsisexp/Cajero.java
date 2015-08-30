    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectsisexp;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package comunicacion;

import jade.core.*;
import jade.core.behaviours.*;
import jade.lang.acl.*;
import java.awt.Desktop;
import java.io.File;
import java.util.Iterator;
import javax.swing.JOptionPane;
 
public class Cajero extends Agent
{
    String nombre = "Cajero";
    public static String cantidad = null;
    String nombrecliente= "cliente";
    
    class CajeroComportaminento extends SimpleBehaviour
    {
        
        Ventana ven = Ventana.vnt;
        
        boolean fin = false;
        @Override
        public void action()
        {
            
                    String respuestaCliente = "";
                
                System.out.println(" Preparandose para recibirC______________________________");
                
                ven.setJTxtArea5("Inicio el día, estoy listo");
                
                 doWait(2000);
                 

                 ACLMessage mensaje = blockingReceive();
                if (mensaje!= null)
                {
                    System.out.println(getLocalName() + ": acaba de recibir el siguiente mensaje: ");
                    System.out.println(mensaje.toString());
                    
                    
                    
                     ven.setJTxtArea5("Hola Mostrador. \n Ahora lo antiendo... ");
                    ThreadEnvia.enviarDatos(fotosOntology.RECIBIR_FOTO);
                    doWait(3500);
                    
                    ven.setJTxtArea5("Cuenta con una cantidad \n mayor o igual a 10 \n S -> SI \n N-> NO");
                    
                    respuestaCliente = "";
                    
                    while(!respuestaCliente.equals("S") && !respuestaCliente.equals("N") ){
                    doWait(3500);
                        respuestaCliente = ven.getJtextField1(); //verifica si ya hay una respuesta                 
                    
                    }
                    
                    if(respuestaCliente.equals("N")){
                        ven.setJTxtArea5("Su impresion no se puede realizar,\n NO cuenta con la cantidad requerida, \n REGRESE DESPUÉS");
                        
                        doWait(4100);
                        
                        ven.setJTxtArea5("");
                        //ven.setJTxtArea4("");
                        ven.setJTxtArea2("");
                        
                        doDelete();
                    }else{
                    
                    
                    ven.setJTxtArea5("deposite 10 pesos\n No regreso cambio");
                    
                    
                    
                    doWait(4000);
                    boolean ban = false;
                    
                    while( (respuestaCliente.equals("") || respuestaCliente.length() > 0 ) && ban == false){
                        doWait(2000);
                        respuestaCliente = ven.getJtextField1(); //verifica si ya hay respuesta
                        
                        try{
                            int a = Integer.parseInt(respuestaCliente);
                            ban = true;
                            
                            if(a < 10 ){
                                
                              ven.setJTxtArea5("La cantidad "+respuestaCliente +" es menor a 10");
                                
                                ban = false;
                            }else{
                                ban = true;
                            }
                            
                        }catch(Exception e){
                            ban = false;
                            
                           ven.setJTxtArea5("Cantidad incorrecta, Ingrese nuevamente");
                        }
                    }
                    
                    /*
                    
                   while(Integer.parseInt(respuestaCliente) < 1000){
                    doWait(2000);
                    respuestaCliente = ven.getJtextField1(); //verifica si ya hay respuesta
                        }*/
                   doWait(3500);
                    
                   ven.setJTxtArea5("Bien. recibo $"+ respuestaCliente);
                   
                   cantidad = respuestaCliente;
                   
                     //respuestaCliente = ""; //limpia variable.
                     
                     doWait(4500);
                     
                     ven.setJTxtArea5("Espere un minuto");
                    
                    doWait(2500);
                     
                   // System.out.println(getLocalName() +": Enviando contestacion");
                    ven.setJTxtArea5(". . . . . . . . . . ");
                    
                    doWait(1500);
                    
                    ven.setJTxtArea5("Bien. Se han depósitado \n  - $"+ respuestaCliente + " ");
                    
                    doWait(5000);
                    
                    nombrecliente = JOptionPane.showInputDialog("Por favor escriba su nombre"); 
                    
                    
                    ReportePDF reporte = new ReportePDF(nombrecliente);
                    
                    
                    ven.setJTxtArea5("Su Tramite ha finalizado \nconrrectamente. \nrecoja su imagen:");
                    
                    
                    doWait(4000);
                    
                    
                    
                    ven.setJTxtArea5("Gracias por su preferencia.");
                    
                    doWait(2000);
                     try {
                        File file = new File("/root/Documents/reporte.pdf");
                        Desktop.getDesktop().open(file);
                        File file2 = new File("/root/Documents/imagen.png");
                        Desktop.getDesktop().open(file2);
                        
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                    
                    //ven.dispose();
                    
                    //Ventana.vnt.setVisible(true);
                    // Ventana.vnt.pack();
      //  vnt.setVisible(true);
                    //ControlAgentes ctr = new ControlAgentes();
                    
                    ACLMessage respuesta = mensaje.createReply();
                    respuesta.setPerformative( ACLMessage.INFORM );
                    respuesta.setContent( "Mostrador, He hecho el trabajo" );
                   /// ven.setJTxtArea4("He terminado. La cuenta AA4587ET878 \n  fue autorizada");
                    ThreadEnvia.enviarDatos(fotosOntology.COMPRAR_FOTO);
                    
                    ven.setJTxtArea5("");
                    
                    send(respuesta);
                    System.out.println(getLocalName() +": Enviando Bien a receptor");
                    System.out.println(respuesta.toString());
                    fin = true;
                              
                }//no tubo dinero
                    
                }
            
        }
 
        @Override
        public boolean done()
        {
            return fin;
        }
    }
    @Override
    protected void setup()
    {
        String cadena;
        AID infoAgente=this.getAID();
        
        cadena=String.format("Experto en %s%n", nombre);
        cadena=cadena+"127.0.0.1";
        //Iterator it=infoAgente.getAllAddresses();
        
        addBehaviour(new CajeroComportaminento());
    }
}