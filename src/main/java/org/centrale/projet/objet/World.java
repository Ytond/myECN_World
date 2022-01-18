/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;


import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Classe pour gérer les éléments de Jeu
 * @author TIEMTORE
 * 
 */

public class World {
 
    
    /**
     * Les personnages du monde
     * 
     */
    public LinkedList<Personnage> personnages;
    /**
     * Les monstres du monde
     * 
     */
    public LinkedList<Monstre> monstres;
    /**
     * Les Objets du monde
     * 
     */
    public LinkedList<Objet> objets;
    /**
     * Le Joueur Humain
     * 
     */
    
    private Joueur J;

    /**
     * Taille du monde 
     */
    
    public int longueur;
    public int hauteur;
    public int taille = longueur*hauteur;

    /**
     * Random once for all
     */
    
    private Random rand; 

    

    public Joueur getJ() {
        return J;
    }
    
    /**
     * Méthode qui renvoie une liste aléatoire de personnages
     * @param nbPersonnages entier
     */
    
    private LinkedList<Personnage> initPersonnages(int nbPersonnages) throws NoSuchAlgorithmException {
        LinkedList<Personnage> personnages = new LinkedList<>();
        //Random gAlea = new Random();

        for (int i = 0; i < nbPersonnages; i++) {
            int typePersonnage = this.rand.nextInt(4);
            switch (typePersonnage) {
                case 0:
                    personnages.add(new Archer());
                    break;
                case 1:
                    personnages.add(new Paysan());
                    break;
                case 2:
                    personnages.add(new Guerrier());
                    break;
                case 3:
                    personnages.add(new Mage());
                    break;
                default:
                   throw new IllegalArgumentException("There's only 4 type of character");
            }
        }
        return personnages;
    }
    
    /**
     * Méthode qui renvoie une liste aléatoire de monstres
     * @param nbMonstres entier
     */
    private LinkedList<Monstre> initMonstres(int nbMonstres) throws NoSuchAlgorithmException {
        LinkedList<Monstre> monstres = new LinkedList<>();
        //Random gAlea = new Random(); 

        for (int i = 0; i < nbMonstres; i++) {
            int typeMonstre = this.rand.nextInt(2);
            switch (typeMonstre) {
                case 0:
                    monstres.add(new Loup());
                    break;
                case 1:
                    monstres.add(new Lapin());
                    break;
                default:
                  throw new IllegalArgumentException("There's only 2 type of monster");
                  
            }
        }
        return monstres;
    }

    /**
     * Méthode qui renvoie une liste aléatoire d'objets
     * @param nbObjets entier
     */
    private LinkedList<Objet> initObjets(int nbObjets) throws NoSuchAlgorithmException {
        LinkedList<Objet> objets = new LinkedList<>();
        //Random gAlea = new Random();

        for (int i = 0; i < nbObjets; i++) {
            int typeObjet = this.rand.nextInt(3);
            switch (typeObjet) {
                case 0:
                    objets.add(new Mana());
                    break;
                case 1:
                    objets.add(new Soin());
                    break;
                case 2:
                    objets.add(new NuageToxique());
                    break;
                default:
                    throw new IllegalArgumentException("There's only 2 type of monster");
            }
        }
        return objets;
    }

    /**
     * Constructeur de la classe World
     * 
     * @param nbObjets      Nombre d'objets max à instancier
     * @param nbMonstres    Nombre de monstres max à instancier
     * @param nbPersonnages Nombre de personnages max à instancier
     */
    public World(int nbPersonnages,int nbMonstres,int nbObjets) throws NoSuchAlgorithmException {
        
        this.rand= SecureRandom.getInstanceStrong();
        this.objets = initObjets(nbObjets);
        this.monstres = initMonstres(nbMonstres);
        this.personnages = initPersonnages(nbPersonnages);
        
        this.J=new Joueur();
        this.longueur=10;
        this.hauteur=10;
        

    }

     /**
     * Constructeur de la classe World
     * 
     * @param nbMonstres    Nombre de monstres max à instancier
     * @param nbPersonnages Nombre de personnages max à instancier
     */
    public World(int nbPersonnages,int nbMonstres) throws NoSuchAlgorithmException {
        
        this.rand= SecureRandom.getInstanceStrong();
        
        this.objets = initObjets(0);
        this.monstres = initMonstres(nbMonstres);
        this.personnages = initPersonnages(nbPersonnages);
        this.J=new Joueur();
    }
   
    
    /**
    * Constructeur par défaut
    */
    public World() throws NoSuchAlgorithmException {
        
        this.rand= SecureRandom.getInstanceStrong();
        this.personnages = new LinkedList<>();
        this.monstres = new LinkedList<>();
        this.objets = new LinkedList<>();
        this.J=new Joueur();
        this.longueur=10;
        this.hauteur=10;
    }
    
    public World( LinkedList<Personnage> p, LinkedList<Monstre> m,LinkedList<Objet> o,Joueur j) throws NoSuchAlgorithmException {
        
        this.rand= SecureRandom.getInstanceStrong();
        this.personnages = p;
        this.monstres = m;
        this.objets = o;
        this.J=j;
    }

    /**
    * Méthode permettant de s'assurer qu'une position est disponible
    * @param pAlea une position Point2D à comparer avec les positions des autres protagonistes déjà présents dans le monde
    * @return true si la position est libre, false sinon
    */
    public boolean isPositionFree(Point2D pAlea) {
        
        for(Personnage p : this.personnages){
            if(pAlea.equals(p.pos))
            {
                return false;
            }
        }
        for(Monstre m : this.monstres){
            if(pAlea.equals(m.pos))
            {
                return false;
            }
        }
        
        for(Objet o : this.objets){
            if(pAlea.equals(o.pos))
            {
                return false;
            }
        }
        if(pAlea.equals(this.J.getPerso().pos))
        {
            return false;
        }
        
        return true;
    }
   
    /**
    * Méthode permettant de s'assurer que la position est à au moins 3 unités de tous les autres protagonistes
    * @param pAlea une position Point2D à comparer avec les positions des autres protagonistes déjà présents dans le monde
    *@return true si la position se trouve à au moins 3 unités de tous les autres protagonistes, false sinon
    */
    public boolean isPosition3away(Point2D pAlea) 
    {
        
        for(Personnage p : this.personnages)
        {
            if(pAlea.distance(p.pos) <=3)
            {
                return false;
            }
        }
        for(Monstre m : this.monstres){
            if(pAlea.distance(m.pos) <=3)
            {
                return false;
            }
        }
        
        for(Objet o : this.objets){
            if(pAlea.distance(o.pos) <=3)
            {
                return false;
            }
        }
        
        return true;
    }


    /**
    * Création du monde ; On place aléatoirement les personnages du monde
    */
    
    
    public void creeMondeAlea() {
   
        //Random gAlea = new Random();
        
        //on place aléatoirement les personnages dans des cases disponibles
        
       
        for(Personnage p : this.personnages){
            
            

            Point2D pAlea = new Point2D(this.rand.nextInt(longueur), this.rand.nextInt(hauteur));
            
            while (!(this.isPositionFree(pAlea))) { //on compare avec le protagoniste déjà placé
                pAlea.setX(this.rand.nextInt(longueur)); //si ça ne convient pas, on génère un autre point
                pAlea.setY(this.rand.nextInt(hauteur));
            }
            p.pos.setPosition(pAlea.getX(), pAlea.getY());
            

        }
        
        //on place aléatoirement les monstres dans des cases disponibles
        for(Monstre m: this.monstres){

            Point2D pAlea = new Point2D(this.rand.nextInt(longueur), this.rand.nextInt(hauteur));
            
            while (!(this.isPositionFree(pAlea))) { //on compare avec le protagoniste déjà placé
                pAlea.setX(this.rand.nextInt(longueur)); //si ça ne convient pas, on génère un autre point
                pAlea.setY(this.rand.nextInt(hauteur));
            }
            m.pos.setPosition(pAlea.getX(), pAlea.getY());
            
        } 
        
        //on place aléatoirement les Objets dans des cases disponibles
        for(Objet o: this.objets){

            Point2D pAlea = new Point2D(this.rand.nextInt(longueur), this.rand.nextInt(hauteur));
            
            while (!(this.isPositionFree(pAlea))) { //on compare avec le protagoniste déjà placé
                pAlea.setX(this.rand.nextInt(longueur)); //si ça ne convient pas, on génère un autre point
                pAlea.setY(this.rand.nextInt(hauteur));
            }
            o.pos.setPosition(pAlea.getX(), pAlea.getY());
            
        }  
        
    }
    /**
     * Tour de Jeu
     * Methode permettant de réaliser une action(déplacer,combattre ou sauvegarder)
     */

  
    public void tourDeJeu()
    {
        boolean in=true;
        while(in)
        {
            System.out.println("\nNouveau Tour de jeu");
            
            System.out.println("Voulez vous :");
            System.out.println("1.Combattre ");
            System.out.println("2.Deplacer");
            System.out.println("3.Sauvegarder la partie");
            System.out.println("4.Retourner au MENU PRINCIPAL");
            
            Scanner sc=new Scanner(System.in);
            int action=sc.nextInt();
            switch(action)
            {
                case 1:
                    LinkedList <Creature> creatureProche=new LinkedList<>();
                    for(Personnage p:this.personnages)
                    {
                        if(p.pos.distance(this.J.getPerso().pos)<2)
                        {
                            creatureProche.add(p);
                        }
                    }
                    for(Monstre m:this.monstres)
                    {
                        if(m.pos.distance(this.J.getPerso().pos)<2)
                        {
                            creatureProche.add(m);
                        }
                    }
                    String classPersoP=this.J.getPerso().getClass().getSimpleName();
                    classPersoP=classPersoP.toLowerCase();
                    System.out.println(classPersoP);
                    if(classPersoP.equals("paysan"))
                    {
                        System.out.println("Un Paysan ne peut pas combattre !!!");
                        
                    }
                    else
                    {
                        if(creatureProche.size()!=0)
                        {
                            this.affichageJeu();
                            String classPerso=this.J.getPerso().getClass().getSimpleName();
                            classPerso=classPerso.toLowerCase();

                            System.out.println("Choisir votre adversaire");
                            for(int i=0;i<creatureProche.size();i++)
                            {
                                System.out.println(i+"."+creatureProche.get(i).getClass().getSimpleName()+"[ "+creatureProche.get(i).getPos().getX()+","+creatureProche.get(i).getPos().getY()+" ]");
                            }
                            Scanner sc2=new Scanner(System.in);
                            int a=sc2.nextInt();

                            switch(classPerso)
                            {
                                case"guerrier" -> ((Guerrier)this.J.getPerso()).combattre(creatureProche.get(a));

                                case"archer" -> ((Archer)this.J.getPerso()).combattre(creatureProche.get(a));
                                case"mage" -> ((Mage)this.J.getPerso()).combattre(creatureProche.get(a));
                                default -> System.out.println("Seuls les Guerriers,Archers et Mages peuvent Combattre");
                            }

                        }
                        else
                        {
                            System.out.println("Aucun adversaire proche");
                            this.affichageJeu();
                        }
                        
                    }
                    
                    break;
                case 2:
                    this.affichageJeu();
                    this.J.getPerso().deplacer(this);
                    this.affichageJeu();
                    break;
                    
                    
                case 3:
                    System.out.println("1.Sauvegarde Automatique");
                    System.out.println("2. Sauvegarde Manuelle");
                    Scanner sc3=new Scanner(System.in);
                    int action3=sc3.nextInt();
                    switch(action3)
                    {
                        case 1:
                            SauvegardePartie sva=new SauvegardePartie();
                            sva.sauvegarderPartie(this);
                            System.out.println("Sauvegarde Automatique Reussie dans " +sva.getFilename());
                            
                            break;
                        case 2:
                            System.out.println("Saisir le nom du fichier de sauvegarde");
                            Scanner sc4=new Scanner(System.in);
                            String nomFichier=sc4.next();
                            nomFichier+=".txt";
                                    
                            SauvegardePartie svm=new SauvegardePartie(nomFichier);
                            svm.sauvegarderPartie(this);
                            System.out.println("Sauvegarde Manuelle Reussie dans"+nomFichier);
                            break;
                        default:
                            System.out.println("Sauvegarde Echouée");
                            break;
                    
                    }
                    break;
                case 4:
                     in=false;
                    break;
               
                    
                default:
                    break;
            }
            
        }
        
        
    }
    /**
     * Methode de creation d'un joueur
     */
    public void creationJoueur() throws NoSuchAlgorithmException
    {
        this.J.choisirPersonnage(this);
        
    }
    
    public void afficheWorld() 
    {
        System.out.println("taille du monde: "+this.longueur+" X "+this.hauteur);
        System.out.println("Nombre de Personnages : "+this.personnages.size()+", Nombre de Monstres : "+this.monstres.size()+", Nombre d'Objets : "+this.objets.size());
        this.J.afficheJoueur();
    }
    /**
     * Méthode pour afficher l'etat du Jeu
     */
           
 
   public void affichageJeu()
   {
       
        System.out.println("Legende");
        System.out.println("JR---> Joueur\t A---->Archer");
        System.out.println("G----> Guerrier\t M---->Mage");
        System.out.println("I----> Lapin \t Mn--->Mana" );
        System.out.println("L----> Loup \t P--->Paysan" );
        System.out.println("S----> Soin \t Nx--->NuageToxique" );
        System.out.println("Le chifffre correspond au pt de Vie");
        System.out.println("");
        int x,y;
        String[][] matrice = new String[this.longueur][this.hauteur];
        for(int i=0;i<longueur;i++)
        {
         for(int j=0;j<hauteur;j++)
         {
            matrice[i][j]=".";
         }
        
        }
        
        
        x=this.J.getPerso().getPos().getX();
        y=this.J.getPerso().getPos().getY();
        int pvJ=this.J.getPerso().getPtVie();
        matrice[x][y]="JR"+pvJ;
   
        for(int i=0;i<personnages.size();i++)
        {
           
           x = personnages.get(i).getPos().getX(); 
           y = personnages.get(i).getPos().getY();
           int pv=personnages.get(i).getPtVie();

           /*
           Archer -> A
           Guerrier -> G
           Mage -> M
           Paysan -> P
           */
           if (personnages.get(i) instanceof Archer)
               matrice[x][y] = "A";
           else if (personnages.get(i) instanceof Guerrier)
               matrice[x][y] = "G";
           else if (personnages.get(i) instanceof Mage)
               matrice[x][y] = "M";
           else if (personnages.get(i) instanceof Paysan)
               matrice[x][y] = "P";
           else
               matrice[x][y] = "0";

        }
     
        for(int i=0;i<monstres.size();i++)
        {
            x = monstres.get(i).getPos().getX();
            y = monstres.get(i).getPos().getY();
           /*
           Loup -> L
           Lapin -> I
           */
           if (monstres.get(i) instanceof Loup)
               matrice[x][y]="L";
           else if (monstres.get(i) instanceof Lapin)
               matrice[x][y]="I";
           else
               matrice[x][y] = "0";
        }
        for(int i=0;i<objets.size();i++)
        {
            x = objets.get(i).getPos().getX();
            y = objets.get(i).getPos().getY();
           /*
           Mana -> Mn
           Soin -> S
           */
           if (objets.get(i) instanceof Mana)
               matrice[x][y]="Mn";
           else if (objets.get(i) instanceof Soin)
               matrice[x][y]="S";
           else if (objets.get(i) instanceof NuageToxique)
               matrice[x][y]="Nx";
           else
               matrice[x][y] = "0";
        }
     
        for(int i=0;i<longueur;i++)
        {
         for(int j=0;j<hauteur;j++)
         {
             System.out.print(matrice[i][j] + "  \t");
         }
         System.out.println();
        }
    }
   
}
   

    

