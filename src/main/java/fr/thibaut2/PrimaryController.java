package fr.thibaut2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PrimaryController {


    @FXML
    void switchToSecondary(ActionEvent event) {
        String dbURL = "jdbc:mysql://localhost:3306/gsb";
        String username = "root";
        String password = "";
        
        try {
        
            Connection conn = DriverManager.getConnection(dbURL, username, password);
        
            if (conn != null) {
                System.out.println("Connected");

                //étape 3: créer l'objet statement 
                Statement stmt = conn.createStatement();
                String sql = "SELECT ag_prenom, ag_nom FROM agents";
                ResultSet res = stmt.executeQuery(sql);
                
                while(res.next()){
                    //Récupérer par nom de colonne
                    String prenom = res.getString("ag_prenom");
                    String nom = res.getString("ag_nom");

                    //Afficher les valeurs
                    System.out.print(", prénom: " + prenom);
                    System.out.print(", nom: " + nom);
            }
        } 
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private Label Salutation;
    
}
