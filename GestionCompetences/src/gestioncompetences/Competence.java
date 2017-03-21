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

/**
 *
 * @author phili
 */
public class Competence {

    /**
     *
     */
    protected String idCompetence;

    /**
     *
     */
    protected String nomEN;

    /**
     *
     */
    protected String nomFR;

    /**
     *
     * @param idComp id de la compétence
     * @param nomAnglais nom anglais de la compétence
     * @param nomFrancais nom français de la compétence
     */
    public Competence(String idComp, String nomAnglais, String nomFrancais) {
        idCompetence = idComp;
        nomEN = nomAnglais;
        nomFR = nomFrancais;
    }

    /**
     *
     * @param aString correspond à une Compétence sous la forme 
     * idCompetence - nomEN - nomFR
     */
    public Competence(String aString) {
        String[] parts = aString.split(" - ");
        idCompetence = parts[0];
        nomEN = parts[1];
        nomFR = parts[2];
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

    /**
     *
     * @return idCompetence-nomEN-nomFR
     */
    @Override
    public String toString() {
        return getIdCompetence() + " - " + getNomEN() + " - " + getNomFR();
    }

    /**
     *
     * @param id identifiant d'une compétence
     * @return object Compétence correspondant à id
     * @throws IOException
     */
    public static Competence getCompetenceById(String id) throws IOException {
        ArrayList<Competence> competences = lecteur.getCompetences(lecteur.cheminCompetences);
        for (Competence competence : competences) {
            if (competence.getIdCompetence().equals(id)) {
                return competence;
            }
        }
        return null;
    }

    /**
     *
     * @param id identifiant d'une Personne
     * @return ArrayList des compétences de la Personne correspondant à id
     * @throws IOException
     */
    public static ArrayList<Personne> getPersonnesByCompetenceId(String id) throws IOException {
        ArrayList<Personne> personnes = new ArrayList<>();
        //ERREUR NULLPOINTEREXCEPTION : lireFichierCompetencesParPersonne ne marche pas
        HashMap<Integer, ArrayList<String>> competencesParPersonne = lecteur.getCompetencesParPersonne(lecteur.cheminCompetencesPersonnel);
        //parcourir les ArrayList<String>
        for (Integer idPersonne : competencesParPersonne.keySet()) {

            ArrayList<String> liste = competencesParPersonne.get(idPersonne);
            if (liste.contains(id)) {
                personnes.add(Personne.getPersonneById(idPersonne));
            }
        }
        /*for(Personne p : personnes)
        {
            System.out.println(p.toString());
        }*/
        return personnes;
    }
}
