/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasexpertostarea2;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class VentanaPrinciapal extends javax.swing.JFrame {

    ///public String[][] baseConocimiento=new String[5][5];
    public String baseConocimiento[] = new String[13];
    public String[][] baseConocimientoAtras = new String[2][13];
    public String objetivo;
    public int lim = 0;
    public int[][] contReglas = new int[3][5];
    public String[][] resultado;
    public String[][] REGLAS = {{"A", "B", "C"},
    {"D", "E", "F", "G"},
    {"H", "I", "J"},
    {"C", "G", "K"},
    {"G", "J", "L"},
    {"K", "L", "M"}
    };
    public String[] subObjetivos=new String[3];

    public VentanaPrinciapal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBC = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextArea7 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextArea8 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaBC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M"
            }
        ));
        jScrollPane1.setViewportView(tablaBC);

        jLabel1.setText("INGRESA LOS VALORES DE LA BASE DEL CONOCIMIENTO:");

        jLabel2.setText("Objetivo: {");

        jLabel3.setText("}");

        jButton1.setText("RAZONAMIENTO HACIA DELANTE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("RAZONAMIENTO HACIA ATRAS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        jLabel4.setText("REGLA  1");

        jLabel7.setText("REGLA 2");

        jLabel9.setText("REGLA 3");

        jLabel11.setText("REGLA 4");

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jTextArea3.setText("    Si A, B\n   entonces  C");
        jScrollPane4.setViewportView(jTextArea3);

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jTextArea4.setText("  Si D, E, F\n entonces G");
        jScrollPane5.setViewportView(jTextArea4);

        jTextArea5.setColumns(20);
        jTextArea5.setRows(5);
        jTextArea5.setText("  Si H, I \n entonces J");
        jScrollPane6.setViewportView(jTextArea5);

        jTextArea6.setColumns(20);
        jTextArea6.setRows(5);
        jTextArea6.setText("   Si C y G\n  entonces K");
        jScrollPane7.setViewportView(jTextArea6);

        jTextArea7.setColumns(20);
        jTextArea7.setRows(5);
        jTextArea7.setText(" Si G y J\n entoncesL");
        jScrollPane8.setViewportView(jTextArea7);

        jLabel6.setText("REGLA 5");

        jLabel8.setText("REGLA 6");

        jTextArea8.setColumns(20);
        jTextArea8.setRows(5);
        jTextArea8.setText("  Si K y L\n entonces M");
        jScrollPane9.setViewportView(jTextArea8);

        jButton3.setText("LIMPIAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel5))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(40, 40, 40)
                                            .addComponent(jLabel7)))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(35, 35, 35)
                                            .addComponent(jLabel9)
                                            .addGap(122, 122, 122)
                                            .addComponent(jLabel11)
                                            .addGap(80, 80, 80)
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel8)
                                            .addGap(49, 49, 49))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 3, Short.MAX_VALUE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1))
                                    .addGap(67, 67, 67)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton2)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(372, 372, 372)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel6)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(14, 14, 14)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String[] llenaBaseConocimiento() {

        String[] baseC = new String[13];
        for (int i = 0; i < 13; i++) {
            if (tablaBC.getValueAt(0, i) != null) {
                baseC[lim] = (String) tablaBC.getColumnName(i);//letra
    //            baseConocimiento[1][lim]=(String) tablaBC.getValueAt(0,i);//valor
                lim++;
                //vemos cuales son las letras de nuestra base de conocimiento
            }

        }
        return baseC;

    }
    
     public String[][] llenaBaseConocimientoAtras() {

        String[][] baseC = new String[2][13];
        for (int i = 0; i < 13; i++) {
            if (tablaBC.getValueAt(0, i) != null) {
                baseC[0][lim] = (String) tablaBC.getColumnName(i);//letra
                baseC[1][lim]=(String) tablaBC.getValueAt(0,i);//valor
                lim++;
                //vemos cuales son las letras de nuestra base de conocimiento
            }

        }
        return baseC;

    }
    public int[][] inicializarContReglas()
    {
       int[][] contR = new int[3][5];
        return contR;
       
    }
    
    public  void imprimeBaseConocimiento()
    { 
        jTextArea1.append("BASE CONOCIMIENTO \n");
        for (int i = 0; i < lim; i++) {  
            jTextArea1.append(baseConocimiento[i]+"  ");
        }
        jTextArea1.append("\n");
    
    }
    
    public  void imprimeBaseConocimiento2()
    { 
        jTextArea2.append("BASE CONOCIMIENTO \n");
        for (int i = 0; i < lim; i++) {  
            jTextArea2.append(baseConocimientoAtras[0][i]+"="+baseConocimientoAtras[1][i]+"    ");
        }
        jTextArea2.append("\n");
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

      String letraConocimiento;

      //extraemos cual es nuestro objetivo a llegar
     objetivo = jTextField1.getText();
     baseConocimiento = llenaBaseConocimiento();   
     imprimeBaseConocimiento();
    
     int contador;
     boolean band=false;
     
     for (int i = 0; i < lim-1; i++) 
     {   
       contReglas=inicializarContReglas();
       contador = 0;
       if(band==true)
            break;
            
       letraConocimiento = baseConocimiento[i];
       jTextArea1.append("Letra Base Conocimiento: "+letraConocimiento+"\n");
           
            for (int regla = 0; regla < REGLAS.length; regla++) {
                //itera a traves de las columnas
                for (int columna = 0; columna < REGLAS[regla].length; columna++) {
                    // Buscamos si nuestro dato de la base del conocimiento coincide con alguna de las reglas, en caso de ser asi, extraemos la regla y su total de condiciones
                    if (REGLAS[regla][columna].equals(letraConocimiento)) {
                        // JOptionPane.showMessageDialog(null, "Regla: " + (regla) + "   condiciones  " + (REGLAS[regla].length));
                        contReglas[0][contador] = regla;
                        contReglas[1][contador] = REGLAS[regla].length;
                        contador++;
                    }

                }
            }

            
            /*
             Una vez que tenemos la letra de nuestra base de conocimiento  y comparada con la regla y sus 
             condiciones buscamos el total de condiciones conocidas para buscar el objetivo
             */
           
            for (int R = 0; R < 5; R++)//numero de reglas a recorrer
            {
                //nos posiciona,os en la regla del contador de reglas y su longitud
                for (int j = 0; j < REGLAS[contReglas[0][R]].length; j++) {
                    for (int k = 0; k < baseConocimiento.length; k++)//recorremos la regla con base a nuestra base de conocimiento
                    {
                        if (REGLAS[contReglas[0][R]][j] == baseConocimiento[k] ) {
                            contReglas[2][R]++;   //incrementamos el numero de condiciones conocidas,
                        }
                    }
                }

                if ((contReglas[2][R]) == (contReglas[1][R] - 1)) {
     
                jTextArea1.append("Regla: "+(contReglas[0][R]+1)+"\tCondiciones: "+(REGLAS[contReglas[0][R]].length-1)+"\t  C. Conocidas: "+contReglas[2][R]+"\n");
                    
                 if (objetivo.equals( REGLAS[contReglas[0][R]][contReglas[2][R]])){       
                    jTextArea1.append(" El Objetivo: "+objetivo+" == "+REGLAS[contReglas[0][R]][contReglas[2][R]]+" se cumple y es valido\n");
                    band=true;
                    break;
                    }
                      else
                       {
                        boolean ban1=false;
                        jTextArea1.append("\t\t"+objetivo+" dif "+REGLAS[contReglas[0][R]][contReglas[2][R]]+"\n");
                        for(String letra:baseConocimiento)
                        {
                          if(REGLAS[contReglas[0][R]][contReglas[2][R]].equals(letra))
                              ban1=true;
                        }
                        
                        if(ban1==false)
                        {
                           baseConocimiento[lim] = REGLAS[contReglas[0][R]][contReglas[2][R]];
                           lim++;
                           imprimeBaseConocimiento();
                        }
                    } 
                }
            }
        }

     
     if(band==false)
     {
     jTextArea1.append(" El Objetivo: "+objetivo+"  NO se cumple y NO es valido\n");
     }
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     
     objetivo = jTextField1.getText();
     baseConocimientoAtras = llenaBaseConocimientoAtras();   
     imprimeBaseConocimiento2();
     boolean valido=false;
     //comparamos en que reglas el objetivo esta como conclusion
     contReglas=inicializarContReglas(); 
       int cont=0; 
       for (int regla = 0; regla < REGLAS.length; regla++) {       
          if(REGLAS[regla][REGLAS[regla].length-1].equals(objetivo))
          {
            contReglas[0][cont] = regla;
            cont++;
          }
        }
   
    boolean  encontrado=false,nuevoSubobjetivo=false;   
    if(cont!=0)
    {
     while(encontrado==false)
     {
     // jTextArea2.append("Regla: "+(contReglas[0][0]+1)+"    SubObjetivos: ");
     
      if(nuevoSubobjetivo==true)
      {
        contReglas=inicializarContReglas(); 
       int x=0; 
       for (int regla = 0; regla < REGLAS.length; regla++) {       
          if(REGLAS[regla][REGLAS[regla].length-1].equals(objetivo))
          {
            contReglas[0][x] = regla;
            x++;
          }
        }
       if(x==0)
       {
       break;
       }
       
      }
      
       jTextArea2.append("Regla: "+(contReglas[0][0]+1)+"    SubObjetivos: ");
     
      int reglaSub=contReglas[0][0]; 
      for (int i = 0; i< REGLAS[reglaSub].length-1; i++) 
     {
        subObjetivos[i]=REGLAS[reglaSub][i];
        jTextArea2.append(subObjetivos[i]+"  ");
     }       
    
     //comprobamos cuales subobjetivos tenemos en la base  de conocimientos
    int subObjetivosCumplidos=0;
     for(int j=0;j<lim;j++ )
    {
      if((baseConocimientoAtras[0][j].equals(subObjetivos[0])) || (baseConocimientoAtras[0][j].equals(subObjetivos[2]))|| (baseConocimientoAtras[0][j].equals(subObjetivos[1])))
      {
          subObjetivosCumplidos++;
      }
      
    }
     
     //JOptionPane.showMessageDialog(null,subObjetivosCumplidos+ "    "+REGLAS[reglaSub].length);
     if(subObjetivosCumplidos==(REGLAS[reglaSub].length-1))
     {
      jTextArea2.append("\tEl objetivo es valido y se cumplio");
      encontrado=true;
      break;
     }
     else
     {
       jTextArea2.append("\nUno o mas antecedentes no pertenecen a la base de conocimiento ");  
       objetivo=subObjetivos[0];  
       jTextArea2.append("\n\tEl subObjetivo es: "+objetivo+"\n\n");
       nuevoSubobjetivo=true;      
      //jTextArea2.append("\nEl objetivo no es valido \n"+subObjetivosCumplidos+"  "+(REGLAS[reglaSub].length-1));
       
     }
     }
    
    }
    else
    {
       jTextArea2.append("\nEn ninguna regla el Objetivo: "+objetivo+" esta  como conclusion "
              + "\n\tpor lo tanto no es valida"); 
    }
    if(encontrado==false)
    {
    String entrada=JOptionPane.showInputDialog(null,"Ingresa un valor V para determinar su conclusion:  ");
    jTextArea2.append("\n\tEl Objetivo es valido y se cumple");
    }
     

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       jTextArea1.setText("");
       jTextArea2.setText("");
       lim=0;
       jTextField1.setText("");
       
       DefaultTableModel modelo = (DefaultTableModel)tablaBC.getModel(); 
       modelo.removeRow(0);
       
       String[] fila=new String[13];
       modelo.addRow(fila);
       
       
    }//GEN-LAST:event_jButton3ActionPerformed

    public void buscarValorObjetivo(String regla[], String objetivo) {

        for (int i = 0; i < regla.length; i++) {
            JOptionPane.showMessageDialog(null, regla[i]);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrinciapal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrinciapal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrinciapal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrinciapal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrinciapal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JTextArea jTextArea8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tablaBC;
    // End of variables declaration//GEN-END:variables
}
