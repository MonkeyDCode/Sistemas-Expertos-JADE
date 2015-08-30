package ProyectoFinal;

import jade.content.ContentElement;
import jade.content.lang.Codec;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;

import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import java.io.IOException;

import javax.swing.ImageIcon;

public class Psicologo extends Agent {
    private Codec codec = new SLCodec();
    private Ontology ontologia = EnfermedadOntology.getInstance();

    public Psicologo() {
        super();
    }

    @Override
    protected void setup() {
        getContentManager().registerLanguage(codec);
        getContentManager().registerOntology(ontologia);
        PsicologoBehaviour psicologoBehaviour = new PsicologoBehaviour(this);
        addBehaviour(psicologoBehaviour);
    }

    class PsicologoBehaviour extends SimpleBehaviour {
        private boolean finished = true;
        String respuesta = "";
        Principal prin = Principal.p1;
        

        public PsicologoBehaviour(Agent a) {
            super(a);
        }

        @Override
        public void action() {
            ACLMessage msg = null;
            Diagnosticar diagnosticar = null;
            Enfermedad enfermedad = null;
            prin.getJTextArea2().setText("Estoy listo para recibir paciente");
            try {
                respuesta = prin.entradaP.readUTF();
                System.out.println("Entro T: "+respuesta);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (respuesta.equals(PrimitivasServidor.ContactarPS)) {
                prin.frame.getJLabel3().setIcon(new ImageIcon("ginecologoT.png"));
                prin.frame.getJLabel2().setIcon(new ImageIcon("TerapeutaTG.png"));
                prin.frame.getJLabel1().setIcon(new ImageIcon("psicologoTT.png"));
                prin.jPanel1.updateUI();
                prin.repaint();
                enfermedad = new Enfermedad();
                enfermedad.setNombre("Anorgasmia");
                enfermedad.setSintomaA("Depresion");
                enfermedad.setSintomaB("Ansiedad");
                enfermedad.setSintomaC("Inhibicion recurrente del orgasmo");
                enfermedad.setCura1("Programa de habilidades sexuales (Ejerecicios)");
                enfermedad.setCura2("Clases de YOGA");
                diagnosticar = new Diagnosticar();
                diagnosticar.setEnfermedad(enfermedad);
                AID r = new AID();
                msg = new ACLMessage(ACLMessage.INFORM);
                r.setLocalName("Terapeuta");
                msg.setSender(getAID());
                msg.addReceiver(r);
                msg.setLanguage(codec.getName());
                msg.setOntology(ontologia.getName());
                prin.getJTextArea4().setText("Colega tengo un paciente que puedes tratar:\n" +
                        "Te mando los datos.");
            }
            try {

                if (msg != null) {
                    if (msg.getPerformative() == ACLMessage.NOT_UNDERSTOOD) {
                        System.out.println("Mensaje NOT UNDERSTOOD recibido");
                    } else {
                        if (msg.getPerformative() == ACLMessage.INFORM) {
                            enfermedad = diagnosticar.getEnfermedad();
                            prin.getJTextArea2().setText("Recibo paciente con los sintomas:\n" +
                                    "Sintoma: " + enfermedad.getSintomaA() + "\n" +
                                    "Sintoma: " + enfermedad.getSintomaB() + "\n" +
                                    "Sintoma: " + enfermedad.getSintomaC() + "\n");
                            doWait(3000);
                            prin.frame.getJLabel3().setIcon(new ImageIcon("ginecologoTG.png"));
                            prin.jPanel1.updateUI();
                            prin.repaint();
                            Recetar recetar = new Recetar();
                            recetar.setEnfermedad(diagnosticar.getEnfermedad());
                            ACLMessage msg2 = new ACLMessage(ACLMessage.INFORM);
                            AID r = new AID();
                            r.setLocalName("Ginecologo");
                            msg2.setLanguage(codec.getName());
                            msg2.setOntology(ontologia.getName());
                            msg2.setSender(getAID());
                            msg2.addReceiver(msg.getSender());
                            getContentManager().fillContent(msg2, recetar);
                            send(msg2);
                            prin.getJTextArea2().append("\nPuedo tratar al paciente");
                            doWait(3000);
                            prin.getJTextArea4().setText("");
                            try {
                                prin.salidaP.writeUTF(PrimitivasCliente.RespuestaP);
                                prin.salidaP.flush();
                                prin.salidaP.writeUTF("Me han comentado que sus sintomas son:\n" +
                                        "Sintoma: " + enfermedad.getSintomaA() + "\n" +
                                        "Sintoma: " + enfermedad.getSintomaB() + "\n" +
                                        "Sintoma: " + enfermedad.getSintomaC() + "\n" +
                                        "Esta de acuerdo?\n SI - SI estoy de acuerdo\nNO - NO estoy de acuerdo\n");
                                prin.salidaP.flush();
                                respuesta = prin.entradaP.readUTF();
                                if (respuesta.equals(PrimitivasServidor.RespuestaSintomasPS)) {
                                    respuesta = prin.entradaP.readUTF();
                                    prin.getJTextArea2().setText("En consulta...");
                                    if (respuesta.equals("SI")) {
                                        prin.salidaP.writeUTF(PrimitivasCliente.RespuestaSIP);
                                        prin.salidaP.flush();
                                        prin.salidaP.writeUTF("Usted Padece: ANORGASMIA\n" +
                                                "Curas Disponibles\n" +
                                                "PH - " + enfermedad.getCura1() + "\n" +
                                                "CY - " + enfermedad.getCura2() + "\n" +
                                                "Cual elige?");
                                        prin.salidaP.flush();
                                        respuesta = prin.entradaP.readUTF();
                                        doWait(2000);
                                        prin.getJTextArea2().setText("Recetando...");
                                        if (respuesta.equals(PrimitivasServidor.RespuestaCuraPS)) {
                                            respuesta = prin.entradaP.readUTF();
                                            prin.salidaP.writeUTF(PrimitivasCliente.RespuestaCP);
                                            prin.salidaP.flush();
                                            if (respuesta.equals("PH")) {
                                                prin.salidaP.writeUTF("El tratamiento de Programa de Ejercicios\n tiene una" +
                                                                     "duracion de 6 meses 2 veces a la semana");
                                                prin.salidaP.flush();
                                                System.out.println("Entro SI");
                                            } else if (respuesta.equals("CY")) {
                                                prin.salidaP.writeUTF("El tratamiento de Clases de Yoga tiene\n" +
                                                        "duracion minima de 7 meses");
                                                prin.salidaP.flush();
                                            }
                                        }
                                        prin.salidaP.writeUTF("Espero que se mejore...\nHasta Luego!!");
                                        prin.salidaP.flush();
                                        doWait(3000);
                                        prin.getJTextArea4().setText("");
                                        prin.frame.getJLabel1().setIcon(new ImageIcon("psicologoTT.png"));
                                        prin.frame.getJLabel2().setIcon(new ImageIcon("TerapeutaT.png"));
                                        prin.frame.getJLabel3().setIcon(new ImageIcon("ginecologoTG.png"));
                                        prin.jPanel1.updateUI();
                                        prin.repaint();
                                    } else if(respuesta.equals("NO")){
                                        prin.salidaP.writeUTF(PrimitivasCliente.RespuestaNOP);
                                        prin.salidaP.flush();
                                        prin.salidaP.writeUTF("Usted esta sana...\nHasta Luego");
                                        prin.salidaP.flush();
                                        prin.getJTextArea4().setText("");
                                        prin.frame.getJLabel1().setIcon(new ImageIcon("psicologoTT.png"));
                                        prin.frame.getJLabel2().setIcon(new ImageIcon("TerapeutaT.png"));
                                        prin.frame.getJLabel3().setIcon(new ImageIcon("ginecologoTG.png"));
                                        prin.jPanel1.updateUI();
                                        prin.repaint();
                                    }
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            // Recibida una performativa incorrecta
                            ACLMessage reply = msg.createReply();
                            reply.setPerformative(ACLMessage.NOT_UNDERSTOOD);
                            reply.setContent("( (Unexpected-act " + ACLMessage.getPerformative(msg.getPerformative()) +
                                             ")( expected (inform)))");
                            send(reply);
                        }
                    }
                } else {
                    //System.out.println("No message received");
                }
            } catch (jade.content.lang.Codec.CodecException ce) {
                System.out.println(ce);
            } catch (jade.content.onto.OntologyException oe) {
                System.out.println(oe);
                oe.printStackTrace();
            }
            finished = false;
        }

        @Override
        public boolean done() {
            return finished;
        }

    }
}