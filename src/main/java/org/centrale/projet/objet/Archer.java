/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.security.NoSuchAlgorithmException;
import java.util.Random; 

/**
 * Classe des Archers
 * @author TIEMTORE
 */

public class Archer extends Personnage implements Combattant {
    
    /**
     * Nombre de flèche de l'archer
     */
    private int nbFleches;
    
    
    /**
     * Constructeur de la classe Archer
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
     * @param nbF   {@link Archer#nbFleches}
     */
    public Archer(String nom, int pV, int pA, int poP, int pM, int rM, int dA, int ptP, int dM, int distMax,Point2D pos,int nbF) throws NoSuchAlgorithmException {
        super(nom, pV,0, pA, poP, pM, rM, dA, ptP, dM, distMax,pos);
        this.nbFleches = nbF ;
    }
    
    /**
     * 
     * @param a {@link Archer}
     */
    public Archer(Archer a) throws NoSuchAlgorithmException {
        super(a);
        this.nbFleches = a.nbFleches ;
    }
    /**
     * Constructeur sans parametre de la classe Archer
     */
    
    public Archer() throws NoSuchAlgorithmException {
        super();
        //Random gAlea=new Random();
        
        this.nbFleches =this.rand.nextInt(100) ;
    }

    public int getNbFleches() {
        return nbFleches;
    }

    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }
    
    @Override
    public void affiche() {
        System.out.print("nom: " + this.nom + ", pV: "+ this.ptVie + ", pM: "
                        +this.ptMana +", pAtt: "+ this.pourcentageAtt + ", pP: "
                        +this.pourcentagePar + ", pM: "+ this.pourcentageMag + ", pRM: "
                        +this.pourcentageResistMag + ", dA: "+this.degAtt + ", ptP: "+this.ptPar + ", dM: "
                        +this.degMag + ", dAMax: " +this.distAttMax + ", nbFleches: " + this.nbFleches + ", pos: ");
        this.pos.affiche();
  
    }
    
    
    /**
     * Methode de combat de la classe Archer
     * uniquement combat à distance
     * @param c {@link Archer}
     */
    
    public void combattre(Creature c) 
    {
        if (this.nbFleches >= 1)
        {   // on vérifie que l'archer a au moins une flèche pour réaliser une attaque
            double dist ;
            dist = this.pos.distance(c.pos) ;
            if ((dist<this.distAttMax))
            {   // si l'archer est à bonne distance
                //Random rand = new Random();
                this.nbFleches = this.nbFleches -1 ;
                if (this.rand.nextInt(100)+1 <= this.pourcentageMag) 
                { //jet de dé entre 1 et 100
                    if (c.ptPar < this.degAtt)
                    {
                        //defense réussie, on vérifie si les points de defense sont superieurs à l'attaque auquel cas l'attaque serait complètement parée
                        System.out.println("Attaque Parée par l'Adversaire");
                        c.setPtVie(c.ptVie - (this.degAtt - c.ptPar)) ; 
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
            else
            {
                System.out.println("Adversaire trop Eloignée");
            }
        }
        else
        {
            System.out.println("Attaque Echouée");
        }
    }
    


    
    
    
    
}
