/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Classe des Loups
 * @author samyamal
 * 
 */

 

public class Loup extends Monstre implements Combattant {

    /**
     * Constructeur de la classe Loup
     * @param ptVie     {@link org.centrale.projet.objet.Creature#ptVie}
     * @param pourcentageAtt    {@link org.centrale.projet.objet.Creature#pourcentageAtt}
     * @param pourcentagePar    {@link org.centrale.projet.objet.Creature#pourcentagePar}
     * @param degAtt    {@link org.centrale.projet.objet.Creature#degAtt}
     * @param ptPar {@link org.centrale.projet.objet.Creature#ptPar}
     * @param pos   {@link org.centrale.projet.objet.Creature#pos}
     */
    public Loup(int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, int ptPar, Point2D pos) throws NoSuchAlgorithmException {
        super(ptVie, pourcentageAtt, pourcentagePar, degAtt, ptPar, pos);
    }
    
    /**
     * Constructeur de la classe Loup
     * @param l {@link Loup}
     */
    public Loup(Loup l) throws NoSuchAlgorithmException {
        super(l);
    }
    /**
     * Constructeur sans parametre de la classe Loup
     */
    
    public Loup() throws NoSuchAlgorithmException {
        super();
    }
    
    /**
     * Methode de combat de la classe Loup
     * uniquement au corps à corps
     * @param c {@link Creature}
     */
    public void combattre(Creature c) 
    {

        double dist ;
        dist = this.pos.distance(c.pos) ; 
        if (dist <2)
        {  //si le loup est à distance de corps à corps
            //Random rand = new Random();  
            if (this.rand.nextInt(100)+1 <= this.pourcentageAtt) 
            { //jet de dé
                if (this.rand.nextInt(100)+1 > c.pourcentagePar) 
                {  //attaque réussie donc jet de dé pour la défense
                    if (c.ptPar < this.degAtt)
                    { //defense réussie, on vérifie si les points de defense sont superieurs à l'attaque auquel cas l'attaque serait complètement parée
                        c.setPtVie(c.ptVie - (this.degAtt - c.ptPar)) ;
                    }
                }
                else 
                { //défense ratée
                    c.setPtVie(c.ptVie - this.degAtt) ;
                }
            }
        }
    }
    
    
}
