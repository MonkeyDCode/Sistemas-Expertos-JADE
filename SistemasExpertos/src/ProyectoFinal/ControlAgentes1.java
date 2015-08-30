package ProyectoFinal;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;

import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;

import jade.wrapper.StaleProxyException;

import java.util.HashMap;

public class ControlAgentes1 {
    private String hostname = "127.0.0.1";
    String Contenedor1 = "Ginecologo";
    private AgentController agenteC;
    private ContainerController contenedorPrincipal;
    private ContainerController contenedorG;
    
    private String Agente1 = "Ginecologo";

    public ControlAgentes1() {
        super();
        iniciarJade();
        agenteC = creaAgentes(contenedorG);
        try {
            agenteC.start();
        } catch (StaleProxyException e) {
            e.printStackTrace();
        }
    }

    private Runtime iniciarJade() {

        Runtime rt = Runtime.instance();
        Profile pMain = new ProfileImpl(hostname, 1234, null); //crea perfil con el nombre de la IP.
        AgentContainer mainContainerRef = rt.createMainContainer(pMain); //DF and AMS se incluyen
       
        ProfileImpl pContainer;
        ContainerController containerRef;
        pContainer = new ProfileImpl(null, 1234, null);
        containerRef = rt.createAgentContainer(pContainer);//crea contenedor
        contenedorG = containerRef;
        
        AgentController rma;
        try {
            rma = mainContainerRef.createNewAgent("rma", "jade.tools.rma.rma", new Object[0]);
            rma.start();
        } catch (StaleProxyException e) {
            e.printStackTrace();
        }

        contenedorPrincipal = mainContainerRef;
        return rt;

    }

    private AgentController creaAgentes(ContainerController contG) {
        Object[] objtab = { "", "" };
        AgentController ag = null;
        try {
             ag = contG.createNewAgent(Agente1, Ginecologo.class.getName(), objtab);
            //consola.append("\t"+Agente1+": Disponible\n"); textArea
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ag;
        
    }
}
