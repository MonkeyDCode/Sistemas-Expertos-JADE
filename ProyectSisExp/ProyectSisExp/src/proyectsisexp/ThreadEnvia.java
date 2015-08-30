package proyectsisexp;
 
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.SocketException;
       
public class ThreadEnvia implements Runnable {
    public static Gerente main;
    private static ObjectOutputStream salida;
    //private String mensaje;
    private Socket conexion;
   
    /*public ThreadEnvia(){
        
    }*/
    
    public ThreadEnvia(Socket conexion, final Gerente main){
        this.conexion = conexion;
        ThreadEnvia.main = main;
        
       // salida =  new DataOutputStream(new BufferedOutputStream(s));
       
    }
   
   //enviar objeto a cliente
   public static void enviarDatos(String mensaje){
        //main.mostrarMensaje("Error escribiendo Mensaje");
        //Fin catch
        
       System.out.println(">>><<<"+mensaje);
       System.out.println("msg_thEnvia "/*+mensaje*/);
     
   } //Fin methodo enviarDatos
 
   //manipula areaPantalla en el hilo despachador de eventos
    public void mostrarMensaje(String mensaje) {
       // main.areaConexion.append(mensaje);
        System.out.println("ENTRO AQUÍ");
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
