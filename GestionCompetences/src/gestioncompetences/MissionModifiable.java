/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncompetences;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Entrax
 */
public class MissionModifiable extends Mission {

    protected int nbRequis;
    protected HashMap<Competence, Integer> personelRequis = new HashMap<>();
    protected HashMap<Competence, ArrayList<Personne>> personelAffecte = new HashMap<>();

    public MissionModifiable(int nbRequis, Date dateDebut, int duree) {
        super(dateDebut, duree);
        this.nbRequis = nbRequis;
    }

    public int getNbRequis() {
        return nbRequis;
    }

    public HashMap<Competence, Integer> getPersonelRequis() {
        return personelRequis;
    }

    public void setPersonelRequis(HashMap<Competence, Integer> personelRequis) {
        this.personelRequis = personelRequis;
    }

    public HashMap<Competence, ArrayList<Personne>> getPersonelAffecte() {
        return personelAffecte;
    }

    public void setPersonelAffecte(HashMap<Competence, ArrayList<Personne>> personelAffecte) {
        this.personelAffecte = personelAffecte;
    }
    
}
