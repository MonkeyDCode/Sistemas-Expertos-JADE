package ProyectoFinal;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;

import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ControlAgentes2 {
    private String hostname = "127.0.0.1";
    private HashMap<String, ContainerController> containerList = new HashMap<String, ContainerController>();
    String Contenedor1 = "Psicologo";
    String Contenedor2 = "Terapeuta";

    private List<AgentController> agentList;
    private String Agente1 = "Psicologo";
    private String Agente2 = "Terapeuta";
    private ContainerController contenedorPrincipal;
    

    //String Contenedor0 = "Ginecologo";
    //private String Agente0 = "Ginecologo";

    public ControlAgentes2() {
        iniciarJade();
        agentList = creaAgentes(containerList);
        startAgentes(agentList);
    }


    private Runtime iniciarJade() {
        Runtime rt = Runtime.instance();
        Profile pMain = new ProfileImpl(hostname, 1234, null); //crea perfil con el nombre de la IP.
        AgentContainer mainContainerRef = rt.createMainContainer(pMain); //DF and AMS se incluyen
        containerList.putAll(creaContainers(rt));
        creaAgentes(mainContainerRef);
        contenedorPrincipal = mainContainerRef;
        return rt;
    }

    //Crea perfiles
    private HashMap<String, ContainerController> creaContainers(Runtime rt) {
        String containerName;
        ProfileImpl pContainer;
        ContainerController containerRef;
        HashMap<String, ContainerController> containerList = new HashMap<String, ContainerController>();
        
        //pContainer = new ProfileImpl(null, 1234, null);
        //containerRef = rt.createAgentContainer(pContainer);
        //containerList.put(Contenedor0, containerRef); //Ginecologo

        pContainer = new ProfileImpl(null, 1234, null);
        containerRef = rt.createAgentContainer(pContainer);
        containerList.put(Contenedor1, containerRef); //Psicologo
        
        pContainer = new ProfileImpl(null, 1234, null);
        containerRef = rt.createAgentContainer(pContainer);
        containerList.put(Contenedor2, containerRef); //Terapeuta
        
        return containerList;
    }

    //Crea tres Agentes
    private List<AgentController> creaAgentes(HashMap<String, ContainerController> containerList) {
        //consola.append("\n\tEstado del agente: \n"); textArea
        ContainerController c;
        String agentName;
        List<AgentController> agentList = new ArrayList();
        Object[] objtab = { "", "" };
        
        /*c = containerList.get(Contenedor0);
        try {
            AgentController ag = c.createNewAgent(Agente0, Ginecologo.class.getName(), objtab);
            agentList.add(ag);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        
        c = containerList.get(Contenedor1);
        try {
            AgentController ag = c.createNewAgent(Agente1, Psicologo.class.getName(), objtab);
            agentList.add(ag);
        } catch (Exception e) {
            e.printStackTrace();
        }

        c = containerList.get(Contenedor2);
        try {
            AgentController ag = c.createNewAgent(Agente2, Terapeuta.class.getName(), objtab);
            agentList.add(ag);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return agentList;
    }

    //Inicia los agentes
    private void startAgentes(List<AgentController> agentList) {
        for (final AgentController ac : agentList) {
            try {
                ac.start();
            } catch (StaleProxyException e) {
                e.printStackTrace();
            }
        }
    }

    private void creaAgentes(ContainerController mc) {
        AgentController rma;
        try {
            rma = mc.createNewAgent("rma", "jade.tools.rma.rma", new Object[0]);
            rma.start();
        } catch (StaleProxyException e) {
            e.printStackTrace();
        }
    }
}