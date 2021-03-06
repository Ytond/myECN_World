/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe d'un Point en 2D
 * @author samyamal
 * 
 */
public class Point2D {

    /**
     * Attribut de la classe de type entier s'appelant 'Point2D'
     *
     * @attribute x l'abscisse
     */
    private int x;
    /**
     * Attribut de la classe de type entier s'appelant 'Point2D'
     * @attribute y l'ordonnee
     */
    private int y;
    
    /**
     * Construsteur de la clasee Point2D
     * @param x   {@link org.centrale.projet.objet.Point2D#x}
     * @param y    {@link org.centrale.projet.objet.Point2D#y}
     */
     
    Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Constructeur de copie de classe Point2D
     * @param p{@link Point2D} 
     */

    Point2D(Point2D p) {
        this.x = p.x;
        this.y = p.y;
    }
    /**
     * Constructeur sans parametre de la classe Point2D
     */
    
    Point2D() {
        this.x = 0;
        this.y = 0;
    }

    

    /**
     * Modificateur de l'attribut 'x'
     */
    public void setX(int value) {
        this.x = value;
    }

    /**
     * Modificateur de l'attribut 'y'
     * @param value
     */
    public void setY(int value) {
        this.y = value;
    }

    /**
     * Modificateur des attributs 'x' et 'y'
     * @param x
     * @param y
     */
    public void setPosition(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    /**
     * Accesseur a l'attribut 'x'
     *
     * @return la valeur de l'attribut 'x'
     */
    public int getX() {
        return this.x;
    }

    /**
     * Accesseur a l'attribut 'y'
     *
     * @return la valeur de l'attribut 'y'
     */
    public int getY() {
        return this.y;
    }

    public void affiche() {
        System.out.println("[" + this.x + "; " + this.y + "]");
    }
    /**
     * Methode translate 
     * Realise une translation 2D
     * @param dx
     * @param dy 
     */

    public void translate(int dx, int dy) {
        this.setX(this.x + dx);
        this.setY(this.y + dy);
    }
    
    /**
     * 
     * @param p {@link Point2D}
     * @return La distance entre notre point et la point donn?? en argument
     */
    public double distance(Point2D p){
        return (Math.sqrt( (double)(p.x-this.x)*(p.x-this.x) + (p.y-this.y)*(p.y-this.y) ));
    }
    
    
    /**
     * la m??thode distance permet de d??terminer si deux points sont ??loign??s d'une distance inf??rieure ou ??gale ?? dist : 
     * s'ils le sont, renvoie true, sinon false
     * @param p
     * @param dist
     * @return 
     */
    public boolean checkDistance(Point2D p, int dist){
        return distance(p) <=dist ;
    }
    
    /**
     * redefinition de la m??thode equals pour d??terminer si deux points sont ??gaux 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Point2D other = (Point2D) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.x;
        hash = 41 * hash + this.y;
        return hash;
    }
   
}