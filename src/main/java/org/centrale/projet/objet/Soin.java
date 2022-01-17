/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe Soin
 * @author samyamal
 */
public class Soin extends Potion {
    
    /**
     * Constructeur de la classe Soin
     * @param ptV{@link Potion#ptVie}
     * @param pos {@link Potion#pos}
     */

    public Soin( int ptV,Point2D pos) {
        super(ptV, 0,pos);
    }
    /**
     * Constructeur de copie de la classe Soin
     * @param s 
     */

    public Soin(Soin s) {
        super(s);
    }
    /**
     * Constructeur sans Parametre de la classe Soin
     */

    public Soin() {
        super();
    }
    
    
    
}
