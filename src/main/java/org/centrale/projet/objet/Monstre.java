/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.security.NoSuchAlgorithmException;


/**
 * Classe abstraite des Monstres
 * @author samyamal
 * 
 */
 
public abstract class Monstre extends Creature {
    

    /**
     * Constructeur de la classe Monstre
     * @param ptVie     {@link Creature#ptVie}
     * @param pourcentageAtt    {@link Creature#pourcentageAtt}
     * @param pourcentagePar    {@link Creature#pourcentagePar}
     * @param degAtt    {@link Creature#degAtt}
     * @param pos   {@link Creature#pos}
     */
    public Monstre(int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, int ptPar, Point2D pos) throws NoSuchAlgorithmException {
        super(ptVie, pourcentageAtt, pourcentagePar, degAtt, ptPar, pos);
    }
    
    /**
     * Constructeur de copie de la classe Monstre
     * @param m {@link Monstre}
     */
    public Monstre(Monstre m) throws NoSuchAlgorithmException {
        super(m);
    }
    /**
     * Constructeur sans parametre de la classe Monstre
     */
    
    public Monstre() throws NoSuchAlgorithmException {
        super();
    }
    
    
   
}
