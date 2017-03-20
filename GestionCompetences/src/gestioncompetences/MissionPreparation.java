/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncompetences;

import gestionFichiers.lecteur;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author phili
 */
public class MissionPreparation extends MissionModifiable {

    /**
     *
     * @param libelle
     * @param dateDebut
     * @param duree
     * @param etat
     * @param nbRequis
     */
    public MissionPreparation(String libelle, String dateDebut, String duree, String etat, String nbRequis) {
        super(libelle, dateDebut, duree, etat, nbRequis);
        this.etat = "Préparation";
    }

    public MissionPreparation(String libelle, String dateDebut, String duree, String etat) {
        super(libelle, dateDebut, duree, etat);
        this.etat = "Préparation";
    }

    public static MissionPreparation getMissionByLibelle(String libelle) throws IOException {
        ArrayList<MissionPreparation> missions = lecteur.getMissionsPreparation(gestionFichiers.lecteur.cheminMissions);
        for (MissionPreparation mission : missions) {
            if (mission.getLibelle().equals(libelle)) {
                return mission;
            }
        }
        return null;
    }

}
