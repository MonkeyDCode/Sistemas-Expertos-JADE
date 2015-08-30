package ProyectoFinal;

import java.awt.Dimension;
import java.awt.Graphics;

import java.awt.Image;

import java.awt.Rectangle;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Pantalla extends JPanel {
    private Image fondo;
    //private JLabel jLabel1 = new JLabel(new ImageIcon("psicologoTT.png"));
    //private JLabel jLabel2 = new JLabel(new ImageIcon("terapeutaT.png"));
    //private JLabel jLabel3 = new JLabel(new ImageIcon("ginecologoT.png"));

    public Pantalla() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout( null );
        this.setSize(new Dimension(1061, 597));
        this.setOpaque(false);
        /*jLabel1.setBounds(new Rectangle(25, 15, 295, 320));
        jLabel2.setBounds(new Rectangle(375, 15, 295, 320));
        jLabel3.setBounds(new Rectangle(725, 15, 295, 320));
        this.add(jLabel1, null);
        this.add(jLabel2, null);
        this.add(jLabel3, null);*/
    }
    
    @Override
    public void paint(Graphics g) {
        
        if (fondo != null) {
            g.drawImage(fondo, 0, 0, null);
        }
        super.paint(g);
    }

    public void setJLabel1(JLabel jLabel1) {
        //this.jLabel1 = jLabel1;
    }

   

    public void setJLabel2(JLabel jLabel2) {
        //this.jLabel2 = jLabel2;
    }


    public void setJLabel3(JLabel jLabel3) {
        //this.jLabel3 = jLabel3;
    }

   
}
