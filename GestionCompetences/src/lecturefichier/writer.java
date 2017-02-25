/**
 * Permet d'écrire les fichiers CSV
 */
package lecturefichier;

import gestioncompetences.Competence;
import gestioncompetences.Personne;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author phili
 */
public class writer {

    public static void sauvegarderPersonnel(String chemin, ArrayList<Personne> personnes) throws IOException {
        String totalite = "";
        for (Personne p : personnes) {
            totalite += p.getPrenom() + ";" + p.getNom() + ";" + p.getDateEntree() + ";" + p.getId() + "\n";
        }
        System.out.println(totalite);

        File fichier = new File(chemin);
        BufferedWriter buffer_ecriture = new BufferedWriter(new FileWriter(fichier));
        buffer_ecriture.write(totalite);
        buffer_ecriture.close();
    }

    public static void sauvegarderCompetences(String chemin, ArrayList<Competence> competences) throws IOException {
        String totalite = "";
        for (Competence c : competences) {
            totalite += c.getIdCompetence() + ";" + c.getNomEN() + ";" + c.getNomFR() + "\n";
        }
        System.out.println(totalite);

        File fichier = new File(chemin);
        BufferedWriter buffer_ecriture = new BufferedWriter(new FileWriter(fichier));
        buffer_ecriture.write(totalite);
        buffer_ecriture.close();
    }
}
