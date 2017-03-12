/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncompetences;

import java.util.Date;

/**
 *
 * @author phili
 */
class MissionPreparation extends MissionModifiable {

    /**
     *
     * @param dateDebut
     * @param duree
     * @param nbRequis
     */
    public MissionPreparation(Date dateDebut, int duree, int nbRequis) {
        super(nbRequis, dateDebut, duree);
        this.etat = "Preparation";
    }

    /**
     * @param competence the competence to add
     * @param nbPersonne the nbPersonne to set
     */
    public void addCompetence(Competence competence, int nbPersonne) {
        this.getPersonelRequis().put(competence, nbPersonne);
    }

    /**
     * @param competence the competence to remove
     */
    public void removeCompetence(Competence competence) {
        this.getPersonelRequis().remove(competence);
    }

    /**
     *
     * @return
     */
    public MissionPlanifiee planifier() {
        return new MissionPlanifiee(getDateDebut(), getDuree(), getNbRequis());
    }

}
