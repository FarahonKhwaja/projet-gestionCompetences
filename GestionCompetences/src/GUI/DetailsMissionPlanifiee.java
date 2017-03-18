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
import java.util.Iterator;
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

    private final HashMap<String, HashMap<String, Integer>> competencesMission = lecteur.getCompetencesParMission(lecteur.cheminCompetencesMission);
    private final HashMap<String, HashMap<String, ArrayList<Integer>>> affectationsMission = lecteur.getAffectationsParMission(lecteur.cheminCompetencesMission);

    /**
     * Creates new form DetailsMissionPreparation
     */
    public DetailsMissionPlanifiee(String libelle, String dateDebut, String duree, String etat) throws IOException {
        initComponents();
        DetailsMissionPlanifiee.libelle = libelle;
        DetailsMissionPlanifiee.dateDebut = dateDebut;
        DetailsMissionPlanifiee.duree = duree;
        DetailsMissionPlanifiee.etat = etat;
        jLabelLibelleMission.setText(libelle);

        MissionPlanifiee m = MissionPlanifiee.getMissionByLibelle(libelle);
        if (m == null) {
            HashMap<Competence, Integer> personelRequis = new HashMap<>();
            this.mission = new MissionPlanifiee(libelle, dateDebut, duree, etat, personelRequis);
        } else {
            this.mission = new MissionPlanifiee(m.getLibelle(), m.getDateDebut(), m.getDuree(), m.getEtat(), m.getPersonnelRequis());
        }

        System.out.println(affectationsMission);
        this.mission.addCompetence(competencesMission);
        this.mission.addPersonne(affectationsMission);
        HashMap<Competence, ArrayList<Personne>> affectationMission = new HashMap<>();
        HashMap<Competence, Integer> competenceMission = new HashMap<>();
        affectationMission = this.mission.getPersonnelAffecte();
        //System.out.println(affectationMission);
        competenceMission = this.mission.getPersonnelRequis();
        for (Competence cp : affectationMission.keySet()) {
            tablePersonnesCompetencesMissionModel.addRow(new Object[]{cp.getIdCompetence(), cp.getNomEN(), cp.getNomFR(), affectationMission.get(cp)});
        }
        for (Personne personne : lecteur.getPersonnel(lecteur.cheminPersonnel)) {
            comboBoxPersonnesCompetencesMissionModel.addElement(personne.toString());
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
        jButtonSavePersonnesCompetencesMission = new javax.swing.JButton();
        jButtonAddPersonnesCompetenceMission = new javax.swing.JButton();
        comboBoxPersonnesCompetencesMissionModel = new DefaultComboBoxModel<String>(new String [] {});
        jComboBoxCompetencesMission = new javax.swing.JComboBox<>();
        jButtonResetPersonnesCompetenceMission = new javax.swing.JButton();
        jLabelLibelleMission = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePersonnesCompetencesMissionModel = new DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Identifiant", "Libellé EN", "Libellé FR", "Personnel assigné"
            });
            jTableCompetencesMission = new javax.swing.JTable();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setTitle("Détails Mission Planifiee");

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

            jComboBoxCompetencesMission.setModel(comboBoxPersonnesCompetencesMissionModel);

            jButtonResetPersonnesCompetenceMission.setText("Réinitialiser");
            jButtonResetPersonnesCompetenceMission.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jButtonResetPersonnesCompetenceMissionMouseClicked(evt);
                }
            });

            jTableCompetencesMission.setModel(tablePersonnesCompetencesMissionModel);
            jScrollPane2.setViewportView(jTableCompetencesMission);

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabelLibelleMission)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonResetPersonnesCompetenceMission)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBoxCompetencesMission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonAddPersonnesCompetenceMission)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonSavePersonnesCompetencesMission)))
                    .addContainerGap())
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabelLibelleMission)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonSavePersonnesCompetencesMission)
                        .addComponent(jButtonAddPersonnesCompetenceMission)
                        .addComponent(jComboBoxCompetencesMission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonResetPersonnesCompetenceMission))
                    .addContainerGap())
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void jButtonSavePersonnesCompetencesMissionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSavePersonnesCompetencesMissionMouseClicked
        // TODO add your handling code here:
        for (Iterator<Competence> iterator = this.mission.getPersonnelRequis().keySet().iterator(); iterator.hasNext();) {
            Competence cp = iterator.next();
            iterator.remove();
        }

        this.dispose();
    }//GEN-LAST:event_jButtonSavePersonnesCompetencesMissionMouseClicked

    private void jButtonAddPersonnesCompetenceMissionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAddPersonnesCompetenceMissionMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButtonAddPersonnesCompetenceMissionMouseClicked

    private void jButtonResetPersonnesCompetenceMissionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonResetPersonnesCompetenceMissionMouseClicked
        // TODO add your handling code here:
        if (jTableCompetencesMission.getSelectedRow() != -1) {
            tablePersonnesCompetencesMissionModel.setValueAt("",jTableCompetencesMission.getSelectedRow(),3);
        }
    }//GEN-LAST:event_jButtonResetPersonnesCompetenceMissionMouseClicked

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
    private javax.swing.JButton jButtonResetPersonnesCompetenceMission;
    private javax.swing.JButton jButtonSavePersonnesCompetencesMission;
    private javax.swing.JComboBox<String> jComboBoxCompetencesMission;
    private javax.swing.JLabel jLabelLibelleMission;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCompetencesMission;
    // End of variables declaration//GEN-END:variables
    DefaultTableModel tablePersonnesCompetencesMissionModel;
    DefaultComboBoxModel<String> comboBoxPersonnesCompetencesMissionModel;
}
