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
<<<<<<< HEAD
public class Competence {
    private String idCompetence;
    private String nomEN;
    private String nomFR;
    
    public Competence(String idComp, String nomAnglais, String nomFrancais) {
=======
class Competence {

    private int idCompetence;
    private String nomEN;
    private String nomFR;

    Competence(int idComp, String nomAnglais, String nomFrancais) {
>>>>>>> origin/master
        idCompetence = idComp;
        nomEN = nomAnglais;
        nomFR = nomFrancais;
    }

    /**
     * @return the idCompetence
     */
<<<<<<< HEAD
    public String getIdCompetence() {
=======
    public int getIdCompetence() {
>>>>>>> origin/master
        return idCompetence;
    }

    /**
<<<<<<< HEAD
=======
     * @param idCompetence the idCompetence to set
     */
    public void setIdCompetence(int idCompetence) {
        this.idCompetence = idCompetence;
    }

    /**
>>>>>>> origin/master
     * @return the nomEN
     */
    public String getNomEN() {
        return nomEN;
    }

    /**
<<<<<<< HEAD
=======
     * @param nomEN the nomEN to set
     */
    public void setNomEN(String nomEN) {
        this.nomEN = nomEN;
    }

    /**
>>>>>>> origin/master
     * @return the nomFR
     */
    public String getNomFR() {
        return nomFR;
    }
<<<<<<< HEAD
=======

    /**
     * @param nomFR the nomFR to set
     */
    public void setNomFR(String nomFR) {
        this.nomFR = nomFR;
    }
>>>>>>> origin/master
}
