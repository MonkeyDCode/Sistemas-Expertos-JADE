package algoritmogenético;

import javax.swing.JOptionPane;

public class Minimizar {
    int min1;
    int min2;
    int min3;   
    int[] vector;   //valor DECIMAL
    String[] binario; // valor BINARIO
    String[] auxBin; 
    String[] otroBin;
    /*   HIJOS */
    String h1 ="";
    String h2="";
    String h3="";
    String h4="";
    String h5="";
    String h6="";
    /*   Auxiliares */
    char[] val1;
    char[] val2;
    char[] val3;
    char[] val4;
    char[] val5;
    char[] val6;
    char[] aux1;
    char[] aux2;
    char[] aux3;
    
    public Minimizar(int[] vec, String[] vecBin){
        this.auxBin = new String[6];
        this.binario = new String[6];
        this.vector = vec;
        this.binario = vecBin;
        buscarMenor(this.vector);
    }
    public final void buscarMenor(int[] vec){
        int aux;
        int[] auxVec = new int[6];
        auxVec = vec;
        for (int i = 0; i < auxVec.length - 1; i++) {
            for (int x = i + 1; x < auxVec.length; x++) {
                if (auxVec[x] < auxVec[i]) {
                    aux = auxVec[i];
                    auxVec[i] = auxVec[x];
                    auxVec[x] = aux;
                }
            }
        }
        min1=auxVec[0];
        for(int i=0;i<vec.length;i++){
            if(vec[i]== min1){
                auxBin[0] = binario[i];
                auxBin[1] = binario[i];
            }
        }
        min2=auxVec[1];
        for(int i=0;i<binario.length;i++){
            if(vec[i] == min2){
                auxBin[2] = binario[i];
                auxBin[3] = binario[i];
            }
        }
        min3=auxVec[2];
        for(int i=0;i<binario.length;i++){
            if(vec[i]== min3){
                auxBin[4] = binario[i];
                auxBin[5] = binario[i];
            }
        }        
        /*
        System.out.println("Min1: "+min1);        
        System.out.println("Min2: "+min2);        
        System.out.println("Min3: "+min3);
        System.out.println("==============");
                */        
        otroBin = auxBin;
    }
    public void competir(){        
        vector[0]= min1;
        vector[1]= min1;
        vector[2]= min2;
        vector[3]= min2;
        vector[4]= min3;
        vector[5]= min3;
        binario = auxBin;        
        JOptionPane.showMessageDialog( null, "Resultado de COMPETIR\n Min1: "+min1+"\n Min2: "+min2+"\n Min3: "+min3 );
    }
    public void cruce(){
        int b = 0;
        String aux=binario[0];
        int a=0;
        while(b==0){
            h1 = binario[0].substring(0,3)+binario[2].substring(0,3); // 1 (0) - 3 (2)
            if(aux.equals(h1) & a==0){
                h1 = binario[2].substring(0,3)+binario[0].substring(0,3); // 1 (0) - 3 (2)
                a++;
            }else{
                b=1;
            }
        }
        b=0;
        a=0;
        aux=binario[1];
        while(b==0){
            h2 = binario[0].substring(3,6)+binario[2].substring(3,6); // 1 (0) - 3 (2)
            if(aux.equals(h2) & a==0){
                h2 = binario[2].substring(3,6)+binario[0].substring(3,6); // 1 (0) - 3 (2)
                a++;
            }else{
                b=1;
            }
        }
        b=0;
        a=0;
        aux=binario[2];
        while(b==0){
            h3 = binario[2].substring(0,3)+binario[3].substring(0,3); // 2 (1) - 4 (3)
            if(aux.equals(h3) & a==0){
                h3 = binario[3].substring(0,3)+binario[2].substring(0,3); // 2 (1) - 4 (3)
                a++;
            }else{
                b=1;
            }
        }                
        h4 = binario[2].substring(3,6)+binario[3].substring(3,6); // 2 (1) - 4 (3)
        h5 = binario[4].substring(0,3)+binario[5].substring(0,3); // 5 (4) - 6 (5)
        h6 = binario[4].substring(3,6)+binario[5].substring(3,6); // 5 (4) - 6 (5)
        binario[0] = h1;
        binario[1] = h2;
        binario[2] = h3;
        binario[3] = h4;
        binario[4] = h5;
        binario[5] = h6;        
        for(int i=0;i<6;i++){            
            vector[i] = Integer.parseInt(binario[i], 2);
        }
    }
    public double promedio(){
        double prom;
        int suma=0;
        for(int i=0;i<6;i++){
            suma = suma + (vector[i] * vector[i]) + (vector[i]*vector[i]*vector[i]);
        }
        prom = suma/6;
        return prom;
    }
    public int[] getVectorDecimal(){
        return this.vector;
    }
    public String[] getVecBinario(){
        return this.binario;
    }
    public String getHijo(int n){
        switch(n){
            case 0:
                return h1;
            case 1:
                return h2;
            case 2:
                return h3;
            case 3:
                return h4;
            case 4:
                return h5;
            default:
                return h6;
        }
    }
    public String getCompetir(int n){
        switch(n){
            case 0:
                return otroBin[0];
            case 1:
                return otroBin[1];
            case 2:
                return auxBin[2];
            case 3:
                return auxBin[3];
            case 4:
                return auxBin[4];
            default:
                return auxBin[5];
        }
    }
}