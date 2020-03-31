/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import gui.JFrameAccueil;

import controleur.CtrlPrincipal;
import controleur.CtrlAccueil;


/**
 *
 * @author maxen
 */
public class Lanceur {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //les controleurs
        CtrlPrincipal leControleurPrincipal;
        CtrlAccueil leControleurAccueil;
        //les vues
        JFrameAccueil vueAccueil;

        //Entity Manager
        EntityManager em;
        Query query;

        // PREPARATION DES DONNEES
        em = Persistence.createEntityManagerFactory("GestionSIOApplication_PU").createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        // Instanciation des contrôleurs et de la vue 
        leControleurPrincipal = new CtrlPrincipal();
        leControleurPrincipal.setEntityManager(em);
        
        //  1- Accueil
        vueAccueil = new JFrameAccueil();
        leControleurAccueil = new CtrlAccueil(vueAccueil, leControleurPrincipal);
        leControleurPrincipal.setCtrlAccueil(leControleurAccueil);
        
        leControleurPrincipal.afficherAccueil();        

    }
    
}
