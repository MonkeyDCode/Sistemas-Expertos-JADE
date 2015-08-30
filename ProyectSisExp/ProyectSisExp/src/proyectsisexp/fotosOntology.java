package proyectsisexp;
 
import jade.content.onto.*;
import jade.content.schema.*;
 
public class fotosOntology extends Ontology {
   // Nombre de la ontología
   public static final String ONTOLOGY_NAME = "ontología de fotografias";
 
  // Vocabulario de la ontología que van a manejar los agentes
  public static final String FOTO = "foto";
  public static final String FOTO_RUTA = "ruta";
  public static final String FOTO_PRECIO = "10";
 
  public static final String OFERTA = "Oferta";
  public static final String OFERTA_FOTO = "oferta de foto";
 
  public static final String COMPRAR = "Comprar";
  public static final String COMPRAR_FOTO = "foto";

  public static final String RECIBIR_FOTO = "Comprar foto";
  public static final String IMPRIMIR_FOTO = "imprime foto";
  public static final String ENVIAR_FOTO = "envia foto";


  // Instancia de la ontología (que será única)
  private static Ontology instancia = new fotosOntology();
 
  // Método para acceder a la instancia de la ontología
  public static Ontology getInstance() {
     return instancia;
   }
 
   // Constructor privado
   private fotosOntology() {
     // fotosOntology extiende la ontología básica
     super(ONTOLOGY_NAME, BasicOntology.getInstance());
 
     try {
       // Añade los elementos
       add(new ConceptSchema(FOTO), Cajero.class);
       add(new PredicateSchema(OFERTA), Ejecutivo.class);
       add(new AgentActionSchema(COMPRAR), Gerente.class);
 
       // Estructura del esquema para el concepto FOTO
       ConceptSchema cs = (ConceptSchema) getSchema(FOTO);
       cs.add(FOTO_RUTA, (PrimitiveSchema) getSchema(BasicOntology.STRING));
       cs.add(FOTO_PRECIO, (PrimitiveSchema) getSchema(BasicOntology.INTEGER));
 
       // Estructura del esquema para el predicado OFERTA
       PredicateSchema ps = (PredicateSchema) getSchema(OFERTA);
       ps.add(OFERTA_FOTO, (ConceptSchema) getSchema(FOTO));
 
       // Estructura del esquema para la acción COMPRAR
       AgentActionSchema as = (AgentActionSchema) getSchema(COMPRAR);
       as.add(COMPRAR_FOTO, (ConceptSchema) getSchema(FOTO));
     }
     catch (OntologyException oe) {
       oe.printStackTrace();
     }
   }
}