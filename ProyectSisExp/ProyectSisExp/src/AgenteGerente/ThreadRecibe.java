package AgenteGerente;
 
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class ThreadRecibe implements Runnable {
    private final VentanaGerente main;
    private String mensaje;
    private ObjectInputStream entrada;
    private Socket cliente;
   
   
   //Inicializar chatServer y configurar GUI
   public ThreadRecibe(Socket cliente, VentanaGerente main){
       this.cliente = cliente;
       this.main = main;
   }  
 
    public void mostrarMensaje(String mensaje) {
       // main.areaMuestraParametrosCliente.append(mensaje);
        System.out.println("Mensaje desde cliente. -> "+mensaje);
    }
   
    public void run() {
        try {
            entrada = new ObjectInputStream(cliente.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ThreadRecibe.class.getName()).log(Level.SEVERE, null, ex);
        }
        do { //procesa los mensajes enviados dsd el servidor
            try {//leer el mensaje y mostrarlo
                mensaje = (String) entrada.readObject(); //leer nuevo mensaje
               // main.mostrarMensaje(mensaje);
                System.out.println("****---" + mensaje);
                main.setJTextArea1(mensaje);
            } //fin try
            catch (SocketException ex) {
            }
            catch (EOFException eofException) {
                //main.mostrarMensaje("Fin de la conexion");
                System.out.println("Fin de la conexion");
                break;
            } //fin catch
            catch (IOException ex) {
                Logger.getLogger(ThreadRecibe.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException classNotFoundException) {
              //  main.mostrarMensaje("Objeto desconocido");
                System.out.println("Objeto desconocido");
            } //fin catch              
 
        } while (!mensaje.equals("Servidor>>> TERMINATE")); //Ejecuta hasta que el server escriba TERMINATE   ##########
 
        try {
            entrada.close(); //cierra input Stream
            cliente.close(); //cieraa Socket
        } //Fin try
        catch (IOException ioException) {
            ioException.printStackTrace();
        } //fin catch
 
        //main.mostrarMensaje("Fin de la conexion");
        System.out.println("Fin de la conexión");
        System.exit(0);
    }
}
