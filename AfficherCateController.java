/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Categorie;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import services.CategorieS;

/**
 * FXML Controller class
 *
 * @author Maissa
 */
public class AfficherCateController implements Initializable {

    @FXML
    private Button btnutilisateurs;
    @FXML
    private Button btnservices1;
    @FXML
    private Button btnreclamations;
    @FXML
    private Button btnlivraison;
    @FXML
    private Button btndéconnexion;
    @FXML
    private TableView<Categorie> table;
    @FXML
    private TableColumn<Categorie, String> typeC;
    @FXML
    private TextField typeF;

    /**
     * Initializes the controller class.
     */
    
    CategorieS c = new CategorieS();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
             List<Categorie> cat = c.recuperer();
            ObservableList<Categorie> olp = FXCollections.observableArrayList(cat);
            typeC.setCellValueFactory(new PropertyValueFactory<> ("type_categorie"));
            table.setItems(olp);
           
        } catch (SQLException ex) { 
            System.out.println("error" + ex.getMessage());
        }
    }    

    @FXML
    private void getData(MouseEvent event) {
                        Categorie cat=table.getSelectionModel().getSelectedItem();
        typeF.setText(cat.getType_categorie());
    }

    @FXML
    private void AjouterCommande(ActionEvent event) {
         Categorie p = new Categorie();
        if (typeF.getText().isEmpty())
                            {Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("");
                            alert.setHeaderText("type est vide");
                            alert.showAndWait();}
        else{
        p.setType_categorie(typeF.getText());
        try {
            c.ajouter(p);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ajout");
            alert.setHeaderText("succès.");
            alert.showAndWait();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    }

    @FXML
    private void ModifierCommande(ActionEvent event) throws SQLException {
          Categorie cat=table.getSelectionModel().getSelectedItem();
                Categorie cat1=new Categorie(cat.getId_categorie(),typeF.getText());
                c.modifier(cat1);
                
                
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("modif");
            alert.setHeaderText("succès.");
            alert.showAndWait();
    }

    @FXML
    private void SupprimerCommande(ActionEvent event) throws SQLException {
         Categorie u = table.getSelectionModel().getSelectedItem();
        c.supprimer(u);
    }

    @FXML
    private void Refresh(ActionEvent event) {
         try{
             List<Categorie> cat = c.recuperer();
            ObservableList<Categorie> olp = FXCollections.observableArrayList(cat);
            typeC.setCellValueFactory(new PropertyValueFactory<> ("type_categorie"));
            table.setItems(olp);
           
        } catch (SQLException ex) { 
            System.out.println("error" + ex.getMessage());
        }
    }
    
}
