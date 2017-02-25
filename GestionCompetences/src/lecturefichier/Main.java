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
        String chemin = "C:\\Users\\phili\\Documents\\projetaoc\\fichiers_projet\\liste_personnel.csv";
        try {
            ArrayList<String> liste_personnel = lecteur.lireFichier(chemin);
            System.out.println(liste_personnel.toString());
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
