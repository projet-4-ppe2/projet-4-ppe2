package gui;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modele.metier.Etudiant;

/**
 * Modèle de données pour le composant JTable de la vue JFrameListeClients
 * On n'utilise pas le modèle par défaut afin de pouvoir y stocker des objes Clent et non des String
 * @author nicolas 
 * @version novembfre 2019
 */
public class ModeleTableListeEtudiants extends AbstractTableModel {

    private String[] lesNomsDeColonnes = {"id", "Nom", "Prenom", "Solde global"};
    private ArrayList<Etudiant> lesEtudiants;
    private final int NB_COLONNES = 4;

    public ModeleTableListeEtudiants(ArrayList<Etudiant> desEtudiants) {
        super();
        lesEtudiants = desEtudiants;
    }

    public ModeleTableListeEtudiants() {
        super();
        lesEtudiants = new ArrayList<>();
    }

    @Override
    public String getColumnName(int column) {
        return lesNomsDeColonnes[column];
    }

    public void addRow(Etudiant unEtudiant) {
        lesEtudiants.add(unEtudiant);
    }

    @Override
    public int getRowCount() {
        return lesEtudiants.size();
    }

    public void clear() {
        lesEtudiants.clear();
    }

    @Override
    public int getColumnCount() {
        return NB_COLONNES;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value;
        Etudiant unEtudiant = getEtudiant(rowIndex);
        switch (columnIndex) {
            case 0: {
                value = unEtudiant.getIdPersonne();
                break;
            }
            case 1: {
                value = unEtudiant.getIdStage();
                break;
            }
            case 2: {
                value = unEtudiant.getIdAnnee();
                break;
            }
            default: {
                value = null;
                break;
            }
        }
        return value;
    }

    public Etudiant getEtudiant(int numLigne) {
        return lesEtudiants.get(numLigne);
    }

}
