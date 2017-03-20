/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionFichiers;

import gestioncompetences.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Cette classe permet de lire des fichiers .CSV
 *
 * @author phili
 */
public class lecteur {

    public static ArrayList<Personne> liste_personnel = new ArrayList<>();
    public static ArrayList<Competence> liste_competences = new ArrayList<>();
    public static ArrayList<Mission> liste_missions = new ArrayList<>();
    public static ArrayList<MissionPreparation> liste_missionsPreparation = new ArrayList<>();
    public static ArrayList<MissionPlanifiee> liste_missionsPlanifiee = new ArrayList<>();
    public static ArrayList<MissionEnCours> liste_missionsEnCours = new ArrayList<>();
    public static ArrayList<MissionTerminee> liste_missionsTerminee = new ArrayList<>();

    public static String yourName = "phili";
    public static String cheminPersonnel = "C:\\Users\\" + yourName + "\\Documents\\GitHub\\projet-gestionCompetences\\fichiers_projet\\liste_personnel.csv";
    public static String cheminCompetences = "C:\\Users\\" + yourName + "\\Documents\\GitHub\\projet-gestionCompetences\\fichiers_projet\\liste_competences.csv";
    public static String cheminCompetencesPersonnel = "C:\\Users\\" + yourName + "\\Documents\\GitHub\\projet-gestionCompetences\\fichiers_projet\\competences_personnel.csv";
    public static String cheminMissions = "C:\\Users\\" + yourName + "\\Documents\\GitHub\\projet-gestionCompetences\\fichiers_projet\\liste_missions.csv";
    public static String cheminCompetencesMission = "C:\\Users\\" + yourName + "\\Documents\\GitHub\\projet-gestionCompetences\\fichiers_projet\\competences_mission.csv";
    public static String cheminAffectationsMission = "C:\\Users\\" + yourName + "\\Documents\\GitHub\\projet-gestionCompetences\\fichiers_projet\\affectations_competences_mission.csv";

    public static ArrayList<Personne> getPersonnel(String chemin) throws IOException {
        return lireFichierPersonnes(chemin);
    }

    /**
     * Lit un fichier de {@link Personne}.
     *
     * @param chemin Correspond au chemin où se trouve le fichier à écrire. Il
     * est créé si inexistant. Si existant, il est écrasé.
     * @return Retourne une ArrayList de {@link Personne}, correspondant au
     * contenu du fichier lu.
     * @throws IOException Si le fichier ciblé n'existe pas, retourne une erreur
     * IOException.
     */
    private static ArrayList<Personne> lireFichierPersonnes(String chemin) throws IOException {
        String chaine;
        int i = 0;
        ArrayList<Personne> personnes = new ArrayList<>();
        BufferedReader fichier = new BufferedReader(new FileReader(chemin));
        while (((chaine = fichier.readLine()) != null)) {
            if (i > 0) {
                String[] infosUnePersonne = chaine.split(";");
                Personne unePersonne = new Personne(infosUnePersonne[1], infosUnePersonne[0], infosUnePersonne[2], Integer.parseInt(infosUnePersonne[3]));
                personnes.add(unePersonne);
            }
            i++;
        }
        liste_personnel = personnes;
        return personnes;
    }

    public static ArrayList<Competence> getCompetences(String chemin) throws IOException {
        return lireFichierCompetences(chemin);
    }

    /**
     * Lit un fichier de {@link Personne}.
     *
     * @param chemin Correspond au chemin où se trouve le fichier à écrire. Il
     * est créé si inexistant. Si existant, il est écrasé.
     * @return Retourne une ArrayList de {@link Competence}, correspondant au
     * contenu du fichier lu.
     * @throws IOException Si le fichier ciblé n'existe pas, retourne une erreur
     * IOException.
     */
    private static ArrayList<Competence> lireFichierCompetences(String chemin) throws IOException {
        String chaine;
        int i = 0;
        ArrayList<Competence> competences = new ArrayList<>();
        BufferedReader fichier = new BufferedReader(new FileReader(chemin));
        while (((chaine = fichier.readLine()) != null)) {
            String[] infosUneCompetence = chaine.split(";");
            Competence uneCompetence = new Competence(infosUneCompetence[0], infosUneCompetence[1], infosUneCompetence[2]);
            competences.add(uneCompetence);
            i++;
        }
        liste_competences = competences;
        return competences;
    }

    /**
     * Getter de @link{lireFichierCompetencesParPersonne}
     *
     * @param chemin correspond au chemin du CSV.
     * @return une Hashmap contenant, pour chaque identifiant de personne, une
     * Arraylist contenant les identifiants des compétences associées à la
     * personne.
     * @throws IOException
     */
    public static HashMap<Integer, ArrayList<String>> getCompetencesParPersonne(String chemin) throws IOException {
        return lireFichierCompetencesParPersonne(chemin);
    }

    /**
     *
     * @param chemin correspond au chemin du CSV.
     * @return une Hashmap contenant, pour chaque identifiant de personne, une
     * Arraylist contenant les identifiants des compétences associées à la
     * personne.
     * @throws IOException
     */
    public static HashMap<Integer, ArrayList<String>> lireFichierCompetencesParPersonne(String chemin) throws IOException {
        HashMap<Integer, ArrayList<String>> competencesPersonne = new HashMap<>();
        String chaine;
        int i = 0;
        BufferedReader fichier = new BufferedReader(new FileReader(chemin));
        while (((chaine = fichier.readLine()) != null)) {
            if (i > 0) {
                String[] infos = chaine.split(";");
                ArrayList<String> competences = new ArrayList<>();
                for (int j = 1; j < infos.length; j++) {
                    competences.add(infos[j]);
                }
                competencesPersonne.put(Integer.parseInt(infos[0]), competences);
            }
            i++;
        }
        return competencesPersonne;
    }

    /**
     *
     * @return l'idenfiant du dernier membre du personnel dans le CSV
     * @throws IOException
     */
    public static int getDernierIdPersonnel() throws IOException {
        ArrayList<Personne> personnel = gestionFichiers.lecteur.getPersonnel(cheminPersonnel);
        return personnel.size();
    }

    /**
     *
     * @param chemin correspond au chemin du CSV.
     * @return une ArrayList contenant toutes les missions du CSV
     * @throws IOException
     */
    public static ArrayList<Mission> getMissions(String chemin) throws IOException {
        return lireFichierMissions(chemin);
    }

    /**
     *
     * @param chemin correspond au chemin du CSV.
     * @return une ArrayList contenant toutes les missions du CSV
     * @throws IOException
     */
    private static ArrayList<Mission> lireFichierMissions(String chemin) throws IOException {
        String chaine;
        int i = 0;
        ArrayList<Mission> missions = new ArrayList<>();
        BufferedReader fichier = new BufferedReader(new FileReader(chemin));
        while (((chaine = fichier.readLine()) != null)) {
            String[] infosuneMission = chaine.split(";");
            Mission uneMission = null;
            switch(infosuneMission[3])
            {
                case "Préparation": 
                {
                    //String libelle, String dateDebut, String duree, String etat
                    uneMission = 
                            new MissionPreparation(infosuneMission[0], infosuneMission[1], infosuneMission[2], infosuneMission[3]);
                    break;
                }
                case "Planifiee":
                {
                    uneMission = new MissionPlanifiee(
                            new MissionPreparation(infosuneMission[0], infosuneMission[1], infosuneMission[2], infosuneMission[3]));
                    break;
                }
                case "En Cours":
                {
                    uneMission = new MissionEnCours(
                            new MissionPlanifiee(
                                    new MissionPreparation(infosuneMission[0], infosuneMission[1], infosuneMission[2], infosuneMission[3])));
                    break;
                }
                case "Terminée":
                {
                    uneMission = new MissionTerminee(
                            new MissionEnCours(
                                    new MissionPlanifiee(
                                            new MissionPreparation(infosuneMission[0], infosuneMission[1], infosuneMission[2], infosuneMission[3]))));
                }
            }

            missions.add(uneMission);
            i++;
        }
        liste_missions = missions;
        return missions;
    }

    /**
     *
     * @param chemin correspond au chemin du CSV.
     * @return une ArrayList contenant toutes les missions en préparation du CSV
     * @throws IOException
     */
    public static ArrayList<MissionPreparation> getMissionsPreparation(String chemin) throws IOException {
        return lireFichierMissionsPreparation(chemin);
    }

    /**
     *
     * @param chemin correspond au chemin du CSV.
     * @return une ArrayList contenant toutes les missions en préparation du CSV
     * @throws IOException
     */
    private static ArrayList<MissionPreparation> lireFichierMissionsPreparation(String chemin) throws IOException {
        String chaine;
        int i = 0;
        ArrayList<MissionPreparation> missions = new ArrayList<>();
        BufferedReader fichier = new BufferedReader(new FileReader(chemin));
        while (((chaine = fichier.readLine()) != null)) {
            String[] infosuneMission = chaine.split(";");
            MissionPreparation uneMission = new MissionPreparation(infosuneMission[0], infosuneMission[1], infosuneMission[2], infosuneMission[3]);
            missions.add(uneMission);
            i++;
        }
        liste_missionsPreparation = missions;
        return missions;
    }

    /**
     *
     * @param chemin correspond au chemin du CSV.
     * @return une ArrayList contenant toutes les missions plannifiées du CSV
     * @throws IOException
     */
    public static ArrayList<MissionPlanifiee> getMissionsPlanifiee(String chemin) throws IOException {
        return lireFichierMissionsPlanifiee(chemin);
    }

    /**
     *
     * @param chemin correspond au chemin du CSV.
     * @return une ArrayList contenant toutes les missions plannifiées du CSV
     * @throws IOException
     */
    private static ArrayList<MissionPlanifiee> lireFichierMissionsPlanifiee(String chemin) throws IOException {
        String chaine;
        int i = 0;
        ArrayList<MissionPlanifiee> missions = new ArrayList<>();
        BufferedReader fichier = new BufferedReader(new FileReader(chemin));
        while (((chaine = fichier.readLine()) != null)) {
            String[] infosuneMission = chaine.split(";");
            HashMap<Competence, Integer> personelRequis = new HashMap<>();
            MissionPlanifiee uneMission = new MissionPlanifiee(infosuneMission[0], infosuneMission[1], infosuneMission[2], infosuneMission[3], personelRequis);
            missions.add(uneMission);
            i++;
        }
        liste_missionsPlanifiee = missions;
        return missions;
    }

    /**
     *
     * @param chemin correspond au chemin du CSV.
     * @return une ArrayList contenant toutes les missions en cours du CSV
     * @throws IOException
     */
    public static ArrayList<MissionEnCours> getMissionsEnCours(String chemin) throws IOException {
        return lireFichierMissionsEnCours(chemin);
    }

    /**
     *
     * @param chemin correspond au chemin du CSV.
     * @return une ArrayList contenant toutes les missions en cours du CSV
     * @throws IOException
     */
    private static ArrayList<MissionEnCours> lireFichierMissionsEnCours(String chemin) throws IOException {
        String chaine;
        int i = 0;
        ArrayList<MissionEnCours> missions = new ArrayList<>();
        BufferedReader fichier = new BufferedReader(new FileReader(chemin));
        while (((chaine = fichier.readLine()) != null)) {
            String[] infosuneMission = chaine.split(";");
            //MissionEnCours uneMission = new MissionEnCours(infosuneMission[0], infosuneMission[1], infosuneMission[2], infosuneMission[3]);
            //missions.add(uneMission);
            i++;
        }
        liste_missionsEnCours = missions;
        return missions;
    }

    /**
     *
     * @param chemin correspond au chemin du CSV.
     * @return une ArrayList contenant toutes les missions terminées du CSV
     * @throws IOException
     */
    public static ArrayList<MissionTerminee> getMissionsTerminee(String chemin) throws IOException {
        return lireFichierMissionsTerminee(chemin);
    }
    /**
     *
     * @param chemin correspond au chemin du CSV.
     * @return une ArrayList contenant toutes les missions terminées du CSV
     * @throws IOException
     */
    private static ArrayList<MissionTerminee> lireFichierMissionsTerminee(String chemin) throws IOException {
        String chaine;
        int i = 0;
        ArrayList<MissionTerminee> missions = new ArrayList<>();
        BufferedReader fichier = new BufferedReader(new FileReader(chemin));
        while (((chaine = fichier.readLine()) != null)) {
            String[] infosuneMission = chaine.split(";");
            //MissionTerminee uneMission = new MissionTerminee(infosuneMission[0], infosuneMission[1], infosuneMission[2], infosuneMission[3]);
            //missions.add(uneMission);
            i++;
        }
        liste_missionsTerminee = missions;
        return missions;
    }
    /**
     *
     * @param chemin correspond au chemin du CSV.
     * @return une Hashmap contenant, pour chaque identifiant de mission,
     * les compétences associées nécessaires.
     * @throws IOException
     */
    public static HashMap<String, HashMap<String, Integer>> getCompetencesParMission(String chemin) throws IOException {
        return lireFichierCompetencesParMission(chemin);
    }
    /**
     *
     * @param chemin correspond au chemin du CSV.
     * @return une Hashmap contenant, pour chaque identifiant de mission,
     * les compétences associées nécessaires.
     * @throws IOException
     */
    public static HashMap<String, HashMap<String, Integer>> lireFichierCompetencesParMission(String chemin) throws IOException {
        HashMap<String, HashMap<String, Integer>> competencesMission = new HashMap<>();
        HashMap<String, Integer> competences = new HashMap<>();
        String chaine;
        int i = 0;
        BufferedReader fichier = new BufferedReader(new FileReader(chemin));
        while (((chaine = fichier.readLine()) != null)) {
            String[] infos = chaine.split(";");
            if (competencesMission.get(infos[0]) != null) {
                competences = competencesMission.get(infos[0]);
            }
            if (infos.length > 1) {
                competences.put(infos[1], Integer.parseInt(infos[2]));
            }
            competencesMission.put(infos[0], competences);
        }
        return competencesMission;
    }
    /**
     *
     * @param chemin correspond au chemin du CSV.
     * @return une Hashmap contenant, pour chaque identifiant de mission,
     * les affectations associées effectuées.
     * @throws IOException
     */
    public static HashMap<String, HashMap<String, ArrayList<Integer>>> getAffectationsParMission(String chemin) throws IOException {
        return lireFichierAffectationsParMission(chemin);
    }
    /**
     *
     * @param chemin correspond au chemin du CSV.
     * @return une Hashmap contenant, pour chaque identifiant de mission,
     * les affectations associées effectuées.
     * @throws IOException
     */
    public static HashMap<String, HashMap<String, ArrayList<Integer>>> lireFichierAffectationsParMission(String chemin) throws IOException {
        HashMap<String, HashMap<String, ArrayList<Integer>>> affectationsMission = new HashMap<>();
        HashMap<String, ArrayList<Integer>> affectations = new HashMap<>();
        String chaine;
        int i = 0;
        BufferedReader fichier = new BufferedReader(new FileReader(chemin));
        while (((chaine = fichier.readLine()) != null)) { //pour chaque compétence
            String[] infos = chaine.split(";");
            if (affectationsMission.get(infos[0]) != null) {
                affectations = affectationsMission.get(infos[0]);
            }
            ArrayList<Integer> personnes = new ArrayList<>();
            for (int j = 3; j < infos.length; j++) {
                personnes.add(Integer.parseInt(infos[j]));
            }
            affectations.put(infos[1], personnes);
            affectationsMission.put(infos[0], affectations);
        }
        return affectationsMission;
    }
    
    public static Personne getPersonneById(String id) throws FileNotFoundException, IOException
    {
        Personne p = null;
        BufferedReader reader = new BufferedReader(new FileReader(cheminPersonnel));
        String chaine;
        while((chaine = reader.readLine()) != null){
            String[] unePersonne = chaine.split(";");
            if(unePersonne[3].equals(id))
            {
                p = new Personne(unePersonne[0], unePersonne[1], unePersonne[2], Integer.parseInt(id));
            }
        }
        return p;
    }
}
