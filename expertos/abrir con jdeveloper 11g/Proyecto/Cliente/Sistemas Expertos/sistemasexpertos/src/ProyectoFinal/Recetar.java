package ProyectoFinal;

import jade.content.AgentAction;

public class Recetar implements AgentAction{
    private Enfermedad enfermedad;
    
    
    public Recetar() {
        super();
    }

    public void setEnfermedad(Enfermedad enfermedad) {
        this.enfermedad = enfermedad;
    }

    public Enfermedad getEnfermedad() {
        return enfermedad;
    }
}
