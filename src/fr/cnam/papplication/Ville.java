package fr.cnam.papplication;

public class Ville {
    /***** Attributs *****/
    private String nom;
    private int departement;

    /***** Constructeurs *****/
    public Ville(String nom, int departement) {
        this.nom = nom;
        this.departement = departement;
    }

    /***** Accesseurs *****/
    public String getNom() {
        return this.nom;
    }

    public int getDepartement() {
        return this.departement;
    }

    /***** Methodes *****/
    public String toString() {
        return this.nom + " " + this.departement;
    }
}
