package Classes;

public class Professionnel {

    private int id;
    private Personne personne;
    private boolean ancien_eleve;
    private String fonction;

    public Professionnel(int id, Personne personne, String fonction, boolean ancien_eleve) {
        this.id = id;
        this.personne = personne;
        this.ancien_eleve = ancien_eleve;
        this.fonction = fonction;
    }
}
