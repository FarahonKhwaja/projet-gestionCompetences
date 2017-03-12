/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncompetences;

import java.util.Date;

/**
 *
 * @author phili
 */
public class Mission {

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

    /**
     * @return the etat
     */
    public String getLibelle() {
        return libelle;
    }

}
