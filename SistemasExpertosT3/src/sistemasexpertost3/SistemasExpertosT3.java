/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemasexpertost3;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class SistemasExpertosT3  extends JFrame {

    private MiPanel areaTrabajo;
    private JPanel panelControl;
    private BorderLayout layout;
    private JLabel etiquetaRuta=new JLabel("Ruta: ");
    private JTextField textRuta=new JTextField("                                                     ");
    private JButton botonRuta;
    public int maximo;
    public int minimo;
    public int[][] matrizPesos=new int[10][10];
    public int[] recorrido=new int[10];         
    public static void main(String[] args) {
      
      SistemasExpertosT3 ventana=new SistemasExpertosT3();
     
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setSize(800,600);
      ventana.setVisible(true);
      ventana.setLocationRelativeTo(null);
        
    }
    
    public SistemasExpertosT3()
    {
      this.setTitle("Ruta mas corta en un grafo");
      layout = new BorderLayout(2, 2);
      
      botonRuta = new JButton("BUSCAR RUTA");
    
      
      areaTrabajo=new MiPanel();
      
      panelControl = new JPanel();
      panelControl.add(botonRuta);
      panelControl.add(etiquetaRuta);
      panelControl.add(textRuta);
      ButtonHandler handler = new ButtonHandler();
      botonRuta.addActionListener(handler);

      
      
       Container cp = this.getContentPane();
       cp.setLayout(layout);
       

       cp.add(panelControl, BorderLayout.NORTH);
       cp.add(areaTrabajo, BorderLayout.SOUTH);
    }
    
     private class ButtonHandler implements ActionListener {

     public void actionPerformed(ActionEvent event) 
      {
        if (event.getActionCommand() == "BUSCAR RUTA") 
        {      
          matrizPesos=areaTrabajo.getMatriz();   
          Logica logica=new Logica();
                //System.out.println(logica.floyd(matrizPesos));     
          String[] caminos=logica.floyd(matrizPesos).split("\n");
          String[] cadenaNumeros=logica.getCadena().split(" ");
                
          int[]distancias=new int[110];
               
          for (int i = 0; i<cadenaNumeros.length; i++) 
          {
           distancias[i]=Integer.parseInt(cadenaNumeros[i]);
           System.out.printf("%d  ",distancias[i]);
          }
                
          maximo=0;
          minimo=200;
          
          int caminoCorto=0;
          int caminoLargo=0;
          /*BUSCAR EL MAXIMO Y EL MINIMO*/
          for (int i = 0; i<distancias.length; i++) 
          {
            if(distancias[i]!=0)
             {      
               if(distancias[i]<minimo)
                {
                 minimo=distancias[i];
                 caminoCorto++;
                }
                             
               if(maximo<distancias[i])
                {
                 maximo=distancias[i];
                 caminoLargo++;
                }       
            }      
          }
               
         System.out.println("El minimo es:"+minimo+" ruta "+caminos[caminoCorto]+"  "+caminoCorto);     
         buscaRutaMinima(caminos,caminoCorto);        
         textRuta.setText(recorrido[0]+"  "+recorrido[1]+"  "+recorrido[2]+"  "+recorrido[3]+"  "+recorrido[4]+"  "+recorrido[5]+"  "+recorrido[6]+"  "+recorrido[7]+"  "+recorrido[8]+"  "+recorrido[9]);
         }
      }
   }
    
    
     public void buscaRutaMinima(String[] caminos,int caminoCorto)
     {
       recorrido[0]=1;
       int cont=1;
       char[] cadenaNum = null;
                
       while(cont<10)
       {
         cadenaNum=caminos[caminoCorto].toCharArray();   
          for (int j = 1; j<cadenaNum.length; j++)
           {
             if((cadenaNum[j]!=' ')&&(cadenaNum[j]!='1'))
               {
                 int numero=Integer.parseInt(cadenaNum[j]+"");
                 int indice=Arrays.binarySearch(recorrido,numero);
                         
                 if(indice<0)
                   {
                     int band=0;
                     for (int x = 0; x<cont; x++)         
                       {
                         if(numero==recorrido[x])
                           {
                                band=1;    
                            }
                        }
                            
                        if(band==0)
                         {
                          recorrido[cont]=numero;        
                          System.out.println(cont);
                          cont++;
                           if(cont>=10)
                            {
                             break;
                            }  
                         }
                            
                    }
                }
            }
                  
           caminoCorto++;      
           if(cont>=10)
           {
            break;
           }         
       }
             
     for (int j = 0; j<recorrido.length; j++)
     {
        if(recorrido[j]==0)
         {
          recorrido[j]=10;
         }
                 
     }   
  }
    
}
