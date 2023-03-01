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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class AfficherFeedbackController implements Initializable{
     @FXML
    private TableView<User> tableUsers;
    @FXML
    private TableColumn<User , String> nomC;
    @FXML
    private TableColumn<User , String> prenomC;
    @FXML
    private TableColumn<User , String> emailC;
    @FXML
    private TableView<Feed_back> tableFeedback;
    @FXML
    private TableColumn<Feed_back , Boolean> favorisC;
    
    @FXML
    ChoiceBox<String> choiceS = new ChoiceBox<>();
    
    @FXML
    private TextField service;
    @FXML
    ChoiceBox<String> choice = new ChoiceBox<>();

    Feed_backServie fs =new Feed_backServie();
    UserServie us = new UserServie();
    ServiceS ss= new ServiceS();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        choice.getItems().addAll("FAVORIS", "NON");
        choice.setValue("FAVORIS");
        service.setText("");
        
        List<Service> services;
         try {
             services = ss.recuperer();
         
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Service s : services) {
            items.add(s.getDescription_service());
        }
        choiceS.setItems(items);
        } catch (SQLException ex) {
             Logger.getLogger(AfficherFeedbackController.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
    
    
    @FXML
    private void close(ActionEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    
     @FXML
    private void retour(ActionEvent event) {
         try{
             Parent loader = FXMLLoader.load(getClass().getResource("afficher.fxml"));
            Scene scene = new Scene(loader);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            Stage stage1 = (Stage)((Node) event.getSource()).getScene().getWindow();
              stage1.close();
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @FXML
    private void getS(MouseEvent event) throws SQLException{
        String s=choiceS.getSelectionModel().getSelectedItem();
        System.out.println(s);
        List<Service> services = ss.recuperer();
        List<Feed_back> feedbacks1 =fs.recuperer();
        List<Feed_back> feedbacks =new ArrayList<>();
        List<User> users =new ArrayList<>();
        
        for (Service se : services) {
        if(se.getDescription_service().equals(s))
        {
            int ids=se.getId_service();
          
        for (Feed_back fe : feedbacks1) {
            
        if(fe.getFk_id_service()== ids)
        {
            int idu =fe.getFk_id_user();
            int idf =fe.getId_feedback();
         
        User u = new User(idu);
        users.add(u);
        Feed_back f= new Feed_back(idf);
        feedbacks.add(f);
             
        }}
        }
        List<User> u =us.afficherPersonne(users);
            ObservableList<User> olp2 = FXCollections.observableArrayList(u);
            tableUsers.setItems(olp2);
            nomC.setCellValueFactory(new PropertyValueFactory<> ("nom"));
            prenomC.setCellValueFactory(new PropertyValueFactory<> ("prenom"));
            emailC.setCellValueFactory(new PropertyValueFactory<> ("email"));
            
         List<Feed_back> feed_backs = fs.afficher(feedbacks);
            ObservableList<Feed_back> olp3 = FXCollections.observableArrayList(feed_backs);
            tableFeedback.setItems(olp3);
            favorisC.setCellValueFactory(new PropertyValueFactory<> ("favoris"));
       
        }
       
    }
   @FXML
    private void getF(MouseEvent event){
        
        String s=choiceS.getSelectionModel().getSelectedItem();
  
        service.setText(s);
    }
    
     @FXML
    private void ajouter(ActionEvent event) {
         try{
             Parent loader = FXMLLoader.load(getClass().getResource("AjouterFeedback.fxml"));
            Scene scene = new Scene(loader);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            Stage stage1 = (Stage)((Node) event.getSource()).getScene().getWindow();
              stage1.close();
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
 
    @FXML
    private void modifier(ActionEvent event) throws SQLException {
         Feed_back f = tableFeedback.getSelectionModel().getSelectedItem();
       
       boolean fav;
        if(choice.getValue().equals("NON"))
            fav=false;
        else fav=true;
        f.setFavoris(fav);
         Feed_back f1 = new Feed_back(f.getId_feedback(),fav);
        fs.modifier(f1);
                        
     
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("modif");
            alert.setHeaderText("succès.");
            alert.showAndWait();
     
        service.setText("");
       
    }
    
       
     @FXML
    private void supprimer(ActionEvent event) throws SQLException {
        Feed_back f = tableFeedback.getSelectionModel().getSelectedItem();
        fs.supprimer(f);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("supp");
            alert.setHeaderText("succès.");
            alert.showAndWait();
    }
    
    }
