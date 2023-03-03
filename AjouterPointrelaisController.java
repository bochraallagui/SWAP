/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Pointrelais;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import services.PointrelaisService;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AjouterPointrelaisController implements Initializable {

    @FXML
    private Pane pnlOverview;
    @FXML
    private TextField adresse_pointrelaisField;
    @FXML
    private TextField regionField;
    @FXML
    private TextField horaireField;
    
    PointrelaisService ps =new PointrelaisService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterPointrelais(ActionEvent event) {
        Pointrelais P = new Pointrelais();
           P.setAdresse_pointrelais(adresse_pointrelaisField.getText());
           P.setRegion(regionField.getText());
           P.setHoraire(Integer.valueOf(horaireField.getText()));
           
           try {
            
            ps.AjouterPointrelais(P);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ajout réussie");
            alert.setHeaderText("L'ajout a été effectuée avec succès.");
            alert.showAndWait();
            reset();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
           
    }
    
     private void reset() 
    {
        adresse_pointrelaisField.setText("");
        regionField.setText("");
        horaireField.setText("");
        
      
    }
    
}
