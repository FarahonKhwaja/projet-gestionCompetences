/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncompetences;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author phili
 */
class MissionEnCours extends MissionPlanifiee {

    protected HashMap<Competence, ArrayList<Personne>> affectationDefinitive;

    /**
     *
     * @param dateDebut
     * @param duree
     * @param nbRequis
     * @param personelRequis
     * @param personelAffecte
     */
    public MissionEnCours(Date dateDebut, int duree, int nbRequis, HashMap<Competence, Integer> personelRequis, HashMap<Competence, ArrayList<Personne>> personelAffecte) {
        super(dateDebut, duree, nbRequis, personelRequis);
        this.etat = "En Cours";
        this.affectationDefinitive = personelAffecte;
    }

    /**
     * @return the affectationDefinitive
     */
    public HashMap<Competence, ArrayList<Personne>> getAffectationDefinitive() {
        return affectationDefinitive;
    }

    /**
     *
     * @return
     */
    public MissionTerminee clore() {
        return new MissionTerminee(getDateDebut(), getDuree(), getNbRequis(), getPersonelRequis(), getPersonelAffecte());
    }

}
