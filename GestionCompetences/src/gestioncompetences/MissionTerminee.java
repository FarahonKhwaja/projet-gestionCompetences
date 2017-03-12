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
public class MissionTerminee extends MissionNonmodifiable {

    protected Date dateFin;

    /**
     *
     * @param dateDebut
     * @param duree
     * @param personelAffecte
     */
    public MissionTerminee(Date dateDebut, int duree, HashMap<Competence, ArrayList<Personne>> personelAffecte) {
        super(dateDebut, duree, personelAffecte);
        this.etat = "Terminee";
    }

    /**
     * @return the dateFin
     */
    public Date getDateFin() {
        return dateFin;
    }

}
