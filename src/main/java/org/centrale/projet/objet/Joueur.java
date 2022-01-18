/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * Classe Joueur
 * Le joueur pourra choisir son personnage de Jeu
 * @author TIEMTORE
 * 
 */
public class Joueur 
{
    /**
     * Attribut de type Personnage
     */
    private Personnage perso;
     /**
     * Random once for all
     */
    
    private Random rand; 
    /**
     * Constructeur de la classe Joueur avec un parametre
     * @param perso{@link Joueur#perso} 
     */
    public Joueur(Personnage perso) throws NoSuchAlgorithmException 
    {
        this.perso = perso;
        this.rand=SecureRandom.getInstanceStrong();
    }
    /**
     * Constructeur sans parametre de la classe Joueur
     */
    public Joueur() throws NoSuchAlgorithmException
    {
        this.perso=null;
        this.rand=SecureRandom.getInstanceStrong();
        
    }

    public Personnage getPerso() {
        return perso;
    }

    public void setPerso(Personnage perso) {
        this.perso = perso;
    }
    /**
     * Methode d'affichage du Joueur
     */
    public void afficheJoueur()
    {
      
        System.out.println("TypeJoueur: "+this.perso.getClass().getSimpleName());
        this.getPerso().affiche();
    }

   /**
    * Methode pour choisir son personnage
    * Le joueur a le choix entre 4 type de Personnage(Archer,Guerrier,Mage,Paysan)
    * Une fois le choix effectuer le joueur fournit un nom à son personnage
    * Les valeurs des autres attributs sont assignées aléatoirement
    * @param w {@link World}
    */
     public void choisirPersonnage(World w) throws NoSuchAlgorithmException
    {
        boolean b=true;
        
        Point2D pos = new Point2D();
        int choix;
        while(b)
        {
            
            
            System.out.println("Choisir votre Personnage");
            System.out.println("1.Guerrier\n2.Archer\n3.Mage\n4.Paysan");
            Scanner scanner = new Scanner( System.in );
            choix= scanner.nextInt();
            String nomPerso;
            String msg="Saisir un nom pour votre personnage";

            switch(choix)
            {
                case 1:

                    pos.setPosition(this.rand.nextInt(w.longueur), this.rand.nextInt(w.hauteur));
                    this.perso=new Guerrier();
                    this.perso.setPos(pos);
                    System.out.println(msg);
                    nomPerso=scanner.next();
                    this.perso.setNom(nomPerso);
                    b=false;
                    break;
                case 2:

                    pos.setPosition(this.rand.nextInt(w.longueur), this.rand.nextInt(w.hauteur));
                    this.perso=new Archer();
                    this.perso.setPos(pos);
                    System.out.println(msg);
                    nomPerso=scanner.next();
                    this.perso.setNom(nomPerso);
                    b=false;
                    break;
                case 3:

                    pos.setPosition(this.rand.nextInt(w.longueur), this.rand.nextInt(w.hauteur));
                    this.perso=new Mage();
                    this.perso.setPos(pos);
                    System.out.println(msg);
                    nomPerso=scanner.next();
                    this.perso.setNom(nomPerso);
                    b=false;
                    break;
                case 4:

                    pos.setPosition(this.rand.nextInt(w.longueur), this.rand.nextInt(w.hauteur));
                    this.perso=new Paysan();
                    this.perso.setPos(pos);
                    System.out.println(msg);
                    nomPerso=scanner.next();
                    this.perso.setNom(nomPerso);
                    b=false;
                    break;
                default:
                    System.out.println("choix non valide");
                    break;
            }
            
        }
 
    }
    
}
