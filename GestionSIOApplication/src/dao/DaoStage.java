/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import java.util.*;
import modele.Stage;
import dao.Jdbc;
import modele.Organisation;


/**
 *
 * @author Valentin
 */
public class DaoStage {
    public static Stage selectOne(String id) throws SQLException {
        Stage unStage = null;
        ResultSet rs = null;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM STAGE WHERE ID= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, id);
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
        Stage clt = null;
        int id = rs.getInt("ID");
        java.sql.Date debut = rs.getDate("DEBUT");
        java.sql.Date fin = rs.getDate("FIN");
        String sujet = rs.getString("SUJET");
        int idEtudiant = rs.getInt("ID_ETUDIANT");
        int idProfessionnel = rs.getInt("ID_PROFESSIONNEL");
        int idOrganisation = rs.getInt("ID_ORGANISATION");
        clt = new Stage(id, DaoStage.toUtilDate(debut), DaoStage.toUtilDate(fin), sujet);
        Etudiant etu = DaoEtudiant.selectOne(idEtudiant);
        clt.setEtudiant(etu);
        Professionnel pro = DaoProfessionnel.selectOne(idProfessionnel);
        clt.setProfessionnel(pro);
        Organisation org = DaoOrganisation.selectOne(idOrganisation);
        clt.setIdOrganisation(org);
        
        return clt;
    }

public static java.sql.Date toSqlDate(java.util.Date uneDate) {
        return new java.sql.Date(uneDate.getTime());
    }

public static java.util.Date toUtilDate(java.sql.Date uneDate) {
        return new java.util.Date(uneDate.getTime());
    }

}