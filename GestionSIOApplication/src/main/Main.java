package main;

import controleur.CtrlListeJury;
import controleur.CtrlPrincipal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import modele.metier.Visite;
import vue.JFrameJury;


public class Main {

    
    public static void main(String[] args) {
        
        CtrlPrincipal leControleurPrincipal;
        JFrameJury vueListeJury;
        CtrlListeJury leControleurListeJury;
        
        EntityManager em;
        Query query;
        List<Visite> desJurys;
        
        // PREPARATION DES DONNEES
        em = Persistence.createEntityManagerFactory("GestionSIOApplicationPU").createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        Query req = em.createQuery("SELECT v FROM VISITE v ");
        desJurys = (List<Visite>) req.getResultList();

        // Instanciation des contrôleurs et de la vue 
        leControleurPrincipal = new CtrlPrincipal();
        leControleurPrincipal.setEntityManager(em);
        
        //  1- liste des Jurys
        vueListeJury = new JFrameJury();
        leControleurListeJury = new CtrlListeJury(vueListeJury, leControleurPrincipal);
        leControleurPrincipal.setCtrlListeJury(leControleurListeJury);

    }
}
