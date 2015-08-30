package ProyectoFinal;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;

import java.io.DataOutputStream;

import java.io.IOException;

import java.net.Socket;

import java.util.Vector;

public class Controlador2 extends Thread {
    private Socket conexion;
    private DataInputStream entrada;
    private DataOutputStream salida;
    static Vector manejador = new Vector();
    public int cont;
    public String NombreJugador = null;
    public Boolean Revancha = null;

    public Controlador2() {
        super();
    }

    /** Creates a new instance of ManejadorServidor */
    public Controlador2(Socket conexion, int i) throws IOException {
        this.conexion = conexion;
        entrada = new DataInputStream(new BufferedInputStream(conexion.getInputStream()));
        salida = new DataOutputStream(new BufferedOutputStream(conexion.getOutputStream()));
        cont = i;
    }

    //Corre el manejador del Servidor
    public void run() {
        try {
            try {
                manejador.addElement(this);
                System.out.println("Hilo: " + cont);
                System.out.println("Numero de Jugadores: " + manejador.size());
                obtenerFlujos(); // obtener flujos de entrada y salida.
                procesarConexion(); //procesar la conexión.

            } finally {
                conexion.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // obtener flujos para enviar y recibir datos
    private void obtenerFlujos() throws IOException {
        // establecer flujo de salida para los objetos
        salida = new DataOutputStream(conexion.getOutputStream());
        salida.flush(); // vaciar búfer de salida para enviar información de encabezado
        // establecer flujo de entrada para los objetos
        entrada = new DataInputStream(conexion.getInputStream());
        //mostrarMensaje( "\nSe recibieron los flujos de E/S\n" );
    }

    //procesar las entradas
    private void procesarConexion() throws IOException {
        Object ent;
        // enviar mensaje de conexión exitosa al cliente
        String mensaje = "";
        do {
            ent = entrada.readUTF();
            if (ent instanceof String) { 
                if (ent.equals(PrimitivasCliente.ContactarP)){
                    System.out.print("Entro1");
                    Controlador2 ms1 = (Controlador2)manejador.get(1);
                    ms1.salida.writeUTF(PrimitivasServidor.ContactarPS);
                    System.out.print("Entro2");
                    ms1.salida.flush();
                }else if(ent.equals(PrimitivasCliente.RespuestaP)){
                    Controlador2 ms0 = (Controlador2)manejador.get(0);
                    ent = entrada.readUTF();
                    ms0.salida.writeUTF((String)ent);
                    ms0.salida.flush();
                }else if(ent.equals(PrimitivasCliente.RespuestaSintomasP)){ 
                    Controlador2 ms1 = (Controlador2)manejador.get(1);
                    ms1.salida.writeUTF(PrimitivasServidor.RespuestaSintomasPS);
                    ms1.salida.flush();
                    ent=entrada.readUTF();
                    ms1.salida.writeUTF((String)ent);
                    ms1.salida.flush();
                }else if(ent.equals(PrimitivasCliente.RespuestaSIP)){
                    Controlador2 ms0 = (Controlador2)manejador.get(0);
                    ms0.salida.writeUTF((PrimitivasServidor.RespuestaSISGP));
                    ms0.salida.flush();
                    ent = entrada.readUTF();
                    ms0.salida.writeUTF((String)ent);
                    ms0.salida.flush();
                }else if(ent.equals(PrimitivasCliente.RespuestaNOP)){
                    Controlador2 ms0 = (Controlador2)manejador.get(0);
                    ms0.salida.writeUTF((PrimitivasServidor.RespuestaNOTSGP));
                    ms0.salida.flush();
                    ent = entrada.readUTF();
                    ms0.salida.writeUTF((String)ent);
                    ms0.salida.flush();
                }else if(ent.equals(PrimitivasCliente.RespuestaCuraP)){ 
                    Controlador2 ms1 = (Controlador2)manejador.get(1);
                    ms1.salida.writeUTF(PrimitivasServidor.RespuestaCuraPS);
                    ms1.salida.flush();
                    ent=entrada.readUTF();
                    ms1.salida.writeUTF((String)ent);
                    ms1.salida.flush();
                }else if(ent.equals(PrimitivasCliente.RespuestaCP)){
                    //System.out.println("Entre a CP");
                    Controlador2 ms0 = (Controlador2)manejador.get(0);
                    ent = entrada.readUTF();
                    //System.out.println("EL mensaje es: "+(String)ent);
                    ms0.salida.writeUTF((String)ent);
                    ms0.salida.flush();
                    
                    ent = entrada.readUTF();
                    ms0.salida.writeUTF((String)ent);
                    ms0.salida.flush();
                }
            } else {
                mensaje = (String)ent;
            }
        } while (!mensaje.equals("TERMINAR"));

    } // fin del método procesarConexion

}