/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Livraison;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import org.controlsfx.control.Notifications;
import services.LivraisonService;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AjouterLivraisonController implements Initializable {

    @FXML
    private Pane pnlOverview;
    @FXML
    private TextField nom_clientField;
    @FXML
    private TextField numero_clientField;
    @FXML
    private DatePicker date_livraisonField;
    @FXML
    private TextField id_livreurField;
    @FXML
    private TextField prenom_clientField;
    @FXML
    private TextField prix_livraisonField;
    @FXML
    private TextField adresse_livraisonField;
    @FXML
    private TextField id_pointrelaisField;

    /**
     * Initializes the controller class.
     */
    
 LivraisonService ls =new LivraisonService();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterLivraison(ActionEvent event) {
         Livraison L = new Livraison();
           L.setNom_client(nom_clientField.getText());
           L.setPrenom_client(prenom_clientField.getText());
           L.setNumero_client(Integer.valueOf(numero_clientField.getText()));
           L.setPrix_livraison(Integer.valueOf(prix_livraisonField.getText()));
           L.setDate_livraison(String.valueOf(date_livraisonField.getValue()));
           L.setAdresse_livraison(adresse_livraisonField.getText());
           L.setFk_id_livreur(Integer.valueOf(id_livreurField.getText()));
           L.setFk_id_pointrelais(Integer.valueOf(id_pointrelaisField.getText()));
           // Check that required fields are not empty 
        if (nom_clientField.getText().isEmpty() || prenom_clientField.getText().isEmpty()  || adresse_livraisonField.getText().isEmpty() ) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Missing fields");
            alert.setHeaderText("All fields must be filled");
            alert.showAndWait();
            
           
        }
        else
            if (numero_clientField.getText().length()!= 8)
        {
             Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("error");
            alert.setHeaderText("numero doit avoir 8 numeros");
            alert.showAndWait();
        }
            
        else
             try {
            
            ls.AjouterLivraison(L);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ajout réussie");
            alert.setHeaderText("L'ajout a été effectuée avec succès.");
            alert.showAndWait();
         
            
       
            Notifications notificationBuilder;
            notificationBuilder = Notifications.create()
                .title("Alert").text("Feedback evoyee avec succes").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                .position(Pos.CENTER_LEFT)
                .onAction(new EventHandler <ActionEvent>() {
                    public void handle(ActionEvent event)
                    {
                    System.out.println("clicked ON");
            }});
        
        notificationBuilder.darkStyle();
        notificationBuilder.show();
           

        
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
