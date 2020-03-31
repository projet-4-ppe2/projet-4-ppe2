package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modele.metier.Personne;
import modele.metier.Professeur;

/**
 *
 * @author MrE1
 */
public class DaoProf {
    
    /**
     * selectOne : lire un enregistrement dans la table CLIENT
     *
     * @param numClient : identifiant conceptuel du client recherché
     * @return une instance de la classe Adresse
     * @throws SQLException
     */
    public static Professeur selectOne(int numProf) throws SQLException {
        Professeur unProf = null;
        ResultSet rs = null;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM PROFESSEUR WHERE ID= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, numProf);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            unProf = DaoProf.professeurFromResultSet(rs);
        }
        return unProf;
    }
    
    /**
     * Extrait un enregistrement du "ResultSet" issu de la table CLIENT
     *
     * @param rs : ResultSet lu dans la table CLIENT
     * @return instance de Client, initialisée d'après le premier enregistrement
     * du ResultSet
     * @throws SQLException
     */
    private static Professeur professeurFromResultSet(ResultSet rs) throws SQLException {
        Professeur prf = null;
        int numProf = rs.getInt("ID");
        int idPersonne = rs.getInt("ID_PERSONNE");
        prf = new Professeur(numProf);
        Personne pers = DaoPersonne.selectOne(idPersonne);
        prf.setIdPersonne(pers);
        return prf;
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
