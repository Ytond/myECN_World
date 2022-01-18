/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.security.NoSuchAlgorithmException;
import java.util.Random;



/**
 * Classe abstaite Personnage
 * @author samyamal
 * 
 */
        
public abstract class Personnage extends Creature {

    /**
     * Nom du personnage
     */
    protected String nom;
    /**
     * Points de mana du personnage
     */
    protected int ptMana;
    /**
     * Pourcentage de magie du personnage
     */
    protected int pourcentageMag;
    /**
     * Pourcentage de resistance à la magie
     */
    protected int pourcentageResistMag;
    /**
     * Degré de magie du personnage
     */
    protected int degMag;
    /**
     * Distance d'attaque maximale du personnage
     */
    protected int distAttMax;

    /**
     * Constructeur d'un Personnage
     * @author samyamal
     * @param nom   Nom du personnage
     * @param ptVie {@link Creature#ptVie}
     * @param ptMana {@link Personnage#ptMana}
     * @param pourcentageAtt {@link Creature#pourcentageAtt}
     * @param pourcentagePar {@link Creature#pourcentagePar}
     * @param pourcentageMag {@link Personnage#pourcentageMag}
     * @param pourcentageResistMag {@link Personnage#pourcentageResistMag}
     * @param degAtt {@link Creature#degAtt}
     * @param ptPar {@link Creature#ptPar}
     * @param degMag {@link Personnage#degMag}
     * @param distAttMax {@link Personnage#distAttMax}
     * @param pos {@link Creature#pos}
     */
    public Personnage(String nom, int ptVie, int ptMana, int pourcentageAtt, int pourcentagePar, int pourcentageMag, int pourcentageResistMag, int degAtt, int ptPar,int degMag, int distAttMax, Point2D pos) throws NoSuchAlgorithmException {
        super(ptVie, pourcentageAtt, pourcentagePar, degAtt, ptPar, pos);
        this.nom = nom;
        this.ptMana = ptMana;
        this.pourcentageMag = pourcentageMag;
        this.pourcentageResistMag = pourcentageResistMag;
        this.degMag = degMag;
        this.distAttMax = distAttMax;
    }

    /**
     * 
     * @param p {@link Personnage}
     */
    public Personnage(Personnage p) throws NoSuchAlgorithmException {
        super(p);
        this.nom = p.nom;
        this.ptMana = p.ptMana;
        this.pourcentageMag = p.pourcentageMag;
        this.pourcentageResistMag = p.pourcentageResistMag;
        this.degMag = p.degMag;
        this.distAttMax = p.distAttMax;
    }
    /**
     * Constructeur sans parametre de la classe Personnage
     */

    
    public Personnage() throws NoSuchAlgorithmException {
        
        super();
        
        this.nom = null;
        this.ptMana = this.rand.nextInt(100);
        this.pourcentageMag = this.rand.nextInt(100);
        this.pourcentageResistMag =this.rand.nextInt(100);
        this.degMag =this.rand.nextInt(100);
        this.distAttMax = this.rand.nextInt(100);
    }

    public String getNom() {
        return nom;
    }

    public int getPtMana() {
        return ptMana;
    }

    public int getPourcentageMag() {
        return pourcentageMag;
    }

    public int getPourcentageResistMag() {
        return pourcentageResistMag;
    }

    public int getDegMag() {
        return degMag;
    }

    public int getDistAttMax() {
        return distAttMax;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPtMana(int ptMana) {
        this.ptMana = ptMana;
    }
    public void setPourcentageMag(int pourcentageMag) {
        this.pourcentageMag = pourcentageMag;
    }

    public void setPourcentageResistMag(int pourcentageResistMag) {
        this.pourcentageResistMag = pourcentageResistMag;
    }

    public void setDegMag(int degMag) {
        this.degMag = degMag;
    }

    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    /**
     * Affiche l'état des attributs du Personnage
     */
    @Override
    public void affiche() {
        System.out.print("nom: " + this.nom + ", ptV: " + this.ptVie + ", ptM: " + this.ptMana + ", pAtt: " + this.pourcentageAtt
                + ", pPar: " + this.pourcentagePar + ", pMag: " + this.pourcentageMag + ", pRM: " + this.pourcentageResistMag
                + ", dA: " + this.degAtt + ", ptPar: " + this.ptPar + ", dM: " + this.degMag + ", dAttMax: " + this.distAttMax + ", pos : ");
        this.pos.affiche();
    }
    
     

}
    

    
    
    
    
    
    
    
    
    
    

