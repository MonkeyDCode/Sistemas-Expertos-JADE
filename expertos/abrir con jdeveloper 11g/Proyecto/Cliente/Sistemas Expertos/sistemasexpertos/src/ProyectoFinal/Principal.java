package ProyectoFinal;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.Graphics;

import java.awt.Image;

import java.awt.Rectangle;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;

import java.io.IOException;

import java.net.UnknownHostException;

import javax.imageio.ImageIO;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;

public class Principal extends JFrame {
    public static Principal p1 = new Principal();
    Pantalla frame = new Pantalla();
    public JPanel jPanel1 = new JPanel();
    private JSeparator jSeparator1 = new JSeparator();
    private JSeparator jSeparator2 = new JSeparator();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JScrollPane jScrollPane2 = new JScrollPane();
    private JScrollPane jScrollPane3 = new JScrollPane();
    private JTextArea jTextArea2 = new JTextArea();
    private JTextArea jTextArea3 = new JTextArea();
    private JTextArea jTextArea4 = new JTextArea();
    
    private Cliente cT;
    private Cliente cP;
    public DataOutputStream salidaT;
    public DataInputStream entradaT;
    public DataOutputStream salidaP;
    public DataInputStream entradaP;
    private String respuesta;
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();

    public Principal() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout(null);
        this.setSize(new Dimension(1056, 597));
        frame.setBounds(new Rectangle(0, 0, 1065, 575));
        frame.getJLabel3().setIcon(new ImageIcon("ginecologoTG.png"));
        jPanel1.setLayout(null);
        jPanel1.setBounds(new Rectangle(0, 0, 1061, 600));
        
        jSeparator1.setBounds(new Rectangle(345, 0, 2, 570));
        jSeparator1.setOrientation(SwingConstants.VERTICAL);
        jSeparator2.setBounds(new Rectangle(700, 0, 10, 575));
        jSeparator2.setOrientation(SwingConstants.VERTICAL);
        jScrollPane1.setBounds(new Rectangle(15, 325, 315, 180));
        jScrollPane2.setBounds(new Rectangle(370, 325, 310, 180));
        jScrollPane3.setBounds(new Rectangle(720, 325, 310, 180));
        jLabel1.setText("PSICÓLOGO");
        jLabel1.setBounds(new Rectangle(115, 515, 125, 35));
        jLabel1.setFont(new Font("Tahoma", 1, 17));
        jLabel1.setForeground(new Color(255, 33, 33));
        jLabel1.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jLabel2.setText("TERAPEUTA SEXUAL");
        jLabel2.setBounds(new Rectangle(435, 515, 195, 35));
        jLabel2.setFont(new Font("Tahoma", 1, 17));
        jLabel2.setForeground(new Color(255, 33, 33));
        jLabel2.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jLabel3.setText("GINECÓLOGO");
        jLabel3.setBounds(new Rectangle(820, 515, 130, 35));
        jLabel3.setFont(new Font("Tahoma", 1, 17));
        jLabel3.setForeground(new Color(255, 33, 33));
        jLabel3.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jPanel1.add(frame,null);
        jScrollPane1.getViewport().add(jTextArea2, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jScrollPane1, null);
        this.getContentPane().add(jSeparator2, null);
        this.getContentPane().add(jSeparator1, null);
        jScrollPane2.getViewport().add(jTextArea3, null);
        this.getContentPane().add(jScrollPane2, null);
        jScrollPane3.getViewport().add(jTextArea4, null);
        this.getContentPane().add(jScrollPane3, null);
        this.getContentPane().add(jPanel1, null);
    }

    public static void main(String args[]) {
        //Principal p = new Principal();
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        Principal.p1.setLocationRelativeTo(null);
        //p.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Principal.p1.setResizable(false);
        Principal.p1.setVisible(true);
        
        Principal.p1.cT= new Cliente();
        Principal.p1.cT.setHost("10.0.0.2");
        Principal.p1.cT.setPuerto(8983);
        try {
            Principal.p1.cT.conecta();
            Principal.p1.obtenerflujosT();
            System.out.println("Exito");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Principal.p1.cP= new Cliente();
        Principal.p1.cP.setHost("10.0.0.2");
        Principal.p1.cP.setPuerto(8984);
        try {
            Principal.p1.cP.conecta();
            Principal.p1.obtenerflujosP();
            System.out.println("Exito");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        ControlAgentes2 control2 = new ControlAgentes2();
    }

    public void obtenerflujosT() throws IOException {
        // establecer flujo de salida para los objetos
        salidaT= new DataOutputStream(cT.getFlujoSalida());
        salidaT.flush(); // vacíar búfer de salida para enviar información de encabezado
        // establecer flujo de entrada para los objetos
        entradaT = new DataInputStream( cT.getFlujoEntrada());
        
    }
    
    public void obtenerflujosP() throws IOException {
        // establecer flujo de salida para los objetos
        salidaP= new DataOutputStream(cP.getFlujoSalida());
        salidaP.flush(); // vacíar búfer de salida para enviar información de encabezado
        // establecer flujo de entrada para los objetos
        entradaP = new DataInputStream( cP.getFlujoEntrada());
        
    }
    
    public void setJTextArea2(JTextArea jTextArea2) {
        this.jTextArea2 = jTextArea2;
    }

    public JTextArea getJTextArea2() {
        return jTextArea2;
    }

    public void setJTextArea3(JTextArea jTextArea3) {
        this.jTextArea3 = jTextArea3;
    }

    public JTextArea getJTextArea3() {
        return jTextArea3;
    }

    public void setJTextArea4(JTextArea jTextArea4) {
        this.jTextArea4 = jTextArea4;
    }

    public JTextArea getJTextArea4() {
        return jTextArea4;
    }
}
