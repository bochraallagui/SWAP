/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.User;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import services.UserServie;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AfficherPersController implements Initializable {

   @FXML
    private TableView<User> tableUsers;
    @FXML
    private TableColumn<User , String> nomC;
    @FXML
    private TableColumn<User , String> prenomC;
    @FXML
    private TableColumn<User , String> date_naissanceC;
    @FXML
    private TableColumn<User , String> roleC;
    @FXML
    private TableColumn<User , String> adresseC;
    @FXML
    private TableColumn<User , Integer> num_telC;
    @FXML
    private TableColumn<User , String> emailC;
      @FXML
    private TextField nomTf;
    @FXML
    private TextField prenomTf;
    @FXML
    private PasswordField passwordTf;
    @FXML
    private TextField adresseTf;
    @FXML
    private TextField numTf;
    @FXML
    private VBox VBox;

    /**
     * Initializes the controller class.
     */
    UserServie ps =new UserServie();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          try{
             List<User> users = ps.recuperer();
            ObservableList<User> olp = FXCollections.observableArrayList(users);
            
            tableUsers.setItems(olp);
            
            
            nomC.setCellValueFactory(new PropertyValueFactory<> ("nom"));
            prenomC.setCellValueFactory(new PropertyValueFactory<> ("prenom"));
            roleC.setCellValueFactory(new PropertyValueFactory<> ("role"));
            adresseC.setCellValueFactory(new PropertyValueFactory<> ("adresse"));
            date_naissanceC.setCellValueFactory(new PropertyValueFactory<> ("date_naissance"));
            num_telC.setCellValueFactory(new PropertyValueFactory<> ("num_tel"));
            emailC.setCellValueFactory(new PropertyValueFactory<> ("email"));
            
            
           
        } catch (SQLException ex) { 
            System.out.println("error" + ex.getMessage());
        }
          
    }    

    @FXML
    private void close(ActionEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void ajouter(ActionEvent event) {
         try{
            Parent loader = FXMLLoader.load(getClass().getResource("AjouterPersonne.fxml"));
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
    private void refresh(ActionEvent event) {
        try{
             List<User> users = ps.recuperer();
            ObservableList<User> olp = FXCollections.observableArrayList(users);
            tableUsers.setItems(olp);
            nomC.setCellValueFactory(new PropertyValueFactory<> ("nom"));
            prenomC.setCellValueFactory(new PropertyValueFactory<> ("prenom"));
            roleC.setCellValueFactory(new PropertyValueFactory<> ("role"));
            adresseC.setCellValueFactory(new PropertyValueFactory<> ("adresse"));
            date_naissanceC.setCellValueFactory(new PropertyValueFactory<> ("date_naissance"));
            num_telC.setCellValueFactory(new PropertyValueFactory<> ("num_tel"));
            emailC.setCellValueFactory(new PropertyValueFactory<> ("email"));
           
            
            
    
            
        } catch (SQLException ex) { 
            System.out.println("error" + ex.getMessage());
        }
        
    }
    
    
    @FXML
    private void supprimer(ActionEvent event) throws SQLException {
        User u = tableUsers.getSelectionModel().getSelectedItem();
        ps.supprimer(u);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("supp");
            alert.setHeaderText("succès.");
            alert.showAndWait();
  
    }
    
    
    @FXML
    private void getData(MouseEvent event){
        
        User u = tableUsers.getSelectionModel().getSelectedItem();
       
        nomTf.setText(u.getNom());
        prenomTf.setText(u.getPrenom());
        adresseTf.setText(u.getAdresse());
        numTf.setText(Integer.toString(u.getNum_tel()));
    }
    
    
    @FXML
    private void modifier(ActionEvent event) throws SQLException {
        
   User u = tableUsers.getSelectionModel().getSelectedItem();
       
       
         if (nomTf.getText().isEmpty() || prenomTf.getText().isEmpty() || adresseTf.getText().isEmpty() || numTf.getText().isEmpty() ||  passwordTf.getText().isEmpty() ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("");
            alert.setHeaderText("data manquante");
            alert.showAndWait();
            }else
                
                        if(passwordTf.getText().contains("+") || (passwordTf.getText().contains("/")) ||(passwordTf.getText().contains("*")))
                            {if (numTf.getText().length()== 8)
                                {
                                       
        try {
            int numero =Integer.parseInt(numTf.getText());
        User u1 = new User(u.getId(),nomTf.getText(),prenomTf.getText(),u.getRole(),adresseTf.getText(),numero,u.getEmail(),passwordTf.getText(),u.getDate_naissance());
        ps.modifier(u1);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Modif réussie");
            alert.setHeaderText("Modif a été effectuée avec succès.");
            alert.showAndWait();
            nomTf.setText("");
        prenomTf.setText("");
        adresseTf.setText("");
        numTf.setText("");
        passwordTf.setText("");
        } catch (SQLException ex) {
            System.out.println("zzzzzzzz"+ex.getMessage());
        } 
                                    
                                }
                            else{Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("");
                            alert.setHeaderText("num_tel doit avoir 8 numero");
                            alert.showAndWait();
                            }
                            }
                        else{Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("");
                        alert.setHeaderText("password doit contenir au moins '/' ou '+' ou '*'");
                        alert.showAndWait();
                        }
                    
     
        
    }
}
          

    
    
    

