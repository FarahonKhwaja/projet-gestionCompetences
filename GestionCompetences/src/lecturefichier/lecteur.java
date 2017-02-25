/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturefichier;

import gestioncompetences.Competence;
import gestioncompetences.Personne;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author phili
 */
public class lecteur {

    public static ArrayList<Personne> lireFichierPersonnes(String chemin) {
        String chaine;
        int i = 0;
        ArrayList<Personne> personnes = new ArrayList<>();
        try (BufferedReader fichier = new BufferedReader(new FileReader(chemin))) {
            while (((chaine = fichier.readLine()) != null)) {
                if (i > 0) {
                    String[] infosUnePersonne = chaine.split(";");
                    Date date = new Date(infosUnePersonne[2]);
                    Personne unePersonne = new Personne(infosUnePersonne[1], infosUnePersonne[0], date, Integer.parseInt(infosUnePersonne[3]));
                    personnes.add(unePersonne);
                }
                i++;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return personnes;
    }

    public static ArrayList<Competence> lireFichierCompetences(String chemin) {
        String chaine;
        int i = 0;
        ArrayList<Competence> competences = new ArrayList<>();
        try (BufferedReader fichier = new BufferedReader(new FileReader(chemin))) {
            while (((chaine = fichier.readLine()) != null)) {
                if (i > 0) {
                    String[] infosUneCompetence = chaine.split(";");
                    Competence uneCompetence = new Competence(infosUneCompetence[0], infosUneCompetence[1], infosUneCompetence[2]);
                    competences.add(uneCompetence);
                }
                i++;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return competences;
    }
}
