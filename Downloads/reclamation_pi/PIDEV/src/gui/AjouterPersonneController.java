/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Personne;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import services.PersonneService;

/**
 * FXML Controller class
 *
 * @author Skander
 */
public class AjouterPersonneController implements Initializable {

    @FXML
    private TextField nomField;
    @FXML
    private TextField prenomField;
    @FXML
    private TextField ageField;
    @FXML
    private Button ajouterBtn;
    @FXML
    private Button afficherBtn;

    PersonneService ps = new PersonneService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void ajouterPersonne(ActionEvent event) {
        Personne p = new Personne();
        p.setAge(Integer.parseInt(ageField.getText()));
        p.setNom(nomField.getText());
        p.setPrenom(prenomField.getText());
        try {
            ps.ajouter(p);
            reset();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void reset() {
        nomField.setText("");
        prenomField.setText("");
        ageField.setText("");
    }

    @FXML
    private void afficherPersonnes(ActionEvent event) {
        try {
            //navigation
            Parent loader = FXMLLoader.load(getClass().getResource("afficherPersonnes.fxml"));
            nomField.getScene().setRoot(loader);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
