/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
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


    @FXML
    private TextField id;
     
   
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
    private TextArea Description_produit;
    @FXML
    private TextField Prix_produit;
    @FXML
    private TextField type;
    @FXML
    private TextField Prix_produit1;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }    

    @FXML
    private void  addr(ActionEvent event) throws SQLException {
               if (Prix_produit.getText().isEmpty() && Prix_produit1.getText().isEmpty() && descriptiontf.getText().isEmpty() )
               {
                Alert a = new Alert(Alert.AlertType.ERROR, "données invalide(s)", ButtonType.OK);
            a.showAndWait();   
               }
               else { 
                   try{
       Produit r1 = new Produit(Integer.parseInt(Prix_produit.getText()),Prix_produit1.getText(),type.getText(), Description_produit.getText()); 
        

        ProduitService s= new ProduitService();
        s.ajouter2(r1);    
         Alert a = new Alert(Alert.AlertType.INFORMATION, "Ajout effectué", ButtonType.OK);
            a.showAndWait();   
    }
              catch (SQLException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
                a.showAndWait();
              }
               }
    }
    @FXML
    private void delrec(ActionEvent event) throws SQLException {
       
           ProduitService s = new ProduitService();
       
        s.supprimer(Integer.parseInt(id.getText()));
        
       
       
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
        Connection connection;
    Statement ste;
    connection = MyDB.getInstance().getCon();
        ProduitService s = new ProduitService();
      Produit r = new Produit();  
      r=s.Onerec(Integer.parseInt(id.getText()));
      String requete = "UPDATE produit SET prix_produit=?, type_paiement=?, type_produit=?, description_produit=? where id_produit=?";
            PreparedStatement pst = connection.prepareStatement(requete);
            
            pst.setInt(1,Integer.parseInt(Prix_produit.getText()));
            
            pst.setString(2, type.getText());
            pst.setString(2, Description_produit.getText());
            pst.setString(2, descriptiontf.getText());
            
            pst.setInt(3,Integer.parseInt(id.getText()));
            pst.executeUpdate();
            System.out.println(" Produit Modifiée! ");
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Modif effectue", ButtonType.OK);
            a.showAndWait();  
    }
    

    @FXML
    private void handleClicks(ActionEvent event) {
    }

    @FXML
    private void goToCategoryList(MouseEvent event) {
    }
 

    
    
}
