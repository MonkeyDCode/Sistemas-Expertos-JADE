/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectsisexp;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Fer
 */
public class ReportePDF 
{
    private File destino=null;
   
        public ReportePDF(String name)
        {
            Ejecutivo ejecutivo = new Ejecutivo();
            Cajero cajero = new Cajero();
            String nombre = null,direccion=null,cantidad=null,formFecha=null;
            int tot=0;
		try {
		    Document minuta = new Document() {};
                    PdfWriter.getInstance(minuta, new FileOutputStream("/root/Documents/"
                            + "reporte.pdf"));
                            
                            nombre = name;
                                
                            Paragraph parag1 = new Paragraph();
                            Paragraph parag2 = new Paragraph();
                            Paragraph parag3 = new Paragraph();
                            Paragraph parag4 = new Paragraph();
                           
                            Image image = null;
                            try {
                                image = Image.getInstance("Header.jpg");
                            } catch (BadElementException ex) {
                                Logger.getLogger(ReportePDF.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (MalformedURLException ex) {
                            Logger.getLogger(ReportePDF.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(ReportePDF.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        image.scaleToFit(500, 150);
                        image.setAlignment(Chunk.ALIGN_CENTER);
                     
                        parag1.add("No. de Impresion:   AA4587ET878\n");
                        parag1.setAlignment(Paragraph.ALIGN_RIGHT);
                        parag2.add("DATOS DEL CLIENTE: "+"\n");
                        parag2.add("Nombre: "+nombre+"\n");

                        Calendar fecha = new GregorianCalendar();
                        formFecha =fecha.get(Calendar.DAY_OF_MONTH)+"/"+(fecha.get(Calendar.MONTH)+1)+"/"+fecha.get(Calendar.YEAR);
                        parag2.add("Fecha: "+formFecha+"\n\n\n");
                        parag2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
                        
                        parag3.add("\t\tTipo de Pago                                    Cantidad                    \n\n");
                        parag3.add("\t\tEfectivo                                                    $"+"10"+"                 \t\t\t\n");
                        parag3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
                        
                        parag4.add("\n\n\n\n\n  _____________________________________");
                        parag4.add("\n  Nombre y Firma del Cliente");
                        parag4.setAlignment(Paragraph.ALIGN_CENTER);
              
                        minuta.open();
                        minuta.add(image);
                        minuta.add(parag1);
                        minuta.add(parag2);
                        minuta.add(parag3);
                        minuta.add(parag4);
                        minuta.close(); 
                        JOptionPane.showMessageDialog(null,"Impresión Generada");
                    } catch (DocumentException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                        }catch(Exception ex){
                    System.out.println(ex.getMessage());
                    }finally {//para cerrar el stream
                    }   
}
	
  
		      
	public void RutaDestino()
        {
	       FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo PDF","pdf","PDF");
	       JFileChooser fileChooser = new JFileChooser();       
	       fileChooser.setFileFilter(filter);
               File archivo  = new File("/root/Documents/reporte.pdf");
	       int result = fileChooser.showSaveDialog(null);
	       if ( result == JFileChooser.APPROVE_OPTION ){   
	        //   this.destino = fileChooser.getSelectedFile().getAbsoluteFile();
                   this.destino = archivo;
               }
	 }
}