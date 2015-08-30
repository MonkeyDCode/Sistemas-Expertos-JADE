/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package heuristica;

import java.util.Random;

/**
 *
 * @author marco
 */
public class Matriz {
    int matriz [][];

    public Matriz() {
        matriz = new int [10][10];
        Random r = new Random();
        r.setSeed(5000);
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                int f=r.nextInt(100);
                f=Integer.signum(f)*f;
                matriz[i][j]=f;
                matriz[j][i]=f;
                if(i==j)matriz[i][j]=0;
            }
        }
    }
    
    public void mostrarMatriz(){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                System.out.println(matriz[i][j]);
            }
        }
    }
}
