/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;



import entities.Pointrelais;
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
import services.PointrelaisService;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AfficherPointrelaisController implements Initializable {

    @FXML
    private TableView<Pointrelais> tablePointrelais;
    @FXML
    private TableColumn<Pointrelais,  String> adresse_pointrelais;
    @FXML
    private TableColumn<Pointrelais,  String> region;
    @FXML
    private TableColumn<Pointrelais,  String> horaire;
    @FXML
    private TextField adresse_pointrelaisField1;
    @FXML
    private TextField regionField1;
    @FXML
    private TextField horaireField1;
    
    PointrelaisService ps = new PointrelaisService();

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       try{
             List<Pointrelais> pointrelais = ps.recuperer();
             ObservableList<Pointrelais> olp = FXCollections.observableArrayList(pointrelais);
            
            
            tablePointrelais.setItems(olp);
            
            
            adresse_pointrelais.setCellValueFactory(new PropertyValueFactory<> ("adresse_pointrelais"));
            region.setCellValueFactory(new PropertyValueFactory<> ("region"));
            horaire.setCellValueFactory(new PropertyValueFactory<> ("horaire"));
            
            
            
           
        } catch (SQLException ex) { 
            System.out.println("error" + ex.getMessage());
        }
    }
    
    
    @FXML
    private void getData(MouseEvent event) {
      Pointrelais u = (Pointrelais) tablePointrelais.getSelectionModel().getSelectedItem();
       
        adresse_pointrelaisField1.setText(u.getAdresse_pointrelais());
        regionField1.setText(u.getRegion());
        horaireField1.setText(Integer.toString(u.getHoraire()));
        
    }    

   

    @FXML
    private void AjouterPointrelais(ActionEvent event) {
       
        try{
             Parent loader = FXMLLoader.load(getClass().getResource("AjouterPointrelais.fxml"));
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
    private void ModifierPointrelais(ActionEvent event) {
        
        Pointrelais u = tablePointrelais.getSelectionModel().getSelectedItem();
         Pointrelais P = new Pointrelais();
           P.setAdresse_pointrelais(adresse_pointrelaisField1.getText());
           P.setRegion(regionField1.getText());
           P.setHoraire(Integer.valueOf(horaireField1.getText()));
           P.setId_pointrelais(u.getId_pointrelais());
        
        try {
            
            ps.ModifierPointrelais(P);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ajout réussie");
            alert.setHeaderText("L'ajout a été effectuée avec succès.");
            alert.showAndWait();
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void SupprimerPointrelais(ActionEvent event) throws SQLException {
         Pointrelais u = (Pointrelais) tablePointrelais.getSelectionModel().getSelectedItem();
        
          ps.SupprimerPointrelais(u);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("supp");
            alert.setHeaderText("succès.");
            alert.showAndWait();
    }
    
    @FXML
    private void RefreshP(ActionEvent event) {
        try{
             List<Pointrelais> pointrelais = ps.recuperer();
             ObservableList<Pointrelais> olp = FXCollections.observableArrayList(pointrelais);
            
            
            tablePointrelais.setItems(olp);
            
            
            adresse_pointrelais.setCellValueFactory(new PropertyValueFactory<> ("adresse_pointrelais"));
            region.setCellValueFactory(new PropertyValueFactory<> ("region"));
            horaire.setCellValueFactory(new PropertyValueFactory<> ("horaire"));
            
            
           
        } catch (SQLException ex) { 
            System.out.println("error" + ex.getMessage());
        }
    }
    }
    

