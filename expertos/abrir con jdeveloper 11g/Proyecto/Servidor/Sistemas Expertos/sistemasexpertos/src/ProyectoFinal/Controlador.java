package ProyectoFinal;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;

import java.io.DataOutputStream;

import java.io.IOException;

import java.net.Socket;

import java.util.Vector;

public class Controlador extends Thread {
    private Socket conexion;
    private DataInputStream entrada;
    private DataOutputStream salida;
    static Vector manejador = new Vector();
    public int cont;
    public String NombreJugador = null;
    public Boolean Revancha = null;

    public Controlador() {
        super();
    }

    /** Creates a new instance of ManejadorServidor */
    public Controlador(Socket conexion, int i) throws IOException {
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
                if (ent.equals(PrimitivasCliente.ContactarT)){
                    Controlador ms1 = (Controlador)manejador.get(1);
                    ms1.salida.writeUTF(PrimitivasServidor.ContactarTS);
                    ms1.salida.flush();
                }else if(ent.equals(PrimitivasCliente.RespuestaT)){
                    Controlador ms0 = (Controlador)manejador.get(0);
                    ent = entrada.readUTF();
                    ms0.salida.writeUTF((String)ent);
                    ms0.salida.flush();
                }else if(ent.equals(PrimitivasCliente.RespuestaSintomasT)){ 
                    Controlador ms1 = (Controlador)manejador.get(1);
                    ms1.salida.writeUTF(PrimitivasServidor.RespuestaSintomasTS);
                    ms1.salida.flush();
                    ent=entrada.readUTF();
                    ms1.salida.writeUTF((String)ent);
                    ms1.salida.flush();
                }else if(ent.equals(PrimitivasCliente.RespuestaSIT)){
                    Controlador ms0 = (Controlador)manejador.get(0);
                    ms0.salida.writeUTF((PrimitivasServidor.RespuestaSISG));
                    ms0.salida.flush();
                    ent = entrada.readUTF();
                    ms0.salida.writeUTF((String)ent);
                    ms0.salida.flush();
                }else if(ent.equals(PrimitivasCliente.RespuestaNOT)){
                    Controlador ms0 = (Controlador)manejador.get(0);
                    ms0.salida.writeUTF((PrimitivasServidor.RespuestaNOTSG));
                    ms0.salida.flush();
                    ent = entrada.readUTF();
                    ms0.salida.writeUTF((String)ent);
                    ms0.salida.flush();
                }else if(ent.equals(PrimitivasCliente.RespuestaCuraT)){ 
                    Controlador ms1 = (Controlador)manejador.get(1);
                    ms1.salida.writeUTF(PrimitivasServidor.RespuestaCuraTS);
                    ms1.salida.flush();
                    ent=entrada.readUTF();
                    ms1.salida.writeUTF((String)ent);
                    ms1.salida.flush();
                }else if(ent.equals(PrimitivasCliente.RespuestaCT)){
                    Controlador ms0 = (Controlador)manejador.get(0);
                    ent = entrada.readUTF();
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
