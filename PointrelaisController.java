/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import entities.Pointrelais;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 *
 * @author hp
 */
public class PointrelaisController {
    @FXML
    private Label adressepointrelaisLabel;
    @FXML
    private Label prixpointrelaisLabel;
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
      public void setPointrelais(Pointrelais L) {
          
           prixpointrelaisLabel.setText(L.getAdresse_pointrelais());
           prixpointrelaisLabel.setText(String.valueOf(L.getPrix_pointrelais()));
            
    }

}
