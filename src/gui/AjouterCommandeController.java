/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Commande;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import services.CommandeService;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author ichra
 */
public class AjouterCommandeController implements Initializable {

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
    private TextField txt_nbr;
    @FXML
    private TextField txt_total;
    @FXML
    private TextField txt_idlivraison;

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
        
                if (txt_nbr.getText().isEmpty() && txt_total.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR, "données invalide(s)", ButtonType.OK);
            a.showAndWait();            
        } else {            
            try {
               Commande r1 = new Commande(Integer.parseInt(txt_nbr.getText()),Integer.parseInt(txt_total.getText()),Integer.parseInt((txt_idlivraison.getText()) ));
                                  
                
                CommandeService s = new CommandeService();
                s.ajouter2(r1);                
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Ajout effectué", ButtonType.OK);
                a.showAndWait();                
            } catch (SQLException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
                a.showAndWait();
            }
        }

    }

    @FXML
    private void ModifierCommande(ActionEvent event) throws SQLException {
   

    }

    @FXML
    private void AfficherCommande(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("AfficherCommandeController.fxml"));
        AnchorPane anchorPane;
        anchorPane = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(anchorPane));
        stage.show();
        CommandeService s = new CommandeService();

    }
    
}
