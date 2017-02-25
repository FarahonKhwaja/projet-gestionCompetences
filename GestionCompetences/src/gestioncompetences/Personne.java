/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncompetences;

import gestionFichiers.lecteur;
import static gestionFichiers.lecteur.lireFichierPersonnes;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author phili
 */
public class Personne {

    String nom, prenom;
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
     * @param competence the competence to add
     */
    public void addCompetence(Competence competence) {
        this.Competences.add(competence);
    }

    /**
     * @param competences
     */
    public void addCompetence(HashMap<Integer, ArrayList<String>> competences) {

        ArrayList<String> idCompetencesPerso = competences.get(this.id);

        idCompetencesPerso.forEach((competenceperso) -> {
            Competence competence = getCompetenceByID(competenceperso);
            if (!Competences.contains(competence)) {
                this.Competences.add(competence);
            }
        });
    }

    /**
     * @param competence the competence to remove
     */
    public void removeCompetence(Competence competence) {
        this.Competences.remove(competence);
    }

    @Override
    public String toString() {
        return id + " - " + prenom + " " + nom;
    }
}
