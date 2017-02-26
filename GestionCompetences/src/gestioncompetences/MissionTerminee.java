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
public class MissionTerminee extends MissionEnCours {

    protected Date dateFin;

    /**
     *
     * @param dateDebut
     * @param duree
     * @param nbRequis
     * @param personelRequis
     * @param personelAffecte
     */
    public MissionTerminee(Date dateDebut, int duree, int nbRequis, HashMap<Competence, Integer> personelRequis, HashMap<Competence, ArrayList<Personne>> personelAffecte) {
        super(dateDebut, duree, nbRequis, personelRequis, personelAffecte);
        this.etat = "Finie";
    }

    /**
     * @return the dateFin
     */
    public Date getDateFin() {
        return dateFin;
    }

}
