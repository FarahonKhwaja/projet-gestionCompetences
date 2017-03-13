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

    protected HashMap<Competence, Integer> personelRequisRestant = new HashMap<>();

    /**
     *
     * @param libelle
     * @param dateDebut
     * @param duree
     * @param etat
     */
    public MissionPlanifiee(String libelle, String dateDebut, String duree, String etat, HashMap<Competence, Integer> personelRequis) {
        super(libelle, dateDebut, duree, etat);
        this.personelRequis = personelRequis;
        this.personelRequisRestant = this.personelRequis;
        this.etat = "Planifiee";
    }

    public MissionPlanifiee(MissionPreparation m) {
        super(m.getLibelle(), m.getDateDebut(), m.getDuree(), m.getEtat());
        this.personelRequis = m.getPersonelRequis();
        System.out.println(this.personelRequis);
        this.personelRequisRestant = this.personelRequis;
        System.out.println(this.personelRequisRestant);
        this.etat = "Planifiee";
    }

    /**
     * @return the personelRequisRestant
     */
    public HashMap<Competence, Integer> getPersonelRequisRestant() {
        return personelRequisRestant;
    }

    /**
     * @param competence the competence to add
     * @param personne
     */
    // Note : Exception 0 restant !
    public void addPersonne(Competence competence, Personne personne) {
        if (this.getPersonelRequisRestant().get(competence) > 0) {
            ArrayList<Personne> personneArray = new ArrayList<>();
            if (this.getPersonelAffecte().get(competence) != null) {
                personneArray = this.getPersonelAffecte().get(competence);
            }
            personneArray.add(personne);
            this.getPersonelAffecte().put(competence, personneArray);
            this.getPersonelRequisRestant().put(competence, this.getPersonelRequisRestant().get(competence) - 1);
        }
    }

    public void addPersonne(HashMap<String, HashMap<String, ArrayList<Integer>>> affectationsMission) {
        HashMap<String, ArrayList<Integer>> libCompetences = affectationsMission.get(this.getLibelle());
        if (libCompetences != null) {
            for (String competenceMission : libCompetences.keySet()) {
                try {
                    Competence competence;
                    competence = Competence.getCompetenceById(competenceMission);
                    System.out.println(competence);
                    ArrayList<Personne> personnes = new ArrayList<>();
                    System.out.println(libCompetences.get(competenceMission));
                    for (int idPersonne : libCompetences.get(competenceMission)) {
                        personnes.add(Personne.getPersonneById(idPersonne));
                    }
                    this.getPersonelAffecte().put(competence, personnes);
                    //System.out.println(this.getPersonelAffecte());
                    //.out.println(this.getPersonelRequis());
                    //System.out.println(this.getPersonelRequisRestant());
                    //this.getPersonelRequisRestant().put(competence, this.getPersonelRequisRestant().get(competence) - 1);
                } catch (IOException ex) {
                    Logger.getLogger(MissionPlanifiee.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * @param competence the competence to remove
     */
    public void removePersonne(Competence competence) {
        this.getPersonelAffecte().remove(competence);
    }

    /**
     *
     */
    //Note pour plus tard : rajouter un check que la personne soit pas déjà sur une mission en cours
    public HashMap<Personne, Integer> chercherAffinites(ArrayList<Personne> personnel) throws IOException {
        HashMap<Personne, Integer> personneAffinites = new HashMap<>();
        for (Personne personne : personnel) {
            int i = 0;
            //System.out.println(personne.getCompetences());
            for (Competence competencePersonne : personne.getCompetences()) {
                //System.out.println("B" + competencePersonne);
                for (Competence key : this.getPersonelRequis().keySet()) {
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
                    //System.out.println(key.getCompetences());
                    for (Competence competencePersonne : key.getCompetences()) {
                        //System.out.println("B" + competencePersonne);
                        for (Competence competence : this.getPersonelRequis().keySet()) {
                            if (competence.getIdCompetence().equals(competencePersonne.getIdCompetence()) && this.getPersonelRequisRestant().get(competence) > 0) {
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
            //System.out.println(personne.getCompetences());
            for (Competence competencePersonne : personne.getCompetences()) {
                //System.out.println("B" + competencePersonne);
                for (Competence competence : this.getPersonelRequisRestant().keySet()) {
                    if (competence.getIdCompetence().equals(competencePersonne.getIdCompetence()) && this.getPersonelRequisRestant().get(competence) > 0) {
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
                    //System.out.println(key.getCompetences());
                    for (Competence competencePersonne : key.getCompetences()) {
                        //System.out.println("B" + competencePersonne);
                        for (Competence competence : this.getPersonelRequis().keySet()) {
                            if (competence.getIdCompetence().equals(competencePersonne.getIdCompetence()) && this.getPersonelRequisRestant().get(competence) > 0) {
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

    /**
     *
     * @return
     */
    public MissionEnCours commencer() {
        return new MissionEnCours(this);
    }

}
