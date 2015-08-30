package se2;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.table.DefaultTableModel;

public class Ventana extends javax.swing.JFrame {
    
    int[][] mat = new int[5][7];
    Random ran=new Random();
    String Titulo[]={"X","Y","Z","M","S","C","F(x)"};   
    
    
    public Ventana() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCalVec = new javax.swing.JButton();
        btnMax = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabla2 = new javax.swing.JTable();
        btnMinimizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCalVec.setText("Calcular Vectores");
        btnCalVec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalVecActionPerformed(evt);
            }
        });

        btnMax.setText("Maximizar");
        btnMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaxActionPerformed(evt);
            }
        });

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tabla1);

        tabla2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tabla2);

        btnMinimizar.setText("Minimizar");
        btnMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizarActionPerformed(evt);
            }
        });

        jLabel1.setText("PSO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(btnCalVec, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(btnMax, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111)
                        .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalVec)
                    .addComponent(btnMax)
                    .addComponent(btnMinimizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalVecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalVecActionPerformed
        DefaultTableModel modelo= new DefaultTableModel(null,Titulo);
        for(int i =0;i<5;i++)
        {
            String[] au=new String[7];
            for(int j=0;j<6;j++)
            {
                mat[i][j]=ran.nextInt(20)-10;
                au[j]=String.valueOf(mat[i][j]);
            }
            mat[i][6]=(5*mat[i][0])-(7*mat[i][1]) +(3*mat[i][2])+(8*mat[i][3])+(3*mat[i][4])-(4*mat[i][5]);
            au[6]=String.valueOf(mat[i][6]);
            modelo.addRow(au);
        }
     
        tabla1.setModel(modelo);  
    }//GEN-LAST:event_btnCalVecActionPerformed

    private void btnMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaxActionPerformed
       DefaultTableModel modelo= new DefaultTableModel(null,Titulo);

        int aux =0;
        int indiceaux = 0;
        ArrayList escogidos=new ArrayList();
        for (int e =0;e<6;e++) {
            escogidos.add(-1);
        } 
        int au2=0;
        while(au2<6)
        {
            int r=ran.nextInt(6);
            if(!escogidos.contains(r))
            {
                escogidos.set(au2, r);
                au2++;
            }
        }
        int auxesco=0;
        for(int a=0; a<1;a++)
        {
        
            for(int i=0;i<5;i++){
                    if(mat[i][6]>aux)
                    {
                        aux=mat[i][6];
                        indiceaux=i;
                    }      
            }
            for(int x=0;x<5;x++)
            {
                mat[x][(int)escogidos.get(auxesco)]= mat[indiceaux][(int)escogidos.get(auxesco)];
                mat[x][(int)escogidos.get(auxesco+1)]= mat[indiceaux][(int)escogidos.get(auxesco+1)];
            }
            auxesco+=2;
            for(int j=0;j<5;j++)
            {
                mat[j][6]=(5*mat[j][0])-(7*mat[j][1]) +(3*mat[j][2])+(8*mat[j][3])+(3*mat[j][4])-(4*mat[j][5]);
            }
        
        }
        
        for(int i =0;i<5;i++)
        {
            String[] au=new String[7];
            for(int j=0;j<6;j++)
            {
                au[j]=String.valueOf(mat[i][j]);
            }
            au[6]=String.valueOf(mat[i][6]);
            modelo.addRow(au);
        }
     
        tabla2.setModel(modelo); 
        
    }//GEN-LAST:event_btnMaxActionPerformed
    
    
    
    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        DefaultTableModel modelo= new DefaultTableModel(null,Titulo);

        int aux =9999;
        int indiceaux = 0;
        ArrayList escogidos=new ArrayList();
        for (int e =0;e<6;e++) {
            escogidos.add(-1);
        } 
        int au2=0;
        while(au2<6)
        {
            int r=ran.nextInt(6);
            if(!escogidos.contains(r))
            {
                escogidos.set(au2, r);
                au2++;
            }
        }
        int auxesco=0;
        for(int a=0; a<1;a++)
        {
        
            for(int i=0;i<5;i++){
                    if(mat[i][6]<aux)
                    {
                        aux=mat[i][6];
                        indiceaux=i;
                    }      
            }
            for(int x=0;x<5;x++)
            {
                mat[x][(int)escogidos.get(auxesco)]= mat[indiceaux][(int)escogidos.get(auxesco)];
                mat[x][(int)escogidos.get(auxesco+1)]= mat[indiceaux][(int)escogidos.get(auxesco+1)];
            }
            auxesco+=2;
            for(int j=0;j<5;j++)
            {
                mat[j][6]=(5*mat[j][0])-(7*mat[j][1]) +(3*mat[j][2])+(8*mat[j][3])+(3*mat[j][4])-(4*mat[j][5]);
            }
        
        }
        
        for(int i =0;i<5;i++)
        {
            String[] au=new String[7];
            for(int j=0;j<6;j++)
            {
                au[j]=String.valueOf(mat[i][j]);
            }
            au[6]=String.valueOf(mat[i][6]);
            modelo.addRow(au);
        }
     
        tabla2.setModel(modelo); 
        
    }//GEN-LAST:event_btnMinimizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalVec;
    private javax.swing.JButton btnMax;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tabla1;
    private javax.swing.JTable tabla2;
    // End of variables declaration//GEN-END:variables
}
