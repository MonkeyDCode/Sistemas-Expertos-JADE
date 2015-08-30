package proyectsisexp;

import java.net.*;
import java.io.*;

public  class Conector
{
	Socket cliente;
	int puerto = 9000;
	String ip = "10.0.0.3";
	BufferedReader entrada, teclado;
	PrintStream salida;

	public void iniciarSocket()
	{
		try{
	
			cliente = new Socket(ip, puerto);
			
			entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

			teclado = new BufferedReader(new InputStreamReader (System.in));
			String tec = teclado.readLine();

			salida = new PrintStream(cliente.getOutputStream());
			salida.println("Hola, que tal Diseñador? necesito \n que me autorices la impresión de la imagen");
			String msj =entrada.readLine();
			entrada.close();
			salida.close();
			teclado.close();
			cliente.close();
			
		}catch(Exception e){
                    System.out.println(e.getMessage());
                };
	}
}
