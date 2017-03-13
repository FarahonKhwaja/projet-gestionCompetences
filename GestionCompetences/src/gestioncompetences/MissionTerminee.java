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
public class MissionTerminee extends MissionNonmodifiable {

    protected String dateFin;

    /**
     *
     * @param dateDebut
     * @param duree
     * @param libelle
     * @param etat
     * @param personelAffecte
     */
    public MissionTerminee(String libelle, String dateDebut, String duree, String etat, HashMap<Competence, ArrayList<Personne>> personelAffecte) {
        super(libelle, dateDebut, duree, etat, personelAffecte);
        this.etat = "Terminée";
    }
    
    public MissionTerminee(MissionEnCours m) {
        super(m.getLibelle(), m.getDateDebut(), m.getDuree(), m.getEtat(), m.getAffectationDefinitive());
        this.etat = "Terminée";
    }

    /**
     * @return the dateFin
     */
    public String getDateFin() {
        return dateFin;
    }

}
