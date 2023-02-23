/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Livraison;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import services.LivraisonService;

/**
 * FXML Controller class
 *
 * @author Skander
 */
public class AjouterLivraisonController implements Initializable {

    @FXML
    private TextField id_livreurField;
    @FXML
    private TextField date_livraisonField;
    @FXML
    private TextField prix_livraisonField;
    @FXML
    private TextField adresse_livraisonField;
    @FXML
    private Button ajouterBtn;
    @FXML
    private Button afficherBtn;

    LivraisonService ls = new LivraisonService();

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void AjouterLivraison(ActionEvent event) {
        Livraison L = new Livraison();
         L.setDate_livraison(date_livraisonField.getText());
        L.setPrix_livraison(Integer.parseInt(prix_livraisonField.getText()));
        L.setAdresse_livraison(adresse_livraisonField.getText());
        L.setFk_id_livreur(Integer.parseInt(id_livreurField.getText()));
        
        try {
            ls.AjouterLivraison(L);
            reset();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void reset() {
        date_livraisonField.setText("");
        prix_livraisonField.setText("");
        adresse_livraisonField.setText("");
        id_livreurField.setText("");
    }

    @FXML
    private void AfficherLivraisons(ActionEvent event) {
        try {
            //navigation
            Parent loader = FXMLLoader.load(getClass().getResource("AfficherLivraisons.fxml"));
            date_livraisonField.getScene().setRoot(loader);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
