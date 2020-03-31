package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modele.metier.Professeur;
import modele.metier.Stage;
import modele.metier.Visite;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author MrE1
 */
public class DaoJury {

    /**
     * lire tous les enregistrements de la table CLIENT
     *
     * @return une collection d'instances de la classe Client
     * @throws SQLException
     */
    public static List<Visite> selectAll() throws SQLException {
        List<Visite> lesJurys = new ArrayList<Visite>();
        Visite unJury = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Visite";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            unJury = DaoJury.juryFromResultSet(rs);
            lesJurys.add(unJury);
        }
        return lesJurys;
    }

    /**
     * Extrait un enregistrement du "ResultSet" issu de la table CLIENT
     *
     * @param rs : ResultSet lu dans la table CLIENT
     * @return instance de Client, initialisée d'après le premier enregistrement
     * du ResultSet
     * @throws SQLException
     */
    private static Visite juryFromResultSet(ResultSet rs) throws SQLException {
        Visite vis = null;
        int numJury = rs.getInt("NUMJURY"); //id
        int idStage = rs.getInt("ID_STAGE"); //id_stage
        int idProf = rs.getInt("ID_PROFESSEUR"); //id_professeur
        java.sql.Date datestage = rs.getDate("DATEDESTAGE"); //date
        boolean jry = rs.getBoolean("JURY"); //jury
        boolean stg1 = rs.getBoolean("STAGE1"); //stage1
        boolean stg2 = rs.getBoolean("STAGE2"); //stage2
        vis = new Visite(numJury, DaoJury.toUtilDate(datestage), jry, stg1, stg2);
        Stage stg = DaoStage.selectOne(idStage);
        Professeur prf = DaoProf.selectOne(idProf);
        vis.setIdStage(stg);
        vis.setIdProfesseur(prf);
        return vis;
    }

    /**
     * conversion de java.sql.Date vers java.util.Date
     *
     * @param uneDate java.sql.Date
     * @return java.util.Date
     */
    public static java.util.Date toUtilDate(java.sql.Date uneDate) {
        return new java.util.Date(uneDate.getTime());
    }

}
