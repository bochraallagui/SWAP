/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Personne;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import services.PersonneService;

/**
 * FXML Controller class
 *
 * @author Skander
 */
public class AfficherPersonnesController implements Initializable {

    @FXML
    private GridPane grid;

    PersonneService ps = new PersonneService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            List<Personne> personnes = ps.recuperer();
            int row = 0;
            int column = 0;
            for (int i = 0; i < personnes.size(); i++) {
                //chargement dynamique d'une interface
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Personne.fxml"));
                AnchorPane pane = loader.load();
               
                //passage de parametres
                PersonneController controller = loader.getController();
                controller.setPersonne(personnes.get(i));

                grid.add(pane, column, row);
                column++;
                if (column > 1) {
                    column = 0;
                    row++;
                }
            }
        } catch (SQLException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
