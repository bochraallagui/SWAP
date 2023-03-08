/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Commande;
import entities.Produit;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import services.CommandeService;
import services.ProduitService;

/**
 * FXML Controller class
 *
 * @author ichra
 */
public class AfficherCommandeController implements Initializable {

    @FXML
    private Button user;
    @FXML
    private Button produit;
    @FXML
    private Button service;
    @FXML
    private Button raclamation;
    @FXML
    private Button livraison;
    @FXML
    private Button deconnexion;
    @FXML
    private Pane pnlCustomer;
    @FXML
    private Pane pnlOrders;
    @FXML
    private Pane pnlMenus;
    @FXML
    private Pane pnlOverview;
    @FXML
    private TableView<Commande> tab;
    @FXML
    private TableColumn<Commande, String> tab_id;
    @FXML
    private TableColumn<Commande, String> tab_nbr;
    @FXML
    private TableColumn<Commande, String> tab_total;
    @FXML
    private TableColumn<Commande, String> tab_idlivraison;
    @FXML
    private Button btn_supprimer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // initialize table columns
         CommandeService p = new CommandeService();
        ObservableList<Commande> commandes = p.getall();
        tab_id.setCellValueFactory(new PropertyValueFactory<>("id_commande"));
        tab_nbr.setCellValueFactory(new PropertyValueFactory<>("nbr_produit"));
        tab_total.setCellValueFactory(new PropertyValueFactory<>("total"));
        tab_idlivraison.setCellValueFactory(new PropertyValueFactory<>("fk_id_livraison"));

        // populate table with data from database
        
        tab.setItems(commandes);
    }    

    @FXML
    private void handleClicks(ActionEvent event) {
    }

    @FXML
    private void goToCategoryList(MouseEvent event) {
    }


        @FXML
private void supp(ActionEvent event) {
    Commande commande = tab.getSelectionModel().getSelectedItem();
    if (commande == null) {
        Alert alert = new Alert(Alert.AlertType.WARNING, "Veuillez sélectionner une commande à supprimer.", ButtonType.OK);
        alert.showAndWait();
    } else {
        try {
            CommandeService commandeService = new CommandeService();
            commandeService.supprimer(commande.getId_commande());
            tab.getItems().remove(commande);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Suppression effectuée.", ButtonType.OK);
            alert.showAndWait();
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Une erreur s'est produite lors de la suppression.", ButtonType.OK);
            alert.showAndWait();
        }
    }
}

    
    
}
