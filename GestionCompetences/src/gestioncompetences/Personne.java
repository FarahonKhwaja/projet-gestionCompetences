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
public class Personne {
    private String nom, prenom;
    private Date dateEntree;
    private int id;
    
    public Personne(String nom, String prenom, Date dateEntree, int id)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.dateEntree = dateEntree;
        this.id = id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @return the dateEntree
     */
    public Date getDateEntree() {
        return dateEntree;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
}
