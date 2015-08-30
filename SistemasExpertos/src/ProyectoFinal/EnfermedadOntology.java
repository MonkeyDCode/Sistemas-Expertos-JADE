package ProyectoFinal;

import jade.content.onto.BasicOntology;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.content.schema.AgentActionSchema;
import jade.content.schema.ConceptSchema;
import jade.content.schema.PredicateSchema;
import jade.content.schema.PrimitiveSchema;

public class EnfermedadOntology extends Ontology{
    public static final String ONTOLOGY_NAME = "Ontologia de Enfermedades";
    
    public static final String ENFERMEDAD = "Enfermedad";
    public static final String ENFERMEDAD_NOMBRE = "Nombre";
    public static final String ENFERMEDAD_SINTOMA1 = "SintomaA";
    public static final String ENFERMEDAD_SINTOMA2 = "SintomaB";
    public static final String ENFERMEDAD_SINTOMA3 = "SintomaC";
    public static final String ENFERMEDAD_CURA1 = "Cura1";
    public static final String ENFERMEDAD_CURA2 = "Cura2";
    
    public static final String DIAGNOSTICAR = "Diagnostico";
    public static final String DIAGNOSTICAR_ENFERMEDAD = "Enfermedad";
    
    public static final String RECETAR = "Recetar";
    public static final String RECETAR_ENFERMEDAD = "Enfermedad";
    
    private static Ontology instancia = new EnfermedadOntology();
    
    public static Ontology getInstance() {
       return instancia;
     }
    
    private EnfermedadOntology() {
        super(ONTOLOGY_NAME, BasicOntology.getInstance());
        
        try {
          add(new ConceptSchema(ENFERMEDAD), Enfermedad.class);
          add(new PredicateSchema(DIAGNOSTICAR), Diagnosticar.class);
          add(new AgentActionSchema(RECETAR), Recetar.class);
        
          ConceptSchema cs = (ConceptSchema) getSchema(ENFERMEDAD);
          cs.add(ENFERMEDAD_NOMBRE, (PrimitiveSchema) getSchema(BasicOntology.STRING));
          cs.add(ENFERMEDAD_SINTOMA1, (PrimitiveSchema) getSchema(BasicOntology.STRING));
          cs.add(ENFERMEDAD_SINTOMA2, (PrimitiveSchema) getSchema(BasicOntology.STRING));
          cs.add(ENFERMEDAD_SINTOMA3, (PrimitiveSchema) getSchema(BasicOntology.STRING));
          cs.add(ENFERMEDAD_CURA1, (PrimitiveSchema) getSchema(BasicOntology.STRING));
          cs.add(ENFERMEDAD_CURA2, (PrimitiveSchema) getSchema(BasicOntology.STRING));
        
          PredicateSchema ps = (PredicateSchema) getSchema(DIAGNOSTICAR);
          ps.add(DIAGNOSTICAR_ENFERMEDAD, (ConceptSchema) getSchema(ENFERMEDAD));
        
          AgentActionSchema as = (AgentActionSchema) getSchema(RECETAR);
          as.add(RECETAR_ENFERMEDAD, (ConceptSchema) getSchema(ENFERMEDAD));
        }
        catch (OntologyException oe) {
          oe.printStackTrace();
        }
    }
}
