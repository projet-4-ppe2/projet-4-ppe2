/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import javax.persistence.EntityManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandre
 */
public class CtrlPrincipal {
    
    EntityManager entityManager = null;
    
    // PROCEDURES APPELEES PAR LES CONTROLEURS PARTICULIERS
    /**
     * Proposer à l'utilisateur de mettre fin au programme
     *
     * @param vue vue à l'origine de la demande
     */
    public void quitterApplication(JFrame vue) {
        // Confirmer avant de quitter
        int rep = JOptionPane.showConfirmDialog(vue, "Quitter l'application\nEtes-vous sûr(e) ?", "AGENCEB", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rep == JOptionPane.YES_OPTION) {
            // valider la transaction JPA
            if (entityManager != null) {
                entityManager.getTransaction().commit();
            }
        }
        // mettre fin à l'application
        System.exit(0);
    }
    
    
    
}
