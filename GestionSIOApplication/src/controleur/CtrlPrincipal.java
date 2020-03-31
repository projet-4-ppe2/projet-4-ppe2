package controleur;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import controleur.CtrlAccueil;
import modele.gestion_sio.Etudiant;

/**
 * Le contrôleur principal est chargé de gérer les changement de vue Il propose
 * une méthode publique pour chaque action Ces méthodes sont appelées par les
 * contrôleurs particuliers
 *
 * @author N. Bourgeois
 * @version novembre 2019
 */
public class CtrlPrincipal {

    EntityManager entityManager = null;
    CtrlAccueil ctrlAccueil = null;

    public CtrlPrincipal() {

    }

    // PROCEDURES APPELEES PAR LES CONTROLEURS PARTICULIERS
    /**
     * Proposer à l'utilisateur de mettre fin au programme
     *
     * @param vue vue à l'origine de la demande
     */
    public void quitterApplication(JFrame vue) {
        // Confirmer avant de quitter
        int rep = JOptionPane.showConfirmDialog(vue, "Quitter l'application\nEtes-vous sûr(e) ?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rep == JOptionPane.YES_OPTION) {
            // valider la transaction JPA
            if (entityManager != null) {
                entityManager.getTransaction().commit();
            }
        }
        // mettre fin à l'application
        System.exit(0);
    }

     /**
     * Afficher la vue "Accueil"
     *
     */
    public void afficherAccueil() {
        // Accueil
        ctrlAccueil.getVue().setVisible(true);
    }
    
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public CtrlAccueil getCtrlAccueil() {
        return ctrlAccueil;
    }

    public void setCtrlAccueil(CtrlAccueil ctrlAccueil) {
        this.ctrlAccueil = ctrlAccueil;
    }
    
}
