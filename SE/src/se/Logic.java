package se;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author root
 */
public class Logic {
    
    //int numeroPoblacion;
    float[] fitness;
    float m;
    float cR;
    ArrayList<XY> array=new ArrayList<XY>();
    Random rand=new Random();
    
    public void generaVector(int numero)
    {
        array.clear();
        for(int i=0;i<numero;i++)
        {
            XY aux =new XY();
            aux.setX(rand.nextInt(20)-10);
            aux.setY(rand.nextInt(20)-10);
            array.add(aux);
        }
        //return array;
    }
    
    public void generaFitness(int numero)
    {
        fitness=new float[numero];
        for(int i=0;i<numero;i++)
        {
            XY aux=array.get(i);
            fitness[i]=(aux.x*aux.x)+(aux.y*aux.y*aux.y);
        }
    }
    

    public float getM() {
        return m;
    }

    public void setM(float m) {
        this.m = m;
    }

    public float getcR() {
        return cR;
    }

    public void setcR(float cR) {
        this.cR = cR;
    }
    
    
}
