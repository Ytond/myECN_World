/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe des objet
 * @author samyamal
 *  
 */
public class Objet extends ElementDeJeu {

    /**
     * Position de l'objet
     */
    protected Point2D pos;
    
    /**
     * Constructeur de la classe Objet
     * @param pos   {@link Potion#pos}
    */
    public Objet(Point2D pos) {
        this.pos = pos;
    }
    
    /**
     * Constructeur de recopie de la classe objet
     * @param o {@link  Objet}
     */
    public Objet(Objet o) {
        this.pos = new Point2D(o.pos);
    }
    
    /**
     * Constructeur sans Parametre dela clasee Objet
     */
    public Objet(){
        this.pos = new Point2D();
    }

    public Point2D getPos() {
        return pos;
    }
}
