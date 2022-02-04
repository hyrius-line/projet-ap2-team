package fr.thibaut2;
import java.io.IOException;

import javafx.fxml.FXML;


public class SecondaryController {

    //étape 3: créer l'objet statement 
    String sql = "SELECT ag_matricule FROM agents WHERE ag_prenom ";

    @FXML
    private void switchToThird() throws IOException {
        App.setRoot("primary");
    }
}