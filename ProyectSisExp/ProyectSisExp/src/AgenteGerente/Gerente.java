
package AgenteGerente;


import jade.core.*;
import jade.core.behaviours.*;
import jade.lang.acl.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
 
public class Gerente extends Agent
{
    String nombre = "Gerente";
    public static Gerente main;
    
    private static ServerSocket servidor; //
    private static Socket conexion; //Socket para conectarse con el cliente
    
    
    class GerenteComportaminento extends SimpleBehaviour
    {
        VentanaGerente ven = VentanaGerente.vnt;
        
        
        boolean fin = false;
        @Override
        public void action()
        {
            // COPIADO DE LA CLASE EJECUTIVO
                               
                
                System.out.println(" Preparandose para recibir______________________________");
                
                ven.setJTextArea1("Inicio el día, estoy activo");
                
                ThreadEnvia.enviarDatos("Inicio el día, estoy activo");
                
                //Enviar por socket.
                 doWait(2000);
                 
            //Obtiene el primer mensaje de la cola de mensajes
                //ACLMessage mensaje = receive();
                 ACLMessage mensaje = blockingReceive();
                if (mensaje!= null)
                {
                    System.out.println(getLocalName() + ": acaba de recibir el siguiente mensaje: ");
                    System.out.println(mensaje.toString());
               
                    
                      // Envia constestación forma 2
                    ven.setJTextArea1("Hola Ejecutivo. \n He recibido su petición de autorizacion \n de la cuenta AA4587ET878");
                    
                    doWait(5000);
                    
                   // System.out.println(getLocalName() +": Enviando contestacion");
                    ven.setJTextArea1("Espera un minuto, Estoy autorizando \n la cuenta AA4587ET878");
                    
                    doWait(7000);
                    
                    ven.setJTextArea1("..........................");
                    
                    doWait(4000);
                    
                    ACLMessage respuesta = mensaje.createReply();
                    respuesta.setPerformative( ACLMessage.INFORM );
                    respuesta.setContent( "He terminado. La cuenta AA4587ET878 fue autorizada" );
                    ven.setJTextArea1("He terminado. La cuenta AA4587ET878 \n  fue autorizada");
                    
                    doWait(5000);
                    
                    ven.setJTextArea1("Hasta la proxima Ejecutivo :-)");
                    
                    doWait(2000);
                    
                    ven.setJTextArea1("");
                    
                    send(respuesta);
                    System.out.println(getLocalName() +": Enviando Bien a receptor");
                    System.out.println(respuesta.toString());
                    fin = true;

                    doDelete();//Se elimina
                     
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
        cadena=cadena+"127.0.0.1:";
        //Iterator it=infoAgente.getAllAddresses();
        
        addBehaviour(new GerenteComportaminento());
    }
}
