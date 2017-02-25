/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturefichier;

import gestioncompetences.Personne;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phili
 */
public class Main {

    public static void main(String[] args) {
        String chemin = "C:\\Users\\phili\\Documents\\GitHub\\projet-gestionCompetences\\fichiers_projet\\liste_personnel.csv";
        String chemin2 = "C:\\Users\\phili\\Documents\\GitHub\\projet-gestionCompetences\\fichiers_projet\\liste_competences.csv";
        ArrayList<Personne> liste_personnel = lecteur.lireFichierPersonnes(chemin);
        for (Personne unePers : liste_personnel) {
            System.out.println(unePers.getNom());
        }
    }
}
