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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import services.AffectationService;
import services.CommandeService;

/**
 * FXML Controller class
 *
 * @author ZeroS TF
 */
public class AfficherAffectationController implements Initializable {
    
    private AjouterAffectationController ajouterAffectationController;

    public void setAjouterAffectationController(AjouterAffectationController ajouterAffectationController) {
        this.ajouterAffectationController = ajouterAffectationController;
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
    private TableView<Affectation> tab;
    @FXML
    private TableColumn<Affectation, String> tab_id;
    @FXML
    private TableColumn<Affectation, String> tab_idproduit;
    @FXML
    private TableColumn<Affectation, String> tab_idcommande;
    @FXML
    private Button btn_supprimer;
    @FXML
    private Button btn_modif;

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
    private void supp(ActionEvent event) {
        Affectation affectation = tab.getSelectionModel().getSelectedItem();
        if (affectation == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Veuillez sélectionner une affectation à supprimer.", ButtonType.OK);
            alert.showAndWait();
        } else {
            try {
                AffectationService affectationService = new AffectationService();
                affectationService.supprimer(affectation.getId_affectation());
                tab.getItems().remove(affectation);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Suppression effectuée.", ButtonType.OK);
                alert.showAndWait();
            } catch (SQLException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Une erreur s'est produite lors de la suppression.", ButtonType.OK);
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void modif(ActionEvent event) throws IOException {
// get the selected Commande object from the TableView
        Affectation affectation = tab.getSelectionModel().getSelectedItem();
        if (affectation == null) {
            // show an error message if no Commande object is selected
            Alert alert = new Alert(Alert.AlertType.WARNING, "Veuillez sélectionner une affectation à modifier.", ButtonType.OK);
            alert.showAndWait();
        } else {
            try {
                // get the FXMLLoader for the AjouterCommandeController
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterAffectation.fxml"));
                Parent root = loader.load();

                // get the AjouterCommandeController and set its reference in this controller
                AjouterAffectationController ajouterAffectationController = loader.getController();
                setAjouterAffectationController(ajouterAffectationController);

                // pass the selected Commande object to the AjouterCommandeController
                ajouterAffectationController.setAffectation(affectation);

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
