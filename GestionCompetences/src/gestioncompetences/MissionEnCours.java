/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncompetences;

import java.util.ArrayList;
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
    public MissionEnCours(String libelle, String dateDebut, String duree, String etat, HashMap<Competence, ArrayList<Personne>> personelAffecte) {
        super(libelle, dateDebut, duree, etat, personelAffecte);
        this.etat = "En Cours";
    }

    /**
     *
     * @return
     */
    public MissionTerminee clore() {
        return new MissionTerminee(getLibelle(), getDateDebut(), getDuree(), getEtat(), getAffectationDefinitive());
    }

}
