package se;

import java.util.ArrayList;
import java.util.Random;

public class Ventana extends javax.swing.JFrame {

    public Ventana() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textM = new javax.swing.JTextField();
        textCr = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        buttonGenerar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        numPoblacion = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("M =");

        jLabel2.setText("Cr =");

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        buttonGenerar.setText("Generar");
        buttonGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGenerarActionPerformed(evt);
            }
        });

        jLabel3.setText("Población");

        numPoblacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "4", "5", "6", "7", "8", "9", "10" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(34, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textM, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(textCr, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numPoblacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(textM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonGenerar)
                    .addComponent(jLabel3)
                    .addComponent(numPoblacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerarActionPerformed
        Logic l =new Logic();
        float m= Float.parseFloat(textM.getText());
        float cr= Float.parseFloat(textCr.getText());
        int num = Integer.parseInt(numPoblacion.getSelectedItem().toString());
        l.generaVector(num);
        l.generaFitness(num);
        l.setM(m);
        l.setcR(cr);
        
        
        textArea.setText("");
        textArea.append("Población inicial    |    Fitness\n");
        for(int i=0;i<l.array.size();i++)
        {
            textArea.append("           ("+l.array.get(i).x+","+l.array.get(i).y+")        |     "+l.fitness[i]+"\n");
        }
        
        calcula(l);
        
        
    }//GEN-LAST:event_buttonGenerarActionPerformed

    public void calcula(Logic lo)
    {
        ArrayList<String> cambios = new ArrayList<String>();
        ArrayList<XY> array2=lo.array;
        for(int j=0;j<Integer.valueOf(numPoblacion.getSelectedItem().toString());j++)
        {
           cambios.add("si");
        }
        int i21=0;
        while(i21<20)
        {
            for (int i=0;i<lo.array.size();i++) {
                
                textArea.append("Objeto:  ("+String.valueOf(lo.array.get(i).x)+" , "+String.valueOf(lo.array.get(i).y)+")\n");
                textArea.append("   V1        V2         V3\n");
                
                ArrayList a=randoms(i,lo);
                textArea.append("   ("+String.valueOf(lo.array.get((int)a.get(0)).x)+" , "+String.valueOf(lo.array.get((int)a.get(0)).y)+")");
                textArea.append("   ("+String.valueOf(lo.array.get((int)a.get(1)).x)+" , "+String.valueOf(lo.array.get((int)a.get(1)).y)+")");
                textArea.append("   ("+String.valueOf(lo.array.get((int)a.get(2)).x)+" , "+String.valueOf(lo.array.get((int)a.get(2)).y)+")\n");
                
                float wx=lo.array.get((int)a.get(0)).x  + (lo.m*(lo.array.get((int)a.get(1)).x - lo.array.get((int)a.get(2)).x) ) ;
                    float wy=lo.array.get((int)a.get(0)).y + (lo.m*(lo.array.get((int)a.get(1)).y - lo.array.get((int)a.get(2)).y) ) ;
                float fw= (wx*wx)+(wy*wy*wy);
                float nCr= fw/lo.fitness[i];
                XY au=new XY();
                au.setX(wx);
                au.setY(wy);
                textArea.append("       Nuevo individuo  ( "+wx+","+wy+")\n   Se acepta : ");
                System.out.println(nCr+"  "+lo.cR);
                if(nCr < lo.cR){
                   
                    cambios.set(i,"si"); 
                    textArea.append(" SI \n\n");
                    array2.set(i,au);
                }
                else{
                    cambios.set(i, "no");
                    textArea.append(" NO \n\n");
                }
            }
            lo.array=array2;
            /*for (String array21 : cambios) {
                System.out.printf(array21);
            }
            System.out.println("");*/
        i21++;    
        }
        
    }

    public ArrayList randoms(int a,Logic lo)
    {
        Random ran=new Random();
        ArrayList index = new ArrayList();
        while(index.size()!=3)
        {
            
            int aux = ran.nextInt(Integer.valueOf(numPoblacion.getSelectedItem().toString()));

            while(!index.contains(aux) && aux != a)
            {
                index.add(aux);
                //System.out.println(index);
            }
        }
        
        return index;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonGenerar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox numPoblacion;
    private javax.swing.JTextArea textArea;
    private javax.swing.JTextField textCr;
    private javax.swing.JTextField textM;
    // End of variables declaration//GEN-END:variables
}
