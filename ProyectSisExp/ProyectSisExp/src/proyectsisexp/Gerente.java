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
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class Gerente extends Agent
{
    String nombre = "Gerente";
    
    
     private static ServerSocket servidor; //
    private static Socket cliente; //Socket para conectarse con el cliente
    // private static String ip = "192,168.1.2"; //ip a la cual se conecta
   // private static String ip = "127.0.0.1"; //ip a la cual se conecta
     private static String ip = "127.0.0.1"; //ip a la cual se conecta
    
    public static Gerente main;
    
    class GerenteComportaminento extends SimpleBehaviour
    {
        
        Ventana ven = Ventana.vnt;
        
        boolean fin = false;
        @Override
        public void action()
        {
     /*       System.out.println(getLocalName() +": Preparandose para enviar un mensaje a receptor");
            AID id = new AID();
            id.setLocalName("receptor");
 
        // Creación del objeto ACLMessage
            ACLMessage mensaje = new ACLMessage(ACLMessage.REQUEST);
 
        //Rellenar los campos necesarios del mensaje
            mensaje.setSender(getAID());
            mensaje.setLanguage("Español");
            mensaje.addReceiver(id);
            mensaje.setContent("Hola, que tal receptor ?");
 
        //Envia el mensaje a los destinatarios
            send(mensaje);
 
            System.out.println(getLocalName() +": Enviando hola a receptor");
            System.out.println(mensaje.toString());
           // fin = true; // Aquí da por terminada la acción del emisor
            
            //Espera la respuesta
            ACLMessage mensaje2 = blockingReceive();
            if (mensaje2!= null)
            {
                System.out.println(getLocalName() + ": acaba de recibir el siguiente mensaje: ");
                System.out.println(mensaje2.toString());
                fin = true;
            }
            
            */
            // COPIADO DE LA CLASE EJECUTIVO
            doWait(4000);
                
                System.out.println(" Preparandose para recibir______________________________");
                
                //ven.setJTxtArea4("Inicio el día, estoy activo");
                  ThreadEnvia.enviarDatos("Inicio el día, estoy activo");
                 doWait(2000);
                 
            //Obtiene el primer mensaje de la cola de mensajes
                //ACLMessage mensaje = receive();
                 ACLMessage mensaje = blockingReceive();
                if (mensaje!= null)
                {
                    System.out.println(getLocalName() + ": acaba de recibir el siguiente mensaje: ");
                    System.out.println(mensaje.toString());
                    
                     // Envia constestación
                  //  System.out.println(getLocalName() +": Enviando contestacion");
                 //   ACLMessage respuesta = new ACLMessage( ACLMessage.INFORM );
                   // respuesta.setContent( "Bien" );
                  //  respuesta.addReceiver( mensaje.getSender() );
                  //  send(respuesta);
                  //  System.out.println(getLocalName() +": Enviando Bien a emisor");
                  //  System.out.println(respuesta.toString());
                  //  fin = true;*/
                    
                      // Envia constestación forma 2
                    //ven.setJTxtArea4("Hola Ejecutivo. \n He recibido su petición de autorizacion \n de la cuenta AA4587ET878");
                     ThreadEnvia.enviarDatos("Hola Ejecutivo. \n He recibido su petición de autorizacion \n de la cuenta AA4587ET878");
                    
                    doWait(5000);
                    
                   // System.out.println(getLocalName() +": Enviando contestacion");
                    //ven.setJTxtArea4("Espera un minuto, Estoy autorizando \n la cuenta AA4587ET878");
                    ThreadEnvia.enviarDatos("Espera un minuto, Estoy autorizando \n la cuenta AA4587ET878");
                    doWait(7000);
                    
                    //ven.setJTxtArea4("Espere ..........................");
                    ThreadEnvia.enviarDatos("Espere ..........................");
                    
                    doWait(4000);
                    
                    ACLMessage respuesta = mensaje.createReply();
                    respuesta.setPerformative( ACLMessage.INFORM );
                    respuesta.setContent( "He terminado. La cuenta AA4587ET878 fue autorizada" );
                    //ven.setJTxtArea4("He terminado. La cuenta AA4587ET878 \n  fue autorizada");
                    ThreadEnvia.enviarDatos("He terminado. La cuenta AA4587ET878 \n  fue autorizada");
                    
                    doWait(5000);
                    
                    //ven.setJTxtArea4("Hasta la proxima Ejecutivo :-)");
                    ThreadEnvia.enviarDatos("Hasta la proxima Ejecutivo :-)");
                    doWait(2000);
                    
                    //ven.setJTxtArea4("");
                    ThreadEnvia.enviarDatos("");
                    
                    send(respuesta);
                    System.out.println(getLocalName() +": Enviando Bien a receptor");
                    System.out.println(respuesta.toString());
                    fin = true;

                    doDelete();//Se elimina
                     
                }/*else{
                    System.out.println("Receptor: Esperando a recibir mensaje...");
                    block();
                }*/
            
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
        
         // -*-*-*-
    
            ExecutorService executor = Executors.newCachedThreadPool(); //Para correr los threads

        try{
           // main.mostrarMensaje("Buscando Servidor ...");
            cliente = new Socket(InetAddress.getByName(ip), 1111); //comunicarme con el servidor
          //  main.mostrarMensaje("Conectado a :" + cliente.getInetAddress().getHostName());


            //Ejecucion de los Threads
            executor.execute(new ThreadRecibe(cliente, main));
            executor.execute(new ThreadEnvia(cliente, main));

        } catch (IOException ex) {
            Logger.getLogger(Ejecutivo.class.getName()).log(Level.SEVERE, null, ex);
        } //Fin del catch
        finally {
        }
        executor.shutdown();
    
    
    // *-*-*-*
        
        addBehaviour(new GerenteComportaminento());
    }
}
