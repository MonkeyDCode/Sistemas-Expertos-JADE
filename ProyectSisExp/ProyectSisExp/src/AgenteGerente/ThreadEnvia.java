package AgenteGerente;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.SocketException;
       
public class ThreadEnvia implements Runnable {
    public static VentanaGerente main;
    private static ObjectOutputStream salida;
    
    private Socket conexion;
   
    public ThreadEnvia(Socket conexion, final VentanaGerente main){
        this.conexion = conexion;
        ThreadEnvia.main = main;
       
       
    }
   
   //enviar objeto a cliente
   public static void enviarDatos(String mensaje){
      try {
         salida.writeObject(mensaje);
         salida.flush(); //flush salida a cliente
        // main.mostrarMensaje("Servidor>>> " + mensaje);
         System.out.println("Servidor>>> " + mensaje);
      } //Fin try
      catch (IOException ioException){
        // main.mostrarMensaje("Error escribiendo Mensaje");
         System.out.println("Error escribiendo Mensaje");
      } //Fin catch  
     
   } //Fin methodo enviarDatos
 
   //manipula areaPantalla en el hilo despachador de eventos
    public void mostrarMensaje(String mensaje) {
       // main.areaConexion.append(mensaje);
        System.out.println(mensaje);
    }
   
    public void run() {
         try {
            salida = new ObjectOutputStream(conexion.getOutputStream());
            salida.flush();
        } catch (SocketException ex) {
        } catch (IOException ioException) {
          ioException.printStackTrace();
        } catch (NullPointerException ex) {
        }
    }  
   
}