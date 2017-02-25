/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionFichiers;

import gestioncompetences.Competence;
import gestioncompetences.Personne;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phili
 */
public class Main {

    public static void main(String[] args) {
        //lecture de CSV
        /*String chemin = "C:\\Users\\phili\\Documents\\GitHub\\projet-gestionCompetences\\fichiers_projet\\liste_personnel.csv";
        String chemin2 = "C:\\Users\\phili\\Documents\\GitHub\\projet-gestionCompetences\\fichiers_projet\\liste_competences.csv";*/
        String chemin3 = "C:\\Users\\phili\\Documents\\GitHub\\projet-gestionCompetences\\fichiers_projet\\competences_personnel.csv";
        /*ArrayList<Personne> liste_personnel = new ArrayList<>();
        ArrayList<Competence> liste_competences = new ArrayList<>();*/
        HashMap<Integer, ArrayList<String>> hashmap;
        try {
            /*liste_personnel = Lecteur.lireFichierPersonnes(chemin);
            liste_competences = Lecteur.lireFichierCompetences(chemin2);*/
            hashmap = Lecteur.lireFichierCompetencesParPersonne(chemin3);
            //System.out.println(hashmap.toString());
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ecriture dans un CSV
        /*try {
            Writer.sauvegarderPersonnel("C:\\Users\\phili\\Documents\\GitHub\\projet-gestionCompetences\\fichiers_projet\\testPers.csv", liste_personnel);
            Writer.sauvegarderCompetences("C:\\Users\\phili\\Documents\\GitHub\\projet-gestionCompetences\\fichiers_projet\\testComp.csv", liste_competences);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
}
