/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;

/**
 * Classe Potion
 * @author samyamal
 * 
 */
public class Potion extends Objet {
    
    /**
     *@attribute 
     * Nombre de points de Vie rendus par la potion
    */
    private int ptVie ;
    /**
     *@attribute 
     * Nombre de points Mana rendus par la potion
    */
    
    private int ptMana ;


    /**
     * 
     * Constructeur de la classe Potion
    * @param pos   {@link Objet#pos}
    * @param ptV   {@link Potion#ptVie}
    * @param ptM   {@link Potion#ptMana}
    */

    public Potion(int ptV, int ptM,Point2D pos) {
        super(pos);
        this.ptVie = ptV ;
        this.ptMana = ptM;
    }
    /**
     * Constructeur de copie de la classe Potion
     * @param p{@link Potion} 
     */

    public Potion(Potion p) {
        super(p);
        this.ptVie = p.ptVie ;
        this.ptMana = p.ptMana ;
    }
    /**
     * Constructeur sans parametre de la classe Potion
     */

    public Potion() {
        super();
        Random gAlea=new Random();
       
        this.ptVie =gAlea.nextInt(1000);
        
        this.ptMana = gAlea.nextInt(100); 
    }

    public int getPtVie() {
        return ptVie;
    }

    public int getPtMana() {
        return ptMana;
    }

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    public void setPtMana(int ptMana) {
        this.ptMana = ptMana;
    }
    
     
    
}
