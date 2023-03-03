/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Livraison;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import services.LivraisonService;

/**
 * FXML Controller class
 *
 * @author hp
 */


    


public class AfficherLivraisonController implements Initializable {

    
    @FXML
    private TableView<Livraison> tableLivraison;
    @FXML
    private TableColumn<Livraison,  String> nomC;
    @FXML
    private TableColumn<Livraison,  String> prenomC;
    @FXML
    private TableColumn<Livraison, Integer> numeroC;
    @FXML
    private TableColumn<Livraison,  Integer> prixC;
    @FXML
    private TableColumn<Livraison,  String> dateC;
    @FXML
    private TableColumn<Livraison, String> adresseC;
    @FXML
    private TextField nom_clientField;
    @FXML
    private TextField prenom_clientField;
    @FXML
    private TextField numero_clientField;
    @FXML
    private TextField prix_livraisonField;
    @FXML
    private TextField adresse_livraisonField;
    @FXML
    private TextField id_livreurField;
    @FXML
    private TextField id_pointrelaisField;

    /**
     * Initializes the controller class.
     */
    
    LivraisonService ls = new LivraisonService();
   
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try{
             List<Livraison> livraisons = ls.recuperer();
             ObservableList<Livraison> olp = FXCollections.observableArrayList(livraisons);
            
            
            tableLivraison.setItems(olp);
            
            
            nomC.setCellValueFactory(new PropertyValueFactory<> ("nom_client"));
            prenomC.setCellValueFactory(new PropertyValueFactory<> ("prenom_client"));
            numeroC.setCellValueFactory(new PropertyValueFactory<> ("numero_client"));
            adresseC.setCellValueFactory(new PropertyValueFactory<> ("adresse_livraison"));
            dateC.setCellValueFactory(new PropertyValueFactory<> ("date_livraison"));
            prixC.setCellValueFactory(new PropertyValueFactory<> ("prix_livraison"));
            
            
           
        } catch (SQLException ex) { 
            System.out.println("error" + ex.getMessage());
        }
    }    

    @FXML
    private void getData(MouseEvent event) {
        Livraison u = tableLivraison.getSelectionModel().getSelectedItem();
       
        nom_clientField.setText(u.getNom_client());
        prenom_clientField.setText(u.getPrenom_client());
        numero_clientField.setText(Integer.toString(u.getNumero_client()));
        adresse_livraisonField.setText(u.getAdresse_livraison());
        prix_livraisonField.setText(Integer.toString(u.getPrix_livraison()));
        id_livreurField.setText(Integer.toString(u.getFk_id_livreur()));
        id_pointrelaisField.setText(Integer.toString(u.getFk_id_pointrelais()));
    }

    @FXML
    private void AjouterLivraison(ActionEvent event) {
          try{
             Parent loader = FXMLLoader.load(getClass().getResource("AjouterLivraison.fxml"));
            Scene scene = new Scene(loader);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
    }
    }

    @FXML
    private void ModifierLivraison(ActionEvent event) {
        Livraison u = tableLivraison.getSelectionModel().getSelectedItem();
         Livraison L = new Livraison();
           L.setNom_client(nom_clientField.getText());
           L.setPrenom_client(prenom_clientField.getText());
           L.setNumero_client(Integer.valueOf(numero_clientField.getText()));
           L.setPrix_livraison(Integer.valueOf(prix_livraisonField.getText()));
           L.setAdresse_livraison(adresse_livraisonField.getText());
           L.setFk_id_livreur(Integer.valueOf(id_livreurField.getText()));
           L.setFk_id_pointrelais(Integer.valueOf(id_pointrelaisField.getText()));
           L.setId_livraison(u.getId_livraison());
        
        try {
            
            ls.ModifierLivraison(L);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("modification réussie");
            alert.setHeaderText("La modification a été effectuée avec succès.");
            alert.showAndWait();
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void SupprimerLivraison(ActionEvent event) throws SQLException {
         Livraison u = tableLivraison.getSelectionModel().getSelectedItem();
        
          ls.SupprimerLivraison(u);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("supp");
            alert.setHeaderText("succès.");
            alert.showAndWait();

    }

    @FXML
    private void Refresh(ActionEvent event) {
         try{
             List<Livraison> livraisons = ls.recuperer();
             ObservableList<Livraison> olp = FXCollections.observableArrayList(livraisons);
            
            
            tableLivraison.setItems(olp);
            
            
            nomC.setCellValueFactory(new PropertyValueFactory<> ("nom_client"));
            prenomC.setCellValueFactory(new PropertyValueFactory<> ("prenom_client"));
            numeroC.setCellValueFactory(new PropertyValueFactory<> ("numero_client"));
            adresseC.setCellValueFactory(new PropertyValueFactory<> ("adresse_livraison"));
            dateC.setCellValueFactory(new PropertyValueFactory<> ("date_livraison"));
            prixC.setCellValueFactory(new PropertyValueFactory<> ("prix_livraison"));
            
            
           
        } catch (SQLException ex) { 
            System.out.println("error" + ex.getMessage());
        }
    }

   
    
}
