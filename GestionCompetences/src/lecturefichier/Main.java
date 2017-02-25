/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturefichier;

import gestioncompetences.Competence;
import gestioncompetences.Personne;
import java.io.FileNotFoundException;
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
        //lecture de CSV
        String chemin = "C:\\Users\\phili\\Documents\\GitHub\\projet-gestionCompetences\\fichiers_projet\\liste_personnel.csv";
        String chemin2 = "C:\\Users\\phili\\Documents\\GitHub\\projet-gestionCompetences\\fichiers_projet\\liste_competences.csv";
        ArrayList<Personne> liste_personnel = new ArrayList<>();
        ArrayList<Competence> liste_competences = new ArrayList<>();
        try {
            liste_personnel = lecteur.lireFichierPersonnes(chemin);
            liste_competences = lecteur.lireFichierCompetences(chemin2);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ecriture dans un CSV
        try {
            writer.sauvegarderPersonnel("C:\\Users\\phili\\Documents\\GitHub\\projet-gestionCompetences\\fichiers_projet\\testPers.csv", liste_personnel);
            writer.sauvegarderCompetences("C:\\Users\\phili\\Documents\\GitHub\\projet-gestionCompetences\\fichiers_projet\\testComp.csv", liste_competences);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
