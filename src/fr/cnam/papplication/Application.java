package fr.cnam.papplication;

import java.io.*;

import fr.cnam.tools.Lire;

public class Application {

    // Formate les données et les renvoie en chaine concaténée au format
    // "VILLE*DEPARTEMENT".
    private static String formaterChaine(String ville, int departement) {
        return ville.toUpperCase() + "*" + departement;
    }

    public static void main(String[] args) throws IOException {
        String nomFichier = "listeVilles.txt", ligne, ville;
        char choix = 'O';
        int departement;
        ListeVilles listeVilles = new ListeVilles();
        File f = new File(nomFichier);
        FileWriter FW = new FileWriter(f);
        BufferedWriter FB = new BufferedWriter(FW);

        // Saisie de la liste des villes à enregistrer.
        System.out.println("*** Enregistrement de la liste des villes a visiter ***");
        while (choix == 'O') {
            System.out.print("\nEntrez un nom de ville: ");
            ville = Lire.S();
            System.out.print("Dans quel departement est situee " + ville + " ? ");
            departement = Lire.i();

            ligne = formaterChaine(ville, departement);
            FB.write(ligne, 0, ligne.length());
            FB.newLine();

            System.out.print("\nVoulez-vous enregistrer une nouvelle ville ? (O/N) ");
            choix = Lire.c();
        }
        FB.close();

        // Lecture et chargement en mémoire de l'integralité du contenu du fichier.
        FileReader FR = new FileReader(f);
        BufferedReader BR = new BufferedReader(FR);
        System.out.println("\n*** Lecture de la liste des villes ***");
        do {
            ligne = BR.readLine();
            if (ligne != null) {
                listeVilles.ajouterVille(ligne);
            }
        } while (ligne != null);
        BR.close();

        // Affichage des villes triées selon le département.
        System.out.print("De quel departement voulez-vous afficher les villes ? ");
        departement = Lire.i();
        listeVilles.afficher(departement);
    }

}
