
package cumulosdeparticulas;

public class MatrizAdyacencia {
    int[][] mat={{0,0,1,0,1,0},
                 {0,0,0,0,0,1},
                 {1,0,0,1,0,0},
                 {0,0,1,0,1,0},
                 {1,0,0,1,0,1},
                 {0,1,0,0,1,0}};
    int[] particula0;
    int[] particula1;
    int[] particula2;
    int[] particula3;
    int[] vector;

    public MatrizAdyacencia() {
        vector = new int[6];
        this.llenarParticula();
    }
    
    public int[] generarParticula(){
        int[] vec = {-1,-1,-1,-1,-1,-1};        
        int numero;
        for(int i=0;i<6;i++){
            vector[i]=0;
        }
        while(vec[0]==-1){
            numero = (int)(Math.random()*(6-1+1)+1);
            if(vector[numero-1]==0){
                vec[0]=numero-1;
                vector[numero-1]=1;
            }
        }
        while(vec[1]==-1){
            numero = (int)(Math.random()*(6-1+1)+1);
            if(vector[numero-1]==0){
                vec[1]=numero-1;
                vector[numero-1]=1;
            }
        }
        while(vec[2]==-1){
            numero = (int)(Math.random()*(6-1+1)+1);
            if(vector[numero-1]==0){
                vec[2]=numero-1;
                vector[numero-1]=1;
            }
        }
        while(vec[3]==-1){
            numero = (int)(Math.random()*(6-1+1)+1);
            if(vector[numero-1]==0){
                vec[3]=numero-1;
                vector[numero-1]=1;
            }
        }
        while(vec[4]==-1){
            numero = (int)(Math.random()*(6-1+1)+1);
            if(vector[numero-1]==0){
                vec[4]=numero-1;
                vector[numero-1]=1;
            }
        }
        while(vec[5]==-1){
            numero = (int)(Math.random()*(6-1+1)+1);
            if(vector[numero-1]==0){
                vec[5]=numero-1;
                vector[numero-1]=1;
            }
        }
        return vec;
    }
    public int[][] getMat() {
        return mat;
    }
    public void llenarParticula(){
        particula0=generarParticula();
        particula1=generarParticula();
        particula2=generarParticula();
        particula3=generarParticula();
        //this.evaluarFuncion(particula0);
    }
    public int[] getParticula(int n) {
        switch(n){
            case 0:
                return particula0;
            case 1:
                return particula1;
            case 2:
                return particula2;
            default:
                return particula3;
        }        
    }
    public int evaluarFuncion(int[] vec){
        int num=0;
        for(int i=0;i<6;i++){
            num=num+identificar(vec[i],i);  //identificar(particula,posicion)
        }
        return num;
    }    
    public int identificar(int val, int pos){   // Si en la matriz hay un 1, entonces
        int num=0;                              // regresa el valor posicional+1.
        if(mat[val][pos]==1){
            num=num+(val+1);
        }
        return num;
    }
}
