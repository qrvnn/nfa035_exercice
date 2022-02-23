package fr.cnam.papplication;

import java.util.ArrayList;

public class ListeVilles {
    /***** Attributs *****/
    private ArrayList<Ville> listeVille;

    /***** Constructeurs *****/
    public ListeVilles() {
        this.listeVille = new ArrayList<Ville>();
    }

    /***** Methodes *****/
    // Ajoute à listeVille un objet Ville paramétré selon la chaîne passée en
    // argument.
    public void ajouterVille(String chaine) {
        Ville ville = creerVille(chaine);
        listeVille.add(ville);
    }

    // Créer et renvoie un objet Ville paramétré selon la chaîne passée en argument.
    private Ville creerVille(String chaine) {
        String nom = chaine.split("\\*")[0];
        int departement = Integer.parseInt(chaine.split("\\*")[1]);

        return new Ville(nom, departement);
    }

    // Compte et renvoie le nombre d'objets Ville dont l'attribut département est
    // égal à l'entier passé en argument.
    private int compterVilles(int departement) {
        int nb = 0;
        for (int i = 0; i < listeVille.size(); i++) {
            if (listeVille.get(i).getDepartement() == departement)
                nb++;
        }
        return nb;
    }

    // Affiche les objets Ville dont l'attribut département est égal à l'entier
    // passé en argument.
    public void afficher(int departement) {
        System.out.println(
                "\nLe " + departement + " contient " + compterVilles(departement) + " ville(s) enregistree(s): ");
        for (int i = 0; i < listeVille.size(); i++) {
            if (listeVille.get(i).getDepartement() == departement)
                System.out.println("-" + listeVille.get(i).toString());
        }
    }

    // Affiche tous les objets Ville contenus dans listeVille.
    public void afficher() {
        for (int i = 0; i < listeVille.size(); i++)
            System.out.println(listeVille.get(i).toString());
    }
}
