/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncompetences;

import gestionFichiers.lecteur;
import gestionFichiers.writer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author phili
 */
public class MissionTerminee extends MissionNonmodifiable {

    /**
     *
     */
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

    /**
     *
     * @param m
     */
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

    /**
     *
     * @param libelle
     * @return
     * @throws IOException
     */
    public static MissionTerminee getMissionByLibelle(String libelle) throws IOException {
        ArrayList<MissionTerminee> missions = lecteur.getMissionsTerminee(gestionFichiers.lecteur.cheminMissions);
        for (MissionTerminee mission : missions) {
            if (mission.getLibelle().equals(libelle)) {
                return mission;
            }
        }
        return null;
    }

    /**
     *
     */
    public void prochainEtat() {
        super.prochainEtat("Terminée");
    }

}
