/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionFichiers;

import gestioncompetences.Competence;
import gestioncompetences.Personne;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Cette classe permet de lire des fichiers .CSV
 *
 * @author phili
 */
public class lecteur {

    public static ArrayList<Personne> liste_personnel = new ArrayList<>();
    public static ArrayList<Competence> liste_competences = new ArrayList<>();

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
                Date date = new Date(infosUnePersonne[2]);
                Personne unePersonne = new Personne(infosUnePersonne[1], infosUnePersonne[0], date, Integer.parseInt(infosUnePersonne[3]));
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
                competencesPersonne.put(i, competences);
            }
            i++;
        }
        return competencesPersonne;
    }
}
