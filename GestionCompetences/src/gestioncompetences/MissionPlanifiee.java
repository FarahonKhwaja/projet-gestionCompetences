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

    HashMap<Competence, Personne> personelAffecte = new HashMap<>();

    public MissionPlanifiee(Date dateDebut, int duree, int nbRequis, HashMap<Competence, Integer> personelRequis) {
        super(dateDebut, duree, nbRequis);
        this.etat = "Planifiee";
        this.personelRequis = personelRequis;
    }

    /**
     * @return the personelAffecte
     */
    public HashMap<Competence, Personne> getPersonelAffecte() {
        return personelAffecte;
    }

    /**
     * @param competence the competence to add
     * @param nbPersonne the nbPersonne to set
     */
    public void addPersonne(Competence competence, Personne personne) {
        this.personelAffecte.put(competence, personne);
    }

    /**
     * @param competence the competence to remove
     */
    public void removePersonne(Competence competence) {
        this.personelAffecte.remove(competence);
    }

}
