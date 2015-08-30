/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemasexpertost3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;


public class MiPanel extends JPanel{

    private final static Color VIOLETA = new Color(128, 0, 128);
    private final static Color INDIGO = new Color(75, 0, 130);
    private final static Color[] colores = {Color.white, Color.white, VIOLETA, INDIGO, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED};
    public char[] nodos={'1','2','3','4','5','6','7','8','9','1','0'};
    public String[] pesos=new String[45];
    public int[][]  matrizPesos=new int[10][10];
            
    public MiPanel()
    {
     setBackground(Color.lightGray);
     setPreferredSize(new Dimension(600,600));
    
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        
        super.paintComponent(g);
        
        pintaGrafo(g);
    }
    
    public void generaPesos()
    {
      Random numerosAleatorios=new Random();
      
      for (int i = 0; i <45; i++) 
      {
         pesos[i]=(numerosAleatorios.nextInt(70)+1)+"";
      }
    
    }
    
    public void pintaGrafo(Graphics g)
    {
    
        super.paintComponent(g);
        generaPesos();
       /*
        DIBUJA EL CONTORNO DEL GRAFO
        */
       g.setColor(Color.RED);
       g.drawLine(300  , 60, 500  , 120);//1
       g.drawLine(500  , 120, 560  , 220);//2
       g.drawLine(560  , 220, 580  , 320);//3
       g.drawLine(580  , 320, 500  , 420);//4
       g.drawLine(500  , 420, 300  , 520);//5
       g.drawLine(300  , 520, 100  , 420);//6
       g.drawLine(100  , 420, 30  , 320);//7
       g.drawLine(30  , 320, 50  , 220);//8
       g.drawLine(50  , 220, 100  , 120);//9
       g.drawLine(100  , 120, 300  , 60);//10
       
       /*
       aristas nodo 10
       */
       g.drawLine(100  , 120, 500  , 120);//11
       g.drawLine(100  , 120, 560  , 220);//12
       g.drawLine(100  , 120, 580  , 320);//13
       g.drawLine(100  , 120, 500  , 420);//14
       g.drawLine(100  , 120, 300  , 520);//15
       g.drawLine(100  , 120, 100  , 420);//16
       g.drawLine(100  , 120, 30  , 320);//17
       /*
       aristas nodo 2
       */
       //g.setColor(Color.GREEN);
       g.drawLine(500  , 120, 50  , 220);//18
       g.drawLine(500  , 120, 30  , 320);//19
       g.drawLine(500  , 120, 100  , 420);//20
       g.drawLine(500  , 120, 300  , 520);//21
       g.drawLine(500  , 120, 500 , 420);//22
       g.drawLine(500  , 120, 580  , 320);//23
      /*
       aristas nodo 1
       */
       //g.setColor(Color.BLUE);
       g.drawLine(300  , 60, 50  , 220);//24
       g.drawLine(300  , 60, 30  , 320);//25
       g.drawLine(300  , 60, 100  , 420);//26
       g.drawLine(300  , 60, 300  , 520);//27
       g.drawLine(300  , 60, 500  , 420);//28
       g.drawLine(300  , 60, 580  , 320);//29
       g.drawLine(300  , 60, 560  , 220);//30
       /*
       aristas nodo 3
       */
       //g.setColor(Color.CYAN);
       g.drawLine(560  , 220, 50  , 220);//31
       g.drawLine(560  , 220, 30  , 320);//32
       g.drawLine(560  , 220, 100  , 420);//33
       g.drawLine(560  , 220, 300  , 520);//34
       g.drawLine(560  , 220, 500  , 420);//35

       /*
       aristas nodo 9
       */
      // g.setColor(VIOLETA);
       g.drawLine(50  , 220, 580  , 320);//36
       g.drawLine(50  , 220, 500  , 420);//37
       g.drawLine(50  , 220, 300  , 520);//38
       g.drawLine(50  , 220, 100  , 420);//39
       
       /*
       aristas nodo 9
       */
       //g.setColor(Color.DARK_GRAY);
       g.drawLine(100  , 420, 580  , 320);//40
       g.drawLine(100  , 420, 500  , 420);//41
      
       /*
       aristas nodo 6
       */
      // g.setColor(Color.WHITE);
       g.drawLine(300  , 520, 580  , 320);//42
       g.drawLine(300  , 520, 30  , 320);//43
       /*
       aristas nodo 4
       */
       //g.setColor(Color.YELLOW);
       g.drawLine(580  , 320, 30  , 320);//44
       g.drawLine(500  , 420, 30  , 320);//44
       
       
       /*
       DIBUJA  LOS NODOS DEL GRAFO
       */
       g.setColor(INDIGO);
       g.fillOval(290, 50, 20, 20);//1
       g.fillOval(490, 110, 20, 20);//2
       g.fillOval(550, 210, 20, 20);//3
       g.fillOval(570, 310, 20, 20);//4
       g.fillOval(490, 410, 20, 20);//5
       g.fillOval(290, 510, 20, 20);//6
       g.fillOval(90, 410, 20, 20);//7
       g.fillOval(20, 310, 20, 20);//8
       g.fillOval(40, 210, 20, 20);//9
       g.fillOval(90, 110, 20, 20);//10
       
       imprimePesosNodos(g);
       }
    
  public void imprimePesosNodos(Graphics g)
  {
      /*
       NUMEROS DE LOS NODOS
       */
       g.setColor(Color.WHITE);
       g.setColor(Color.WHITE);
       g.drawChars(nodos, 0, 1, 295, 60);//1
       g.drawChars(nodos, 1, 1, 495, 125);//2
       g.drawChars(nodos, 2, 1, 555, 225);//3
       g.drawChars(nodos, 3, 1, 575, 325);//4
       g.drawChars(nodos, 4, 1, 495, 425);//5
       g.drawChars(nodos, 5, 1, 295, 525);//6
       g.drawChars(nodos, 6, 1, 95, 425);//7
       g.drawChars(nodos, 7, 1, 25, 325);//8
       g.drawChars(nodos, 8, 1, 45, 225);//9
       g.drawChars(nodos, 9, 2, 95, 125);//10
       /*
        IMPRIME LOS PESOS DE CADA ARCO
       */  
        g.drawString(pesos[0], 390, 80);//1
        g.drawString(pesos[1], 520, 160);//2
        g.drawString(pesos[2], 560, 260);//3
        g.drawString(pesos[3], 560, 360);//4
        g.drawString(pesos[4], 390, 480);//5
        g.drawString(pesos[5], 200, 480);//6
        g.drawString(pesos[6], 50,360);//7
        g.drawString(pesos[7], 30, 260);//8
        g.drawString(pesos[8], 50, 160);//9
        g.drawString(pesos[9], 200, 80);//10
        g.drawString(pesos[10], 270, 120);//11
        g.drawString(pesos[11], 270, 160);//12
        g.drawString(pesos[12], 270, 200);//13
        g.drawString(pesos[13], 270, 260);//14
        g.drawString(pesos[14], 180, 280);//15
        g.drawString(pesos[15], 100, 280);//16
        g.drawString(pesos[16], 40, 280);//17
        g.drawString(pesos[17], 330, 160);//18
        g.drawString(pesos[18], 330, 200);//19
        g.drawString(pesos[19], 330, 240);//20
        g.drawString(pesos[20], 430, 240);//21
        g.drawString(pesos[21], 480, 240);//22
        g.drawString(pesos[22], 520, 190);//23
        g.drawString(pesos[23], 240, 100);//24
        g.drawString(pesos[24], 140, 200);//25
        g.drawString(pesos[25], 300, 180);//26
        g.drawString(pesos[26], 300, 300);//27
        g.drawString(pesos[27], 400, 280);//28
        g.drawString(pesos[28], 460, 200);//29
        //g.setColor(Color.CYAN);
        g.drawString(pesos[29], 350, 100);//30
        g.drawString(pesos[30], 200, 220);//31
        g.drawString(pesos[31], 200, 250);//32
        g.drawString(pesos[32], 200, 290);//33
        g.drawString(pesos[33], 350, 420);//34
        g.drawString(pesos[34], 510, 390);//35
        //g.setColor(Color.YELLOW);
        g.drawString(pesos[35], 140, 240);//36
        g.drawString(pesos[36], 140, 270);//37
        g.drawString(pesos[37], 130, 330);//38
        g.drawString(pesos[38], 80, 350);//39
        g.drawString(pesos[39], 280, 380);//40
        //g.setColor(Color.GREEN);
        g.drawString(pesos[40], 430, 360);//41
        g.drawString(pesos[41], 400, 440);//42
        g.drawString(pesos[42], 180, 440);//43
        g.drawString(pesos[43], 280, 320);//42
        g.drawString(pesos[44], 200, 360);//43
        
       llenarMatriz();
        
  }
    
  public void llenarMatriz()
  {   
    int cont=0;
    cont=29;
    /*for (int j = 2; j<9; j++) 
    {
      matrizPesos[0][j]=cont;
      cont--;
    }
    
    cont=9;
    for (int j = 0; j<8; j++) 
    {
      matrizPesos[9][j]=cont; //renglon
      matrizPesos[j][9]=cont; //columna
      cont++;
    }
    
    cont=29;
    for (int j = 2; j<9; j++) 
    {
      matrizPesos[j][0]=cont;
      cont--;
    }
    
    cont=22;
    for (int j = 3; j<9; j++) 
    {
      matrizPesos[1][j]=cont;
      cont--;
    }
    
    cont=22;
    for (int j = 3; j<9; j++) 
    {
      matrizPesos[j][1]=cont;
      cont--;
    }
    cont=33;
    for (int j = 4; j<9; j++) 
    {   
      matrizPesos[2][j]=cont;
      cont--;
    }

    cont=35;
    for (int j = 3; j<8; j++) 
    {   
     matrizPesos[j][8]=cont;
      cont++;
    }
    
    cont=43;
    for (int j = 3; j<7; j++) 
    {
      matrizPesos[j][7]=cont;
      cont--;
    }
    
    cont=39;
    for (int j = 3; j<6; j++) 
    {
      matrizPesos[j][6]=cont;
      cont++;
    }
    
    cont=32;
    for (int j = 6; j<9; j++) 
    {
      matrizPesos[j][2]=cont;
      cont--;
    }
    
    cont=35;
    for (int j = 3; j<7; j++) 
    {
      matrizPesos[8][j]=cont;
      cont++;
    }
    
    matrizPesos[3][5]=cont=41;
    matrizPesos[1][0]=cont=0;
    matrizPesos[9][8]=cont=8;
    matrizPesos[5][2]=cont=23;
    
    matrizPesos[5][3]=cont=41;
    matrizPesos[6][3]=cont=32;
    matrizPesos[7][3]=cont=43;
 
    matrizPesos[6][4]=cont=40;
    matrizPesos[7][4]=cont=44;
    matrizPesos[7][5]=cont=42;
    
    matrizPesos[6][2]=cont=32;
    matrizPesos[7][2]=cont=31;
  
    cont=0;
    for (int i = 1; i<9; i++) 
    {
     for (int j = 1; j<9; j++) 
      { 
        if(i==j)
        {
            matrizPesos[i][j-1]=cont;
            matrizPesos[i][j+1]=cont+1;
            
            cont++;
         }
      }
   }
    
  for (int i = 0; i<10; i++) 
  {
    for (int j = 0; j<10; j++) 
    { 
     System.out.printf("%d   ",matrizPesos[i][j]);
    }
   System.out.println();
   }*/   
    
    for (int j = 2; j<9; j++) 
    {
      matrizPesos[0][j]=Integer.parseInt(pesos[cont]);
      cont--;
    }
    
    cont=9;
    for (int j = 0; j<8; j++) 
    {
      matrizPesos[9][j]=Integer.parseInt(pesos[cont]); //renglon
      matrizPesos[j][9]=Integer.parseInt(pesos[cont]); //columna
      cont++;
    }
    
    cont=29;
    for (int j = 2; j<9; j++) 
    {
      matrizPesos[j][0]=Integer.parseInt(pesos[cont]);
      cont--;
    }
    
    cont=22;
    for (int j = 3; j<9; j++) 
    {
      matrizPesos[1][j]=Integer.parseInt(pesos[cont]);
      cont--;
    }
    ///)
    cont=22;
    for (int j = 3; j<9; j++) 
    {
      matrizPesos[j][1]=Integer.parseInt(pesos[cont]);
      cont--;
    }
    //
    cont=34;
    for (int j = 4; j<9; j++) 
    {   
      matrizPesos[2][j]=Integer.parseInt(pesos[cont]);
      cont--;
    }

    cont=35;
    for (int j = 3; j<7; j++) 
    {   
     matrizPesos[j][8]=Integer.parseInt(pesos[cont]);
      cont++;
    }
    
    cont=43;
    for (int j = 3; j<6; j++) 
    {
      matrizPesos[j][7]=Integer.parseInt(pesos[cont]);
      cont--;
    }
    
    cont=39;
    for (int j = 3; j<5; j++) 
    {
      matrizPesos[j][6]=Integer.parseInt(pesos[cont]);
      cont++;
    }
    
    cont=33;
    for (int j = 5; j<9; j++) 
    {
      matrizPesos[j][2]=Integer.parseInt(pesos[cont]);
      cont--;
    }
    
    cont=35;
    for (int j = 3; j<7; j++) 
    {
      matrizPesos[8][j]=Integer.parseInt(pesos[cont]);
      cont++;
    }
    
    matrizPesos[3][5]=Integer.parseInt(pesos[41]);
    matrizPesos[1][0]=Integer.parseInt(pesos[0]);
    matrizPesos[9][8]=Integer.parseInt(pesos[8]);
    matrizPesos[5][2]=Integer.parseInt(pesos[33]);
    
    matrizPesos[5][3]=Integer.parseInt(pesos[41]);
    matrizPesos[6][3]=Integer.parseInt(pesos[39]);
    matrizPesos[7][3]=Integer.parseInt(pesos[43]);
 
    matrizPesos[6][4]=Integer.parseInt(pesos[40]);
    matrizPesos[7][4]=Integer.parseInt(pesos[44]);
    matrizPesos[7][5]=Integer.parseInt(pesos[42]);
    
    matrizPesos[6][2]=Integer.parseInt(pesos[32]);
    matrizPesos[7][2]=Integer.parseInt(pesos[31]);
  
    cont=0;
    for (int i = 1; i<9; i++) 
    {
     for (int j = 1; j<9; j++) 
      { 
        if(i==j)
        {
            matrizPesos[i][j]=99999999;
            matrizPesos[i][j-1]=Integer.parseInt(pesos[cont]);
            matrizPesos[i][j+1]=Integer.parseInt(pesos[cont+1]);
            
            cont++;
         }
      }
   }
  matrizPesos[0][0]=99999999;
  /*for (int i = 0; i<10; i++) 
  {
    for (int j = 0; j<10; j++) 
    { 
     System.out.printf("%d   ",matrizPesos[i][j]);
    }
   System.out.println();
   }*/
  }
  
  public int[][] getMatriz()
  {
   return this.matrizPesos;
  }
  
    
}
