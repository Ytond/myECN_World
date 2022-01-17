/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.security.NoSuchAlgorithmException;

/**
 * Classe des Lapins
 * @author TIEMTORE
 * 
 */



public class Lapin extends Monstre{
    
     /**
     * Constructeur de la classe Lapin
     * @param ptVie     {@link org.centrale.projet.objet.Creature#ptVie}
     * @param pourcentageAtt    {@link org.centrale.projet.objet.Creature#pourcentageAtt}
     * @param pourcentagePar    {@link org.centrale.projet.objet.Creature#pourcentagePar}
     * @param degAtt    {@link org.centrale.projet.objet.Creature#degAtt}
     * @param ptPar {@link org.centrale.projet.objet.Creature#ptPar}
     * @param pos   {@link org.centrale.projet.objet.Creature#pos}
     */
    public Lapin(int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, int ptPar, Point2D pos) throws NoSuchAlgorithmException {
        super(ptVie, pourcentageAtt, pourcentagePar, degAtt, ptPar, pos);
    }
    
    /**
     * Constructeur de la classe Lapin
     * @param l {@link Loup}
     */
    public Lapin(Lapin l) throws NoSuchAlgorithmException {
        super(l);
    }
    /**
     * Constructeru sans parametre de la classe Lapin
     */
    public Lapin() throws NoSuchAlgorithmException {
        super();
    }
    
}
