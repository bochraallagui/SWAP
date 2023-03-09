/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Affectation;
import entities.Commande;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import services.AffectationService;
import services.CommandeService;

/**
 * FXML Controller class
 *
 * @author ZeroS TF
 */
public class AjouterAffectationController implements Initializable {
    
    private Affectation affectation;

    public Affectation getAffectation() {
        return affectation;
    }

    public void setAffectation(Affectation affectation) {
        this.affectation = affectation;
    }

    @FXML
    private Button btnutilisateurs;
    @FXML
    private Button btnproduits;
    @FXML
    private Button btnservices;
    @FXML
    private Button btnreclamations;
    @FXML
    private Button btnlivraison;
    @FXML
    private Button btndéconnexion;
    @FXML
    private Pane pnlCustomer;
    @FXML
    private Pane pnlOrders;
    @FXML
    private Pane pnlMenus;
    @FXML
    private Pane pnlOverview;
    @FXML
    private TextField txt_idproduit;
    @FXML
    private TextField txt_idcommande;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleClicks(ActionEvent event) {
    }

    @FXML
    private void goToCategoryList(MouseEvent event) {
    }

    @FXML
    private void AjouterCommande(ActionEvent event) {
        
        if (txt_idproduit.getText().isEmpty() && txt_idcommande.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR, "données invalide(s)", ButtonType.OK);
            a.showAndWait();            
        } else {            
            try {
               Affectation r1 = new Affectation(Integer.parseInt(txt_idproduit.getText()),Integer.parseInt(txt_idcommande.getText()));
                                  
                
                AffectationService s = new AffectationService();
                s.ajouter(r1);                
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Ajout effectué", ButtonType.OK);
                a.showAndWait();                
            } catch (SQLException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
                a.showAndWait();
            }
        }
    }

    @FXML
    private void ModifierCommande(ActionEvent event) {
        if (txt_idproduit.getText().isEmpty() && txt_idcommande.getText().isEmpty()) {
        Alert a = new Alert(Alert.AlertType.ERROR, "données invalide(s)", ButtonType.OK);
        a.showAndWait();            
    } else {            
        try {
            Affectation r1 = new Affectation(Integer.parseInt(txt_idproduit.getText()),Integer.parseInt(txt_idcommande.getText()));
            r1.setId_affectation(affectation.getId_affectation()); // set the id of the existing commande
            
            AffectationService s = new AffectationService();
            s.modifier(r1);                
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Modification effectuée", ButtonType.OK);
            a.showAndWait();                
        } catch (SQLException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
            a.showAndWait();
        }
    }
    }

    @FXML
    private void AfficherCommande(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("AfficherAffectationController.fxml"));
        AnchorPane anchorPane;
        anchorPane = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(anchorPane));
        stage.show();
    }
    
}
