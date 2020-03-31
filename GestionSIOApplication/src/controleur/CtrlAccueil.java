/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;
import java.util.List;
import gui.JFrameAccueil;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

/**
 *
 * @author maxen
 */
public class CtrlAccueil implements WindowListener, ActionListener, MouseListener{
    private JFrameAccueil vue;         // LA VUE
    private CtrlPrincipal ctrlPrincipal;
    
    public CtrlAccueil(JFrameAccueil vue, CtrlPrincipal ctrl) {
        this.vue = vue;
        this.ctrlPrincipal = ctrl;
        // le contrôleur écoute la vue
        this.vue.addWindowListener(this);
    }

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

    public JFrameAccueil getVue() {
        return vue;
    }

    public void setVue(JFrameAccueil vue) {
        this.vue = vue;
    }

    public CtrlPrincipal getCtrlPrincipal() {
        return ctrlPrincipal;
    }

    public void setCtrlPrincipal(CtrlPrincipal ctrlPrincipal) {
        this.ctrlPrincipal = ctrlPrincipal;
    }
    
}
