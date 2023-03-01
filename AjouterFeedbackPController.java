/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import entities.Feed_backP;
import entities.Produit;
import entities.User;
import java.io.IOException;
import java.net.URL;
import static java.sql.JDBCType.NULL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import services.Feed_backPServie;
import services.ProduitS;
import services.UserServie;

/**
 *
 * @author ASUS
 */
public class AjouterFeedbackPController implements Initializable {
    
    
     @FXML
    private TableView<User> tableUsers;
    @FXML
    private TableColumn<User , String> nomC;
    @FXML
    private TableColumn<User , String> prenomC;
    @FXML
    private TableColumn<User , String> emailC;
    @FXML
    private TableView<Produit> tableProduits;
    @FXML
    private TableColumn<Produit , String> descS;
    @FXML
    private TableColumn<Produit , String> prix;
    
     @FXML
    private TextField nom_prenom;
    @FXML
    private TextField produit;
    @FXML
    ChoiceBox<String> choice = new ChoiceBox<>();

    
    
    
UserServie us = new UserServie();   
Feed_backPServie fs = new Feed_backPServie(); 
ProduitS ss = new ProduitS();
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choice.getItems().addAll("FAVORIS", "NON");
        choice.setValue("FAVORIS");
        nom_prenom.setText("");
        produit.setText("");
        
      try {   List<User> users = us.recuperer();
            ObservableList<User> olp = FXCollections.observableArrayList(users);
            tableUsers.setItems(olp);
            nomC.setCellValueFactory(new PropertyValueFactory<> ("nom"));
            prenomC.setCellValueFactory(new PropertyValueFactory<> ("prenom"));
            emailC.setCellValueFactory(new PropertyValueFactory<> ("email"));

        } catch (SQLException ex) { 
            System.out.println("error" + ex.getMessage());
        }
      try {   List<Produit> Produits = ss.recuperer();
            ObservableList<Produit> olp2 = FXCollections.observableArrayList(Produits);
            tableProduits.setItems(olp2);
            descS.setCellValueFactory(new PropertyValueFactory<> ("description_produit"));
            prix.setCellValueFactory(new PropertyValueFactory<> ("prix_produit"));

        } catch (SQLException ex) { 
            System.out.println("error" + ex.getMessage());
        }
        
    }
    
    
    
    @FXML
    private void getData1(MouseEvent event){
        User u = tableUsers.getSelectionModel().getSelectedItem();
        nom_prenom.setText(u.getNom()+" "+u.getPrenom());        
    }
    
    @FXML
    private void getData2(MouseEvent event){
        Produit s = tableProduits.getSelectionModel().getSelectedItem();
        produit.setText(s.getDescription_produit());  
    }
    
   
    @FXML
    private void valider(ActionEvent event) throws IOException{
         User u = tableUsers.getSelectionModel().getSelectedItem();
        Produit s = tableProduits.getSelectionModel().getSelectedItem();
        Feed_backP f = new Feed_backP();
        
        f.setFk_id_userP(u.getId());
        f.setFk_id_produit(s.getId_produit());
       boolean fav;
        if(choice.getValue().equals("NON"))
            fav=false;
        else fav=true;
        f.setFavorisP(fav);
        
        try {
            fs.ajouter(f);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ajout réussie");
            alert.setHeaderText("L'ajout a été effectuée avec succès.");
            alert.showAndWait();
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
        Parent loader = FXMLLoader.load(getClass().getResource("AfficherFeedbackP.fxml"));
            Scene scene = new Scene(loader);
            Stage stage1 = new Stage();
            stage1.setScene(scene);
            stage1.initStyle(StageStyle.UTILITY);
            stage1.show();
        } catch (SQLException ex) {
            System.out.println("zzzzzzzz"+ex.getMessage());
        } 
    
        
    }
    @FXML
    private void clear(ActionEvent event){
        nom_prenom.setText("");
        produit.setText("");
        
    }
    @FXML
    private void close(ActionEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    
}
