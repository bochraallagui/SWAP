/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Commande;
import entities.Produit;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import services.ProduitService;
import utils.MyDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AjouterProduitController implements Initializable {

    private Produit produitt;

    public Produit getProduit() {
        return produitt;
    }

    public void setProduit(Produit produitt) {
        this.produitt = produitt;
    }

    private TextField descriptiontf;
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
    private TextArea Descriptionproduit;
    @FXML
    private TextField prixproduit;
    @FXML
    private TextField typeproduit;
    @FXML
    private TextField typepaiement;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (produitt != null) {
            Descriptionproduit.setText(produitt.getDescription_produit());
            prixproduit.setText(Integer.toString(produitt.getPrix_produit()));
            typeproduit.setText(produitt.getType_produit());
            typepaiement.setText(produitt.getType_paiement());
        }

    }

    @FXML
    private void addr(ActionEvent event) throws SQLException {
        if (typeproduit.getText().isEmpty() && typepaiement.getText().isEmpty() && Descriptionproduit.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR, "données invalide(s)", ButtonType.OK);
            a.showAndWait();
        } else {
            try {
                Produit r1 = new Produit(Integer.parseInt(prixproduit.getText()), typeproduit.getText(), typepaiement.getText(), Descriptionproduit.getText());

                ProduitService s = new ProduitService();
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
    private void afficher(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("AfficherProduitController.fxml"));
        AnchorPane anchorPane;
        anchorPane = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(anchorPane));
        stage.show();
        ProduitService s = new ProduitService();

    }

    @FXML
    private void modif(ActionEvent event) throws SQLException {
        if (produitt == null) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Aucun produit sélectionné", ButtonType.OK);
            a.showAndWait();
            return;
        }
        ProduitService s = new ProduitService();
        Produit updatedProduit = new Produit(Integer.parseInt(prixproduit.getText()), typeproduit.getText(),
                typepaiement.getText(), Descriptionproduit.getText());
        updatedProduit.setId_produit(produitt.getId_produit());
        s.modifier(updatedProduit);
        Alert a = new Alert(Alert.AlertType.INFORMATION, "Produit modifié", ButtonType.OK);
        a.showAndWait();
    }

    @FXML
    private void handleClicks(ActionEvent event) {
    }

    @FXML
    private void goToCategoryList(MouseEvent event) {
    }

}
