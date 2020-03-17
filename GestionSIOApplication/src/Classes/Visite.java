package Classes;

import java.util.Date;

public class Visite {
    private int id;
    private Date date;
    private boolean jury;
    private boolean stage1;
    private boolean stage2;
    private String annee;
    private Professeur professeur;
    private Stage stage;

    public Visite(int id,Date date,boolean jury,boolean stage1, boolean stage2,String annee,Professeur professeur,Stage stage){
        this.id = id;
        this.date = date;
        this.jury = jury;
        this.stage1 = stage1;
        this.stage2 = stage2;
        this.annee = annee;
        this.professeur = professeur;
        this.stage = stage;
    }
}
