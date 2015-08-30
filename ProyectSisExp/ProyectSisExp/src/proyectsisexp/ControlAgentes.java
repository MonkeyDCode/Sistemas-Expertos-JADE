
package proyectsisexp;

//import jade.core.AgentContainer;
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

/**
 *
 * @author Samuel
 */
public class ControlAgentes {

    private String hostname = "127.0.0.1";
    private HashMap<String, ContainerController> containerList = new HashMap<String, ContainerController>();
    String Contenedor1 = "Ejecutivo";
    String Contenedor2 = "Gerente";
    String Contenedor3 = "Cajero";

    private List<AgentController> agentList;

    private String Agente1 = "Ejecutivo";
    private String Agente2 = "Gerente";
    private String Agente3 = "Cajero";

    private ContainerController contenedorPrincipal;

    public ControlAgentes() {

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

        //  consola.append("\t\tConsola de  Agentes\n"); //textArea

        contenedorPrincipal = mainContainerRef;

        return rt;

    }

    //AMS
    private Runtime metodo1(HashMap<String, ContainerController> containerList) {

        Runtime rt = Runtime.instance();
        Profile pMain = new ProfileImpl(hostname, 1234, null);

        AgentContainer mainContainerRef = rt.createMainContainer(pMain); //DF and AMS se incluyen
        containerList.putAll(creaContainers(rt));

        creaAgentes(mainContainerRef);

        // consola.append("\t\tConsola de  Agentes\n"); //textArea

        contenedorPrincipal = mainContainerRef;

        return rt;

    }

    //Crea perfiles

    private HashMap<String, ContainerController> creaContainers(Runtime rt) {
        String containerName;
        ProfileImpl pContainer;
        ContainerController containerRef;
        HashMap<String, ContainerController> containerList = new HashMap<String, ContainerController>();


        pContainer = new ProfileImpl(null, 1234, null);
        containerRef = rt.createAgentContainer(pContainer);
        containerList.put(Contenedor1, containerRef); //Ejecutivo

//        pContainer = new ProfileImpl(null, 1234, null);
//        containerRef = rt.createAgentContainer(pContainer);
//        containerList.put(Contenedor2, containerRef); //Gerente

        pContainer = new ProfileImpl(null, 1234, null);
        containerRef = rt.createAgentContainer(pContainer);
        containerList.put(Contenedor3, containerRef); //Cajero

        //  consola.append("");   //textArea
        return containerList;
    }

    //Crea tres Agentes

    private List<AgentController> creaAgentes(HashMap<String, ContainerController> containerList) {
        //consola.append("\n\tEstado del agente: \n"); textArea
        ContainerController c;
        String agentName;
        List<AgentController> agentList = new ArrayList();

        c = containerList.get(Contenedor1);
        //Object[] objtab={consola,Datos};
        Object[] objtab = { "", "" };

        try {
            //Se crea el agente ejeuctivo de la clase Ejecutivo.
            AgentController ag = c.createNewAgent(Agente1, Ejecutivo.class.getName(), objtab);
            agentList.add(ag);
            //  consola.append("\t"+Agente1+": Disponible\n"); textArea
        } catch (Exception e) {
            e.printStackTrace();
        }

        //AUN NO TENEMOS CREADO EL AGENTE GERENTE. <<Es el Remoto.>>
//        c = containerList.get(Contenedor2);
//        try {
//            AgentController ag = c.createNewAgent(Agente2, Gerente.class.getName(), objtab); //Agente Gerente
//            agentList.add(ag);
//            //consola.append("\t"+Agente2+": Disponible\n"); //textArea
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        c = containerList.get(Contenedor3);
        try {
            AgentController ag = c.createNewAgent(Agente3, Cajero.class.getName(), objtab);
            agentList.add(ag);
            //consola.append("\t"+Agente3+": Disponible\n"); //textArea
        } catch (Exception e) {
            e.printStackTrace();
        }

        //consola.append("\n...Todos los agentes estan disponibles\n");//textArea
        return agentList;
    }

    //Inicia los agentes

    private void startAgentes(List<AgentController> agentList) {
        //consola.append("\n");   //textArea
        for (final AgentController ac : agentList) {
            try {
                ac.start();
            } catch (StaleProxyException e) {
                e.printStackTrace();
            }
        }
        //consola.append("\n"); //textArea
    }

    private void creaAgentes(ContainerController mc) {

        //    consola.append("\n");
        AgentController rma;

        try {
            rma = mc.createNewAgent("rma", "jade.tools.rma.rma", new Object[0]);
            rma.start();
        } catch (StaleProxyException e) {
            e.printStackTrace();
            //    consola.append("Error en creacion del RMA...\n");
        }

        // consola.append("");

    }


}
