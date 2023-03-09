/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import entities.Reclamation;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import services.serviceReclamation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 * FXML Controller class
 * 
 * @author HP
 */
public class Afficher_reclamation_fxmlController implements Initializable {
	@FXML
    private TextField maail;
 
    @FXML
    private ListView<Reclamation> list_rec;
    @FXML
    private TextField searchField;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        serviceReclamation s = new serviceReclamation();
        ObservableList<Reclamation> items = s.getall();
        ObservableList<Reclamation> sortedList = FXCollections.observableArrayList(list_rec.getItems());
        Comparator<Reclamation> comparator = Comparator.comparing(Reclamation::getobjectif);
        sortedList.sort(comparator);
      
        list_rec.setItems(sortedList);

        list_rec.setItems(items);
        
        ObservableList<Reclamation> filteredItems = filterBadWords(items);
        list_rec.setItems(filteredItems);


        // TODO
        
    }

    @FXML
    private void Trier(ActionEvent event) throws SQLException {
        // Créer une Comparator personnalisée pour trier les réclamations par objet en ordre croissant
        Comparator<Reclamation> comparator = Comparator.comparingInt(Reclamation::getId_rec).reversed(); {

        	ObservableList<Reclamation> sortedList = FXCollections.observableArrayList(list_rec.getItems());
        	FXCollections.sort(sortedList, comparator);
        	list_rec.setItems(sortedList);

            // Réassigner la liste triée à la ListView
            list_rec.setItems(list_rec.getItems());
        }
    }

    private ObservableList<Reclamation> filterBadWords(ObservableList<Reclamation> items) {
        // Liste de badwords à filtrer
        List<String> badWords = Arrays.asList("badword1", "badword2", "badword3");

        // Créer un prédicat pour filtrer les réclamations contenant des mots interdits
        Predicate<Reclamation> filterPredicate = reclamation -> {
            String objectif = reclamation.getobjectif();
            String reclamationText = reclamation.gettext();
            for (String badWord : badWords) {
                if (objectif.contains(badWord) || reclamationText.contains(badWord)) {
                    return false;
                }
            } 
            return true;
        };

        // Utiliser la méthode filter() pour appliquer le prédicat et filtrer les réclamations
        ObservableList<Reclamation> filteredItems = items.filtered(filterPredicate);

        return filteredItems;
    }
    
    
    //recherche objectif
    @FXML
   
    private void handleSearchButton(ActionEvent event) {
        String searchQuery = searchField.getText();
        serviceReclamation rs= new serviceReclamation();
    try {
        List<Reclamation> searchResults = rs.rechercherParobjectif(searchQuery);
        list_rec.setItems(FXCollections.observableArrayList(searchResults));
    } catch (SQLException e) {
        // Gérer l'exception
    }}
    
    
   

    @FXML
    private void handleClicks(ActionEvent event) {
    }

    @FXML
    private void goToCategoryList(MouseEvent event) {
    }

}
