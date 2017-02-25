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
    private String idCompetence;
    private String nomEN;
    private String nomFR;
    
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
     * @return the nomEN
     */
    public String getNomEN() {
        return nomEN;
    }

    /**
     * @return the nomFR
     */
    public String getNomFR() {
        return nomFR;
    }
}
