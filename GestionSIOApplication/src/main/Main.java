package main;

import controleur.CtrlVisite;
import controleur.CtrlPrincipal;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modele.dao.Jdbc;
import vue.JFrameJury;
import vue.JFrameAccueil;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Jdbc.creer("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:", "@localhost:1521:XE", "", "btssio", "btssio");
        Jdbc.creer("jdbc:mysql:", "//localhost/", "GESTION_SIO", "gestion_sio_user", "secret");
        try {
            Jdbc.getInstance().connecter();
            CtrlPrincipal leControleurPrincipal = new CtrlPrincipal();
            
            JFrameAccueil VueAccueil = new JFrameAccueil();

            // instanciation contrôleur et vue sur la liste des jurys
            JFrameJury laVueLesJurys = new JFrameJury();
            CtrlVisite leControleurLesJurys = new CtrlVisite(laVueLesJurys, leControleurPrincipal);
            leControleurPrincipal.setCtrlJury(leControleurLesJurys);

            // afficher la vue initiale
            VueAccueil.setVisible(true);

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Main - classe JDBC non trouvée");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Main - échec de connexion");
        }

    }
}
