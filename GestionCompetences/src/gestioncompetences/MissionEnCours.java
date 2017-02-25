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
class MissionEnCours extends MissionPlanifiee {

    HashMap<Competence, Personne> affectationDefinitive;

    /**
     *
     */
    public MissionEnCours(Date dateDebut, int duree, int nbRequis, HashMap<Competence, Integer> personelRequis, HashMap<Competence, Personne> personelAffecte) {
        super(dateDebut, duree, nbRequis, personelRequis);
        this.etat = "En Cours";
        this.affectationDefinitive = personelAffecte;
    }

    /**
     * @return the affectationDefinitive
     */
    public HashMap<Competence, Personne> getAffectationDefinitive() {
        return affectationDefinitive;
    }

}
