/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemasexpertost2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Ventana  extends JFrame{

private JButton botonPoblacion=new JButton("Generar poblacion");
private JButton botonGeneraciones=new JButton("Generaciones");

private String[] columnas ={"5","4","3","2","1","0","Decimal"};
private Object[][] datos={{" "," "," "," "," "," "," "}};
private JTextField promedio1=new JTextField("    ");
private JLabel etiqueta1=new JLabel("Promedio: ");
private JLabel etiqueta2=new JLabel("No. generaciones: ");
final JTable tabla;
private JPanel panelTabla=new JPanel();
private DefaultTableModel dtm;
public int poblacionInicial[][]=new int[6][7];
public float promedio;
private JCheckBox maxBox=new JCheckBox("Maximizar");
private JCheckBox minBox=new JCheckBox("Minimizar");

public Ventana()
{
    
  super("Herencia genetica");  
  setLayout(null);
  
  botonPoblacion.setBounds(100, 50, 180, 30);
  botonGeneraciones.setBounds(600, 50, 180, 30);
  
  panelTabla.setBounds(new Rectangle(50, 100, 250, 200));
  panelTabla.setBackground(Color.LIGHT_GRAY);
  
  etiqueta1.setBounds(50, 300, 100, 30);
  etiqueta2.setBounds(50, 340, 150, 30);
 
  promedio1.setBounds(130,310, 100, 20);
  maxBox.setBounds(350,50,120,20);
  minBox.setBounds(470,50,120,20);
  
  ButtonHandler handler=new ButtonHandler();
  botonPoblacion.addActionListener(handler);
  botonGeneraciones.addActionListener(handler);
  
  dtm=new DefaultTableModel(datos,columnas);
  tabla=new JTable(dtm);
  tabla.setPreferredScrollableViewportSize(new Dimension(250,300));
  JScrollPane miScroll=new JScrollPane(tabla);
  panelTabla.add(miScroll);
  
  maxBox.setEnabled(false);
  minBox.setEnabled(false);
  
  this.add(botonPoblacion);
  this.add(botonGeneraciones);
  this.add(panelTabla);
  this.add(etiqueta1);
  this.add(promedio1);
  this.add(maxBox);
  this.add(minBox);
  this.add(etiqueta2);
  dtm.removeRow(0);
  
  this.promedio=0;
}
     

private class ButtonHandler implements ActionListener
{
public void actionPerformed(ActionEvent event)
 {

   if(event.getActionCommand()=="Generar poblacion") 
   {
    maxBox.setEnabled(true);
    minBox.setEnabled(true);         
  
    poblacionInicial=generarPoblacionInicial();   
   
    String[][] cadena=new String[6][7];
    
    /*
    Cambiamos los vectores binarios a cadenas
    */
    for (int i = 0; i < 6; i++) 
    {        
      for (int j = 0; j < 7; j++) 
       {
         cadena[i][j] = poblacionInicial[i][j] + "";
         
       }
      dtm.addRow(cadena[i]);
    }
    /*
    Sacamos el promedio con base a la buncicion
    f(x)=x3-x2
    */
    for (int i = 0; i < 6; i++) 
    {        
      promedio+=Math.pow(poblacionInicial[0][6],3)-Math.pow(poblacionInicial[0][6],2);
    }
   
    promedio1.setText((promedio/6)+"");
      
   }
   else
   if(event.getActionCommand()=="Generaciones") 
   {
       System.out.println("Hola Mundo");
       
       if(maxBox.isSelected())
       {                                                             //falta colocar el numero de iteraciones          
         MaximizarMinimizar maximizar=new MaximizarMinimizar(poblacionInicial,1);
       }
       else
         if(minBox.isSelected())
         {
          MaximizarMinimizar minimizar=new MaximizarMinimizar(poblacionInicial,1);
         }
   }
   
 }

}
    
public int[][] generarPoblacionInicial()
{
 int[][] poblacion=new int[6][7];
 int sumDecimal=0;
 Random numerosAleatorios=new Random();
 
 //generamos los numeros aleatorios binarios
 for(int i=0;i<6;i++)
 {
   for(int j=6;j>=0;j--)
   {
     poblacion[i][j]=numerosAleatorios.nextInt(2);
   }
 
 }
 //obtnemos su representacion en numero decimal
  for(int i=0;i<6;i++)
  {
    sumDecimal=0;  
    for(int j=0;j<6;j++)
    {
      if(poblacion[i][j]==1)
      {
        sumDecimal+=Math.pow(2,5-j);
      }
   }
   poblacion[i][6]=sumDecimal;   
 }

 return poblacion;
}




}
