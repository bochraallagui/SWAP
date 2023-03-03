/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Livraison;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import services.LivraisonService;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AjouterLivraisonController implements Initializable {

    @FXML
    private Pane pnlOverview;
    private TextField nom_clientField;
    private TextField numero_clientField;
    private DatePicker date_livraisonField;
    private TextField id_livreurField;
    private TextField prenom_clientField;
    private TextField prix_livraisonField;
    private TextField adresse_livraisonField;
    private TextField id_pointrelaisField;
    
 LivraisonService ls =new LivraisonService();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void AjouterLivraison(ActionEvent event) {
      Livraison L = new Livraison();
           L.setNom_client(nom_clientField.getText());
           L.setPrenom_client(prenom_clientField.getText());
           L.setNumero_client(Integer.valueOf(numero_clientField.getText()));
           L.setPrix_livraison(Integer.valueOf(prix_livraisonField.getText()));
           L.setDate_livraison(String.valueOf(date_livraisonField.getValue()));
           L.setAdresse_livraison(adresse_livraisonField.getText());
           L.setFk_id_livreur(Integer.valueOf(id_livreurField.getText()));
           L.setFk_id_pointrelais(Integer.valueOf(id_pointrelaisField.getText()));
           
        
        try {
            
            ls.AjouterLivraison(L);
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
        nom_clientField.setText("");
        prenom_clientField.setText("");
        numero_clientField.setText("");
        prix_livraisonField.setText("");
        adresse_livraisonField.setText("");
        id_livreurField.setText("");
        id_pointrelaisField.setText("");
      
    }

    @FXML
    private void AjouterPointrelais(ActionEvent event) {
    }

    
    
}
