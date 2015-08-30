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
public class Regla {
    private String regla;
    private ArrayList condiciones;
    private String conclusion;
    public Regla(String reg,ArrayList cond,String conc){
        this.regla=reg;
        this.condiciones=cond;
        this.conclusion=conc;
    }

    /**
     * @return the regla
     */
    public String getRegla() {
        return regla;
    }

    /**
     * @return the condiciones
     */
    public ArrayList getCondiciones() {
        return condiciones;
    }

    /**
     * @return the conclusion
     */
    public String getConclusion() {
        return conclusion;
    }
}
