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
import jade.domain.FIPANames;
import jade.lang.acl.*;
import jade.proto.AchieveREResponder;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
 
public class Ejecutivo extends Agent
{
    private static final String debito = "D";
    private static final String credito = "C";
    public static String nombreCliente = null;
    public static String direccionCliente = null;
                Conector c =new Conector();

    
    public String nombre = "Ejecutivo"; 
    
        ///para el socket
    
    	;
    
    
    
  public class EjecutivoComportaminento extends SimpleBehaviour
  {
            
            public int opcion,opc;
            private boolean fin = false;
            BufferedImage imagen;
           // @Override
            
            public void action()
            {
         //   ThreadEnvia th = new ThreadEnvia();   
                
         String respuestaCliente = "";
        Ventana ven = Ventana.vnt;
        System.out.println("Bienvenido. ¿En que le puedo servir?");
        //Ventana.vnt.setJTxtArea2("Bienvenido. ¿En que le puedo servir?");
        ven.setJTxtArea2("Bienvenido. ¿En que le puedo servir? \n IF -> Imprimir Fotografias");
   //   ThreadEnvia.enviarDatos("Bienvenido. ¿En que le puedo servir? \n AC -> Abrir una cuenta bancaria"); //se envia el mensaje
       
        //Espera por contestacion del cliente
        while(!respuestaCliente.equals("IF")){
            doWait(3000);
            respuestaCliente = ven.getJtextField1(); //verifica si ya hay respuesta
        }
        respuestaCliente = ""; //limpia variable.
        
        ven.setJTxtArea2("Correcto. ¿Desde donde desea imprimir? \n D -> Dispositivo USB \n C -> Camara de rollo");
        // \n C -> Cuenta de Crédito 
        //ThreadEnvia.enviarDatos("Correcto. ¿Qué tipo de cuenta desea abrir?  \n C -> Cuenta de Crédito \n D -> Cuenta de Débito");
        
        //ven.setJTxtArea4("");
        ven.setJTxtArea5("");
        //Espera nuevamente por la contestacion
        while(!respuestaCliente.equals("D") && !respuestaCliente.equals("C")){
            doWait(3000);
            respuestaCliente = ven.getJtextField1(); //verifica si ya hay una respuesta
            
            if(respuestaCliente.equals("C") ){
                ven.setJTxtArea2("Lo siento. Nuestro Local aun no tiene la \n capacidad de ofrecer este servicio \n Desea Imprimir desde dispositivo USB \n S -> De acuerdo \n N -> Desacuerdo");
                
                while(!respuestaCliente.equals("S") && !respuestaCliente.equals("N") ){
                    respuestaCliente = ven.getJtextField1(); //verifica si ya hay una respuesta
                    doWait(3500);
                    
                }
                
                if(respuestaCliente.equals("S") ){
                        respuestaCliente = "D";
                    }else{
                      ven.setJTxtArea2("Sentimos no poder servirle, Adios."); 
                      
                      
                      
                      doWait(4000);
                      
                       ven.setJTxtArea2("");
                       //ven.setJTxtArea4("");
                       ven.setJTxtArea5("");
                      
                    doDelete();
                    //respuestaCliente = "X";
                    }
                
              
            }
            
        }
        
        
        
        if(respuestaCliente.equals(debito)){
            
            respuestaCliente = "";
           ven.setJTxtArea2("Bien. Para Imprimir desde USB \n necesita presentar alguna opción \n de la siguiente lista : ");
           
           doWait(2500);
           
           ven.setJTxtArea2("Seleccione una opción: \nA -> Cámara USB. \nB -> Memoria USB \nC -> Otro dispositivo ");
           
           while(!respuestaCliente.equals("A") && !respuestaCliente.equals("B") && !respuestaCliente.equals("C") ){
            doWait(3000);
            respuestaCliente = ven.getJtextField1(); //verifica si ya hay una respuesta
        }

           ven.setJTxtArea2("Selecciono la opción "+ respuestaCliente);
           
           doWait(2000);
          
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & GIF Images", "jpg", "gif");
            chooser.setFileFilter(filter);
            String ruta=null;
            File archivo=null;
            int seleccion = chooser.showDialog(null, "Abrir!");
            switch(seleccion) {
                    case JFileChooser.APPROVE_OPTION:
                             archivo = chooser.getSelectedFile();

                            //y guardar una ruta

                            ruta= archivo.getPath();
                     break;

                    case JFileChooser.CANCEL_OPTION:
                     //dio click en cancelar o cerro la ventana
                     break;

                    case JFileChooser.ERROR_OPTION:
                     //llega aqui si sucede un error
                     break;
            }   
            
           opcion=1;
           while(opcion != 0){
           try{
               imagen = ImageIO.read(archivo);
                ImageIcon icon = new ImageIcon(imagen);
                opcion= JOptionPane.showConfirmDialog(null,"Esta es tu imagen ?", "Selecciona la opción", 0,0, icon);
           if(opcion == JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "Perfecto!. Gracias");
                opcion =0;
                
           }else if(opcion == JOptionPane.NO_OPTION)
           {
               seleccion = chooser.showDialog(null, "Abrir!");
                    switch(seleccion) {
                    case JFileChooser.APPROVE_OPTION:
                            archivo = chooser.getSelectedFile();

                            //y guardar una ruta

                            ruta= archivo.getPath();
                     break;

                    case JFileChooser.CANCEL_OPTION:
                     //dio click en cancelar o cerro la ventana
                     break;

                    case JFileChooser.ERROR_OPTION:
                     //llega aqui si sucede un error
                     break;
                    }
           }
           }catch(Exception e)
           {
               JOptionPane.showMessageDialog(null, "Sin esta información no podemos continuar con su trámite. Gracias");
               System.exit(0);
               opcion=0;
           }
           }
           
           ven.setJTxtArea2("Espere un minuto mientras reviso \n su imagen...");
           
           doWait(4000);
           
            ven.setJTxtArea2("Su imagen es correcta, \n se está editando su imagen \n por el diseñador ...");
            
            doWait(3000);
            
            ven.setJTxtArea2("");
            
            doWait(1000);
             ven.setJTxtArea2("Hola, que tal Diseñador? necesito \n que edites esta imagen ");
          doWait(3000);
             /* ven.setJTxtArea2("Hola Gerente, \n necesito que me autorices la \n \n cuenta AA4587ET878, gracias");
            
            */
          //doWake();
           // EjecutivoComportaminento.action();
            
        }
        
                
            System.out.println(getLocalName() +": Preparandose para enviar un mensaje a receptor");
            

        //Envia el mensaje a los destinatarios
            //send(mensaje);
            
            ThreadEnvia.enviarDatos(fotosOntology.ENVIAR_FOTO);
            BufferedImage imagenew;
            iniciarSocket(imagen);
            imagenew=socketServer();
            
            //String respuesta=c.getA();
                     
            
            ven.setJTxtArea2("");
            System.out.println(getLocalName() +": Enviando hola a receptor");
            //System.out.println(mensaje.toString());
            //fin = true; // Aquí da por terminada la acción del emisor
            
            //Espera la respuesta
            //ACLMessage mensaje2 = blockingReceive();
            if (imagenew!=null)
            {
                ImageIcon icon = new ImageIcon(imagenew);
                ven.setJTxtArea2("Mil gracias Diseñador. ");
                opcion= JOptionPane.showConfirmDialog(null,"Esta será la imagen a imprimir", "Selecciona la opción", 0,0, icon);
                if(opcion == JOptionPane.YES_OPTION){
                        JOptionPane.showMessageDialog(null, "Perfecto!. Gracias");
                        guardarImagen(imagenew);
                        System.out.println(getLocalName() + ": acaba de recibir el siguiente mensaje  _.._ : \n ");
                 
                                doWait(3000);

                                ven.setJTxtArea2("Gracias por esperar, \n su impresión \n ha sido autorizada ");

                                doWait(4000);
                                if(imagenew!=null)
                                {

                                }

                                ven.setJTxtArea2("Ahora debe depósitar \n 10 pesos en la maquina expendedora ");

                                doWait(3500);

                                ven.setJTxtArea2(" Adios ");

                                doWait(2000);

                                ven.setJTxtArea2("");



                                // *-*-*-*--*-*- COMUNICACION CON EL CAJERO


                                 AID id2 = new AID();
                                 id2.setLocalName("Cajero");

                                ACLMessage mensaje3 = new ACLMessage(ACLMessage.REQUEST);

                        //Rellenar los campos necesarios del mensaje
                            mensaje3.setSender(getAID());
                            mensaje3.setLanguage("Español");
                            mensaje3.addReceiver(id2);
                            mensaje3.setContent("Hola, que tal Maquina? \n podrías atender a mi cliente");

                            ven.setJTxtArea2("Hola, que tal Maquina? \n podrías atender a mi cliente, \n su numero de imagen es  \n la AA4587ET878");

                            send(mensaje3);
                            ThreadEnvia.enviarDatos(fotosOntology.IMPRIMIR_FOTO);
                            doWait(2500);

                             ven.setJTxtArea2("");

                            System.out.println(getLocalName() +": Enviando hola a receptor");
                            System.out.println(mensaje3.toString());
                           // fin = true; // Aquí da por terminada la acción del emisor

                            //Espera la respuesta
                            ACLMessage mensaje4 = blockingReceive();
                            if (mensaje4!= null)
                            {
                                System.out.println(getLocalName() + ": acaba de recibir el siguiente mensaje  _ maquina - : ");
                                fin = true;
                                }
                        
                        
                        
                }else if(opcion == JOptionPane.NO_OPTION)
                {
                     ven.setJTxtArea2("Ha ocurrdio un error\n regrese más tarde ");
                }
                
            
            } 
            else
            {
               System.out.println("no regresó nada");
               ven.setJTxtArea2("Ha ocurrdio un error\n regrese más tarde "); 
            }
                
                // -----------------
     
            }
            @Override
            public boolean done()
            {
                return fin;
            }
    }
  
  public void guardarImagen(BufferedImage buferdeimagen) {
        try {
            String ruta="";
            File archivo = null;

            ImageIO.write(buferdeimagen, "png", new File("/root/Documents/imagen.png"));

            
            //creamos un caso para saber como se debe guardar la imagen
            
        } catch (IOException ex) {
            System.out.println("");        }     
     }
    

  
  
    @Override
    protected void setup()
    {
        
         String cadena;
        AID infoAgente=this.getAID();
        
        cadena=String.format("Experto en %s%n", nombre);
        cadena=cadena+"127.0.0.1:";
        //Iterator it=infoAgente.getAllAddresses();
        
        addBehaviour(new EjecutivoComportaminento());
        

        
    }
    
    @SuppressWarnings("empty-statement")
    public BufferedImage iniciarSocket(BufferedImage image)
	{
            Socket cliente;
            int puerto = 8000;
            String ip = "10.0.0.3";
            //ObjectInputStream entrada, teclado;
            ObjectOutputStream salida;
		try{
	
			cliente = new Socket(ip, puerto);
                        System.out.println("probando conexión");                        
                        ImageIO.write(image, "png", cliente.getOutputStream());
                        System.out.println("envio correcto");
			cliente.close();
                        return null;
			
		}catch(Exception e){
                    System.out.println(e.getMessage());
                    
                };
                return null;
	}
    
    public BufferedImage socketServer() 
    {
        try
        {
        ServerSocket server= new ServerSocket(9000);
        Socket conexion = server.accept();
        BufferedImage imagen= ImageIO.read(conexion.getInputStream()); 
        conexion.close();
        ImageIcon icon = new ImageIcon(imagen);
        return imagen;
        }
        catch(Exception e)
        {
            System.out.println("no funciono :c");
        }
        
        return null;
    }
   
    
 
    class ComprobarResponder extends AchieveREResponder {
        public ComprobarResponder(Agent agente, MessageTemplate plantilla) {
            super(agente, plantilla);
        }
    }
}