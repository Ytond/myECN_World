/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;
import java.security.NoSuchAlgorithmException;


/**
 * 
 * Classe des Guerriers
 * @author samyamal
 * 
 */

 

public class Guerrier extends Personnage implements Combattant {
    
    /**
     * Constructeur de la classe Guerrier
     * @param nom  {@link Personnage#nom}
     * @param ptVie {@link Creature#ptVie}
     * @param ptMana    {@link Personnage#ptMana}
     * @param pourcentageAtt    {@link Creature#pourcentageAtt}
     * @param pourcentagePar    {@link Creature#pourcentagePar}
     * @param pourcentageMag    {@link Personnage#pourcentageMag}
     * @param pourcentageResistMag  {@link Personnage#pourcentageResistMag}
     * @param degAtt    {@link Creature#degAtt}
     * @param ptPar {@link Creature#ptPar}
     * @param degMag    {@link Personnage#degMag}
     * @param distAttMax    {@link Personnage#distAttMax}
     * @param pos   {@link Creature#pos}
     */
    public Guerrier(String nom, int ptVie, int ptMana, int pourcentageAtt, int pourcentagePar, int pourcentageMag, int pourcentageResistMag, int degAtt, int ptPar, int degMag, int distAttMax, Point2D pos) throws NoSuchAlgorithmException {
        super(nom, ptVie, ptMana, pourcentageAtt, pourcentagePar, pourcentageMag, pourcentageResistMag, degAtt, ptPar, degMag, distAttMax, pos);
    }
    
    /**
     * Constructeur de la classe Guerrier
     * @param g {@link Guerrier}
     */
    public Guerrier(Guerrier g) throws NoSuchAlgorithmException {
        super(g);
    }
    /**
     * 
     * Constructeur sans Parametre de la classe Guerrier
     */
    
    public Guerrier() throws NoSuchAlgorithmException {
        super();
    }
    
    @Override
    public void affiche() {
        System.out.print("nom: " + this.nom + ", ptV: " + this.ptVie + ", ptM: "
                + this.ptMana + ", pA: " + this.pourcentageAtt + ", pPar: "
                + this.pourcentagePar + ", pM: " + this.pourcentageMag + ", pRM: "
                + this.pourcentageResistMag + ", dA: " + this.degAtt + ", ptP: " +  this.ptPar + ", dM: "
                + this.degMag + ", dAMax: " + this.distAttMax + ", pos : ");
        this.pos.affiche();

    }
    
    
    /**
     * Methode de combat de la classe Guerrier
     * uniquement au corps ?? corps
     * @param c {@link Guerrier}
     */
    public void combattre(Creature c) 
    {
        double dist ;
        dist = this.pos.distance(c.pos) ; 
        if (dist <2)
        {  //si le guerrier est ?? distance de corps ?? corps
           
            if (this.rand.nextInt(100)+1 <= this.pourcentageAtt) 
            {
                //jet de d??
                System.out.println("Attaque Possible");
                if (this.rand.nextInt(100)+1 <= c.pourcentagePar) 
                {  //attaque r??ussie donc jet de d?? pour la d??fense
                    if (c.ptPar < this.degAtt)
                    {
                        //defense r??ussie, on v??rifie si les points de defense sont superieurs ?? l'attaque auquel cas l'attaque serait compl??tement par??e
                        System.out.println("Attaque Par??e par l'Adversaire");
                        c.setPtVie(c.ptVie - (this.degAtt - c.ptPar)) ; 
                    } 
                }
                else 
                { //defense rat??e
                    System.out.println("Attaque 100% R??ussie");
                    c.setPtVie(c.ptVie - this.degAtt) ;
                    
                }
            }
            else
            {
                System.out.println("Attaque Echou??e");
            }
        }
    }

}
