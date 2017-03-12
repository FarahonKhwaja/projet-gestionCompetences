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

    /**
     *
     * @param libelle
     * @param dateDebut
     * @param duree
     * @param etat
     * @param nbRequis
     */
    public MissionModifiable(String libelle, String dateDebut, String duree, String etat, int nbRequis) {
        super(libelle, dateDebut, duree, etat);
        this.nbRequis = nbRequis;
    }

    /**
     * @return the nbRequis
     */
    public int getNbRequis() {
        return nbRequis;
    }

    /**
     * @return the personelRequis
     */
    public HashMap<Competence, Integer> getPersonelRequis() {
        return personelRequis;
    }

    /**
     * @return the personelAffecte
     */
    public HashMap<Competence, ArrayList<Personne>> getPersonelAffecte() {
        return personelAffecte;
    }

}
