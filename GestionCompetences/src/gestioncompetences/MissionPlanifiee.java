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

    /**
     *
     */
    protected HashMap<Competence, Integer> personnelRequisRestant = new HashMap<>();

    /**
     *
     */
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
        this.personnelRequisRestant = this.personnelRequis;
        this.etat = "Planifiée";
    }

    /**
     *
     * @param m correspond à la {@link MissionPreparation} à transformer en 
     * {@link MissionPlanifiee}
     */
    public MissionPlanifiee(MissionPreparation m) {
        super(m.getLibelle(), m.getDateDebut(), m.getDuree(), m.getEtat());
        this.personnelRequis = m.getPersonnelRequis();
        this.personnelRequisRestant = this.personnelRequis;
        this.etat = "Planifiée";
    }

    /**
     * @return the personnelRequisRestant
     */
    public HashMap<Competence, Integer> getPersonnelRequisRestant() {
        return personnelRequisRestant;
    }

    /**
     * @return le personnel affecté
     */
    public HashMap<Competence, ArrayList<Personne>> getPersonnelAffecte() {
        return personnelAffecte;
    }

    /**
     * @param competence la {@link Competence} à ajouter
     * @param personne la {@link Personne} à qui il faut ajouter la compétence competence
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
    }

    /**
     *
     * @param affectationsMission
     */
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
    public void clearAffectations() {
        for (Competence cp : this.getPersonnelRequisRestant().keySet()) {
            int nb = 0;
            if (this.getPersonnelAffecte().get(cp) != null) {
                nb = this.getPersonnelAffecte().get(cp).size();
            }
            this.getPersonnelRequisRestant().put(cp, this.getPersonnelRequisRestant().get(cp) + nb);
        }
        this.getPersonnelAffecte().clear();
    }

    /**
     *
     * @param competence correspond à une {@link Competence}
     * @param personne correspond à une {@link Personne}
     */
    public void removePersonne(Competence competence, Personne personne) {
        for (Competence cp : this.getPersonnelAffecte().keySet()) {
            if (cp.getIdCompetence().equals(competence.getIdCompetence())) {
                ArrayList<Personne> personneArrayTemp = this.getPersonnelAffecte().get(cp);
                ArrayList<Personne> personneArray = new ArrayList<>();
                for (Personne pers : personneArrayTemp) {
                    if (pers.getId() != personne.getId()) {
                        personneArray.add(pers);
                    }
                }
                this.getPersonnelAffecte().put(cp, personneArray);
                this.getPersonnelRequisRestant().put(cp, this.getPersonnelRequisRestant().get(cp) + 1);
            }
        }
    }

    /**
     *
     * @throws IOException
     */
    public void multiSelectionAutoSup() throws IOException {
        ArrayList<Personne> personnel = lecteur.getPersonnel(lecteur.cheminPersonnel);
        HashMap<Personne, Integer> personneAffinites = new HashMap<>();
        for (Personne personne : personnel) {
            personne.addCompetence(lecteur.getCompetencesParPersonne(lecteur.cheminCompetencesPersonnel));
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

    /**
     *
     * @param personnel correspond à une ArrayList de {@link Personne}
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

    /**
     *
     * @param libelle libellé d'une mission
     * @return la mission correspondant au libellé
     * @throws IOException
     */
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
     */
    public void prochainEtat() {
        super.prochainEtat("En Cours");
    }
}
