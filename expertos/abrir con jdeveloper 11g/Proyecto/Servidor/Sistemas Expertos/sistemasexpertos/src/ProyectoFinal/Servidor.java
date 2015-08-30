package ProyectoFinal;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread{
    
    public void run(){
        try {
            int i = 0;
            ServerSocket s = new ServerSocket(8983);
            while (true) {
                Socket entrante = s.accept();
                Runnable r = new Controlador(entrante,i);
                Thread t = new Thread(r);
                t.start();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}