/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author maxen
 */
public class JFrameAccueil extends javax.swing.JFrame {
    /**
     * Creates new form JFrameAccueil
     */    
    public JFrameAccueil() {
        initComponents();
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonEtudiant = new javax.swing.JButton();
        jButtonAdministrateur = new javax.swing.JButton();
        jButtonProfesseur = new javax.swing.JButton();
        jLabelTitre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonEtudiant.setText("Etudiant");
        jButtonEtudiant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEtudiantActionPerformed(evt);
            }
        });

        jButtonAdministrateur.setText("Administrateur");
        jButtonAdministrateur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdministrateurActionPerformed(evt);
            }
        });

        jButtonProfesseur.setText("Professeur");
        jButtonProfesseur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProfesseurActionPerformed(evt);
            }
        });

        jLabelTitre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelTitre.setText("Gestion SIO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jButtonEtudiant)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTitre)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAdministrateur)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(jButtonProfesseur)
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabelTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEtudiant)
                    .addComponent(jButtonAdministrateur)
                    .addComponent(jButtonProfesseur))
                .addGap(79, 79, 79))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEtudiantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEtudiantActionPerformed
        JFrameEtudiant JFrameE= new JFrameEtudiant();
        JFrameE.setVisible(true);
        this.setVisible(false);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButtonEtudiantActionPerformed

    private void jButtonProfesseurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProfesseurActionPerformed
        JFrameProfesseur JFrameP= new JFrameProfesseur();
        JFrameP.setVisible(true);
        this.setVisible(false);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.dispose();    }//GEN-LAST:event_jButtonProfesseurActionPerformed

    private void jButtonAdministrateurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdministrateurActionPerformed
        JFrameAdministrateur JFrameA = new JFrameAdministrateur();
        JFrameA.setVisible(true);
        this.setVisible(false);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButtonAdministrateurActionPerformed

    
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
            java.util.logging.Logger.getLogger(JFrameAccueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameAccueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameAccueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameAccueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameAccueil().setVisible(true);
            }
        });
    }

    public JButton getjButtonAdministrateur() {
        return jButtonAdministrateur;
    }

    public void setjButtonAdministrateur(JButton jButtonAdministrateur) {
        this.jButtonAdministrateur = jButtonAdministrateur;
    }

    public JButton getjButtonEtudiant() {
        return jButtonEtudiant;
    }

    public void setjButtonEtudiant(JButton jButtonEtudiant) {
        this.jButtonEtudiant = jButtonEtudiant;
    }

    public JButton getjButtonProfesseur() {
        return jButtonProfesseur;
    }

    public void setjButtonProfesseur(JButton jButtonProfesseur) {
        this.jButtonProfesseur = jButtonProfesseur;
    }

    public JLabel getjLabelTitre() {
        return jLabelTitre;
    }

    public void setjLabelTitre(JLabel jLabelTitre) {
        this.jLabelTitre = jLabelTitre;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdministrateur;
    private javax.swing.JButton jButtonEtudiant;
    private javax.swing.JButton jButtonProfesseur;
    private javax.swing.JLabel jLabelTitre;
    // End of variables declaration//GEN-END:variables

}
