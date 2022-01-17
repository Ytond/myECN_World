/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Classe des Mages
 * @author samyamal
 * 
 */

 

public class Mage extends Personnage implements Combattant {
    
    /**
     * Constructeur de la classe Mage
     * @param nom
     * @param ptVie
     * @param ptMana
     * @param pourcentageAtt
     * @param pourcentagePar
     * @param pourcentageMag
     * @param pourcentageResistMag
     * @param degAtt
     * @param ptPar
     * @param degMag
     * @param distAttMax
     * @param pos 
     */
    public Mage(String nom, int ptVie, int ptMana, int pourcentageAtt, int pourcentagePar, int pourcentageMag, int pourcentageResistMag, int degAtt, int ptPar, int degMag, int distAttMax, Point2D pos) throws NoSuchAlgorithmException {
        super(nom, ptVie, ptMana, pourcentageAtt, pourcentagePar, pourcentageMag, pourcentageResistMag, degAtt, ptPar, degMag, distAttMax, pos);
    }
    
    /**
     * Constructeur de la classe Mage à partir d'un objet Mage
     * @param m {@link Mage}
     */
    public Mage(Mage m) throws NoSuchAlgorithmException {
        super(m);
    }
    /**
     * Constructeur sans parametre de la classe Mage
     */
    
    public Mage() throws NoSuchAlgorithmException {
        super();
    }
    
    @Override
    public void affiche() {
        System.out.print("nom: " + this.nom + ", pV: " + this.ptVie + ", pM: "
                + this.ptMana + ", pA: " + this.pourcentageAtt + ", pP: "
                + this.pourcentagePar + ", pM: " + this.pourcentageMag + ", pRM: "
                + this.pourcentageResistMag + ", dA: " + this.degAtt + ", ptP : " + this.ptPar + ", dM : "
                + this.degMag + ", dAMax : " + this.distAttMax + ", nbFleches : ");
        this.pos.affiche();

    }
    
    
    /**
     * Methode de combat de la classe Mage
     * uniquement combat magique (à distance)
     * @param c {@link Creature}
     */
    public void combattre(Creature c) 
    {
        if (this.ptMana >= 1)
        {  // on vérifie que l'archer a au moins de quoi réaliser une attaque
            double dist ;
            dist = this.pos.distance(c.pos) ; 
            if ((dist<this.distAttMax))
            { // si le mage est à bonne distance
                System.out.println("Attaque Possible");
                //Random rand = new Random();  
                this.ptMana = this.ptMana -1 ;
                if (this.rand.nextInt(100)+1 <= this.pourcentageMag) 
                { //jet de dé entre 1 et 100
                    if (c.ptPar < this.degMag)
                    {
                        //defense réussie, on vérifie si les points de defense sont superieurs à l'attaque auquel cas l'attaque serait complètement parée
                        System.out.println("Attaque Parée par l'Adversaire");
                        c.setPtVie(c.ptVie - (this.degMag - c.ptPar)) ; 
                    } 
                    else
                    {
                        c.setPtVie(c.ptVie - this.degMag) ;
                        System.out.println("Attaque Réussie");//attaque réussie
                    }
                    
                }
                else
                {
                    System.out.println("Attaque Echouée");
                            
                }
                        
            }
        }
        else
        {
            System.out.println("Attaque Echouée");
        }
    }
    
}
