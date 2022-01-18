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
 * Classe abstraite Créature
 * @author TIEMTORE
 */


 

public abstract class Creature extends ElementDeJeu implements Deplacable{
    
    /**
     *
     * Points de vie de la créature
     */
    protected int ptVie ;
    /**
     * Pourcentage d'attaque de la créature
     */
    protected int pourcentageAtt ;
    /**
     * Pourcentage de défense de la créature 
     */
    protected int pourcentagePar ;
    /**
     * Degré d'attaque de la créature
     */
    protected int degAtt ;
    /**
     * Points de defense de la créature
     */
    protected int ptPar ;
    /**
     * Position de la créature
     */
    protected Point2D pos ;
    /**
     * Random once for all
     */
    
    protected Random rand; 
    
    /**
     * Constructeur de la classe créature
     * @param ptVie     {@link Creature#ptVie}
     * @param pourcentageAtt    {@link Creature#pourcentageAtt}
     * @param pourcentagePar    {@link Creature#pourcentagePar}
     * @param degAtt    {@link Creature#degAtt}
     * @param ptPar    {@link Creature#ptPar}
     * @param pos   {@link Creature#pos}
     */
    public Creature(int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, int ptPar, Point2D pos) throws NoSuchAlgorithmException {
        
        this.rand= SecureRandom.getInstanceStrong();
        this.ptVie = ptVie;
        this.pourcentageAtt = pourcentageAtt;
        this.pourcentagePar = pourcentagePar;
        this.degAtt = degAtt;
        this.ptPar = ptPar;
        this.pos = pos;
        
    }
    
    /**
     * Constructeur de la classe Creature
     * @param c {@link Monstre}
     */
    public Creature(Creature c) throws NoSuchAlgorithmException {
        
        this.rand= SecureRandom.getInstanceStrong();
        this.ptVie = c.ptVie;
        this.pourcentageAtt = c.pourcentageAtt;
        this.pourcentagePar = c.pourcentagePar;
        this.degAtt = c.degAtt;
        this.ptPar = c.ptPar;
        this.pos = new Point2D(c.pos);
        
    }
    /**
     * Constructeur sans parametres(Aléatoire)
     * 
     */
    
 
    
    public Creature() throws NoSuchAlgorithmException {
        
        this.rand= SecureRandom.getInstanceStrong();
        this.ptVie =this.rand.nextInt(100);
        this.pourcentageAtt =this.rand.nextInt(100);
        this.pourcentagePar =this.rand.nextInt(100);
        this.degAtt =this.rand.nextInt(100);
        this.ptPar =this.rand.nextInt(100);
        this.pos = new Point2D();
        
    }
    
    public int getPtVie() {
        return ptVie;
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
    
    public int getptPar() {
        return ptPar;
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    public void setPourcentageAtt(int pourcentageAtt) {
        this.pourcentageAtt = pourcentageAtt;
    }

    public void setPourcentagePar(int pourcentagePar) {
        this.pourcentagePar = pourcentagePar;
    }

    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }
    
    public void setptPar(int ptPar) {
        this.ptPar = ptPar;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
    /**
     * Affiche l'état des attributs du Personnage
     */
    public void affiche() {
        System.out.print("ptV: " + this.ptVie +
                ", pAtt: " + this.pourcentageAtt +
                ", pPar: " + this.pourcentagePar +
                ", degAtt: " + this.degAtt + 
                ", ptPar: " + this.ptPar + ", ");
        System.out.print("pos : ");
        this.pos.affiche();
    }
    
    /**
     * Déplace la créature aléatoirement vers une case adjacente
     */
    public void deplace() {
        
        this.pos.translate(this.rand.nextInt(3)-1,this.rand.nextInt(3)-1) ;
    }
    /**
     * Déplace la créature vers une position souhaitée
     * @param dx Déplacement selon x
     * @param dy Déplacement selon y
     */
    public void deplace(int dx, int dy) {
        this.pos.translate(dx,dy);
    }

    /**
     * Implémentation de la méthode de l'interface Deplacable
     * Permet au Joueur de se déplacer au clavier
     * @param w {@link World}prend en parametre un objet de type World
     * Implémentation de la méthode de l'interface Deplacablr
     */
    @Override
    public void deplacer(World w)
    {
        
        System.out.println("Déplacement");
        System.out.println("G pour Gauche");
        System.out.println("D pour Droite");
        System.out.println("B pour Bas");
        System.out.println("H pour Haut ");
        Scanner sc=new Scanner(System.in);
        String dep=sc.next();
        Point2D posTest=new Point2D(this.pos.getX(),this.pos.getY());
        switch(dep)
        {
            case "G":
                posTest.translate(0,-1);
                if(w.isPositionFree(posTest)&&posTest.getX()>0&&posTest.getX()<w.longueur&&posTest.getY()<w.hauteur&&posTest.getY()>0)
                {
                    this.pos.translate(0,-1);
                    System.out.println("Déplacement à Gauche réussi");
                }
                else
                {
                    System.out.println("Case occupée");
                }
                
                break;      
            case "D":
                posTest.translate(0,1);
                if(w.isPositionFree(posTest)&&posTest.getX()>0&&posTest.getX()<w.longueur&&posTest.getY()<w.hauteur&&posTest.getY()>0)
                {
                    this.pos.translate(0,1);
                    System.out.println("Déplacement à Droite réussi");
                }
                else
                {
                    System.out.println("Case occupée");
                }
                
                break;
            case "H":
                posTest.translate(-1, 0);
                if(w.isPositionFree(posTest)&&posTest.getX()>0&&posTest.getX()<w.longueur&&posTest.getY()<w.hauteur&&posTest.getY()>0)
                {
                    this.pos.translate(-1,0);
                    System.out.println("Déplacement ers le Haut réussi");
                }
                else
                {
                    System.out.println("Case occupée");
                }
                
                
                break;
            case "B":
                posTest.translate(1,0);
                if(w.isPositionFree(posTest)&&posTest.getX()>0&&posTest.getX()<w.longueur&&posTest.getY()<w.hauteur&&posTest.getY()>0)
                {
                      this.pos.translate(1,0);
                      System.out.println("Déplacementvers le Bas réussi");
                }
                else
                {
                    System.out.println("Case occupée");
                }
                
                break;
                
            default:
                this.pos.translate(0,0);
                break;
        }
        
    }
}