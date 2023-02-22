/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Personne;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Skander
 */
public class PersonneController implements Initializable {

    @FXML
    private Label nomPrenomLabel;
    @FXML
    private Label ageLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setPersonne(Personne p) {
        nomPrenomLabel.setText(p.getPrenom() + " " + p.getNom());
        ageLabel.setText(String.valueOf(p.getAge()) + "ans");
    }
}
