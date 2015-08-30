package ProyectoFinal;

import jade.content.ContentElement;
import jade.content.lang.Codec;
import jade.content.lang.Codec.CodecException;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;

import jade.content.onto.OntologyException;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;

import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;

import jade.lang.acl.ACLMessage;

import jade.lang.acl.MessageTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Random;

import javax.swing.ImageIcon;


public class Ginecologo extends Agent {
    private Codec codec = new SLCodec();
    private Ontology ontologia = EnfermedadOntology.getInstance();

    public Ginecologo() {
        super();
    }

    @Override
    protected void setup() {
        /** Registrarse en el DF */
        DFAgentDescription dfd = new DFAgentDescription();
        ServiceDescription sd = new ServiceDescription();
        sd.setType("Ginecologo");
        sd.setName(getName());
        sd.setOwnership("CASADECITAS");
        dfd.setName(getAID());
        dfd.addServices(sd);
        try {
            DFService.register(this, dfd);
        } catch (FIPAException e) {
            System.err.println(getLocalName() + " Registracion Fallo. Razon: " + e.getMessage());
            doDelete();
        }

        getContentManager().registerLanguage(codec);
        getContentManager().registerOntology(ontologia);

        GinecologoeBehaviour ginecologoBehaviour = new GinecologoeBehaviour(this);
        addBehaviour(ginecologoBehaviour);
    }

    @Override
    protected void takeDown() {
        try {
            DFService.deregister(this);
        } catch (FIPAException fe) {
            fe.printStackTrace();
        }
    }

    class GinecologoeBehaviour extends SimpleBehaviour {
        private boolean finished = false;
        private boolean accion = false;
        //Principal prin = Principal.p1;
        PrincipalII prinII = PrincipalII.p2;
        String respuestaC = "A";
        private String respuesta;

        public GinecologoeBehaviour(Agent a) {
            super(a);
        }

        @Override
        public void action() {
            try {
                ACLMessage msg = null;
                prinII.getJTextArea4().setText("BIENVENIDA...Como le puedo ayudar?\n\tEE -> Estoy Enferma\n\tVR -> Vengo a revision\n\tME -> Me equivoque");
                do {
                    doWait(3000);
                    respuestaC = prinII.getJTextField1().getText();
                    if (respuestaC.equals("EE")) {
                        prinII.getJTextField1().setText("");
                        prinII.getJTextArea4().setText("Digame que sintoma presenta:\n" +
                                "   DE - Depresi�n\n" +
                                "   AN - Ansiedad\n" +
                                "   IN - Inhibicion recurrente del orgasmo\n" +
                                "   FL - Flujo Grumoso\n" +
                                "   MO - Molestia o Picor\n" +
                                "   DO - Dolor al orinar\n" +
                                "   IL - Inadecuada Lubricacion Vaginal\n" +
                                "   IR - Irritacion Vaginal\n" +
                                "   CO - Coito Doloroso\n");
                        do {
                            doWait(3000);
                            respuestaC = prinII.getJTextField1().getText();
                            prinII.getJTextField1().setText("");
                            if (respuestaC.equals("DE") || respuestaC.equals("AN") || respuestaC.equals("IN")) {
                                ComunicaPsicologo();
                            } else if (respuestaC.equals("FL") || respuestaC.equals("MO") || respuestaC.equals("DO")) {
                                AccionGinecologo();
                            } else if (respuestaC.equals("IL") || respuestaC.equals("IR") || respuestaC.equals("CO")) {
                                ComunicaTerapeuta();
                            }
                        } while (accion == false);
                    } else if (respuestaC.equals("VR")) {
                        prinII.getJTextField1().setText("");
                        prinII.getJTextArea4().setText("Pase por favor.");
                        doWait(2000);
                        prinII.getJTextArea4().setText("Revisando al paciente...");
                        doWait(2000);
                        int n = (int)(Math.random() * 3);
                        if (n == 0) {
                            ComunicaPsicologo();
                        } else if (n == 1) {
                            AccionGinecologo();
                        } else if (n == 2) {
                            ComunicaTerapeuta();
                        }
                        doWait(3000);
                    } else if (respuestaC.equals("ME")) {
                        prinII.getJTextField1().setText("");
                        prinII.getJTextArea4().setText("No se preocupe ... ADIOS");
                        doWait(2000);
                        accion = true;
                    }
                } while (accion == false);
                accion = false;
            } catch (jade.content.lang.Codec.CodecException ce) {
                System.out.println(ce);
            } catch (jade.content.onto.OntologyException oe) {
                System.out.println(oe);
            } catch (Exception e) {
                System.out.println("\n\n... Terminando ...");
                finished = true;
            }
        }

        public boolean done() {
            return finished;
        }
        
        private void ComunicaTerapeuta() throws CodecException, OntologyException, IOException {
         
        do{   
            prinII.getJTextArea4().setText("Los sintomas que usted presenta son:\n" +
                    "-Inadecuada Lubricacion Vaginal\n" +
                    "-Irritacion Vaginal\n" +
                    "-Coito Doloroso\n" +
                    "La canalizare con un colega espere...");
            doWait(2000);
            
            prinII.salida.writeUTF(PrimitivasCliente.ContactarT);
            prinII.salida.flush();
            respuesta=prinII.entrada.readUTF();
            prinII.getJTextArea4().setText("Pase por favor con el terapeuta");
            doWait(2000);
            prinII.getJTextArea4().setText("");

            
            prinII.jPanel1.updateUI();
            prinII.repaint();
            
            prinII.getJTextArea3().setText(respuesta);
            prinII.salida.writeUTF(PrimitivasCliente.RespuestaSintomasT);
            prinII.salida.flush(); 
            
            do{
                respuesta=prinII.getJTextField1().getText();
                if(respuesta.equals("SI")||respuesta.equals("NO")){
                    accion=true;
                }
            }while(accion==false);
            
            prinII.getJTextField1().setText("");
            doWait(2000);
            prinII.salida.writeUTF(respuesta);
            prinII.salida.flush(); 
            accion=false;
            respuesta=prinII.entrada.readUTF();
            
            if(respuesta.equals(PrimitivasServidor.RespuestaSISG)){
                respuesta=prinII.entrada.readUTF();
                prinII.getJTextArea3().setText(respuesta);
                prinII.salida.writeUTF(PrimitivasCliente.RespuestaCuraT);
                prinII.salida.flush(); 
                do{
                    respuesta=prinII.getJTextField1().getText();
                    if(respuesta.equals("TD")||respuesta.equals("TS")){
                        accion=true;
                    }
                }while(accion==false);
                prinII.getJTextField1().setText("");
                doWait(2000);
                prinII.salida.writeUTF(respuesta);
                prinII.salida.flush(); 
                respuesta=prinII.entrada.readUTF();
                prinII.getJTextArea3().setText(respuesta);
                doWait(2000);
                respuesta=prinII.entrada.readUTF();
                prinII.getJTextArea3().setText(respuesta);
                doWait(2000);
                prinII.getJTextArea3().setText("");    
            }else if(respuesta.equals(PrimitivasServidor.RespuestaNOTSG)){
                System.out.println("Me quedo aqui");
                respuesta=prinII.entrada.readUTF();
                prinII.getJTextArea3().setText(respuesta);
                doWait(2000);
                prinII.getJTextArea3().setText("");
                accion=true;
            }
        }while(accion==false);

            
            prinII.jPanel1.updateUI();
            prinII.repaint();
        }

        private void ComunicaPsicologo() throws CodecException, OntologyException, IOException {
             
            do{   
                prinII.getJTextArea4().setText("Los sintomas que usted presenta son:\n" +
                        "-Inadecuada Lubricacion Vaginal\n" +
                        "-Irritacion Vaginal\n" +
                        "-Coito Doloroso\n" +
                        "La canalizare con un colega espere...");
                doWait(2000);
                
                prinII.salida2.writeUTF(PrimitivasCliente.ContactarP);
                prinII.salida2.flush();
                respuesta=prinII.entrada2.readUTF();
                prinII.getJTextArea4().setText("Pase por favor con la psicologa");
                doWait(2000);
                prinII.getJTextArea4().setText("");

                
                prinII.jPanel1.updateUI();
                prinII.repaint();
                
                prinII.getJTextArea2().setText(respuesta);
                prinII.salida2.writeUTF(PrimitivasCliente.RespuestaSintomasP);
                prinII.salida2.flush(); 
                
                do{
                    respuesta=prinII.getJTextField1().getText();
                    if(respuesta.equals("SI")||respuesta.equals("NO")){
                        accion=true;
                    }
                }while(accion==false);
                
                prinII.getJTextField1().setText("");
                doWait(2000);
                prinII.salida2.writeUTF(respuesta);
                prinII.salida2.flush(); 
                accion=false;
                respuesta=prinII.entrada2.readUTF();
                
                if(respuesta.equals(PrimitivasServidor.RespuestaSISGP)){
                    respuesta=prinII.entrada2.readUTF();
                    prinII.getJTextArea2().setText(respuesta);
                    prinII.salida2.writeUTF(PrimitivasCliente.RespuestaCuraP);
                    prinII.salida2.flush(); 
                    do{
                        respuesta=prinII.getJTextField1().getText();
                        if(respuesta.equals("PH")||respuesta.equals("CY")){
                            accion=true;
                        }
                    }while(accion==false);
                    prinII.getJTextField1().setText("");
                    doWait(2000);
                    prinII.salida2.writeUTF(respuesta);
                    prinII.salida2.flush();
                    /***/
                    System.out.println("Lloro Lloro");
                    respuesta=prinII.entrada2.readUTF();
                    System.out.println("Respuesta= "+respuesta);
                    prinII.getJTextArea2().setText(respuesta);
                    doWait(2000);
                    respuesta=prinII.entrada2.readUTF();
                    prinII.getJTextArea2().setText(respuesta);
                    doWait(2000);
                    prinII.getJTextArea2().setText("");    
                }else if(respuesta.equals(PrimitivasServidor.RespuestaNOTSGP)){
                    respuesta=prinII.entrada2.readUTF();
                    prinII.getJTextArea2().setText(respuesta);
                    doWait(2000);
                    prinII.getJTextArea2().setText("");
                    accion=true;
                }
            }while(accion==false);

                prinII.jPanel1.updateUI();
                prinII.repaint();
        }

        private void AccionGinecologo() {
            prinII.getJTextArea4().setText("Dado los sintomas que usted presenta:\n" +
                    "-Flujo Grumoso\n" +
                    "-Molestia o Picor\n" +
                    "-Dolor al orinar\n" +
                    "Usted tiene: INFECCION VAGINAL");
            doWait(3000);
            prinII.getJTextArea4().setText("Curas Disponibles\n" +
                    "MF - Medicamentos Fungicidas\n" +
                    "CV - Crema Vaginal\n" +
                    "Cual elige?");
            do {
                doWait(3000);
                respuestaC = prinII.getJTextField1().getText();
                if (respuestaC.equals("MF")) {
                    prinII.getJTextArea4().setText("El tratamiento de Medicamentos Fungicidas tiene\n" +
                                                   "duracion de 1 mes apliquela 2 veces al dia");
                    doWait(3000);
                    accion = true;
                } else if (respuestaC.equals("CV")) {
                    prinII.getJTextArea4().setText("El tratamiento de Crema Vaginal tiene\n" +
                                                   "duracion de 2 mes apliquela 1 vez al dia");
                    doWait(3000);
                    accion = true;
                }
            } while (accion == false);
            prinII.getJTextField1().setText("");
            prinII.getJTextArea4().setText("Espero que se mejore...\nHasta Luego");
            doWait(3000);
        }
    }
}