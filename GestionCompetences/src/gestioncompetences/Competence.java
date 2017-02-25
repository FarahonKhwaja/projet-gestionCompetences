/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncompetences;

/**
 *
 * @author phili
 */
public class Competence {

    String idCompetence;
    String nomEN;
    String nomFR;

    /**
     *
     * @param idComp
     * @param nomAnglais
     * @param nomFrancais
     */
    public Competence(String idComp, String nomAnglais, String nomFrancais) {
        idCompetence = idComp;
        nomEN = nomAnglais;
        nomFR = nomFrancais;
    }

    /**
     * @return the idCompetence
     */
    public String getIdCompetence() {
        return idCompetence;
    }

    /**
     * @param idCompetence the idCompetence to set
     */
    public void setIdCompetence(String idCompetence) {
        this.idCompetence = idCompetence;
    }

    /**
     * @return the nomEN
     */
    public String getNomEN() {
        return nomEN;
    }

    /**
     * @param nomEN the nomEN to set
     */
    public void setNomEN(String nomEN) {
        this.nomEN = nomEN;
    }

    /**
     * @return the nomFR
     */
    public String getNomFR() {
        return nomFR;
    }

    /**
     * @param nomFR the nomFR to set
     */
    public void setNomFR(String nomFR) {
        this.nomFR = nomFR;
    }

    @Override
    public String toString() {
        return idCompetence + " - " + nomEN + " - " + nomFR;
    }
}
