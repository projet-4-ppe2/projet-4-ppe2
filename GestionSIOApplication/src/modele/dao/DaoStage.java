/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import java.sql.*;
import java.util.*;
import modele.metier.Stage;
import modele.dao.Jdbc;
import modele.metier.Etudiant;
import modele.metier.Organisation;
import modele.metier.Professionnel;

/**
 *
 * @author Valentin
 */
public class DaoStage {

    public static Stage selectOne(int id) throws SQLException {
        Stage unStage = null;
        ResultSet rs = null;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM STAGE WHERE ID= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, id);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            unStage = DaoStage.stageFromResultSet(rs);
        }
        return unStage;
    }

    public static List<Stage> selectAll() throws SQLException {
        List<Stage> lesStages = new ArrayList<Stage>();
        Stage unStage = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM STAGE";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            unStage = DaoStage.stageFromResultSet(rs);
            lesStages.add(unStage);
        }
        return lesStages;
    }

    private static Stage stageFromResultSet(ResultSet rs) throws SQLException {
        Stage stg = null;
        int id = rs.getInt("ID");
        java.sql.Date debut = rs.getDate("DEBUT");
        java.sql.Date fin = rs.getDate("FIN");
        String sujet = rs.getString("SUJET");
        int idEtudiant = rs.getInt("ID_ETUDIANT");
        int idProfessionnel = rs.getInt("ID_PROFESSIONNEL");
        int idOrganisation = rs.getInt("ID_ORGANISATION");
        stg = new Stage(id, DaoStage.toUtilDate(debut), DaoStage.toUtilDate(fin), sujet);
        Etudiant etu = DaoEtudiant.selectOne(idEtudiant);
        stg.setIdEtudiant(etu);
        Professionnel pro = DaoProfessionnel.selectOne(idProfessionnel);
        stg.setIdProfessionnel(pro);
        Organisation org = DaoOrganisation.selectOne(idOrganisation);
        stg.setIdOrganisation(org);

        return stg;
    }

    public static java.sql.Date toSqlDate(java.util.Date uneDate) {
        return new java.sql.Date(uneDate.getTime());
    }

    public static java.util.Date toUtilDate(java.sql.Date uneDate) {
        return new java.util.Date(uneDate.getTime());
    }

}
