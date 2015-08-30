package evoluciondiferencial;

public class generarPadres {
    
    double[] vecPoblacion;

    public generarPadres() {
        this.vecPoblacion = new double[4];
    }
    
    public void llenarPoblacion(){
        for(int i=0;i<4;i++){
            double num = Math.random()*(10-(-10)+1)+(-10);
            this.vecPoblacion[i]=Math.round(num);
        }
    }
    public double[] getVector(){
        return vecPoblacion;
    }
}
