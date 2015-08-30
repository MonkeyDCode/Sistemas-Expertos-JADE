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

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.UnknownHostException;

import javax.imageio.ImageIO;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;

public class PrincipalII extends JFrame {
    public static PrincipalII p2 = new PrincipalII();
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
    private JLabel jLabel1 = new JLabel();
    private JTextField jTextField1 = new JTextField();
    private Servidor s;
    private Servidor2 s2;
    private Cliente cli;
    private Cliente cli2;
    public  DataOutputStream salida;
    public DataInputStream entrada;
    public  DataOutputStream salida2;
    public DataInputStream entrada2;
    

    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JLabel jLabel4 = new JLabel();

    
    public PrincipalII() {
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
        frame.setBounds(new Rectangle(0, 0, 1065, 575));
        frame.getJLabel1().setIcon(new ImageIcon("psicologoTTG.png"));
        frame.getJLabel2().setIcon(new ImageIcon("terapeutaTG.png"));
        jPanel1.setLayout(null);
        jPanel1.setBounds(new Rectangle(0, 0, 1061, 600));
        
        jSeparator1.setBounds(new Rectangle(345, 0, 2, 570));
        jSeparator1.setOrientation(SwingConstants.VERTICAL);
        jSeparator2.setBounds(new Rectangle(700, 0, 10, 575));
        jSeparator2.setOrientation(SwingConstants.VERTICAL);
        jScrollPane1.setBounds(new Rectangle(15, 325, 315, 150));
        jScrollPane2.setBounds(new Rectangle(370, 325, 310, 150));
        jScrollPane3.setBounds(new Rectangle(720, 325, 310, 150));
        jLabel1.setText("Usuario");
        jLabel1.setBounds(new Rectangle(240, 525, 95, 35));
        jLabel1.setFont(new Font("Tahoma", 1, 20));
        jTextField1.setBounds(new Rectangle(325, 525, 390, 30));
        jScrollPane1.getViewport().add(jTextArea2, null);
        
        jLabel2.setText("PSICÓLOGO");
        jLabel2.setBounds(new Rectangle(110, 480, 125, 35));
        jLabel2.setFont(new Font("Tahoma", 1, 17));
        jLabel2.setForeground(new Color(255, 33, 33));
        jLabel2.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jLabel3.setText("TERAPEUTA SEXUAL");
        jLabel3.setBounds(new Rectangle(435, 480, 195, 35));
        jLabel3.setFont(new Font("Tahoma", 1, 17));
        jLabel3.setForeground(new Color(255, 33, 33));
        jLabel3.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jLabel4.setText("GINECÓLOGO");
        jLabel4.setBounds(new Rectangle(820, 480, 130, 35));
        jLabel4.setFont(new Font("Tahoma", 1, 17));
        jLabel4.setForeground(new Color(255, 33, 33));
        jLabel4.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

        this.getContentPane().add(jTextField1, null);
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jSeparator2, null);
        this.getContentPane().add(jSeparator1, null);
        jScrollPane2.getViewport().add(jTextArea3, null);
        jScrollPane3.getViewport().add(jTextArea4, null);
        this.getContentPane().add(jScrollPane2, null);
        this.getContentPane().add(jScrollPane3, null);
        frame.add(jScrollPane1, null);
        frame.add(jLabel2, null);
        frame.add(jLabel3, null);
        frame.add(jLabel4, null);
        jPanel1.add(frame,null);
        this.getContentPane().add(jPanel1, null);
    }

    public static void main(String args[]){
        //PrincipalII p = new PrincipalII();
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
        PrincipalII.p2.setLocationRelativeTo(null);
        //p.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        PrincipalII.p2.setResizable(false);
        PrincipalII.p2.setVisible(true);
        
        PrincipalII.p2.s=new Servidor();
        PrincipalII.p2.s.start();
        
        PrincipalII.p2.s2=new Servidor2();
        PrincipalII.p2.s2.start();
        
        PrincipalII.p2.cli = new Cliente();
        PrincipalII.p2.cli.setHost("10.0.0.2");
        PrincipalII.p2.cli.setPuerto(8983);

        try {
            PrincipalII.p2.cli.conecta();
            PrincipalII.p2.obtenerflujos();
        } catch (UnknownHostException e) {
        } catch (IOException e) {
        }
        
        PrincipalII.p2.cli2 = new Cliente();
        PrincipalII.p2.cli2.setHost("10.0.0.2");
        PrincipalII.p2.cli2.setPuerto(8984);

        try {
            PrincipalII.p2.cli2.conecta();
            PrincipalII.p2.obtenerflujos2();
        } catch (UnknownHostException e) {
        } catch (IOException e) {
        }
        
        ControlAgentes1 control1 = new ControlAgentes1();
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

    public void setJTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }

    public JTextField getJTextField1() {
        return jTextField1;
    }
    

    //Metodo que obtiene los flujos del socket
    public void obtenerflujos() throws IOException {
        
        // establecer flujo de salida para los objetos
        salida= new DataOutputStream(cli.getFlujoSalida());
        salida.flush(); // vacíar búfer de salida para enviar información de encabezado

        // establecer flujo de entrada para los objetos
        entrada = new DataInputStream( cli.getFlujoEntrada());
        
    }
    
    
    //Metodo que obtiene los flujos del socket
    public void obtenerflujos2() throws IOException {
        
        // establecer flujo de salida para los objetos
        salida2= new DataOutputStream(cli2.getFlujoSalida());
        salida2.flush(); // vacíar búfer de salida para enviar información de encabezado

        // establecer flujo de entrada para los objetos
        entrada2 = new DataInputStream( cli2.getFlujoEntrada());
        
    }
}