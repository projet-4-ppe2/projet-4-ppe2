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
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import vue.JFrameJury;
import modele.metier.Visite;
import modele.dao.DaoJury;

/**
 *
 * @author MrE1
 */
public class CtrlListeJury implements WindowListener, ActionListener, MouseListener {

    private JFrameJury vue;         // LA VUE
    private CtrlPrincipal ctrlPrincipal;
    private List<Visite> lesJurys;        // La liste des clients à afficher

    public CtrlListeJury(JFrameJury vue, CtrlPrincipal ctrl) {
        this.vue = vue;
        this.ctrlPrincipal = ctrl;
        // le contrôleur écoute la vue
        this.vue.addWindowListener(this);
    }

    /**
     * Remplit le modèle de JTable de la vue avec les données provenant de la
     * liste des clients
     */
    public void afficherLeJury() {
        // Affichage de la liste des clients
        List<Visite> lesJurys = null;
        try {
            String str_nom = null;
            String str_stg1 = null;
            String str_stg2 = null;

            lesJurys = DaoJury.selectAll();
            getVue().getModeleTableJurys().setRowCount(0);
            String[] titresColonnes = {"Nom", "Entreprise", "Etudiant", "Date"};
            getVue().getModeleTableJurys().setColumnIdentifiers(titresColonnes);
            String[] ligneDonnees = new String[4];
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            for (Visite unJury : lesJurys) {
                if (unJury.getJury() == true) {
                    str_nom = "1";
                }
                if (unJury.getStage1() == true) {
                    str_stg1 = "1";
                }
                if (unJury.getStage2() == true) {
                    str_stg2 = "1";
                }
                ligneDonnees[0] = str_nom;
                ligneDonnees[1] = str_stg1;
                ligneDonnees[2] = str_stg2;
                ligneDonnees[3] = sdf.format(unJury.getDate());
                getVue().getModeleTableJurys().addRow(ligneDonnees);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(getVue(), "CtrlListeJury - échec de sélection des jurys");
        }

    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

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
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    // ACCESSEURS et MUTATEURS
    public JFrameJury getVue() {
        return vue;
    }

    public void setVue(JFrameJury vue) {
        this.vue = vue;
    }

    public CtrlPrincipal getCtrlPrincipal() {
        return ctrlPrincipal;
    }

    public void setCtrlPrincipal(CtrlPrincipal ctrlPrincipal) {
        this.ctrlPrincipal = ctrlPrincipal;
    }

    public List<Visite> getLesJury() {
        return lesJurys;
    }

    public void setLesJurys(List<Visite> lesJurys) {
        this.lesJurys = lesJurys;
    }

}
