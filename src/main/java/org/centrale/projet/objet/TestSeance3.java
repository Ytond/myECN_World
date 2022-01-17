/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
        
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Scanner;
        


/**
 * Classe TestSeance3
 * Classe Principale contenant la methode main
 * @author TIEMTORE
 */

public class TestSeance3 
{
 
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException 
    {
      
       World w ;
       boolean nouvellePartie=true;
       while(nouvellePartie)
       {
           System.out.println("******Bienvenue au  MENU PRINCIPAL******");
           System.out.println("Voulez vous?");
           System.out.println("1.Commencer une nouvelle Partie\n2.Charger une partie\n3.Quitter");
           Scanner scan=new Scanner(System.in);
           int partie=scan.nextInt();
           switch(partie)
           {
                case 1:
                    w=new World(14,11,9); 
                    w.creationJoueur();
                    w.creeMondeAlea();
                    w.tourDeJeu();
                  
                   break;
                case 2:
                    System.out.println("Saisir le nom du fichier de Sauvegarde");
                    Scanner sca=new Scanner(System.in);
                    String fileName=sca.next();
                    fileName+=".txt";
                    ChargementPartie p=new ChargementPartie(fileName);
                    w=p.chargerPartie();
                    w.tourDeJeu(); 
                   break;
                case 3:
                    System.out.println("Jeu Quitté");
                    nouvellePartie=false; 
                    break;
               default:
                   System.out.println("Jeu Quitté");
                   nouvellePartie=false;
                   break;
           }
           
       }



    } 
            
}