/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sejade;

import jade.core.Agent;

/**
 *
 * @author root
 */
public class HolaMundoAgente extends Agent {

    @Override
    protected void setup()
    {
        System.out.println("Mi nombre es "+ this.getLocalName());   
    }
    
}
