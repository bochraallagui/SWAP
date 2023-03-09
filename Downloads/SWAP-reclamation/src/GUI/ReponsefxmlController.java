/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import entities.Reponse;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import services.serviceReponse;
import utils.MyDB;
/**
 * FXML Controller class
 *
 * @author HP
 */
public class ReponsefxmlController implements Initializable {

    @FXML
    private TextField message_repTf;
    @FXML
    private TextField etatTf;
    @FXML
    private TextField idrectf;
     
    @FXML
    private TextField iduser;
    @FXML
    private Text reponse;
    @FXML
    private Text objectif;
    @FXML
    private TextField idrec;
    @FXML
    private TextField idreptf;
    @FXML
    private TextField idadmintf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	 
     
    }    
@FXML
    private void addr(ActionEvent event) throws SQLException {
        if (message_repTf.getText().isEmpty() && etatTf.getText().isEmpty() ) {
            Alert a = new Alert(Alert.AlertType.ERROR, "données invalide(s)", ButtonType.OK);
            a.showAndWait();
        } else {
            try {
                Reponse r1 = new Reponse(Integer.parseInt(idrectf.getText()), message_repTf.getText(),Integer.parseInt(idadmintf.getText()) ,etatTf.getText());

                serviceReponse s = new serviceReponse();
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
    private void delrec(ActionEvent event) throws SQLException {
       
           serviceReponse s = new serviceReponse();
       
        s.supprimer(Integer.parseInt(idreptf.getText()));
        
       
       
               }

    
    
    @FXML
    private void afficher(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
         fxmlLoader.setLocation(getClass().getResource("afficher_reponse_fxml.fxml"));
          AnchorPane anchorPane;
          anchorPane = fxmlLoader.load();
          Stage stage = new Stage();
        stage.setScene(new Scene(anchorPane));
        stage.show();
        serviceReponse s = new serviceReponse();
        
       
        
    }

    @FXML
    private void modif(ActionEvent event) throws SQLException {
        Connection connection;
    Statement ste;
    connection = MyDB.getInstance().getCon();
        serviceReponse s = new serviceReponse();
      Reponse r = new Reponse();  
      r=s.Onerec(Integer.parseInt(idreptf.getText()));
      String requete = "UPDATE reponse SET message_rep=?, etat=?, fk_id_admin=?  where id_reponse=?";
            PreparedStatement pst = connection.prepareStatement(requete);
            
        
            pst.setString(1,message_repTf.getText());
            pst.setInt(2,Integer.parseInt(idadmintf.getText()));
            pst.setString(3, etatTf.getText());
            pst.setInt(4,Integer.parseInt(idreptf.getText()));
            pst.executeUpdate();
            System.out.println(" Reponse Modifiée! ");
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

    

