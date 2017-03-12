/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionFichiers;

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

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //lecture de CSV
        /*ArrayList<Personne> liste_personnel = new ArrayList<>();
        ArrayList<Competence> liste_competences = new ArrayList<>();*/
        HashMap<Integer, ArrayList<String>> hashmap = new HashMap<>();
        try {
            /*liste_personnel = Lecteur.lireFichierPersonnes(chemin);
            liste_competences = Lecteur.lireFichierCompetences(chemin2);*/
            hashmap = lecteur.lireFichierCompetencesParPersonne(gestionFichiers.lecteur.cheminCompetences);
            //System.out.println(hashmap.toString());
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
