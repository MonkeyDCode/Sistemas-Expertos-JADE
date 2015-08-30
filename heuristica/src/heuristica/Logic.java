
package heuristica;

import java.util.Random;

public class Logic {
    
    public static int[][] generaCaminos(){
        Random rnd = new Random();
        int caminos[][]=new int[10][10];
        for(int y =0;y<10;y++)
        { 
            for(int x=0;x<10;x++)
            {
                if(x!=y)
                {
                    if(caminos[y][x]==0)
                    {
                    caminos[x][y]=rnd.nextInt(40)+10;
                    }
                    else
                    {
                    caminos[x][y]=caminos[y][x];
                    }
                }
            }
        }
        return caminos;
    }
    
    public static int[] caminoCorto(int[][] caminos,int origen)
    {
        int b=origen;
        int[] ruta=new int[10];
        for(int fla=0;fla<10;fla ++)
        {
            ruta[fla]=-1;
        }    
        ruta[0]=origen;
        int a=1;
        while(a<10)
        {
            int aux=9999;
            int aux2=0;
            for(int x=0; x<10; x++)   
            {
                if(caminos[x][origen]< aux && x!=origen && !existe(x,ruta)) 
                {
                        aux=caminos[x][origen];
                        aux2=x;
                        //System.out.println(aux);
                        ruta[a]=aux2;
                        //break;
                }

            }
            origen=aux2;
            //System.out.println("pasa origen a ser "+aux2);
            a++;  
        }
        return ruta;
    }
    
    private static boolean existe(int x,int[] rutas)
    {
        for (int a=0; a <10;a++) {
            if(x==rutas[a])
                return true;
        }
        
        return false;
    }
    
    public static int[] caminoRandom(int[][] caminos)
    {
        int[] ruta=new int[10];
        int[] mini= minimo(caminos);
        for(int fla=0;fla<10;fla ++)
        {
            ruta[fla]=-1;
        }
        ruta[0]=mini[0];
        ruta[1]=mini[1];
        int origen=ruta[1];
        int a=2;
        while(a<10)
        {
            int aux=9999;
            int aux2=0;
            for(int x=0; x<10; x++)   
            {
                if(caminos[x][origen]< aux && x!=origen && !existe(x,ruta)) 
                {
                        aux=caminos[x][origen];
                        aux2=x;
                        //System.out.println(aux);
                        ruta[a]=aux2;
                        //break;
                }

            }
            origen=aux2;
            //System.out.println("pasa origen a ser "+aux2);
            a++;  
        }
        return ruta;
    }
    
    private static int[] minimo(int[][] cam)
    {
        int[] minimo = new int[2];
        int min=9999;
        for (int a =0;a<10;a++)
        {
            for(int b=0;b<10;b++)
            {
                if(cam[a][b]<min && cam[a][b]!= 0)
                {
                    minimo[0]=a;
                    minimo[1]=b;
                    //System.out.println(cam[a][b]);
                    min=cam[a][b];
                }
            }
        }
        
        
        return minimo;
    }
    
    
    public static int calcPeso(int[][] matriz, int[] vector)
    {
        int peso =0;
        for(int a =0; a<9;a++)
        {
            peso += matriz[vector[a]][vector[a+1]];
        }
        peso += matriz[vector[0]][vector[9]];
        return peso;
    }
    
}
    
    



