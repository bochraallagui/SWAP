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
public class AfficherCommandeController implements Initializable {

    private AjouterCommandeController ajouterCommandeController;
    @FXML
    private Button btn_export;

    public void setAjouterCommandeController(AjouterCommandeController ajouterCommandeController) {
        this.ajouterCommandeController = ajouterCommandeController;
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
    @FXML
    private Button btn_modif;

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

    @FXML
    private void modif(ActionEvent event) {
        // get the selected Commande object from the TableView
        Commande commande = tab.getSelectionModel().getSelectedItem();
        if (commande == null) {
            // show an error message if no Commande object is selected
            Alert alert = new Alert(Alert.AlertType.WARNING, "Veuillez sélectionner une commande à modifier.", ButtonType.OK);
            alert.showAndWait();
        } else {
            try {
                // get the FXMLLoader for the AjouterCommandeController
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterCommande.fxml"));
                Parent root = loader.load();

                // get the AjouterCommandeController and set its reference in this controller
                AjouterCommandeController ajouterCommandeController = loader.getController();
                setAjouterCommandeController(ajouterCommandeController);

                // pass the selected Commande object to the AjouterCommandeController
                ajouterCommandeController.setCommande(commande);

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

    @FXML
    private void export(ActionEvent event) {
        try {
            new CommandeService().exportToExcel();
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Export to Excel");
            alert.setHeaderText("Export to Excel");
            alert.setContentText("An error occurred while exporting the data to an Excel file.");
            alert.showAndWait();
        }
    }

}
