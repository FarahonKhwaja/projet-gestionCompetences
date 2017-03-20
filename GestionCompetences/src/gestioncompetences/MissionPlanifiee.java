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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phili
 */
public class MissionPlanifiee extends MissionModifiable {

    protected HashMap<Competence, Integer> personnelRequisRestant = new HashMap<>();
    protected HashMap<Competence, ArrayList<Personne>> personnelAffecte = new HashMap<>();

    /**
     *
     * @param libelle
     * @param dateDebut
     * @param duree
     * @param etat
     * @param personelRequis
     */
    public MissionPlanifiee(String libelle, String dateDebut, String duree, String etat, HashMap<Competence, Integer> personelRequis) {
        super(libelle, dateDebut, duree, etat);
        this.personnelRequis = personelRequis;
        this.personnelRequisRestant = personelRequis;
        this.etat = "Planifiée";
    }

    public MissionPlanifiee(MissionPreparation m) {
        super(m.getLibelle(), m.getDateDebut(), m.getDuree(), m.getEtat());
        this.personnelRequis = m.getPersonnelRequis();
        this.personnelRequisRestant = m.getPersonnelRequis();
        this.etat = "Planifiée";
    }

    /**
     * @return the personnelRequisRestant
     */
    public HashMap<Competence, Integer> getPersonnelRequisRestant() {
        return personnelRequisRestant;
    }

    /**
     * @return the personnelAffecte
     */
    public HashMap<Competence, ArrayList<Personne>> getPersonnelAffecte() {
        return personnelAffecte;
    }

    /**
     * @param competence the competence to add
     * @param personne
     */
    public void addPersonne(Competence competence, Personne personne) {
        for (Competence cp : this.getPersonnelRequisRestant().keySet()) {
            if (cp.getIdCompetence().equals(competence.getIdCompetence()) && this.getPersonnelRequisRestant().get(cp) > 0) {
                ArrayList<Personne> personneArray = new ArrayList<>();
                if (this.getPersonnelAffecte().get(cp) != null) {
                    personneArray = this.getPersonnelAffecte().get(cp);
                }
                personneArray.add(personne);
                this.getPersonnelAffecte().put(cp, personneArray);
                this.getPersonnelRequisRestant().put(cp, this.getPersonnelRequisRestant().get(cp) - 1);
            }
        }
        System.out.println(this.getPersonnelRequisRestant());
        System.out.println(this.getPersonnelRequis());
        System.out.println("");
    }

    public void addPersonne(HashMap<String, HashMap<String, ArrayList<Integer>>> affectationsMission) {
        HashMap<String, ArrayList<Integer>> libCompetences = affectationsMission.get(this.getLibelle());
        if (libCompetences != null) {
            for (String competenceMission : libCompetences.keySet()) {
                try {
                    Competence competence;
                    competence = Competence.getCompetenceById(competenceMission);
                    ArrayList<Personne> personnes = new ArrayList<>();
                    for (int idPersonne : libCompetences.get(competenceMission)) {
                        addPersonne(competence, Personne.getPersonneById(idPersonne));
                    }
                } catch (IOException ex) {
                    Logger.getLogger(MissionPlanifiee.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     *
     */
    //Note pour plus tard : rajouter un check que la personne soit pas déjà sur une mission en cours
    public HashMap<Personne, Integer> chercherAffinites(ArrayList<Personne> personnel) throws IOException {
        HashMap<Personne, Integer> personneAffinites = new HashMap<>();
        for (Personne personne : personnel) {
            int i = 0;
            for (Competence competencePersonne : personne.getCompetences()) {
                for (Competence key : this.getPersonnelRequis().keySet()) {
                    if (key.getIdCompetence().equals(competencePersonne.getIdCompetence())) {
                        i++;
                    }
                }
            }
            personneAffinites.put(personne, i);
        }
        return personneAffinites;
    }

    /**
     *
     * @param personneAffinites
     * @throws IOException
     */
    public void multiSelectionAuto(HashMap<Personne, Integer> personneAffinites) throws IOException {
        int i = 0;
        for (Personne key : personneAffinites.keySet()) {
            if (personneAffinites.get(key).compareTo(i) > 0) {
                i = personneAffinites.get(key);
            }
        }
        while (i > 0) {
            for (Personne key : personneAffinites.keySet()) {
                if (personneAffinites.get(key).compareTo(i) == 0) {
                    for (Competence competencePersonne : key.getCompetences()) {
                        for (Competence competence : this.getPersonnelRequis().keySet()) {
                            if (competence.getIdCompetence().equals(competencePersonne.getIdCompetence()) && this.getPersonnelRequisRestant().get(competence) > 0) {
                                addPersonne(competence, key);
                            }
                        }
                    }
                }
            }
            i--;
        }
    }

    /**
     *
     * @param personnel
     * @throws IOException
     */
    public void multiSelectionAutoSup(ArrayList<Personne> personnel) throws IOException {
        HashMap<Personne, Integer> personneAffinites = new HashMap<>();
        for (Personne personne : personnel) {
            int i = 0;
            for (Competence competencePersonne : personne.getCompetences()) {
                for (Competence competence : this.getPersonnelRequisRestant().keySet()) {
                    if (competence.getIdCompetence().equals(competencePersonne.getIdCompetence()) && this.getPersonnelRequisRestant().get(competence) > 0) {
                        i++;
                    }
                }
            }
            personneAffinites.put(personne, i);
        }

        int j = 0;
        for (Personne key : personneAffinites.keySet()) {
            if (personneAffinites.get(key).compareTo(j) > 0) {
                j = personneAffinites.get(key);
            }
        }

        if (j != 0) {
            for (Personne key : personneAffinites.keySet()) {
                if (personneAffinites.get(key).compareTo(j) == 0) {
                    for (Competence competencePersonne : key.getCompetences()) {
                        for (Competence competence : this.getPersonnelRequis().keySet()) {
                            if (competence.getIdCompetence().equals(competencePersonne.getIdCompetence()) && this.getPersonnelRequisRestant().get(competence) > 0) {
                                addPersonne(competence, key);
                            }
                        }
                    }
                }
            }
            multiSelectionAutoSup(personnel);
        }

    }

    public static MissionPlanifiee getMissionByLibelle(String libelle) throws IOException {
        ArrayList<MissionPlanifiee> missions = lecteur.getMissionsPlanifiee(gestionFichiers.lecteur.cheminMissions);
        for (MissionPlanifiee mission : missions) {
            if (mission.getLibelle().equals(libelle)) {
                return mission;
            }
        }
        return null;
    }

}
