/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncompetences;

import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author phili
 */
class MissionPreparation extends Mission {

    int nbRequis;
    HashMap<Competence, Integer> personelRequis = new HashMap<>();

    /**
     * @param dateDebut the dateDebut to set
     * @param duree the duree to set
     */
    public MissionPreparation(Date dateDebut, int duree, int nbRequis) {
        super(dateDebut, duree);
        this.nbRequis = nbRequis;
        this.etat = "Preparation";
    }

    /**
     * @return the nbRequis
     */
    public int getNbRequis() {
        return nbRequis;
    }

    /**
     * @param nbRequis the nbRequis to set
     */
    public void setNbRequis(int nbRequis) {
        this.nbRequis = nbRequis;
    }

    /**
     * @return the personelRequis
     */
    public HashMap<Competence, Integer> getPersonelRequis() {
        return personelRequis;
    }

    /**
     * @param competence the competence to add
     * @param nbPersonne the nbPersonne to set
     */
    public void addCompetence(Competence competence, int nbPersonne) {
        this.personelRequis.put(competence, nbPersonne);
    }

    /**
     * @param competence the competence to remove
     */
    public void removeCompetence(Competence competence) {
        this.personelRequis.remove(competence);
    }

}
