/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncompetences;

import gestionFichiers.Lecteur;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phili
 */
public class Personne {

    String nom;
    String prenom;
    Date dateEntree;
    int id;
    ArrayList<Competence> Competences = new ArrayList<>();

    /**
     *
     * @param nom
     * @param prenom
     * @param dateEntree
     * @param id
     */
    public Personne(String nom, String prenom, Date dateEntree, int id) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateEntree = dateEntree;
        this.id = id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @return the dateEntree
     */
    public Date getDateEntree() {
        return dateEntree;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the Competences
     */
    public ArrayList<Competence> getCompetences() {
        return Competences;
    }

    /**
     * @param competence the competence to add
     */
    public void addCompetence(Competence competence) {
        this.getCompetences().add(competence);
    }

    /**
     * @param competences
     */
    public void addCompetence(HashMap<Integer, ArrayList<String>> competences) {

        ArrayList<String> idCompetencesPerso = competences.get(this.getId());
        idCompetencesPerso.forEach((competenceperso) -> {
            Competence competence;
            try {
                competence = Competence.getCompetenceById(competenceperso);
                if (!Competences.contains(competence)) {
                    this.getCompetences().add(competence);
                }
            } catch (IOException ex) {
                Logger.getLogger(Personne.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    /**
     * @param competence the competence to remove
     */
    public void removeCompetence(Competence competence) {
        this.getCompetences().remove(competence);
    }

    @Override
    public String toString() {
        return getId() + " - " + getPrenom() + " " + getNom();
    }

    public static Personne getPersonneById(int id) throws IOException {
        ArrayList<Personne> personnes = Lecteur.lireFichierPersonnes("C:\\\\Users\\\\entrax\\\\Documents\\\\GitHub\\\\projet-gestionCompetences\\\\fichiers_projet\\\\liste_personnel.csv");
        for (Personne personne : personnes) {
            if (personne.getId() ==  id) {
                return personne;
            }
        }
        return null;

    }
}
