/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import entities.Feed_back;
import entities.Service;
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
import services.Feed_backServie;
import services.ServiceS;
import services.UserServie;

/**
 *
 * @author ASUS
 */
public class AjouterFeedbackController implements Initializable {
    
    
     @FXML
    private TableView<User> tableUsers;
    @FXML
    private TableColumn<User , String> nomC;
    @FXML
    private TableColumn<User , String> prenomC;
    @FXML
    private TableColumn<User , String> emailC;
    @FXML
    private TableView<Service> tableServices;
    @FXML
    private TableColumn<Service , String> descS;
    @FXML
    private TableColumn<Service , String> dateS;
    
     @FXML
    private TextField nom_prenom;
    @FXML
    private TextField service;
    @FXML
    ChoiceBox<String> choice = new ChoiceBox<>();

    
    
    
UserServie us = new UserServie();   
Feed_backServie fs = new Feed_backServie(); 
ServiceS ss = new ServiceS();
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choice.getItems().addAll("FAVORIS", "NON");
        choice.setValue("FAVORIS");
        nom_prenom.setText("");
        service.setText("");
        
      try {   List<User> users = us.recuperer();
            ObservableList<User> olp = FXCollections.observableArrayList(users);
            tableUsers.setItems(olp);
            nomC.setCellValueFactory(new PropertyValueFactory<> ("nom"));
            prenomC.setCellValueFactory(new PropertyValueFactory<> ("prenom"));
            emailC.setCellValueFactory(new PropertyValueFactory<> ("email"));

        } catch (SQLException ex) { 
            System.out.println("error" + ex.getMessage());
        }
      try {   List<Service> services = ss.recuperer();
            ObservableList<Service> olp2 = FXCollections.observableArrayList(services);
            tableServices.setItems(olp2);
            descS.setCellValueFactory(new PropertyValueFactory<> ("description_service"));
            dateS.setCellValueFactory(new PropertyValueFactory<> ("date_service"));

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
        Service s = tableServices.getSelectionModel().getSelectedItem();
        service.setText(s.getDescription_service());  
    }
    
   
    @FXML
    private void valider(ActionEvent event) throws IOException{
         User u = tableUsers.getSelectionModel().getSelectedItem();
        Service s = tableServices.getSelectionModel().getSelectedItem();
        Feed_back f = new Feed_back();
        
        f.setFk_id_user(u.getId());
        f.setFk_id_service(s.getId_service());
       boolean fav;
        if(choice.getValue().equals("NON"))
            fav=false;
        else fav=true;
        f.setFavoris(fav);
        
        try {
            fs.ajouter(f);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ajout réussie");
            alert.setHeaderText("L'ajout a été effectuée avec succès.");
            alert.showAndWait();
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
        Parent loader = FXMLLoader.load(getClass().getResource("AfficherFeedback.fxml"));
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
        service.setText("");
        
    }
    @FXML
    private void close(ActionEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    
}
