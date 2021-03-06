/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import gestionFichiers.lecteur;
import gestioncompetences.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Entrax
 */
public class DetailsMissionPlanifiee extends javax.swing.JFrame {

    private static String libelle, dateDebut, duree, etat;
    private final MissionPlanifiee mission;

    private HashMap<String, HashMap<String, Integer>> competencesMission = new HashMap<>();
    private HashMap<String, HashMap<String, ArrayList<Integer>>> affectationsMission = new HashMap<>();

    /**
     * Creates new form DetailsMissionPreparation
     *
     * @param libelle
     * @param dateDebut
     * @param duree
     * @param etat
     * @throws java.io.IOException
     */
    public DetailsMissionPlanifiee(String libelle, String dateDebut, String duree, String etat) throws IOException {
        initComponents();
        DetailsMissionPlanifiee.libelle = libelle;
        DetailsMissionPlanifiee.dateDebut = dateDebut;
        DetailsMissionPlanifiee.duree = duree;
        DetailsMissionPlanifiee.etat = etat;
        jLabelLibelleMission.setText(libelle);

        competencesMission = lecteur.getCompetencesParMission(lecteur.cheminCompetencesMission);
        affectationsMission = lecteur.getAffectationsParMission(lecteur.cheminAffectationsMission);

        MissionPlanifiee m = MissionPlanifiee.getMissionByLibelle(libelle);
        if (m == null) {
            HashMap<Competence, Integer> personelRequis = new HashMap<>();
            this.mission = new MissionPlanifiee(libelle, dateDebut, duree, etat, personelRequis);
        } else {
            this.mission = new MissionPlanifiee(m.getLibelle(), m.getDateDebut(), m.getDuree(), m.getEtat(), m.getPersonnelRequis());
        }

        this.mission.addCompetence(competencesMission);
        this.mission.addPersonne(affectationsMission);
        HashMap<Competence, Integer> competenceMission = this.mission.getPersonnelRequis();
        for (Competence cp : this.mission.getPersonnelRequis().keySet()) {
            int nbR = 0;
            for (Competence libCp : competenceMission.keySet()) {
                if (libCp.getIdCompetence().equals(cp.getIdCompetence())) {
                    nbR = competenceMission.get(libCp);
                }
            }
            int nb = 0;
            if (this.mission.getPersonnelAffecte().get(cp) != null) {
                nb = this.mission.getPersonnelAffecte().get(cp).size();
            }
            tableCompetencesMissionModel.addRow(new Object[]{cp.getIdCompetence(), cp.getNomEN(), cp.getNomFR(), nb, nbR});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelLibelleMission = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCompetencesMissionModel = new DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Identifiant", "Libellé EN", "Libellé FR", "Personnel assigné", "Personnel manquant"
            })
            {
                @Override
                public boolean isCellEditable(int row, int column)
                {
                    return false;
                }
            };
            jTableCompetencesMission = new javax.swing.JTable();
            jButtonCommencer = new javax.swing.JButton();
            jScrollPane1 = new javax.swing.JScrollPane();
            tablePersonnesCompetenceMissionModel = new DefaultTableModel(              new Object [][] {},              new String [] {                  "Identifiant", "Nom", "Prénom", "Date d'entrée"              })
            {
                @Override
                public boolean isCellEditable(int row, int column)
                {
                    return false;
                }
            };
            jTablePersonnesCompetenceMission = new javax.swing.JTable();
            jButtonSavePersonnesCompetencesMission = new javax.swing.JButton();
            jButtonAddPersonnesCompetenceMission = new javax.swing.JButton();
            comboBoxPersonnesMissionModel = new DefaultComboBoxModel<String>(new String [] {});
            jComboBoxPersonnesMission = new javax.swing.JComboBox<>();
            jButtonResetPersonnesCompetenceMission = new javax.swing.JButton();
            jLabel1 = new javax.swing.JLabel();
            jButtonDeletePersonnesCompetenceMission = new javax.swing.JButton();
            jButtonAutoSelectPersonnesCompetenceMission = new javax.swing.JButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setTitle("Détails Mission Planifiee");

            jTableCompetencesMission.setAutoCreateRowSorter(true);
            jTableCompetencesMission.setModel(tableCompetencesMissionModel);
            jTableCompetencesMission.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jTableCompetencesMissionMouseClicked(evt);
                }
            });
            jScrollPane2.setViewportView(jTableCompetencesMission);

            jButtonCommencer.setText("Commencer");
            jButtonCommencer.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jButtonCommencerMouseClicked(evt);
                }
            });

            jTablePersonnesCompetenceMission.setAutoCreateRowSorter(true);
            jTablePersonnesCompetenceMission.setModel(tablePersonnesCompetenceMissionModel);
            jScrollPane1.setViewportView(jTablePersonnesCompetenceMission);

            jButtonSavePersonnesCompetencesMission.setText("Enregister");
            jButtonSavePersonnesCompetencesMission.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jButtonSavePersonnesCompetencesMissionMouseClicked(evt);
                }
            });

            jButtonAddPersonnesCompetenceMission.setText("Assigner");
            jButtonAddPersonnesCompetenceMission.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jButtonAddPersonnesCompetenceMissionMouseClicked(evt);
                }
            });

            jComboBoxPersonnesMission.setModel(comboBoxPersonnesMissionModel);

            jButtonResetPersonnesCompetenceMission.setText("Réinitialiser");
            jButtonResetPersonnesCompetenceMission.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jButtonResetPersonnesCompetenceMissionMouseClicked(evt);
                }
            });

            jLabel1.setText("Affectations");

            jButtonDeletePersonnesCompetenceMission.setText("Supprimer");
            jButtonDeletePersonnesCompetenceMission.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jButtonDeletePersonnesCompetenceMissionMouseClicked(evt);
                }
            });

            jButtonAutoSelectPersonnesCompetenceMission.setText("Sélection automatique");
            jButtonAutoSelectPersonnesCompetenceMission.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jButtonAutoSelectPersonnesCompetenceMissionMouseClicked(evt);
                }
            });

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabelLibelleMission)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonCommencer, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButtonAutoSelectPersonnesCompetenceMission)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonResetPersonnesCompetenceMission)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                            .addComponent(jComboBoxPersonnesMission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonAddPersonnesCompetenceMission)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonDeletePersonnesCompetenceMission)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonSavePersonnesCompetencesMission))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap())
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButtonCommencer)
                        .addComponent(jLabelLibelleMission))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonSavePersonnesCompetencesMission)
                        .addComponent(jComboBoxPersonnesMission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonResetPersonnesCompetenceMission)
                        .addComponent(jButtonAutoSelectPersonnesCompetenceMission)
                        .addComponent(jButtonDeletePersonnesCompetenceMission)
                        .addComponent(jButtonAddPersonnesCompetenceMission))
                    .addContainerGap())
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void jButtonSavePersonnesCompetencesMissionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSavePersonnesCompetencesMissionMouseClicked
        // TODO add your handling code here:
        HashMap<String, ArrayList<Integer>> affectationsCompetence = new HashMap<>();

        for (Competence cp : this.mission.getPersonnelAffecte().keySet()) {
            ArrayList<Integer> idPersonnes = new ArrayList<>();
            for (Personne personne : this.mission.getPersonnelAffecte().get(cp)) {
                idPersonnes.add(personne.getId());
            }
            affectationsCompetence.put(cp.getIdCompetence(), idPersonnes);
        }
        affectationsMission.put(this.mission.getLibelle(), affectationsCompetence);

        try {
            gestionFichiers.writer.sauvegarderAffectationsParMission(affectationsMission);
        } catch (IOException ex) {
            Logger.getLogger(DetailsMissionPreparation.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.dispose();
    }//GEN-LAST:event_jButtonSavePersonnesCompetencesMissionMouseClicked

    private void jButtonAddPersonnesCompetenceMissionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAddPersonnesCompetenceMissionMouseClicked
        // TODO add your handling code here:
        if (jTableCompetencesMission.getSelectedRow() != -1 && comboBoxPersonnesMissionModel.getSelectedItem() != null && (int) tableCompetencesMissionModel.getValueAt(jTableCompetencesMission.getSelectedRow(), 4) > 0) {
            String[] pString = comboBoxPersonnesMissionModel.getSelectedItem().toString().split(" - ");
            Personne pers;
            try {
                System.out.println("test");
                pers = Personne.getPersonneById(Integer.parseInt(pString[0]));
                this.mission.addPersonne(Competence.getCompetenceById(tableCompetencesMissionModel.getValueAt(jTableCompetencesMission.getSelectedRow(), 0).toString()), pers);
                tablePersonnesCompetenceMissionModel.addRow(new Object[]{pers.getId(), pers.getNom(), pers.getPrenom(), pers.getDateEntree()});
                tableCompetencesMissionModel.setValueAt((int) tableCompetencesMissionModel.getValueAt(jTableCompetencesMission.getSelectedRow(), 3) + 1, jTableCompetencesMission.getSelectedRow(), 3);
                tableCompetencesMissionModel.setValueAt((int) tableCompetencesMissionModel.getValueAt(jTableCompetencesMission.getSelectedRow(), 4) - 1, jTableCompetencesMission.getSelectedRow(), 4);
            } catch (IOException ex) {
                Logger.getLogger(DetailsMissionPlanifiee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonAddPersonnesCompetenceMissionMouseClicked

    private void jButtonResetPersonnesCompetenceMissionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonResetPersonnesCompetenceMissionMouseClicked
        // TODO add your handling code here:
        this.mission.clearAffectations();
        while (tableCompetencesMissionModel.getRowCount() != 0) {
            tableCompetencesMissionModel.removeRow(0);
        }
        while (tablePersonnesCompetenceMissionModel.getRowCount() != 0) {
            tablePersonnesCompetenceMissionModel.removeRow(0);
        }
        this.mission.addPersonne(affectationsMission);

        HashMap<Competence, Integer> competenceMission = this.mission.getPersonnelRequis();
        for (Competence cp : this.mission.getPersonnelRequis().keySet()) {
            int nbR = 0;
            for (Competence libCp : competenceMission.keySet()) {
                if (libCp.getIdCompetence().equals(cp.getIdCompetence())) {
                    nbR = competenceMission.get(libCp);
                }
            }
            int nb = 0;
            if (this.mission.getPersonnelAffecte().get(cp) != null) {
                nb = this.mission.getPersonnelAffecte().get(cp).size();
            }
            tableCompetencesMissionModel.addRow(new Object[]{cp.getIdCompetence(), cp.getNomEN(), cp.getNomFR(), nb, nbR});
        }
    }//GEN-LAST:event_jButtonResetPersonnesCompetenceMissionMouseClicked

    private void jTableCompetencesMissionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCompetencesMissionMouseClicked
        // TODO add your handling code here:

        String idComp = tableCompetencesMissionModel.getValueAt(jTableCompetencesMission.getSelectedRow(), 0).toString();
        //Affichage du personnel de la mission
        while (tablePersonnesCompetenceMissionModel.getRowCount() != 0) {
            tablePersonnesCompetenceMissionModel.removeRow(0);
        }
        Competence cp;
        ArrayList<Personne> personnel = new ArrayList<>();
        try {
            cp = Competence.getCompetenceById(idComp);
            for (Competence comp : this.mission.getPersonnelAffecte().keySet()) {
                if (comp.getIdCompetence().equals(cp.getIdCompetence())) {
                    personnel = this.mission.getPersonnelAffecte().get(comp);
                }
            }
            for (Personne pers : personnel) {
                tablePersonnesCompetenceMissionModel.addRow(new Object[]{pers.getId(), pers.getNom(), pers.getPrenom(), pers.getDateEntree()});
            }
        } catch (IOException ex) {
            Logger.getLogger(DetailsMissionPlanifiee.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Affichage du personnel éligible pour la mission
        if (comboBoxPersonnesMissionModel.getSize() != 0) {
            comboBoxPersonnesMissionModel.removeAllElements();
        }
        ArrayList<Personne> personnes = new ArrayList<>();
        try {
            personnes = Competence.getPersonnesByCompetenceId(idComp);
            for (Personne personne : personnes) {
                comboBoxPersonnesMissionModel.addElement(personne.toString());
            }
        } catch (IOException ex) {
            Logger.getLogger(DetailsCompetence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTableCompetencesMissionMouseClicked

    private void jButtonDeletePersonnesCompetenceMissionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDeletePersonnesCompetenceMissionMouseClicked
        // TODO add your handling code here:
        if (jTablePersonnesCompetenceMission.getSelectedRow() != -1) {
            String[] pString = tablePersonnesCompetenceMissionModel.getValueAt(jTablePersonnesCompetenceMission.getSelectedRow(), 0).toString().split(" - ");
            Personne pers;
            try {
                pers = Personne.getPersonneById(Integer.parseInt(pString[0]));
                this.mission.removePersonne(Competence.getCompetenceById(tableCompetencesMissionModel.getValueAt(jTableCompetencesMission.getSelectedRow(), 0).toString()), pers);
                tablePersonnesCompetenceMissionModel.removeRow(jTablePersonnesCompetenceMission.getSelectedRow());
                tableCompetencesMissionModel.setValueAt((int) tableCompetencesMissionModel.getValueAt(jTableCompetencesMission.getSelectedRow(), 3) - 1, jTableCompetencesMission.getSelectedRow(), 3);
                tableCompetencesMissionModel.setValueAt((int) tableCompetencesMissionModel.getValueAt(jTableCompetencesMission.getSelectedRow(), 4) + 1, jTableCompetencesMission.getSelectedRow(), 4);
            } catch (IOException ex) {
                Logger.getLogger(DetailsMissionPlanifiee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonDeletePersonnesCompetenceMissionMouseClicked

    private void jButtonAutoSelectPersonnesCompetenceMissionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAutoSelectPersonnesCompetenceMissionMouseClicked
        // TODO add your handling code here:
        try {
            this.mission.multiSelectionAutoSup();
        } catch (IOException ex) {
            Logger.getLogger(DetailsMissionPlanifiee.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (tableCompetencesMissionModel.getRowCount() != 0) {
            tableCompetencesMissionModel.removeRow(0);
        }
        while (tablePersonnesCompetenceMissionModel.getRowCount() != 0) {
            tablePersonnesCompetenceMissionModel.removeRow(0);
        }

        HashMap<Competence, Integer> competenceMission = this.mission.getPersonnelRequis();
        for (Competence cp : this.mission.getPersonnelAffecte().keySet()) {
            int nb = 0;
            for (Competence libCp : competenceMission.keySet()) {
                if (libCp.getIdCompetence().equals(cp.getIdCompetence())) {
                    nb = competenceMission.get(libCp);
                }
            }
            tableCompetencesMissionModel.addRow(new Object[]{cp.getIdCompetence(), cp.getNomEN(), cp.getNomFR(), this.mission.getPersonnelAffecte().get(cp).size(), nb});
        }
    }//GEN-LAST:event_jButtonAutoSelectPersonnesCompetenceMissionMouseClicked

    private void jButtonCommencerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCommencerMouseClicked
        // TODO add your handling code here:
        HashMap<String, ArrayList<Integer>> affectationsCompetence = new HashMap<>();

        for (Competence cp : this.mission.getPersonnelAffecte().keySet()) {
            ArrayList<Integer> idPersonnes = new ArrayList<>();
            for (Personne personne : this.mission.getPersonnelAffecte().get(cp)) {
                idPersonnes.add(personne.getId());
            }
            affectationsCompetence.put(cp.getIdCompetence(), idPersonnes);
        }
        affectationsMission.put(this.mission.getLibelle(), affectationsCompetence);

        try {
            this.mission.prochainEtat();
            gestionFichiers.writer.sauvegarderAffectationsParMission(affectationsMission);
        } catch (IOException ex) {
            Logger.getLogger(DetailsMissionPreparation.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.dispose();
    }//GEN-LAST:event_jButtonCommencerMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DetailsMissionPlanifiee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetailsMissionPlanifiee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetailsMissionPlanifiee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetailsMissionPlanifiee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DetailsMissionPlanifiee(DetailsMissionPlanifiee.libelle, DetailsMissionPlanifiee.dateDebut, DetailsMissionPlanifiee.duree, DetailsMissionPlanifiee.etat).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(DetailsMissionPlanifiee.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddPersonnesCompetenceMission;
    private javax.swing.JButton jButtonAutoSelectPersonnesCompetenceMission;
    private javax.swing.JButton jButtonCommencer;
    private javax.swing.JButton jButtonDeletePersonnesCompetenceMission;
    private javax.swing.JButton jButtonResetPersonnesCompetenceMission;
    private javax.swing.JButton jButtonSavePersonnesCompetencesMission;
    private javax.swing.JComboBox<String> jComboBoxPersonnesMission;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelLibelleMission;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCompetencesMission;
    private javax.swing.JTable jTablePersonnesCompetenceMission;
    // End of variables declaration//GEN-END:variables
    DefaultTableModel tableCompetencesMissionModel;
    DefaultTableModel tablePersonnesCompetenceMissionModel;
    DefaultComboBoxModel<String> comboBoxPersonnesMissionModel;
}
