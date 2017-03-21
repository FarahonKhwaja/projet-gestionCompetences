/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncompetences;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Entrax
 */
public abstract class MissionNonmodifiable extends Mission {

    /**
     *
     */
    protected HashMap<Competence, ArrayList<Personne>> affectationDefinitive;

    /**
     *
     * @param libelle libellé d'une mission non modifiable
     * @param dateDebut date de début d'une mission non modifiable
     * @param duree durée d'une mission non modifiable
     * @param etat état d'une mission non modifiable
     * @param personnelAffecte personnel affecté à une mission non modifiable
     */
    public MissionNonmodifiable(String libelle, String dateDebut, String duree, String etat, HashMap<Competence, ArrayList<Personne>> personnelAffecte) {
        super(libelle, dateDebut, duree, etat);
        this.affectationDefinitive = personnelAffecte;
    }

    /**
     * @return the affectationDefinitive
     */
    public HashMap<Competence, ArrayList<Personne>> getAffectationDefinitive() {
        return affectationDefinitive;
    }

}
