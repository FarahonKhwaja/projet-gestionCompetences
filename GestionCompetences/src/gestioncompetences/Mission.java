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
abstract class Mission {

    protected Date dateDebut;
    protected int duree;
    protected String etat;

    public Mission(Date dateDebut, int duree) {
        this.dateDebut = dateDebut;
        this.duree = duree;
        this.etat = "";
    }

    /**
     * @return the dateDebut
     */
    public Date getDateDebut() {
        return dateDebut;
    }

    /**
     * @return the duree
     */
    public int getDuree() {
        return duree;
    }

}
