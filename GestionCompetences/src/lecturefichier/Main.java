/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturefichier;

import gestioncompetences.Competence;
import gestioncompetences.Personne;
import java.util.ArrayList;

/**
 *
 * @author phili
 */
public class Main {

    public static void main(String[] args) {
        String chemin = "C:\\Users\\phili\\Documents\\GitHub\\projet-gestionCompetences\\fichiers_projet\\liste_personnel.csv";
        String chemin2 = "C:\\Users\\phili\\Documents\\GitHub\\projet-gestionCompetences\\fichiers_projet\\liste_competences.csv";
        ArrayList<Personne> liste_personnel = lecteur.lireFichierPersonnes(chemin);
        ArrayList<Competence> liste_competences = lecteur.lireFichierCompetences(chemin2);
        /*for (Personne unePers : liste_personnel) {
            System.out.println(unePers.getNom());
        }*/
        for(Competence uneComp : liste_competences)
        {
            System.out.println(uneComp.getNomFR());
        }
    }
}
