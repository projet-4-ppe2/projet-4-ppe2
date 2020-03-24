// copyright by https://www.codejava.net
package csv;

import java.io.*;
import java.sql.*;

 
public class csv {
 
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/gestion_sio";
        String username = "root";
        String password = "";
 
        String csvFilePath = "D:\\Valentin\\Desktop\\ExemplesExportsCSV_V2\\personne.csv";
 
        int batchSize = 20;
 
        Connection connection = null;
 
        try {
 
            connection = DriverManager.getConnection(jdbcURL, username, password);
            connection.setAutoCommit(false);
 
            String sql = "INSERT INTO personne ( id, nom, prenom, email, telephone, civilite, ville, adresse, codePostal) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
 
            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
            String lineText = null;
 
            int count = 0;
 
            lineReader.readLine(); // skip header line
 
            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                String id = data[0];
                String nom = data[1];
                String prenom = data[2];
                String email = data[3];
                String telephone = data[4];
                String civilite = data[5];
                String ville = data[6];
                String adresse = data[7];
                String codePostale = data.length == 9 ? data[8] : "";
 
                statement.setString(1, id);
                
                statement.setString(2, nom);
 
                statement.setString(3, prenom);
 
                statement.setString(4, email);
 
                statement.setString(5, telephone);
                
                statement.setString(6, civilite);
                
                statement.setString(7, ville);
                
                statement.setString(8, adresse);
                
                statement.setString(9, codePostale);
 
                statement.addBatch();
 
                if (count % batchSize == 0) {
                    statement.executeBatch();
                }
            }
 
            lineReader.close();
 
            // execute the remaining queries
            statement.executeBatch();
 
            connection.commit();
            connection.close();
 
        } catch (IOException ex) {
            System.err.println(ex);
        } catch (SQLException ex) {
            ex.printStackTrace();
 
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
 
    }
}