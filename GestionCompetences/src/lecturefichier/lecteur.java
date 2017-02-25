/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturefichier;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author phili
 */
public class lecteur {

    public static ArrayList<String> lireFichier(String chemin) throws FileNotFoundException, IOException {
        String chaine;
        ArrayList<String> csvComplet = new ArrayList<>();
        try (BufferedReader fichier = new BufferedReader(new FileReader(chemin))) {
            while (((chaine = fichier.readLine()) != null)) {
                csvComplet.addAll(Arrays.asList(chaine.split(";")));
            }
        }
        return csvComplet;
    }
}
