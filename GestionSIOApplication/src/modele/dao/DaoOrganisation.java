/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import modele.dao.Jdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.metier.Organisation;
import java.util.List;

/**
 *
 * @author Justine
 */
public class DaoOrganisation{
    
    /**
     * Extraction d'une organisation, sur son identifiant
     * @param idOrganisation identifiant
     * @return objet Organisation
     * @throws SQLException 
     */
    public static Organisation selectOne(int idOrganisation) throws SQLException {
        Organisation uneOrganisation = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Organisation WHERE ID= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idOrganisation);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("id");
            String nom = rs.getString("nom");
            String adresse = rs.getString("adresse");
            uneOrganisation = new Organisation(id, nom, adresse);
        }
        return uneOrganisation;
    }
   
    /**
     * Extraction de toutes les organisations
     * @return collection d'organisation
     * @throws SQLException 
     */
    public static List<Organisation> selectAll() throws SQLException {
        List<Organisation> lesOrganisation = new ArrayList<Organisation>();
        Organisation uneOrganisation;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Organisation";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String nom = rs.getString("nom");
            String adresse = rs.getString("adresse");
            uneOrganisation = new Organisation(id, nom, adresse);
            lesOrganisation.add(uneOrganisation);
        }
        return lesOrganisation;
    }

    /**
     * Extraction de toutes les organisations, ordonnées
     * @param cleTri 1=>id ; 2=>adresse
     * @param ordreTri 1=>ASC ; 2=>DESC
     * @return collection d'adresses
     * @throws SQLException 
     */
    public static List<Organisation> selectAll(int cleTri, int ordreTri) throws SQLException {
        List<Organisation> lesOrganisations = new ArrayList<Organisation>();
        Organisation uneOrganisation;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Organisation";
        switch (cleTri) {
            case 1: // Tri par Id
                requete += " ORDER BY id";
                break;
            case 2: // Tri par ville
                requete += " ORDER BY adresse";
                break;
        }
        if (cleTri == 1 || cleTri == 2) {
            switch (ordreTri) {
                case 1: // Tri croissant
                    requete += " ASC";
                    break;
                case 2: // Tri décroissant
                    requete += " DESC";
                    break;
            }
        }
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String nom = rs.getString("nom");
            String adresse = rs.getString("ville");
            uneOrganisation = new Organisation(id, nom, adresse);
            lesOrganisations.add(uneOrganisation);
        }
        return lesOrganisations;
    }

    public static int insert(int idOrganisation, Organisation uneOrganisation) throws SQLException {
        int nb;
        Jdbc jdbc = Jdbc.getInstance();
        String requete;
        ResultSet rs;
        PreparedStatement pstmt;
        requete = "INSERT INTO Organisation (id, nom, adresse) VALUES (?, ?, ?)";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idOrganisation);
        pstmt.setString(2, uneOrganisation.getNom());
        pstmt.setString(3, uneOrganisation.getAdresse());
        nb = pstmt.executeUpdate();
        return nb;
    }

    public static int update(int idOrganisation, Organisation uneOrganisation) throws SQLException {
        int nb;
        Jdbc jdbc = Jdbc.getInstance();
        String requete;
        ResultSet rs;
        PreparedStatement pstmt;
        requete = "UPDATE Organisation SET nom = ? , adresse = ? WHERE ID = ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, uneOrganisation.getNom());
        pstmt.setString(2, uneOrganisation.getAdresse());
        pstmt.setInt(4, idOrganisation);
        nb = pstmt.executeUpdate();
        return nb;
    }

    public static int delete(int idOrganisation) throws SQLException {
        int nb;
        Jdbc jdbc = Jdbc.getInstance();
        String requete;
        ResultSet rs;
        PreparedStatement pstmt;
        requete = "DELETE  FROM Organisation WHERE ID = ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idOrganisation);
        nb = pstmt.executeUpdate();
        return nb;
    }
}
