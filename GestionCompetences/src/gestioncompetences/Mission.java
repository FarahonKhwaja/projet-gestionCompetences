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
public abstract class Mission {

    protected String libelle, dateDebut, duree, etat;

    /**
     *
     * @param libelle
     * @param dateDebut
     * @param duree
     * @param etat
     */
    public Mission(String libelle, String dateDebut, String duree, String etat) {
        this.dateDebut = dateDebut;
        this.duree = duree;
        this.libelle = libelle;
        this.etat = etat;
    }

    /**
     * @return the dateDebut
     */
    public String getDateDebut() {
        return dateDebut;
    }

    /**
     * @return the duree
     */
    public String getDuree() {
        return duree;
    }

    /**
     * @return the etat
     */
    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    /**
     * @return the etat
     */
    public String getLibelle() {
        return libelle;
    }

    public void prochainEtat(String etat) {
        try {
            ArrayList<Mission> missionsPrep = lecteur.getMissions(gestionFichiers.lecteur.cheminMissions);
            ArrayList<Mission> missions = new ArrayList<>();
            for (Mission mission : missionsPrep) {
                if (mission.getLibelle().equals(this.libelle)) {
                    mission.setEtat(etat);
                }
                missions.add(mission);
            }
            writer.sauvegarderMissions(missions);
        } catch (IOException ex) {
            Logger.getLogger(MissionPlanifiee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Mission getMissionByLibelle(String libelle) throws IOException {
        ArrayList<Mission> missions = lecteur.getMissions(gestionFichiers.lecteur.cheminMissions);
        for (Mission mission : missions) {
            if (mission.getLibelle().equals(libelle)) {
                return mission;
            }
        }
        return null;
    }

}
