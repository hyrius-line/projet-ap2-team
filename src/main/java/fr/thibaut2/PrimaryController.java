package fr.thibaut2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class PrimaryController {

    @FXML
    private TextArea C_login;
    @FXML
    private TextArea C_mdp;



    @FXML
    void switchToSecondary(ActionEvent event) throws IOException {

        System.out.println( C_login.getText());
        System.out.println( C_mdp.getText());

        if (!C_login.getText().equals("") && !C_mdp.getText().equals("")) {

            String dbURL = "jdbc:mysql://localhost:3306/gsb";
            String username = "root";
            String password = "";
            
            try {
            
                Connection conn = DriverManager.getConnection(dbURL, username, password);
            
                if (conn != null) {
                    System.out.println("Connected");

                    //étape 3: créer l'objet statement 
                    Statement stmt = conn.createStatement();
                    String sql = "SELECT ag_matricule, ag_login, ag_password, ag_prenom, ag_nom FROM agents WHERE";
                    ResultSet res = stmt.executeQuery(sql);
                    
                    res.next();
                        //Récupérer par nom de colonne
                        Donnee.matricule = res.getString("ag_matricule");
                        Donnee.login = res.getString("ag_login");
                        Donnee.mdp = res.getString("ag_password");
                        Donnee.prenom = res.getString("ag_prenom");
                        Donnee.nom = res.getString("ag_nom");

                        if (C_login.getText().equals(Donnee.login) && C_mdp.getText().equals(Donnee.mdp)) {

                            //Afficher les valeurs
                            System.out.print(", matricule: " + Donnee.matricule);
                            System.out.print(", login: " + Donnee.login);
                            System.out.print(", password: " + Donnee.mdp);
                            System.out.print(", prénom: " + Donnee.prenom);
                            System.out.print(", nom: " + Donnee.nom);
                            
                            App.setRoot("secondary");
                        }

                } 
            
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}
