package controleur;

import java.awt.event.*;
import java.util.List;
import modele.metier.*;
import gui.JFrameListeEtudiants;

/**
 * Contrôleur de la vue JFrameListeEtudiants
 * @author N. Bourgeois
 * @version nov 2019
 */
public class CtrlEtudiants implements WindowListener, ActionListener, MouseListener {

    private JFrameListeEtudiants vue;         // LA VUE
    private CtrlPrincipal ctrlPrincipal;
    private List<Etudiant> lesEtudiants;        // La liste des clients à afficher

    public CtrlEtudiants(JFrameListeEtudiants vue, CtrlPrincipal ctrl) {
        this.vue = vue;
        this.ctrlPrincipal = ctrl;
        // le contrôleur écoute la vue
        this.vue.addWindowListener(this);
    }

    /**
     * Remplit le modèle de JTable de la vue avec les données provenant de la liste des clients
     */
    public void afficherLesEtudiants() {
         // Affichage de la liste des clients
        vue.getModeleTableListeEtudiants().clear();
        for (Etudiant clt : lesEtudiants) {
            vue.getModeleTableListeEtudiants().addRow(clt);
        }

    }

    // REACTIONS EVENEMENTIELLES
    @Override
    public void windowOpened(WindowEvent e) {
    }

    /**
     * Réaction au clic sur le bouton de fermeture de la fenêtre
     * on confie la tâche au contrôleur principal
     * @param e 
     */
    @Override
    public void windowClosing(WindowEvent e) {
         ctrlPrincipal.quitterApplication(this.vue);
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        System.out.println("ACTION PERFORMED !");
    }
    
    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    
    // ACCESSEURS et MUTATEURS

    public JFrameListeEtudiants getVue() {
        return vue;
    }

    public void setVue(JFrameListeEtudiants vue) {
        this.vue = vue;
    }

    public CtrlPrincipal getCtrlPrincipal() {
        return ctrlPrincipal;
    }

    public void setCtrlPrincipal(CtrlPrincipal ctrlPrincipal) {
        this.ctrlPrincipal = ctrlPrincipal;
    }

    public List<Etudiant> getLesEtudiants() {
        return lesEtudiants;
    }

    public void setLesEtudiants(List<Etudiant> lesEtudiants) {
        this.lesEtudiants = lesEtudiants;
    } 

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
