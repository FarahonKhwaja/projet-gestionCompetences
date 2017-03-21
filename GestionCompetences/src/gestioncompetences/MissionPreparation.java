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
import java.util.logging.Level;
import java.util.logging.Logger;

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

    @Override
    public void prochainEtat() {
        try {
            ArrayList<MissionPreparation> missionsPrep = lecteur.getMissionsPreparation(gestionFichiers.lecteur.cheminMissions);
            ArrayList<Mission> missions = new ArrayList<>();
            for (MissionPreparation mission : missionsPrep) {
                if (mission.getLibelle().equals(this.libelle)) {
                    mission.setEtat("Planifiée");
                }
                missions.add(mission);
            }
            writer.sauvegarderMissions(missions);
        } catch (IOException ex) {
            Logger.getLogger(MissionPlanifiee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
