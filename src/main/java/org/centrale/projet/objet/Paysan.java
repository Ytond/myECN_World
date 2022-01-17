/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.security.NoSuchAlgorithmException;

/**
 * Classe des Paysans
 * @author samyamal
 * 
 */
public class Paysan extends Personnage {

    /**
     * Constructeur de la classe Paysan
     * @param nom  {@link Personnage#nom}
     * @param pV {@link Creature#ptVie}
     * @param pA  {@link Creature#pourcentageAtt}
     * @param poP    {@link Creature#pourcentagePar}
     * @param pM    {@link Personnage#pourcentageMag}
     * @param rM  {@link Personnage#pourcentageResistMag}
     * @param dA   {@link Creature#degAtt}
     * @param ptP {@link Creature#ptPar}
     * @param dM   {@link Personnage#degMag}
     * @param distMax    {@link Personnage#distAttMax}
     * @param pos   {@link Creature#pos}
     */
    public Paysan(String nom, int pV, int pA, int poP, int pM, int rM, int dA, int ptP, int dM, int distMax,Point2D pos) throws NoSuchAlgorithmException {
        super(nom, pV,0, pA, poP, pM, rM, dA, ptP, dM, distMax,pos);
    }
    
    /**
     * Constructeur de la classe Paysan
     * @param p {@link Paysan}
     */
    public Paysan(Paysan p) throws NoSuchAlgorithmException {
        super(p);
    }
    /**
     * Constructeur sans parametre de la classe Paysan
     */
    
    public Paysan() throws NoSuchAlgorithmException {
        super();
    }
       
}
