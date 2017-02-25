/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturefichier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phili
 */
public class Main {
    public static void main(String[] args)
    {
        String chemin = "C:\\Users\\phili\\Documents\\GitHub\\projet-gestionCompetences\\fichiers_projet\\liste_personnel.csv";
        String chemin2 = "C:\\Users\\phili\\Documents\\GitHub\\projet-gestionCompetences\\fichiers_projet\\liste_competences.csv";
        try {
            ArrayList<String> liste_personnel = lecteur.lireFichier(chemin);
            ArrayList<String> liste_competences = lecteur.lireFichier(chemin2);
            for(String str : liste_personnel)
            {
                System.out.println(str);
            }
            for(String str : liste_competences)
            {
                System.out.println(str);
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
