/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modele.metier.Organisation;
import modele.metier.Personne;
import modele.metier.Professionnel;

/**
 *
 * @author MrE1
 */
class DaoOrganisation {
    
    /**
     * selectOne : lire un enregistrement dans la table CLIENT
     *
     * @param numClient : identifiant conceptuel du client recherché
     * @return une instance de la classe Adresse
     * @throws SQLException
     */
    public static Organisation selectOne(int numOrga) throws SQLException {
        Organisation uneOrga = null;
        ResultSet rs = null;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM ORGANISATION WHERE NUMCLIENT= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, numOrga);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            uneOrga = DaoOrganisation.organisationFromResultSet(rs);
        }
        return uneOrga;
    }

    private static Organisation organisationFromResultSet(ResultSet rs) throws SQLException {
        Organisation orga = null;
        int id = rs.getInt("ID");
        String nom = rs.getString("NOM");
        String adresse = rs.getString("ADRESSE");
        orga = new Organisation(id,nom,adresse);
        return orga;
    }
    
}
