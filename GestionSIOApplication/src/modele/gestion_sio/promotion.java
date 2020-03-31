package modele.gestion_sio;


public class promotion {
    private Etudiant etudiant;
    private Annee annee;
    private String option;
    
    public promotion(Etudiant etudiant,Annee annee, String option){
        this.etudiant = etudiant;
        this.annee = annee;
        this.option = option;
    }
}
