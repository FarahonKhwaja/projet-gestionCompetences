/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncompetences;

import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author phili
 */
class MissionPreparation extends Mission {
    
    HashMap<Competence, Integer> personelRequis;
    int nbRequis;

    public MissionPreparation(Date dateDebut, int duree, int nbRequis) {
        super(dateDebut, duree);
        this.nbRequis = nbRequis;
        this.personelRequis = new HashMap<>();
        this.etat = "Preparation";
    }

    public HashMap<Competence, Integer> getPersonelRequis() {
        return personelRequis;
    }

    public void setPersonelRequis(HashMap<Competence, Integer> personelRequis) {
        this.personelRequis = personelRequis;
    }

    public void addCompetence(Competence competence, int nbPersonne) {
        this.personelRequis.put(competence, nbPersonne);
    }

    public void removeCompetence(Competence competence) {
        this.personelRequis.remove(competence);
    }

    public int getNbRequis() {
        return nbRequis;
    }

    public void setNbRequis(int nbRequis) {
        this.nbRequis = nbRequis;
    }
    
}
