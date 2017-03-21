/**
 * Permet d'écrire les fichiers CSV
 */
package gestionFichiers;

import gestioncompetences.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Cette classe permet d'écrire dans des fichiers .CSV
 *
 * @author phili
 */
public class writer {

    /**
     *
     * @param personnes Correspond à l'ArrayList de personnes à écrire.
     * @throws IOException Si le chemin indiqué n'est pas atteignable, déclenche
     * une exception.
     */
    public static void sauvegarderPersonnel(ArrayList<Personne> personnes) throws IOException {
        String totalite = "Prenom;Nom;date entrée entreprise;identifiant\n";
        for (Personne p : personnes) {
            totalite += p.getPrenom() + ";" + p.getNom() + ";" + p.getDateEntree() + ";" + p.getId() + "\n";
        }

        File fichier = new File(gestionFichiers.lecteur.cheminPersonnel);
        BufferedWriter buffer_ecriture = new BufferedWriter(new FileWriter(fichier));
        buffer_ecriture.write(totalite);
        buffer_ecriture.close();
    }

    /**
     *
     * @param competences Correspond à l'ArrayList de compétences à écrire.
     * @throws IOException Si le chemin indiqué n'est pas atteignable, déclenche
     * une exception.
     */
    public static void sauvegarderCompetences(ArrayList<Competence> competences) throws IOException {
        String totalite = "";
        for (Competence c : competences) {
            totalite += c.getIdCompetence() + ";" + c.getNomEN() + ";" + c.getNomFR() + "\n";
        }

        File fichier = new File(gestionFichiers.lecteur.cheminCompetences);
        BufferedWriter buffer_ecriture = new BufferedWriter(new FileWriter(fichier));
        buffer_ecriture.write(totalite);
        buffer_ecriture.close();
    }

    /**
     *
     * @param competencesPersonnel correspond à une Hashmap contenant, pour
     * chaque identifiant de personnel, les compétences qu'il possède.
     * @throws IOException
     */
    public static void sauvegarderCompetencesPersonnel(HashMap<Integer, ArrayList<String>> competencesPersonnel) throws IOException {
        String totalite = "Employe;Liste Competences\n";
        for (Integer key : competencesPersonnel.keySet()) {
            totalite += key.toString() + ";";
            for (String cp : competencesPersonnel.get(key)) {
                totalite += cp + ";";
            }
            totalite += "\n";
        }

        File fichier = new File(gestionFichiers.lecteur.cheminCompetencesPersonnel);
        BufferedWriter buffer_ecriture = new BufferedWriter(new FileWriter(fichier));
        buffer_ecriture.write(totalite);
        buffer_ecriture.close();
    }

    /**
     *
     * @param missions correspond à une liste de @link{Mission}
     * @throws IOException
     */
    public static void sauvegarderMissions(ArrayList<Mission> missions) throws IOException {
        String totalite = "";
        for (Mission m : missions) {
            totalite += m.getLibelle() + ";" + m.getDateDebut() + ";" + m.getDuree() + ";" + m.getEtat() + "\n";
        }
        File fichier = new File(gestionFichiers.lecteur.cheminMissions);
        BufferedWriter buffer_ecriture = new BufferedWriter(new FileWriter(fichier));
        buffer_ecriture.write(totalite);
        buffer_ecriture.close();
    }

    /**
     *
     * @param competencesMissionsPreparation correspond à une Hashmap contenant,
     * pour chaque identifiant de mission, les compétences nécessaires.
     * @throws IOException
     */
    public static void sauvegarderCompetencesMissionPreparation(HashMap<String, HashMap<String, Integer>> competencesMissionsPreparation) throws IOException {
        String totalite = "";
        for (String MissionPreparation : competencesMissionsPreparation.keySet()) {
            for (String idCompetence : competencesMissionsPreparation.get(MissionPreparation).keySet()) {
                totalite += MissionPreparation + ";" + idCompetence + ";" + competencesMissionsPreparation.get(MissionPreparation).get(idCompetence) + "\n";
            }
        }

        File fichier = new File(gestionFichiers.lecteur.cheminCompetencesMission);
        BufferedWriter buffer_ecriture = new BufferedWriter(new FileWriter(fichier));
        buffer_ecriture.write(totalite);
        buffer_ecriture.close();
    }

    public static void sauvegarderAffectationsParMission(HashMap<String, HashMap<String, ArrayList<Integer>>> affectationsParMission) throws IOException {
        String totalite = "";
        for (String Missions : affectationsParMission.keySet()) {
            for (String idCompetence : affectationsParMission.get(Missions).keySet()) {
                totalite += Missions + ";" + idCompetence + ";";
                for (Integer idPersonne : affectationsParMission.get(Missions).get(idCompetence)) {
                    totalite += idPersonne + ";";
                }
                totalite += "\n";
            }
        }

        File fichier = new File(gestionFichiers.lecteur.cheminAffectationsMission);
        BufferedWriter buffer_ecriture = new BufferedWriter(new FileWriter(fichier));
        buffer_ecriture.write(totalite);
        buffer_ecriture.close();
    }
}
