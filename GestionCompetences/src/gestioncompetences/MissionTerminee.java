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
     * @param libelle
     * @param personelAffecte
     */
    public MissionTerminee(String libelle, String dateDebut, String duree, String etat, HashMap<Competence, ArrayList<Personne>> personelAffecte) {
        super(libelle, dateDebut, duree, etat, personelAffecte);
        this.etat = "Terminee";
    }

    /**
     * @return the dateFin
     */
    public Date getDateFin() {
        return dateFin;
    }

}
