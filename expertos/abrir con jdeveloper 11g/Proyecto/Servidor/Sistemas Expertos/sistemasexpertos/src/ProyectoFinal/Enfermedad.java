package ProyectoFinal;

import jade.content.Concept;

public class Enfermedad implements Concept {
    private String nombre;
    
    private String sintomaA;
    private String sintomaB;
    private String sintomaC;
    

    private String cura1;
    private String cura2;
    
    public Enfermedad() {
        super();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }


    public void setCura1(String cura1) {
        this.cura1 = cura1;
    }

    public String getCura1() {
        return cura1;
    }

    public void setCura2(String cura2) {
        this.cura2 = cura2;
    }

    public String getCura2() {
        return cura2;
    }

    public void setSintomaA(String sintomaA) {
        this.sintomaA = sintomaA;
    }

    public String getSintomaA() {
        return sintomaA;
    }

    public void setSintomaB(String sintomaB) {
        this.sintomaB = sintomaB;
    }

    public String getSintomaB() {
        return sintomaB;
    }

    public void setSintomaC(String sintomaC) {
        this.sintomaC = sintomaC;
    }

    public String getSintomaC() {
        return sintomaC;
    }
}
