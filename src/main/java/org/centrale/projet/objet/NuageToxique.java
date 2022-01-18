/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Classe NuageToxique 
 * Objet pouvant combattre
 * @author TIEMTORE
 */
public class NuageToxique extends Objet implements Deplacable,Combattant
{
    
    /**
     * Pourcentage d'attaque de Nuage toxique
     */
    private int pourcentageAtt ;
    /**
     * Pourcentage de défense de Nuage toxique
     */
    private int pourcentagePar ;
    /**
     * Degré d'attaque de Nuage toxique
     */
    private int degAtt ;
    /**
     * Points de defense de Nuage toxique
     */
    private int ptPar ;
    
     /**
     * Random once for all
     */
    
    private Random rand; 

    public NuageToxique(int pourcentageAtt, int pourcentagePar, int degAtt, int ptPar, Point2D pos) throws NoSuchAlgorithmException {
        super(pos);
        this.rand=SecureRandom.getInstanceStrong();
        this.pourcentageAtt = pourcentageAtt;
        this.pourcentagePar = pourcentagePar;
        this.degAtt = degAtt;
        this.ptPar = ptPar;
        
    }

    public NuageToxique(NuageToxique N) throws NoSuchAlgorithmException {
        super(N);
        this.rand=SecureRandom.getInstanceStrong();
        this.pourcentageAtt = N.pourcentageAtt;
        this.pourcentagePar = N.pourcentagePar;
        this.degAtt = N.degAtt;
        this.ptPar = N.ptPar;
    }

    public NuageToxique() throws NoSuchAlgorithmException {
        super();
       
       
        this.rand=SecureRandom.getInstanceStrong();
        this.pourcentageAtt =  this.rand.nextInt(100);
        this.pourcentagePar =  this.rand.nextInt(100);
        this.degAtt = this.rand.nextInt(100);
        this.ptPar =  this.rand.nextInt(100);
    }

    public int getPourcentageAtt() {
        return pourcentageAtt;
    }

    public int getPourcentagePar() {
        return pourcentagePar;
    }

    public int getDegAtt() {
        return degAtt;
    }

    public int getPtPar() {
        return ptPar;
    }
    
    
    public void deplacer(World w)
    {
    }
    
    public void combattre(Creature c) {

        double dist ;
        dist = this.pos.distance(c.pos) ; 
        if (dist <2){  //si le guerrier est à distance de corps à corps
            
            if (this.rand.nextInt(100)+1 <= this.pourcentageAtt) { //jet de dé
                if (this.rand.nextInt(100)+1 <= c.pourcentagePar) {  //attaque réussie donc jet de dé pour la défense
                    if (c.ptPar < this.degAtt){ //defense réussie, on vérifie si les points de defense sont superieurs à l'attaque auquel cas l'attaque serait complètement parée
                        c.setPtVie(c.ptVie - (this.degAtt - c.ptPar)) ; 
                    } 
                }
                else { //defense ratée
                    c.setPtVie(c.ptVie - this.degAtt) ;
                }
            }
        }
    }
    
}
