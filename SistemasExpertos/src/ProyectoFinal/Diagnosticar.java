package ProyectoFinal;

import jade.content.Predicate;

public class Diagnosticar implements Predicate{
    private Enfermedad enfermedad;
    
    public Diagnosticar() {
        super();
    }

    public void setEnfermedad(Enfermedad enfermedad) {
        this.enfermedad = enfermedad;
    }

    public Enfermedad getEnfermedad() {
        return enfermedad;
    }
}
