/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.io.BufferedReader;
import java.io.FileReader;
import static java.lang.Integer.parseInt;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *Classe chargementPartie
 * Charger une partie à l'aide d'un fichier texte existant
 * @author TIEMTORE
 */
public class ChargementPartie 
{
    /**
     * Nom du fichier Texte
     */
    private String NomFichier;
    /**
     * Buffer
     */
    private BufferedReader Buffer;
    
    /**
     * Constructeur chargement Partie
     * @param nomFichier {@link ChargementPartie#NomFichier}
     */
    public ChargementPartie(String nomFichier)
    {
        
        this.NomFichier=nomFichier;
        
    }
    /**
     * Methode chargerPartie
     * @return {@link World} renvoie un objet de type World
     */
    public World chargerPartie() throws NoSuchAlgorithmException
    {
        LinkedList <Personnage> personnages=new LinkedList();
        LinkedList <Monstre> monstres=new LinkedList();
        LinkedList <Objet> objets= new LinkedList();
        int longueur=10;
        int hauteur=10;
        World w ;

        Joueur J=new Joueur();
        StringTokenizer tokenizer;
        try
        {
            String ligne;
            this.Buffer = new BufferedReader(new FileReader(this.NomFichier));
            ligne = this.Buffer.readLine();
            while(ligne!=null)
            {
                //System.out.println(ligne);
                tokenizer =new StringTokenizer(ligne," ");
                String nom;
                String typePerso;
                ArrayList<Integer> table =new ArrayList();
                Point2D p;
                String mot=tokenizer.nextToken();//On capte le 1er mot
                mot=mot.toLowerCase();
                switch(mot)
                {
                    
                    
                    case"longueur":
                        while(tokenizer.hasMoreTokens())
                        {
                            mot=tokenizer.nextToken();
                            longueur=(parseInt(mot));                     
                        }
                        break;
                        
                    case"hauteur":
                        while(tokenizer.hasMoreTokens())
                        {
                            mot=tokenizer.nextToken();
                            hauteur=(parseInt(mot));                     
                        }
                        break;
                        
                  
                    case"joueur":
                        mot=tokenizer.nextToken();
                        mot=mot.toLowerCase();
                        typePerso=mot;// On capte le 2e mot
                                           
                        switch(typePerso)
                        {
                            
                            case"archer":
                                mot=tokenizer.nextToken();
                                mot=mot.toLowerCase();
                                nom=mot;// On capte le 3e mot

                                while(tokenizer.hasMoreTokens())
                                {
                                    mot=tokenizer.nextToken();
                                    table.add(parseInt(mot));

                                }
                                p=new Point2D(table.get(9),table.get(10));
                                Archer A=new Archer(nom,table.get(0),table.get(1),table.get(2),table.get(3),table.get(4),table.get(5),table.get(6),table.get(7),table.get(8),p,table.get(11));
                                J.setPerso(A);
                                
                                break;
                            case"guerrier":
                                mot=tokenizer.nextToken();
                                mot=mot.toLowerCase();
                                nom=mot;// 3e mot

                                while(tokenizer.hasMoreTokens())
                                {
                                    mot=tokenizer.nextToken();
                                    table.add(parseInt(mot));

                                }
                                p=new Point2D(table.get(10),table.get(11));
                                Guerrier G=new Guerrier(nom,table.get(0),table.get(1),table.get(2),table.get(3),table.get(4),table.get(5),table.get(6),table.get(7),table.get(8),table.get(9),p);
                                J.setPerso(G);
                                break;    

                            case"mage":
                                mot=tokenizer.nextToken();
                                mot=mot.toLowerCase();
                                nom=mot;// 3e mot

                                while(tokenizer.hasMoreTokens())
                                {
                                    mot=tokenizer.nextToken();
                                    table.add(parseInt(mot));

                                }
                                p=new Point2D(table.get(10),table.get(11));
                                Mage M=new Mage(nom,table.get(0),table.get(1),table.get(2),table.get(3),table.get(4),table.get(5),table.get(6),table.get(7),table.get(8),table.get(9),p);
                                J.setPerso(M);
                                break;      

                            case"paysan":
                                mot=tokenizer.nextToken();
                                mot=mot.toLowerCase();
                                nom=mot;// 3e mot

                                while(tokenizer.hasMoreTokens())
                                {
                                    mot=tokenizer.nextToken();
                                    table.add(parseInt(mot));

                                }
                                p=new Point2D(table.get(9),table.get(10));
                                Paysan P=new Paysan(nom,table.get(0),table.get(1),table.get(2),table.get(3),table.get(4),table.get(5),table.get(6),table.get(7),table.get(8),p);
                                J.setPerso(P);
                                break;
                            default: 
                                break;
                      
                        }
                        break;
                        
                    case"archer":
                        mot=tokenizer.nextToken();
                        mot=mot.toLowerCase();
                        nom=mot;// On capte le 2e mot
                        
                        while(tokenizer.hasMoreTokens())
                        {
                            mot=tokenizer.nextToken();
                            table.add(parseInt(mot));
                                                
                        }
                        p=new Point2D(table.get(9),table.get(10));
                        Archer A=new Archer(nom,table.get(0),table.get(1),table.get(2),table.get(3),table.get(4),table.get(5),table.get(6),table.get(7),table.get(8),p,table.get(11));
                        personnages.add(A);
                        break;
                    case"guerrier":
                        mot=tokenizer.nextToken();
                        mot=mot.toLowerCase();
                        nom=mot;// 2e mot
                        
                        while(tokenizer.hasMoreTokens())
                        {
                            mot=tokenizer.nextToken();
                            table.add(parseInt(mot));
                                                
                        }
                        p=new Point2D(table.get(10),table.get(11));
                        Guerrier G=new Guerrier(nom,table.get(0),table.get(1),table.get(2),table.get(3),table.get(4),table.get(5),table.get(6),table.get(7),table.get(8),table.get(9),p);
                        personnages.add(G);
                        break;    
                       
                    case"mage":
                        mot=tokenizer.nextToken();
                        mot=mot.toLowerCase();
                        nom=mot;// 2e mot
                        
                        while(tokenizer.hasMoreTokens())
                        {
                            mot=tokenizer.nextToken();
                            table.add(parseInt(mot));
                                                
                        }
                        p=new Point2D(table.get(10),table.get(11));
                        Mage M=new Mage(nom,table.get(0),table.get(1),table.get(2),table.get(3),table.get(4),table.get(5),table.get(6),table.get(7),table.get(8),table.get(9),p);
                        personnages.add(M);
                        break;      
                        
                    case"paysan":
                        mot=tokenizer.nextToken();
                        mot=mot.toLowerCase();
                        nom=mot;// 2e mot
                     
                        while(tokenizer.hasMoreTokens())
                        {
                            mot=tokenizer.nextToken();
                            table.add(parseInt(mot));
                                                
                        }
                        p=new Point2D(table.get(9),table.get(10));
                        Paysan P=new Paysan(nom,table.get(0),table.get(1),table.get(2),table.get(3),table.get(4),table.get(5),table.get(6),table.get(7),table.get(8),p);
                        personnages.add(P);
                        break;
                   
                    case"loup":
                        
                        while(tokenizer.hasMoreTokens())
                        {
                            mot=tokenizer.nextToken();
                            table.add(parseInt(mot));
                                                
                        }
                        p=new Point2D(table.get(5),table.get(6));
                        Loup Lo=new Loup(table.get(0),table.get(1),table.get(2),table.get(3),table.get(4),p);
                        monstres.add(Lo);
                        break; 
                    
                    case"lapin":
                       
                        while(tokenizer.hasMoreTokens())
                        {
                            mot=tokenizer.nextToken();
                            table.add(parseInt(mot));
                                                
                        }
                        p=new Point2D(table.get(5),table.get(6));
                        Lapin La=new Lapin(table.get(0),table.get(1),table.get(2),table.get(3),table.get(4),p);
                        monstres.add(La);
                        break;  
                    
                    case"soin":
                       
                        while(tokenizer.hasMoreTokens())
                        {
                            mot=tokenizer.nextToken();
                            table.add(parseInt(mot));
                                                
                        }
                        p=new Point2D(table.get(1),table.get(2));
                        Soin S=new Soin(table.get(0),p);
                        objets.add(S);
                        break;
                        
                    case"mana":
                       
                        while(tokenizer.hasMoreTokens())
                        {
                            mot=tokenizer.nextToken();
                            table.add(parseInt(mot));
                                                
                        }
                        p=new Point2D(table.get(1),table.get(2));
                        Mana Ma=new Mana(table.get(0),p);
                        objets.add(Ma);
                        break;
                        
                    case"nuagetoxique":
                        
                        while(tokenizer.hasMoreTokens())
                        {
                            mot=tokenizer.nextToken();
                            table.add(parseInt(mot));
                                                
                        }
                        p=new Point2D(table.get(4),table.get(5));
                        NuageToxique N=new NuageToxique(table.get(0),table.get(1),table.get(2),table.get(3),p);
                        objets.add(N);
                        break;

                    default:   
                        break;
          
                }
                             
                ligne = this.Buffer.readLine();
                                
            }
           
            w=new World(personnages,monstres,objets,J);
            w.longueur=longueur;
            w.hauteur=hauteur;
            System.out.println("Fin de Chargement\n");
            
            return w;
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
                  
        }
        
        return null;
        
    }
}
