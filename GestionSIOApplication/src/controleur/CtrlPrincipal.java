/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandre
 */
public class CtrlPrincipal {

    EntityManager entityManager;
    CtrlVisite ctrlVisite;
    CtrlEtudiant ctrlEtudiant;

    // PROCEDURES APPELEES PAR LES CONTROLEURS PARTICULIERS
    /**
     * Proposer à l'utilisateur de mettre fin au programme
     *
     * @param vue vue à l'origine de la demande
     */
    public void quitterApplication() {
        // Confirmer avant de quitter
        int rep = JOptionPane.showConfirmDialog(null, "Quitter l'application\nEtes-vous sûr(e) ?", "AGENCEB", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rep == JOptionPane.YES_OPTION) {
            // mettre fin à l'application
            System.exit(0);
        }
    }
    
    public void afficherLeJury() {
        this.ctrlVisite.getVue().setVisible(true);
        this.ctrlEtudiant.getVue().setVisible(false);
    }
    
    public void afficherLesEtudiants() {
        this.ctrlVisite.getVue().setVisible(false);
        this.ctrlEtudiant.getVue().setVisible(true);
    }
    

    public CtrlVisite getCtrlJury() {
        return ctrlVisite;
    }

    public void setCtrlJury(CtrlVisite ctrlVisite) {
        this.ctrlVisite = ctrlVisite;
    }
    
    public CtrlEtudiant getCtrlEtudiant() {
        return ctrlEtudiant;
    }

    public void setCtrlEtudiant(CtrlEtudiant ctrlEtudiant) {
        this.ctrlEtudiant = ctrlEtudiant;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
