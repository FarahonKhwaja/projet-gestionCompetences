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
class Mission {

    Date dateDebut;
    int duree;
    String etat;

    /**
     *
     * @param dateDebut the dateDebut to set
     * @param duree the duree to set
     */
    public Mission(Date dateDebut, int duree) {
        this.dateDebut = dateDebut;
        this.duree = duree;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

}
