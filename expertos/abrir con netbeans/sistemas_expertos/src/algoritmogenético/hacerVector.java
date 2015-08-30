package algoritmogenético;

import java.util.Random;

public class hacerVector {
    int n;
    int[] v = new int[6];
    int[] num = new int[6];    // valor DECIMAL
    String[] vecBin = new String[6];
    char bin[];
    
    Random rnd = new Random();    
    
    public hacerVector(){
        inicializar();
        numeroAleatorio();
        llenarVector();
        //imprimir();
    }
    public void inicializar(){
        for(int i=0;i<v.length;i++){
            v[i]=0;
            num[i]=0;
        }
    }
    public void numeroAleatorio(){
        for(int i=0;i<6;i++){
            num[i] =(int)(Math.random()*(63-0+1)+0);            
        }                
    }
    public void llenarVector(){
        for(int i=0;i<6;i++){            
            vecBin[i]= rellenar(num[i]);
            //System.out.println(num[i]+":"+vecBin[i]);
        }
    }
    public double promedio(){
        double prom;
        int suma=0;
        for(int i=0;i<6;i++){
            suma = suma + (num[i] * num[i]);
        }
        prom = suma/6;
        return prom;
    }
    public String rellenar(int n){
        String aux0="";
        String aux1 = "";
        aux0 = Integer.toBinaryString(n);
        if(aux0.length()<6){
            for(int i=0; i<(6-aux0.length());i++){
                aux1=aux1+"0";
            }
            aux0 =aux1+"" + aux0;
        }        
        return aux0;
    }
    public void imprimir(){
        for(int i=0;i<6;i++){
            System.out.print(v[i]+"-");
        }
    }
    public int getVector(int n){
        return this.num[n];
    }
    
    public String getVecBinario(int n){
        return this.vecBin[n];
    }
    public String[] getVecBinario(){
        return this.vecBin;
    }
}
