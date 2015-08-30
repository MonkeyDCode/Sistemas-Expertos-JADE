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
import javax.swing.JTextArea;

public class Terapeuta extends Agent {
    private Codec codec = new SLCodec();
    private Ontology ontologia = EnfermedadOntology.getInstance();

    public Terapeuta() {
        super();
    }

    @Override
    protected void setup() {
        getContentManager().registerLanguage(codec);
        getContentManager().registerOntology(ontologia);
        TerapeutaBehaviour terapeutaBehaviour = new TerapeutaBehaviour(this);
        addBehaviour(terapeutaBehaviour);
    }

    class TerapeutaBehaviour extends SimpleBehaviour {
        private boolean finished = true;
        String respuesta = "";
        Principal prin = Principal.p1;

        public TerapeutaBehaviour(Agent a) {
            super(a);
        }

        @Override
        public void action() {
            ACLMessage msg = null;
            Diagnosticar diagnosticar = null;
            Enfermedad enfermedad = null;
            prin.getJTextArea3().setText("Estoy listo para recibir paciente");
            try {
                respuesta = prin.entradaT.readUTF();
                System.out.println("Entro T: "+respuesta);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (respuesta.equals(PrimitivasServidor.ContactarTS)) {
                prin.frame.getJLabel3().setIcon(new ImageIcon("ginecologoT.png"));
                prin.frame.getJLabel2().setIcon(new ImageIcon("TerapeutaT.png"));
                prin.frame.getJLabel1().setIcon(new ImageIcon("psicologoTTG.png"));
                prin.jPanel1.updateUI();
                prin.repaint();
                enfermedad = new Enfermedad();
                enfermedad.setNombre("Dispaurenia");
                enfermedad.setSintomaA("Inadecuada Lubricacion Vaginal");
                enfermedad.setSintomaB("Irritacion Vaginal");
                enfermedad.setSintomaC("Coito Doloroso");
                enfermedad.setCura1("Terapia de desensibilización");
                enfermedad.setCura2("Consejería o terapia sexual");
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
                            prin.getJTextArea3().setText("Recibo paciente con los sintomas:\n" +
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
                            prin.getJTextArea3().append("\nPuedo tratar al paciente");
                            doWait(3000);
                            prin.getJTextArea4().setText("");
                            try {
                                prin.salidaT.writeUTF(PrimitivasCliente.RespuestaT);
                                prin.salidaT.flush();
                                prin.salidaT.writeUTF("Me han comentado que sus sintomas son:\n" +
                                        "Sintoma: " + enfermedad.getSintomaA() + "\n" +
                                        "Sintoma: " + enfermedad.getSintomaB() + "\n" +
                                        "Sintoma: " + enfermedad.getSintomaC() + "\n" +
                                        "Esta de acuerdo?\n SI - SI estoy de acuerdo\nNO - NO estoy de acuerdo\n");
                                prin.salidaT.flush();
                                respuesta = prin.entradaT.readUTF();
                                if (respuesta.equals(PrimitivasServidor.RespuestaSintomasTS)) {
                                    respuesta = prin.entradaT.readUTF();
                                    prin.getJTextArea3().setText("En consulta...");
                                    if (respuesta.equals("SI")) {
                                        prin.salidaT.writeUTF(PrimitivasCliente.RespuestaSIT);
                                        prin.salidaT.flush();
                                        prin.salidaT.writeUTF("Usted Padece: DISPAURENIA\n" +
                                                "Curas Disponibles\n" +
                                                "TD - " + enfermedad.getCura1() + "\n" +
                                                "TS - " + enfermedad.getCura2() + "\n" +
                                                "Cual elige?");
                                        prin.salidaT.flush();
                                        respuesta = prin.entradaT.readUTF();
                                        doWait(2000);
                                        prin.getJTextArea3().setText("Recetando...");
                                        if (respuesta.equals(PrimitivasServidor.RespuestaCuraTS)) {
                                            respuesta = prin.entradaT.readUTF();
                                            prin.salidaT.writeUTF(PrimitivasCliente.RespuestaCT);
                                            prin.salidaT.flush();
                                            if (respuesta.equals("TD")) {
                                                prin.salidaT.writeUTF("El tratamiento de Terapia de Senzabilizacion\n tiene una" +
                                                                     "duracion de 6 meses 2 veces a la semana");
                                                prin.salidaT.flush();
                                            } else if (respuesta.equals("TS")) {
                                                prin.salidaT.writeUTF("El tratamiento de Terapia Sexual tiene\n" +
                                                        "duracion minima de 7 meses");
                                                prin.salidaT.flush();
                                            }
                                        }
                                        prin.salidaT.writeUTF("Espero que se mejore...\nHasta Luego!!");
                                        prin.salidaT.flush();
                                        doWait(3000);
                                        
                                    } else if(respuesta.equals("NO")){
                                        prin.salidaT.writeUTF(PrimitivasCliente.RespuestaNOT);
                                        prin.salidaT.flush();
                                        prin.salidaT.writeUTF("Usted esta sana...\nHasta Luego");
                                        prin.salidaT.flush();
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
                    prin.getJTextArea4().setText("");
                    prin.frame.getJLabel1().setIcon(new ImageIcon("psicologoTT.png"));
                    prin.frame.getJLabel2().setIcon(new ImageIcon("TerapeutaT.png"));
                    prin.frame.getJLabel3().setIcon(new ImageIcon("ginecologoTG.png"));
                    prin.jPanel1.updateUI();
                    prin.repaint();
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
