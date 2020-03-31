/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modele.metier.Annee;
import modele.metier.Etudiant;
import modele.metier.Personne;

/**
 *
 * @author MrE1
 */
public class DaoEtudiant {

    /**
     * selectOne : lire un enregistrement dans la table CLIENT
     *
     * @param numClient : identifiant conceptuel du client recherché
     * @return une instance de la classe Adresse
     * @throws SQLException
     */
    public static Etudiant selectOne(int numEtu) throws SQLException {
        Etudiant unEtudiant = null;
        ResultSet rs = null;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM ETUDIANT WHERE ID= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, numEtu);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            unEtudiant = DaoEtudiant.etudiantFromResultSet(rs);
        }
        return unEtudiant;
    }

    /**
     * Extrait un enregistrement du "ResultSet" issu de la table CLIENT
     *
     * @param rs : ResultSet lu dans la table CLIENT
     * @return instance de Client, initialisée d'après le premier enregistrement
     * du ResultSet
     * @throws SQLException
     */
    private static Etudiant etudiantFromResultSet(ResultSet rs) throws SQLException {
        Etudiant etu = null;
        int numEtu = rs.getInt("ID");
        int idPers = rs.getInt("ID_PERSONNE");
        int idStage = rs.getInt("ID_STAGE");
        int idAnnee = rs.getInt("ID_ANNEE");
        etu = new Etudiant(numEtu,idStage);
        Personne pers = DaoPersonne.selectOne(idPers);
        Annee annee = DaoAnnee.selectOne(idAnnee);
        etu.setIdPersonne(pers);
        etu.setIdAnnee(annee);
        return etu;
    }

}
