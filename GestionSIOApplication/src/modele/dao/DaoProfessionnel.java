/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modele.metier.Etudiant;
import modele.metier.Organisation;
import modele.metier.Personne;
import modele.metier.Professionnel;
import modele.metier.Stage;

/**
 *
 * @author MrE1
 */
class DaoProfessionnel {

    /**
     * selectOne : lire un enregistrement dans la table CLIENT
     *
     * @param numClient : identifiant conceptuel du client recherché
     * @return une instance de la classe Adresse
     * @throws SQLException
     */
    public static Professionnel selectOne(int numClient) throws SQLException {
        Professionnel unprofessionnel = null;
        ResultSet rs = null;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM PROFESSIONNEL WHERE NUMCLIENT= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, numClient);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            unprofessionnel = DaoProfessionnel.professionnelFromResultSet(rs);
        }
        return unprofessionnel;
    }

    private static Professionnel professionnelFromResultSet(ResultSet rs) throws SQLException {
        Professionnel professionnel = null;
        int id = rs.getInt("ID");
        int idPersonne = rs.getInt("ID_PERSONNE");
        boolean anc_ele = rs.getBoolean("ANCIEN_ELEVE");
        String fnc = rs.getString("FONCTION");
        professionnel = new Professionnel(id,anc_ele,fnc );
        Personne pers = DaoPersonne.selectOne(idPersonne);
        professionnel.setIdPersonne(pers);
        return professionnel;
    }

}
