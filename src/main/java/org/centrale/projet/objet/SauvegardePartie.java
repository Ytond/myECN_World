/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe SauvegardePartie
 * @author r_rizkallah
 */
public class SauvegardePartie {
    
    private String filename;
    private BufferedWriter bw = null;

    public String getFilename() {
        return filename;
    }

    public BufferedWriter getBw() {
        return bw;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setBw(BufferedWriter bw) {
        this.bw = bw;
    }
    
    
    
    /**
     * Ce constructeur prend un nom du fichier afin de sauvgarder la partie du jeu
     * @param filename : c'est le nom du fichier proposer par l'utilisateur
     * 
     */
    public SauvegardePartie(String filename){
        this.filename=filename;
    } 
    
    /**
     * Ce constructeur fournit un nom unique au fichier de sauvegarde
     * Il ajoute l'instant de la sauvegarde en millisecondes
     */
    public SauvegardePartie(){
        this.filename="Save"+java.util.Calendar.getInstance().getTimeInMillis()+".txt";
    } 
    
    /**
     * Cette fonction permet d'enumerer les objets des classes Personnage, Monstre et Joueur afin de sauvegarder leurs attributs dans le fichier de sauvegarde
     * @param w {@link World}: Objet World
     * 
     */
    public void sauvegarderPartie(World w)
    {
        Personnage personnage ;
        Monstre monstre ;
        Objet objet;
        try{
            this.bw = new BufferedWriter(new FileWriter(filename));
            bw.write("Longueur"+" "+w.longueur);
            bw.newLine();
            bw.write("Hauteur"+" "+w.hauteur);
            bw.newLine();
            for(int i=0;i<w.personnages.size();i++)
            {
                personnage = w.personnages.get(i);
                bw.write(personnage.getClass().getSimpleName() +" "+personnage.getNom() +" "+ String.valueOf(personnage.getPtVie()) +" "+String.valueOf(personnage.getPtMana()) +" "+String.valueOf(personnage.getPourcentageAtt()) +" "+String.valueOf(personnage.getPourcentagePar()) +" "+String.valueOf(personnage.getPourcentageMag()) +" "+String.valueOf(personnage.getPourcentageResistMag()) +" "+String.valueOf(personnage.getDegAtt()) +" "+String.valueOf(personnage.getptPar()) +" "+String.valueOf(personnage.getDegMag()) +" "+String.valueOf(personnage.getDistAttMax()) +" "+String.valueOf(personnage.getPos().getX()) +" "+String.valueOf(personnage.getPos().getY()));
                bw.newLine();
            }
            for(int i=0;i<w.objets.size();i++)
            {
                objet = w.objets.get(i);
                if(objet instanceof Soin)
                {
                    bw.write(objet.getClass().getSimpleName()+" "+String.valueOf(((Soin) objet).getPtVie())+" "+String.valueOf(objet.getPos().getX()) +" "+String.valueOf(objet.getPos().getY()));
                }
                else if(objet instanceof Mana)
                {
                    bw.write(objet.getClass().getSimpleName()+" "+String.valueOf(((Mana) objet).getPtMana())+" "+String.valueOf(objet.getPos().getX()) +" "+String.valueOf(objet.getPos().getY()));
                }
                else if(objet instanceof NuageToxique)
                {
                    bw.write(objet.getClass().getSimpleName()+" "+String.valueOf(((NuageToxique) objet).getPourcentageAtt())+" "+String.valueOf(((NuageToxique) objet).getPourcentagePar())+" "+String.valueOf(((NuageToxique) objet).getDegAtt())+" "+String.valueOf(((NuageToxique) objet).getPtPar())+" "+String.valueOf(objet.getPos().getX()) +" "+String.valueOf(objet.getPos().getY()));
                }
                
                else
                {
                bw.write(objet.getClass().getSimpleName() +" "+" "+String.valueOf(objet.getPos().getX()) +" "+String.valueOf(objet.getPos().getY()));
                }
                bw.newLine();
            }
            for(int i=0;i<w.monstres.size();i++)
            {
                monstre = w.monstres.get(i);
                bw.write(monstre.getClass().getSimpleName() +" "+ String.valueOf(monstre.getPtVie()) +" "+String.valueOf(monstre.getPourcentageAtt()) +" "+String.valueOf(monstre.getPourcentagePar()) +" "+String.valueOf(monstre.getDegAtt()) +" "+String.valueOf(monstre.getptPar()) +" "+String.valueOf(monstre.getPos().getX()) +" "+String.valueOf(monstre.getPos().getY()));
                bw.newLine();
            
            }
            bw.write(w.getJ().getClass().getSimpleName()+" "+w.getJ().getPerso().getClass().getSimpleName()+" "+w.getJ().getPerso().getNom()+" "+String.valueOf(w.getJ().getPerso().getPtVie()) +" "+String.valueOf(w.getJ().getPerso().getPtMana()) +" "+String.valueOf(w.getJ().getPerso().getPourcentageAtt()) +" "+String.valueOf(w.getJ().getPerso().getPourcentagePar()) +" "+String.valueOf(w.getJ().getPerso().getPourcentageMag()) +" "+String.valueOf(w.getJ().getPerso().getPourcentageResistMag()) +" "+String.valueOf(w.getJ().getPerso().getDegAtt()) +" "+String.valueOf(w.getJ().getPerso().getptPar()) +" "+String.valueOf(w.getJ().getPerso().getDegMag()) +" "+String.valueOf(w.getJ().getPerso().getDistAttMax()) +" "+String.valueOf(w.getJ().getPerso().getPos().getX()) +" "+String.valueOf(w.getJ().getPerso().getPos().getY()));
        }
        catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        finally{
            try{
                if(bw!=null){
                    bw.flush();
                    bw.close();
                    
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        
        
        
    }
}