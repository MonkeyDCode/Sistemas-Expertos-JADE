package ProyectoFinal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;


//Clase que tiene la instancia o creacion de un Cliente con sus flujos de entrada y salida

public class Cliente {
    
	private String host;
	private int puerto;
	private InputStream flujoEntrada;
	private OutputStream flujoSalida;
	private Socket s;
	
	public Cliente() {
	}
	
	public Cliente(String h, int p){
		this.host = h;
		this.puerto = p;
	}
	
	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @param host the host to set
	 */
	public void setHost(String h) {
		this.host = h;
	}

	/**
	 * @return the puerto
	 */
	public int getPuerto() {
		return puerto;
	}

	/**
	 * @param puerto the puerto to set
	 */
	public void setPuerto(int p) {
		this.puerto = p;
	}
	
	public void conecta() throws UnknownHostException, IOException{
		this.s = new Socket(this.host, this.puerto);
		this.flujoEntrada = s.getInputStream();
		this.flujoSalida = s.getOutputStream();
	}
	
	public void desconecta() throws IOException{
		this.s.close();
	}

	/**
	 * @return the entradaSock
	 */
	public InputStream getFlujoEntrada() {
		if(s == null){
			return null;
		}
		return flujoEntrada;
	}

	/**
	 * @return
	 */
	public OutputStream getFlujoSalida() {
		if(s == null){
			return null;
		}
		return flujoSalida;
	}
        
}