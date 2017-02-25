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
public class GestionCompetences {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Competence sociable = new Competence("1", "Aucune idée", "Sociable");
        Competence motive = new Competence("2", "Aucune idée", "Motivé");
        Competence devWeb = new Competence("3", "Aucune idée", "Développement Web");
        Competence reseau = new Competence("4", "Aucune idée", "Réseaux");

        Personne jean = new Personne("Peuplus", "Jean", new Date(), 1);
        Personne beth = new Personne("Rave", "Beth", new Date(), 2);
        Personne carry = new Personne("Bout", "Carry", new Date(), 3);
        
        System.out.println(jean.toString());
        System.out.println(devWeb.toString());

        MissionPreparation missionPrep = new MissionPreparation(new Date(21, 2, 1994), 10, 5);
        missionPrep.addCompetence(motive, 2);
        missionPrep.addCompetence(devWeb, 1);
        missionPrep.addCompetence(sociable, 1);
        missionPrep.addCompetence(reseau, 1);
        
        MissionPlanifiee missionPlanifiee = new MissionPlanifiee(missionPrep.getDateDebut(), missionPrep.getDuree(), missionPrep.getNbRequis(), missionPrep.getPersonelRequis());
        missionPlanifiee.addPersonne(motive, jean);
        missionPlanifiee.addPersonne(devWeb, beth);
        missionPlanifiee.addPersonne(reseau, carry);
        missionPlanifiee.addPersonne(sociable, jean);
        
        MissionEnCours missionEnCours = new MissionEnCours(missionPlanifiee.getDateDebut(), missionPlanifiee.getDuree(), missionPlanifiee.getNbRequis(), missionPlanifiee.getPersonelRequis(), missionPlanifiee.getPersonelAffecte());
        System.out.println(missionEnCours.affectationDefinitive.toString());
        

    }

}
