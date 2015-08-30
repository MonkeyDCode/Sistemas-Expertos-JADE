package algoritmogenético;

import javax.swing.JOptionPane;

public class Maximizar {
    int max1;
    int max2;
    int max3;   
    int[] vector;   //valor DECIMAL
    String[] binario; // valor BINARIO
    String[] auxBin; 
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
    
    public Maximizar(int[] vec, String[] vecBin){
        this.auxBin = new String[6];
        this.binario = new String[6];
        this.vector = vec;
        this.binario = vecBin;
        buscarMayor(this.vector);
    }
    public final void buscarMayor(int[] vec){
        int aux=vec[0];
        for(int i=0;i<6;i++){
            if(vec[i]>=aux){
                aux=vec[i];
                aux1 = binario[i].toCharArray();
                auxBin[0] = binario[i];
                auxBin[1] = binario[i];
            }
        }
        max1=aux;
        //System.out.println("Max1: "+max1);
        aux=-1;
        for(int i=0;i<6;i++){
            if(vec[i]>aux & vec[i]<max1){
                aux=vec[i];
                aux2 = binario[i].toCharArray();
                auxBin[2] = binario[i];
                auxBin[3] = binario[i];
            }
        }
        max2=aux;
        //System.out.println("Max2: "+max2);
        aux=-1;
        for(int i=0;i<6;i++){
            if(vec[i]>aux & vec[i]<max2){
                aux=vec[i];
                aux3 = binario[i].toCharArray();
                auxBin[4] = binario[i];
                auxBin[5] = binario[i];
            }
        }
        max3=aux;
        //System.out.println("Max3: "+max3);        
    }
    public void competir(){        
        vector[0]= max1;
        vector[1]= max1;
        vector[2]= max2;
        vector[3]= max2;
        vector[4]= max3;
        vector[5]= max3;
        binario = auxBin;
        JOptionPane.showMessageDialog( null, "Resultado de COMPETIR\n Max1: "+max1+"\n Max2: "+max2+"\n Max3: "+max3 );
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
                return auxBin[0];
            case 1:
                return auxBin[1];
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
