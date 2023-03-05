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
import entities.Reponse;
import javafx.collections.ObservableList;
import services.serviceReponse;
/**
 * FXML Controller class
 *
 * @author HP
 */
public class Afficher_reponse_fxmlController implements Initializable {

    @FXML
    private ListView<Reponse> list_rep;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        serviceReponse s = new serviceReponse();
        ObservableList<Reponse> items = s.getall();
        list_rep.setItems(items);
        // TODO
    }    
    
}
