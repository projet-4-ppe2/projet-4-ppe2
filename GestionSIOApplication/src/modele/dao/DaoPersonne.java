/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modele.metier.Personne;

/**
 *
 * @author MrE1
 */
class DaoPersonne {

    /**
     * selectOne : lire un enregistrement dans la table CLIENT
     *
     * @param numClient : identifiant conceptuel du client recherché
     * @return une instance de la classe Adresse
     * @throws SQLException
     */
    public static Personne selectOne(int numPers) throws SQLException {
        Personne unePersonne = null;
        ResultSet rs = null;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM PERSONNE WHERE ID= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, numPers);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            unePersonne = DaoPersonne.personneFromResultSet(rs);
        }
        return unePersonne;
    }

    /**
     * Extrait un enregistrement du "ResultSet" issu de la table CLIENT
     *
     * @param rs : ResultSet lu dans la table CLIENT
     * @return instance de Client, initialisée d'après le premier enregistrement
     * du ResultSet
     * @throws SQLException
     */
    private static Personne personneFromResultSet(ResultSet rs) throws SQLException {
        Personne pers = null;
        int numPers = rs.getInt("ID");
        String nom = rs.getString("NOM");
        String personne = rs.getString("PERSONNE");
        String email = rs.getString("EMAIL");
        String telephone = rs.getString("TELEPHONE");
        String civilite = rs.getString("CIVILITE");
        String ville = rs.getString("VILLE");
        String adresse = rs.getString("ADRESSE");
        int cdp = rs.getInt("CODEPOSTAL");
        pers = new Personne(numPers, nom, personne, email, telephone, civilite, ville, adresse, cdp);
        return pers;
    }

}
