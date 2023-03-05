/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import entities.Reclamation;
import javafx.collections.ObservableList;
import services.serviceReclamation;
/**
 * FXML Controller class
 *
 * @author HP
 */
public class Afficher_reclamation_fxmlController implements Initializable {

    @FXML
    private ListView<Reclamation> list_rec;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        serviceReclamation s = new serviceReclamation();
        ObservableList<Reclamation> items = s.getall();
        list_rec.setItems(items);
        // TODO
    }    
    
}
