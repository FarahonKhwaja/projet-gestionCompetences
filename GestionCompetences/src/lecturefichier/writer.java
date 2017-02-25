/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturefichier;

import gestioncompetences.Personne;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 *
 * @author phili
 */
public class writer {
    public static void sauvegarderPersonnel(String chemin, ArrayList<Personne> personnes) throws FileNotFoundException, IOException
    {
        String totalite = "";
        for(Personne p : personnes)
        {
            totalite += p.getPrenom() + ";" + p.getNom() + ";" + p.getDateEntree() + ";" + p.getId() + "\n";
        }
        System.out.println(totalite);
        
        File fichier = new File(chemin);
        BufferedWriter buffer_ecriture = new BufferedWriter(new FileWriter(fichier));
        buffer_ecriture.write(totalite);
        buffer_ecriture.close();
        
    }
}
