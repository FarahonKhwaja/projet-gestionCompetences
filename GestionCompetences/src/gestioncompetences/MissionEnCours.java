/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncompetences;

import gestionFichiers.lecteur;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author phili
 */
public class MissionEnCours extends MissionNonmodifiable {

    /**
     *
     * @param libelle
     * @param dateDebut
     * @param duree
     * @param etat
     * @param personelAffecte
     */
    public MissionEnCours(String libelle, String dateDebut, String duree, String etat, HashMap<Competence, ArrayList<Personne>> personelAffecte) {
        super(libelle, dateDebut, duree, etat, personelAffecte);
        this.etat = "En Cours";
    }

    public MissionEnCours(MissionPlanifiee m) {
        super(m.getLibelle(), m.getDateDebut(), m.getDuree(), m.getEtat(), m.getPersonnelAffecte());
        this.etat = "En Cours";
    }

    public static MissionEnCours getMissionByLibelle(String libelle) throws IOException {
        ArrayList<MissionEnCours> missions = lecteur.getMissionsEnCours(gestionFichiers.lecteur.cheminMissions);
        for (MissionEnCours mission : missions) {
            if (mission.getLibelle().equals(libelle)) {
                return mission;
            }
        }
        return null;
    }

    public void prochainEtat() {
        super.prochainEtat("Terminée");
    }

}
