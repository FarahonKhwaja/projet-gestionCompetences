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

    HashMap<Competence, Integer> personelAffecte;

    public MissionPlanifiee(Date dateDebut, int duree, int nbRequis, HashMap<Competence, Integer> personelAffecte) {
        super(dateDebut, duree, nbRequis);
        this.personelAffecte = personelAffecte;
    }

    public HashMap<Competence, Integer> getPersonelAffecte() {
        return personelAffecte;
    }

    public void setPersonelAffecte(HashMap<Competence, Integer> personelAffecte) {
        this.personelAffecte = personelAffecte;
    }

    public void addCompetence(Competence competence, int nbPersonne) {
        this.personelAffecte.put(competence, nbPersonne);
    }

    public void removeCompetence(Competence competence) {
        this.personelAffecte.remove(competence);
    }

}
