package Classes;

import java.util.Date;

public class Stage {

    private int id;
    private Etudiant etudiant;
    private Professionnel professionnel;
    private Organisation organisation;
    private Date debut;
    private Date fin;
    private String sujet;

    public Stage(int id, Etudiant etudiant, Professionnel professionnel, Organisation organisation,Date debut,Date fin,String sujet) {
        this.id = id;
        this.etudiant = etudiant;
        this.professionnel = professionnel;
        this.organisation = organisation;
        this.debut = debut;
        this.fin = fin;
        this.sujet = sujet;

    }
}
