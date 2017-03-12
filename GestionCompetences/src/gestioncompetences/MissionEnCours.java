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
class MissionEnCours extends MissionNonmodifiable {

    /**
     *
     * @param dateDebut
     * @param duree
     * @param nbRequis
     * @param personelRequis
     * @param personelAffecte
     */
    public MissionEnCours(Date dateDebut, int duree, HashMap<Competence, ArrayList<Personne>> personelAffecte) {
        super(dateDebut, duree, personelAffecte);
        this.etat = "En Cours";
    }

    /**
     *
     * @return
     */
    public MissionTerminee clore() {
        return new MissionTerminee(getDateDebut(), getDuree(), getAffectationDefinitive());
    }

}
