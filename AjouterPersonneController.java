/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.User;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.UserServie;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjouterPersonneController implements Initializable {

    @FXML
    private TextField nomTf;
    @FXML
    private TextField prenomTf;
    @FXML
    private TextField adresseTf;
    @FXML
    private TextField numTf;
    @FXML
    private TextField emailTf;
    
    @FXML
    private PasswordField passwordTf;
    @FXML
    private DatePicker dateTf;

    /**
     * Initializes the controller class.
     */
   @FXML
ChoiceBox<String> choiceBox = new ChoiceBox<>();

        
    UserServie ps = new UserServie();
    
        

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        choiceBox.getItems().addAll("Utilisateur", "livreur");
        choiceBox.setValue("livreur");
    }

    @FXML
    private void ajouterPersonne(ActionEvent event) throws SQLException {
        User p = new User();
            p.setNom(nomTf.getText());
            p.setPrenom(prenomTf.getText());
            p.setRole(choiceBox.getValue());
            p.setAdresse(adresseTf.getText());
            p.setDate_naissance(String.valueOf(dateTf.getValue()));
            p.setNum_tel(Integer.valueOf(numTf.getText()));
            p.setEmail(emailTf.getText());
            p.setPassword(passwordTf.getText());
            
         // Check that required fields are not empty    
            if (nomTf.getText().isEmpty() || prenomTf.getText().isEmpty() || adresseTf.getText().isEmpty() || numTf.getText().isEmpty() || emailTf.getText().isEmpty() || passwordTf.getText().isEmpty() ) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("");
            alert.setHeaderText("data manquante");
            alert.showAndWait();
            }else
                if (emailTf.getText().contains("@"))
                        {if(passwordTf.getText().contains("+") || (passwordTf.getText().contains("/")) ||(passwordTf.getText().contains("*")))
                            {if (numTf.getText().length()== 8)
                                {
                                       
        try {
            ps.ajouter(p);
            //reset();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Ajout réussie");
            alert.setHeaderText("L'ajout a été effectuée avec succès.");
            alert.showAndWait();
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.close();
        } catch (SQLException ex) {
            System.out.println("zzzzzzzz"+ex.getMessage());
        } 
                                    
                                }
                            else{Alert alert = new Alert(AlertType.ERROR);
                            alert.setTitle("");
                            alert.setHeaderText("num_tel doit avoir 8 numero");
                            alert.showAndWait();
                            }
                            }
                        else{Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("");
                        alert.setHeaderText("password doit contenir au moins '/' ou '+' ou '*'");
                        alert.showAndWait();
                        }
                        }
                else{Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("");
                alert.setHeaderText("l'email doit contenir '@'");
                alert.showAndWait();}
                        
                    
           
                               
            
        
    }
/*
 private void reset() {
        nomTf.setText("");
        prenomTf.setText("");
        adresseTf.setText("");
        numTf.setText("");
        emailTf.setText("");
        passwordTf.setText("");
    }

    */
}
