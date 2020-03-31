/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import modele.Stage;
import modele.Organisation;
import vue.JFrameStage;
import dao.DaoStage;

/**
 *
 * @author Justine
 */
public class CtrlListeStages implements WindowListener, ActionListener {
    
    private JFrameStage vue;         // LA VUE
    private CtrlPrincipal ctrlPrincipal;

    public CtrlListeStages(JFrameStage vue, CtrlPrincipal ctrl) {
        this.vue = vue;
        this.ctrlPrincipal = ctrl;
        // le contrôleur écoute la vue
        this.vue.addWindowListener(this);
       // préparer l'état iniitial de la vue
        List<Stage> lesStages = null;
        try {
            lesStages = DaoStage.selectAll();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(getVue(), "CtrlLesStages - échec de sélection des stages");
        }
        afficherLesStages(lesStages);
    }

    // contrôle de la vue
    /**
     * Remplir le composant JTable avec les stages
     * @param desStages liste des stages à afficher
     */
    private final void afficherLesStages(List<Stage> desStages) {
        getVue().getModeleTableStages().setRowCount(0);
        String[] titresColonnes = {"Nom", "Ville"};
        getVue().getModeleTableStages().setColumnIdentifiers(titresColonnes);
        String[] ligneDonnees = new String[2];
        for (Stage unStage : desStages) {
            ligneDonnees[0] = unStage.getIdOrganisation().getNom();
            ligneDonnees[1] = unStage.getIdOrganisation().getAdresse();
            getVue().getModeleTableStages().addRow(ligneDonnees);            
        }       
    }

    // ACCESSEURS et MUTATEURS
    public JFrameStage getVue() {
        return vue;
    }

    public void setVue(JFrameStage vue) {
        this.vue = vue;
    }

    // REACTIONS EVENEMENTIELLES
    @Override
    public void windowOpened(WindowEvent e) {    }


    @Override
    public void windowClosed(WindowEvent e) {    }

    @Override
    public void windowIconified(WindowEvent e) {    }

    @Override
    public void windowDeiconified(WindowEvent e) {    }

    @Override
    public void windowActivated(WindowEvent e) {    }

    @Override
    public void windowDeactivated(WindowEvent e) {   }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

}
