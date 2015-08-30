/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectsisexp;

/**
 *
 * @author Fer
 */
public class ProyectSisExp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      //  Ventana vnt = new Ventana();
        Ventana.vnt.setVisible(true);
        Ventana.vnt.pack();
      //  vnt.setVisible(true);
        ControlAgentes ctr = new ControlAgentes();
    }
}
