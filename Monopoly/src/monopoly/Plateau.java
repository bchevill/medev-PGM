package monopoly;

import java.util.*;


public class Plateau {
    
    private ArrayList<Case> listeCases;
    private LinkedList<Joueur> listeJoueurs;
    private Boolean partieTerminee;
  
    // CONSTRUCTEURS
    public Plateau () {
        this.listeCases=new ArrayList<Case>(40);
        this.listeJoueurs= new LinkedList<Joueur>();
        partieTerminee=false;
    }
    public Plateau (ArrayList<Case> l1, LinkedList<Joueur> l2) {
        this.listeCases=l1;
        this.listeJoueurs=l2;
        partieTerminee=false;
    }

    //GETTERS & SETTERS
    public ArrayList<Case> getListeCases() {
        return listeCases;
    }
    public void setListeCases(ArrayList<Case> listeCases) {
        this.listeCases = listeCases;
    }
    public LinkedList<Joueur> getListeJoueurs() {
        return listeJoueurs;
    }
    public void setListeJoueurs(LinkedList<Joueur> listeJoueurs) {
        this.listeJoueurs = listeJoueurs;
    }  
    
    //
    public int nbGares(Joueur j) {
        int nbGares=0;
        for (Case c : listeCases) {
            if ((c instanceof Gare) &&(c.getProprietaire()==j)) {
                nbGares++;
            }
        }
        return nbGares;
    }
    
    public void affiche() {
        for (Case c : listeCases) {
            System.out.println(c.toString()+"\n");
        }
        
        //TODO afficher les joueurs
        for (Joueur j : listeJoueurs) {
            System.out.println(j.toString()+"\n");
        }
    }
    
    public Case avance(Case c, int d) {
        return listeCases.get(c.getPosition()+d);
    }
    
    public Boolean finDePartie(){
        partieTerminee=true;
        return (partieTerminee);
    }
}
