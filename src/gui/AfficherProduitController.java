/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Commande;
import entities.Produit;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import services.CommandeService;
import services.ProduitService;

/**
 * FXML Controller class
 *
 * @author ichra
 */
public class AfficherProduitController implements Initializable {
    
    private AjouterProduitController ajouterProduitController;
    @FXML
    private Button btn_modif;

    public void setAjouterProduitController(AjouterProduitController ajouterProduitController) {
        this.ajouterProduitController = ajouterProduitController;
    }

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
    private TableView<Produit> tab;
    @FXML
    private TableColumn<Produit, String> tab_id;
    @FXML
    private TableColumn<Produit, String> tab_prix;
    @FXML
    private TableColumn<Produit, String> tab_typepaiment;
    @FXML
    private TableColumn<Produit, String> tab_type;
    @FXML
    private TableColumn<Produit, String> tab_description;
    @FXML
    private Button btn_supprimer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         // initialize table columns
         ProduitService p = new ProduitService();
        ObservableList<Produit> produits = p.getall();
        tab_id.setCellValueFactory(new PropertyValueFactory<>("id_produit"));
        tab_prix.setCellValueFactory(new PropertyValueFactory<>("prix_produit"));
        tab_typepaiment.setCellValueFactory(new PropertyValueFactory<>("type_paiement"));
        tab_type.setCellValueFactory(new PropertyValueFactory<>("type_produit"));
        tab_description.setCellValueFactory(new PropertyValueFactory<>("description_produit"));

        // populate table with data from database
        
        tab.setItems(produits);
    }    

    @FXML
    private void handleClicks(ActionEvent event) {
    }

    @FXML
    private void goToCategoryList(MouseEvent event) {
    }

    @FXML
    private void supp(ActionEvent event) {
        Produit produit = tab.getSelectionModel().getSelectedItem();
    if (produit == null) {
        Alert alert = new Alert(Alert.AlertType.WARNING, "Veuillez sélectionner un produit à supprimer.", ButtonType.OK);
        alert.showAndWait();
    } else {
        try {
            ProduitService p = new ProduitService();
            p.supprimer(produit.getId_produit());
            tab.getItems().remove(produit);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Suppression effectuée.", ButtonType.OK);
            alert.showAndWait();
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Une erreur s'est produite lors de la suppression.", ButtonType.OK);
            alert.showAndWait();
        }
    }
    }

    @FXML
    private void modif(ActionEvent event) {
        // get the selected Commande object from the TableView
    Produit produit = tab.getSelectionModel().getSelectedItem();
    if (produit == null) {
        // show an error message if no Commande object is selected
        Alert alert = new Alert(Alert.AlertType.WARNING, "Veuillez sélectionner un produit à modifier.", ButtonType.OK);
        alert.showAndWait();
    } else {
        try {
            // get the FXMLLoader for the AjouterCommandeController
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterProduit.fxml"));
            Parent root = loader.load();

            // get the AjouterCommandeController and set its reference in this controller
            AjouterProduitController ajouterProduitController = loader.getController();
            setAjouterProduitController(ajouterProduitController);

            // pass the selected Commande object to the AjouterCommandeController
            ajouterProduitController.setProduit(produit);

            // show the AjouterCommandeController
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            // show an error message if an error occurs while loading the AjouterCommandeController
            Alert alert = new Alert(Alert.AlertType.ERROR, "Une erreur s'est produite lors de l'ouverture de la fenêtre de modification.", ButtonType.OK);
            alert.showAndWait();
        }
    }
    }
    
}
