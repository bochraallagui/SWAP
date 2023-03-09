/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import entities.Reclamation;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
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
import services.serviceReclamation;
import utils.MyDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
/**
 * FXML Controller class
 *
 * @author HP
 */
public class ReclamationfxmlController implements Initializable {

    @FXML
    private TextField tfobj;
    @FXML
    private TextField tftxt;
    @FXML
    private TextField idrec;
     
    @FXML
    private TextField iduser;
    @FXML
    private Text reclamation;
    @FXML
    private Text objectif;
    @FXML
    private TextField fk_id_utilisateurtf ;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	  
    
    }    
 
    @FXML
    private void  addr(ActionEvent event) throws SQLException {
               if (tfobj.getText().isEmpty() && tftxt.getText().isEmpty() )
               {
                Alert a = new Alert(Alert.AlertType.ERROR, "données invalide(s)", ButtonType.OK);
            a.showAndWait();   
               }
               else { 
                   try{
        Reclamation r1 = new Reclamation(tfobj.getText(),tftxt.getText(), Integer.parseInt(fk_id_utilisateurtf.getText())); 
        

        serviceReclamation s= new serviceReclamation();
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
       
           serviceReclamation s = new serviceReclamation();
       
        s.supprimer(Integer.parseInt(idrec.getText()));
        
       
       
               }

    
    
    @FXML
    private void afficher(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
         fxmlLoader.setLocation(getClass().getResource("afficher_reclamation_fxml.fxml"));
          AnchorPane anchorPane;
          anchorPane = fxmlLoader.load();
          Stage stage = new Stage();
        stage.setScene(new Scene(anchorPane));
        stage.show();
        serviceReclamation s = new serviceReclamation();
        
        
        
    }

    @FXML
    private void modif(ActionEvent event) throws SQLException {
        Connection connection;
    Statement ste;
    connection = MyDB.getInstance().getCon();
        serviceReclamation s = new serviceReclamation();
      Reclamation r = new Reclamation();  
      r=s.Onerec(Integer.parseInt(idrec.getText()));
      String requete = "UPDATE reclamation SET objectif=?, text=? where id_rec=?";
            PreparedStatement pst = connection.prepareStatement(requete);
            
        
            pst.setString(1,tfobj.getText());
            
            pst.setString(2, tftxt.getText());
            pst.setInt(3,Integer.parseInt(idrec.getText()));
            pst.executeUpdate();
            System.out.println(" Reclamation Modifiée! ");
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
