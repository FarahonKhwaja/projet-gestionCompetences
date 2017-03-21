/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncompetences;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Entrax
 */
public abstract class MissionModifiable extends Mission {

    protected String nbRequis;
    protected HashMap<Competence, Integer> personnelRequis = new HashMap<>();

    /**
     *
     * @param libelle
     * @param dateDebut
     * @param duree
     * @param etat
     * @param nbRequis
     */
    public MissionModifiable(String libelle, String dateDebut, String duree, String etat, String nbRequis) {
        super(libelle, dateDebut, duree, etat);
        this.nbRequis = nbRequis;
    }

    public MissionModifiable(String libelle, String dateDebut, String duree, String etat) {
        super(libelle, dateDebut, duree, etat);
        this.nbRequis = "0";
    }

    /**
     * @return the nbRequis
     */
    public String getNbRequis() {
        return nbRequis;
    }

    /**
     * @return the personnelRequis
     */
    public HashMap<Competence, Integer> getPersonnelRequis() {
        return personnelRequis;
    }

    /**
     * @param competence the competence to add
     * @param nbPersonne the nbPersonne to set
     */
    public void addCompetence(Competence competence, int nbPersonne) {
        this.getPersonnelRequis().put(competence, nbPersonne);
    }

    /**
     * @param competencesMission
     */
    public void addCompetence(HashMap<String, HashMap<String, Integer>> competencesMission) {
        HashMap<String, Integer> libCompetences = competencesMission.get(this.getLibelle());
        if (libCompetences != null) {
            for (String competenceMission : libCompetences.keySet()) {
                Competence competence;
                try {
                    competence = Competence.getCompetenceById(competenceMission);
                    this.getPersonnelRequis().put(competence, libCompetences.get(competenceMission));
                } catch (IOException ex) {
                    Logger.getLogger(MissionPreparation.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
