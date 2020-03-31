package modele.metier;


public class Promotion {
    private Etudiant etudiant;
    private Annee annee;
    private String option;
    
    public Promotion(Etudiant etudiant,Annee annee, String option){
        this.etudiant = etudiant;
        this.annee = annee;
        this.option = option;
    }
}
