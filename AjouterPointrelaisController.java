/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import static com.sun.webkit.perf.WCFontPerfLogger.reset;
import entities.Pointrelais;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import services.PointrelaisService;

/**
 *
 * @author hp
 */
public class AjouterPointrelaisController {
    @FXML
    private TextField adresse_pointrelaisField;
    @FXML
    private TextField prix_pointrelaisField;
    @FXML
    private Button ajouterpointrelaisBtn;
    @FXML
    private Button afficherpointrelaisBtn;

    PointrelaisService ps = new PointrelaisService() ;
     

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void AjouterPointrelais(ActionEvent event) {
        Pointrelais P = new Pointrelais();
        
        P.setAdresse_pointrelais(adresse_pointrelaisField.getText());
        P.setPrix_pointrelais(Integer.parseInt(prix_pointrelaisField.getText()));
       
        
        try {
            ps.AjouterPointrelais(P);
            reset();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        // Check that required fields are not empty
   
        if (adresse_pointrelaisField.getText().isEmpty() || prix_pointrelaisField.getText().isEmpty() ) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Missing fields");
            alert.setHeaderText("All fields must be filled");
            alert.showAndWait();
            return;
        }
    }
     
    
    
    

    private void reset() {
        adresse_pointrelaisField.setText("");
        prix_pointrelaisField.setText("");
       
    }

    @FXML
    private void AfficherPointrelais(ActionEvent event) {
        try {
            //navigation
            Parent loader = FXMLLoader.load(getClass().getResource("AfficherPointrelais.fxml"));
            adresse_pointrelaisField.getScene().setRoot(loader);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
