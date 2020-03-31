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
import modele.metier.Personne;

/**
 *
 * @author MrE1
 */
class DaoAnnee {
    
    /**
     * selectOne : lire un enregistrement dans la table CLIENT
     *
     * @param numClient : identifiant conceptuel du client recherché
     * @return une instance de la classe Adresse
     * @throws SQLException
     */
    public static Annee selectOne(int numAnnee) throws SQLException {
        Annee uneAnnee = null;
        ResultSet rs = null;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM ANNEE WHERE ID= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, numAnnee);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            uneAnnee = DaoAnnee.anneeFromResultSet(rs);
        }
        return uneAnnee;
    }

    /**
     * Extrait un enregistrement du "ResultSet" issu de la table CLIENT
     *
     * @param rs : ResultSet lu dans la table CLIENT
     * @return instance de Client, initialisée d'après le premier enregistrement
     * du ResultSet
     * @throws SQLException
     */
    private static Annee anneeFromResultSet(ResultSet rs) throws SQLException {
        Annee annee = null;
        int numAnnee = rs.getInt("ID");
        String date_annee = rs.getString("ANNEE");
        annee = new Annee(numAnnee,date_annee);
        return annee;
    }
    
    
}
