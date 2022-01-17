/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe Mana
 * @author samyamal
 * 
 */
public class Mana extends Potion {
    /**
     * Construrcteur de la classe Mana
     * @param ptM{@link Potion#ptMana}
     * @param pos {@link Potion#pos}
     */

    public Mana( int ptM,Point2D pos) {
        super( 0, ptM,pos);
    }
    /**
     * Constructeur de copie de la classe Mana
     * @param m {@link Mana}
     */

    public Mana(Mana m) {
        super(m);
    }
    /**
     * Constructeur sans parametre de la classe Mana
     */

    public Mana() {
        super();
    }
    
}
