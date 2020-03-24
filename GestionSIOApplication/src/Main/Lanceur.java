/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import gui.JFrameAccueil;
import gui.JFrameAdministrateur;
import gui.JFrameListeEtudiants;

import controleur.CtrlPrincipal;
import controleur.CtrlListeEtudiants;

import modele.gestion_sio.Etudiant;

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
        CtrlListeEtudiants leControleurListeEtudiants;
        //les vues
        JFrameAccueil vueListeAccueil;
        JFrameAdministrateur vueFicheAdministrateur;
        JFrameListeEtudiants vueListeEtudiants;

        //Entity Manager
        EntityManager em;
        Query query;
        List<Etudiant> desEtudiants;

        // PREPARATION DES DONNEES
        em = Persistence.createEntityManagerFactory("GestionSIOApplication_PU").createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        Query req = em.createQuery("SELECT e FROM Etudiant e ");
        desEtudiants = (List<Etudiant>) req.getResultList();
        
        // Instanciation des contrôleurs et de la vue 
        leControleurPrincipal = new CtrlPrincipal();
        leControleurPrincipal.setEntityManager(em);
        
        //  1- liste des etudiants
        vueListeEtudiants = new JFrameListeEtudiants();
        leControleurListeEtudiants = new CtrlListeEtudiants(vueListeEtudiants, leControleurPrincipal);
        leControleurPrincipal.setCtrlListeClients(leControleurListeEtudiants);
    }
    
}
