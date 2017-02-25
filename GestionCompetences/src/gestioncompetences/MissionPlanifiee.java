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
class MissionPlanifiee extends MissionPreparation {

    protected HashMap<Competence, Personne> personelAffecte;

    public MissionPlanifiee(Date dateDebut, int duree, int nbRequis, HashMap<Competence, Personne> personelAffecte) {
        super(dateDebut, duree, nbRequis);
        this.personelAffecte = personelAffecte;
    }

    /**
     * @return the personelAffecte
     */
    public HashMap<Competence, Personne> getPersonelAffecte() {
        return personelAffecte;
    }

    /**
     * @param personelAffecte the personelAffecte to set
     */
    public void setPersonelAffecte(HashMap<Competence, Personne> personelAffecte) {
        this.personelAffecte = personelAffecte;
    }

    /**
     * @param competence the competence to add
     * @param nbPersonne the nbPersonne to set
     */
    public void addCompetence(Competence competence, Personne personne) {
        this.personelAffecte.put(competence, personne);
    }

    /**
     * @param competence the competence to remove
     */
    public void removeCompetence(Competence competence) {
        this.personelAffecte.remove(competence);
    }

}
