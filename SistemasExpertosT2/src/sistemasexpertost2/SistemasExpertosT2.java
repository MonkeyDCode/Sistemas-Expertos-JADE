/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemasexpertost2;

import javax.swing.JFrame;

/**
 *
 * @author josea
 */
public class SistemasExpertosT2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Ventana marco=new Ventana();
        
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setSize(900, 500);
        marco.setVisible(true);
        marco.setLocationRelativeTo(null);
    }
    
}
