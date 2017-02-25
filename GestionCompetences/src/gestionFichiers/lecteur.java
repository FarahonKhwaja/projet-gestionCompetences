/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionFichiers;

import gestioncompetences.Competence;
import gestioncompetences.Personne;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
    public static ArrayList<Personne> lireFichierPersonnes(String chemin) throws IOException {
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
        return personnes;
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
    public static ArrayList<Competence> lireFichierCompetences(String chemin) throws IOException {
        String chaine;
        int i = 0;
        ArrayList<Competence> competences = new ArrayList<>();
        BufferedReader fichier = new BufferedReader(new FileReader(chemin));
        while (((chaine = fichier.readLine()) != null)) {
            if (i > 0) {
                String[] infosUneCompetence = chaine.split(";");
                Competence uneCompetence = new Competence(infosUneCompetence[0], infosUneCompetence[1], infosUneCompetence[2]);
                competences.add(uneCompetence);
            }
            i++;
        }
        return competences;
    }

    public static void lireFichierCompetencesParPersonne(String chemin) throws IOException {
        HashMap<Integer, ArrayList<Competence>> competencesPersonne;
        String chaine;
        int i = 0;
        BufferedReader fichier = new BufferedReader(new FileReader(chemin));
        while (((chaine = fichier.readLine()) != null)) {
            if (i > 0) {
                String[] infos = chaine.split(";");
                
            }
        }
    }
}
