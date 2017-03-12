/**
 * Permet d'écrire les fichiers CSV
 */
package gestionFichiers;

import gestioncompetences.Competence;
import gestioncompetences.Personne;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Cette classe permet d'écrire dans des fichiers .CSV
 *
 * @author phili
 */
public class writer {

    /**
     *
     * @param chemin Correspond au chemin où se trouve le fichier à écrire. Il
     * est créé si inexistant. Si existant, il est écrasé.
     * @param personnes Correspond à l'ArrayList de personnes à écrire.
     * @throws IOException Si le chemin indiqué n'est pas atteignable, déclenche
     * une exception.
     */
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

    /**
     *
     * @param chemin Correspond au chemin où se trouve le fichier à écrire. Il
     * est créé si inexistant. Si existant, il est écrasé.
     * @param competences Correspond à l'ArrayList de compétences à écrire.
     * @throws IOException Si le chemin indiqué n'est pas atteignable, déclenche
     * une exception.
     */
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
