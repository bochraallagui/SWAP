/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Livraison;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author bochr
 */
public class  LivraisonController implements Initializable {

    @FXML
    private Label dateLabel;
    @FXML
    private Label prixLabel;
    @FXML
    private Label adresseLabel;
    @FXML
    private Label idlivreurLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
      public void setLivraison(Livraison L) {
            dateLabel.setText(L.getDate_livraison());
            prixLabel.setText(String.valueOf(L.getPrix_livraison()));
            adresseLabel.setText(L.getAdresse_livraison());
            idlivreurLabel.setText(String.valueOf(L.getFk_id_livreur()));
            
    }
}

