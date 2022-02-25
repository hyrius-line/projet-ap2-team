package fr.thibaut2;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
public class SecondaryController {

    @FXML
    private Label Text_U;

    @FXML
    private void switchToPrimary() throws IOException {
        
        Text_U.setText("coucou " + Donnee.prenom +" "+ Donnee.nom);

        
    }
}