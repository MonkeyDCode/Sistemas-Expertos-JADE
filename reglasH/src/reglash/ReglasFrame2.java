/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reglash;

import java.util.ArrayList;

/**
 *
 * @author oracle
 */
public class ReglasFrame2 extends javax.swing.JFrame {

    /**
     * Creates new form ReglasFrame
     */
    ArrayList BC;
    ArrayList BCV;
    ArrayList a1, a2, a3, a4, a5, a6, a7, a8, a9;
    Regla r1, r2, r3, r4, r5, r6, r7, r8, r9;
    String obj = null;

    public ReglasFrame2() {
        initComponents();
        a1 = new ArrayList();
        a1.add("h8");
        a1.add("h6");
        a1.add("h5");
        r1 = new Regla("r1", a1, "h4");
        a2 = new ArrayList();
        a2.add("h6");
        a2.add("h3");
        r2 = new Regla("r2", a2, "h9");
        a3 = new ArrayList();
        a3.add("h7");
        a3.add("h4");
        r3 = new Regla("r3", a3, "h9");
        a4 = new ArrayList();
        a4.add("h8");
        r4 = new Regla("r4", a4, "h1");
        a5 = new ArrayList();
        a5.add("h6");
        r5 = new Regla("r5", a5, "h5");
        a6 = new ArrayList();
        a6.add("h9");
        a6.add("h1");
        r6 = new Regla("r6", a6, "h2");
        a7 = new ArrayList();
        a7.add("h7");
        r7 = new Regla("r7", a7, "h6");
        a8 = new ArrayList();
        a8.add("h1");
        a8.add("h7");
        r8 = new Regla("r8", a8, "h9");
        a9 = new ArrayList();
        a9.add("h1");
        a9.add("h8");
        r9 = new Regla("r9", a9, "h6");
        BC = new ArrayList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hecho1 = new javax.swing.JComboBox();
        hecho2 = new javax.swing.JComboBox();
        hecho3 = new javax.swing.JComboBox();
        objetivo = new javax.swing.JComboBox();
        evaluar1 = new javax.swing.JButton();
        evaluar2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        text1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        text2 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        hecho1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "h1", "h2", "h3", "h4", "h5", "h6", "h7", "h8", "h9" }));

        hecho2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "h1", "h2", "h3", "h4", "h5", "h6", "h7", "h8", "h9" }));
        hecho2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hecho2ActionPerformed(evt);
            }
        });

        hecho3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "h1", "h2", "h3", "h4", "h5", "h6", "h7", "h8", "h9" }));

        objetivo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "h1", "h2", "h3", "h4", "h5", "h6", "h7", "h8", "h9" }));

        evaluar1.setText("evaluar hacia adelante");
        evaluar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                evaluar1ActionPerformed(evt);
            }
        });

        evaluar2.setText("evaluar hacia atras");
        evaluar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                evaluar2ActionPerformed(evt);
            }
        });

        jLabel1.setText("OBJETIVO");

        jLabel2.setText("HECHO 1");

        jLabel3.setText("HECHO 2");

        jLabel4.setText("HECHO 3");

        jLabel5.setText("SISTEMAS EXPERTOS TAREA 2");

        text1.setColumns(20);
        text1.setRows(5);
        jScrollPane1.setViewportView(text1);

        text2.setColumns(20);
        text2.setRows(5);
        jScrollPane2.setViewportView(text2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(132, 132, 132))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(objetivo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(evaluar1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(hecho1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(hecho2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(hecho3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4))
                                .addGap(32, 32, 32))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(evaluar2)
                                .addGap(104, 104, 104))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(objetivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hecho1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hecho2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hecho3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(evaluar1)
                    .addComponent(evaluar2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hecho2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hecho2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hecho2ActionPerformed

    private void evaluar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evaluar1ActionPerformed
        // TODO add your handling code here:
        BC.clear();
        text1.setText("");
        if (!hecho1.getSelectedItem().toString().equals("hecho")) {
            BC.add(hecho1.getSelectedItem().toString());
            //BCV.add(Boolean.valueOf(((String)valor1.getSelectedItem())));
            System.out.println(hecho1.getSelectedItem().toString());
            text1.append(hecho1.getSelectedItem().toString()+"\n");
        }
        if (!hecho2.getSelectedItem().toString().equals("hecho")) {
            BC.add(hecho2.getSelectedItem().toString());
            //BCV.add(Boolean.valueOf((String) valor2.getSelectedItem()));
            System.out.println(hecho2.getSelectedItem().toString());
            text1.append(hecho2.getSelectedItem().toString()+"\n");
        }
        if (!hecho3.getSelectedItem().toString().equals("hecho")) {
            BC.add(hecho3.getSelectedItem().toString());
            //BCV.add(Boolean.valueOf((String) valor3.getSelectedItem()));
            System.out.println(hecho3.getSelectedItem().toString());
            text1.append(hecho3.getSelectedItem().toString()+"\n");
        }
        if (!objetivo.getSelectedItem().toString().equals("objetivo")) {
            obj = (objetivo.getSelectedItem().toString());
            System.out.println(objetivo.getSelectedItem().toString());
            text1.append(objetivo.getSelectedItem().toString()+"\n");
        }
        //hacia adelante
        String s;
        int i = 0;
        int b = 0;
        s = (String) BC.get(i);
        while (true) {
            if (i > 9) {
                i = 0;
            }
            System.out.println(i + s);
            if (s.equals(obj) || BC.size() == 9) {
                System.out.println("hecho");
                text1.append("hecho"+"\n");
                return;
            }
            ArrayList reglas = new ArrayList();
            if (a1.contains(s)) {
                reglas.add(r1);
                System.out.println(" 1");
                text1.append("1"+"\n");
            }
            if (a2.contains(s)) {
                reglas.add(r2);
                System.out.println(" 2");
                text1.append("2"+"\n");
            }
            if (a3.contains(s)) {
                reglas.add(r3);
                System.out.println(" 3");
                text1.append("3"+"\n");
            }
            if (a4.contains(s)) {
                reglas.add(r4);
                System.out.println(" 4");
                text1.append("4"+"\n");
            }
            if (a5.contains(s)) {
                reglas.add(r5);
                System.out.println(" 5");
                text1.append("5"+"\n");
            }
            if (a6.contains(s)) {
                reglas.add(r6);
                System.out.println(" 6");
                text1.append("6"+"\n");
            }
            if (a7.contains(s)) {
                reglas.add(r7);
                System.out.println(" 7");
                text1.append("7"+"\n");
            }
            if (a8.contains(s)) {
                reglas.add(r8);
                System.out.println(" 8");
                text1.append("8"+"\n");
            }
            if (a9.contains(s)) {
                reglas.add(r9);
                System.out.println(" 9");
                text1.append("9"+"\n");
            }
            Regla r = null;
            //Se obtiene la regla con menos condiciones y 
            //si son iguales toma la primera que se seleccionó
            for (int reg = 0; reg < reglas.size(); reg++) {
                for (int bc = 0; bc < BC.size(); bc++) {
                    if (((Regla) reglas.get(reg)).getCondiciones().contains(BC.get(bc))) {
                        if (r == null) {
                            r = ((Regla) reglas.get(reg));
                        } else {
                            if (r.getCondiciones().size() > ((Regla) reglas.get(reg)).getCondiciones().size()) {
                                r = ((Regla) reglas.get(reg));
                            }
                        }
                    }
                }
            }
            if (r != null) {
                if (r.getCondiciones().size() == 1) {
                    BC.add(r.getCondiciones().get(0));
                    //BCV.add(true);
                } else {
                    if (r.getCondiciones().size() == 2) {
                        if (((String) r.getCondiciones().get(0)).equals(s)) {
                            if (BC.contains(r.getCondiciones().get(1))) {
                                BC.add(r.getConclusion());
                                //BCV.add(true);
                            } else {
                                s = (String) r.getCondiciones().get(1);
                                b = 1;
                            }
                        } else {
                            if (BC.contains(r.getCondiciones().get(0))) {
                                BC.add(r.getConclusion());
                                //BCV.add(true);
                            } else {
                                s = (String) r.getCondiciones().get(0);
                                b = 1;
                            }
                        }
                    }
                }
            }
            for (int k = 0; k < BC.size(); k++) {
                System.out.println(obj + BC.get(k));
                //text2.setText(obj + BC.get(k)+"\n");
                text1.append(obj + BC.get(k)+"\n");
            }
            if (BC.contains(obj) || BC.size() == 9) {
                System.out.println("hecho");
                //text2.setText("\n hecho");
                text1.append("hecho"+"\n");
                return;
            }
            if (b == 0 && i < BC.size()) {
                s = (String) BC.get(i);
            } else {
                b = 0;
            }
            i++;
        }
    }//GEN-LAST:event_evaluar1ActionPerformed

    private void evaluar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evaluar2ActionPerformed
        // TODO add your handling code here:
        BC.clear();
        text2.setText("");
        if (!hecho1.getSelectedItem().toString().equals("hecho")) {
            BC.add(hecho1.getSelectedItem().toString());
            System.out.println(hecho1.getSelectedItem().toString());
            text2.append(hecho1.getSelectedItem().toString()+"\n");
        }
        if (!hecho2.getSelectedItem().toString().equals("hecho")) {
            BC.add(hecho2.getSelectedItem().toString());
            System.out.println(hecho2.getSelectedItem().toString());
            text2.append(hecho2.getSelectedItem().toString()+"\n");
        }
        if (!hecho3.getSelectedItem().toString().equals("hecho")) {
            BC.add(hecho3.getSelectedItem().toString());
            System.out.println(hecho3.getSelectedItem().toString());
            text2.append(hecho3.getSelectedItem().toString()+"\n");
        }
        if (!objetivo.getSelectedItem().toString().equals("objetivo")) {
            obj = (objetivo.getSelectedItem().toString());
            System.out.println(objetivo.getSelectedItem().toString());
            text2.append(objetivo.getSelectedItem().toString()+"\n");
        }
        String s;
        int i = 0;
        int b = 0;
        s = obj;
        while (true) {
            if (i > 9) {
                i = 0;
            }
            System.out.println(i + s);
            if (BC.contains(s) || BC.size() == 9) {
               System.out.println("hecho");
               text2.append("hecho \n");
                return;
            }
            ArrayList reglas = new ArrayList();
            if (r1.getConclusion().equals(s)) {
                reglas.add(r1);
                System.out.println(" 1");
                text2.append("1\n");
            }
            if (r2.getConclusion().equals(s)) {
                reglas.add(r2);
                System.out.println(" 2");
                text2.append("2\n");
            }
            if (r3.getConclusion().equals(s)) {
                reglas.add(r3);
                System.out.println(" 3");
                text2.append("3\n");
            }
            if (r4.getConclusion().equals(s)) {
                reglas.add(r4);
                System.out.println(" 4");
                text2.append("4\n");
            }
            if (r5.getConclusion().equals(s)) {
                reglas.add(r5);
                System.out.println(" 5");
                text2.append("5\n");
            }
            if (r6.getConclusion().equals(s)) {
                reglas.add(r6);
                System.out.println(" 6");
                text2.append("6\n");
            }
            if (r7.getConclusion().equals(s)) {
                reglas.add(r7);
                System.out.println(" 7");
                text2.append("7\n");
            }
            if (r8.getConclusion().equals(s)) {
                reglas.add(r8);
                System.out.println(" 8");
                text2.append("8\n");
            }
            if (r9.getConclusion().equals(s)) {
                reglas.add(r9);
                System.out.println(" 9");
                text2.append("9\n");
            }
            Regla r = null;
            //Se obtiene la regla con menos condiciones y 
            //si son iguales toma la primera que se seleccionó
            for (int reg = 0; reg < reglas.size(); reg++) {
                for (int bc = 0; bc < BC.size(); bc++) {
                    if (((Regla) reglas.get(reg)).getCondiciones().contains(BC.get(bc))) {
                        if (r == null) {
                            r = ((Regla) reglas.get(reg));
                        } else {
                            if (r.getCondiciones().size() > ((Regla) reglas.get(reg)).getCondiciones().size()) {
                                r = ((Regla) reglas.get(reg));
                            }
                        }
                    }
                }
            }
            if (r != null) {
                if (r.getCondiciones().size() == 1) {
                    String cond = (String) r.getCondiciones().get(0);
                    int ind = BC.indexOf(cond);
                    if (BC.contains(cond)) {
                        s = (String) r.getConclusion();
                        b=1;
                    }
                    //BCV.add(true);
                } else {
                    if (r.getCondiciones().size() == 2) {
                        if (BC.contains((String) r.getCondiciones().get(0))) {
                            int ind = BC.indexOf(r.getCondiciones().get(1));
                            if (BC.contains(r.getCondiciones().get(1))) {
                                s = (String) r.getConclusion();
                                b=1;
                            } else {
                                s = (String) r.getCondiciones().get(1);
                                b = 1;
                            }
                        } else {
                            if (BC.contains(r.getCondiciones().get(1))) {
                                int ind = BC.indexOf(r.getCondiciones().get(0));
                                if (BC.contains(r.getCondiciones().get(0))) {
                                    System.out.println("hecho");
                                    text2.append("hecho\n");
                                    break;
                                } else {
                                    s = (String) r.getCondiciones().get(1);
                                    b = 1;
                                }
                            } else {
                                s = (String) r.getCondiciones().get(0);
                                b = 1;
                            }
                        }
                    }
                }
            }
            for (int k = 0; k < BC.size(); k++) {
                System.out.println(obj + BC.get(k));
                text2.append(obj + BC.get(k)+"\n");
            }
            if (BC.contains(obj) || BC.size() == 9) {
                System.out.println("hecho ");
                text2.append("hecho\n");
                return;
            }
            if (b == 0 && i < BC.size()) {
                s = (String) BC.get(i);
            } else {
                b = 0;
            }
            i++;
        }
    }//GEN-LAST:event_evaluar2ActionPerformed

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
            java.util.logging.Logger.getLogger(ReglasFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReglasFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReglasFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReglasFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReglasFrame2().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton evaluar1;
    private javax.swing.JButton evaluar2;
    private javax.swing.JComboBox hecho1;
    private javax.swing.JComboBox hecho2;
    private javax.swing.JComboBox hecho3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox objetivo;
    private javax.swing.JTextArea text1;
    private javax.swing.JTextArea text2;
    // End of variables declaration//GEN-END:variables
}
