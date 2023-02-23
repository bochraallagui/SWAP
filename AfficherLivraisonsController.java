/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Livraison;
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
import services.LivraisonService;

/**
 * FXML Controller class
 *
 * @author Skander
 */
public class AfficherLivraisonsController implements Initializable {

    @FXML
    private GridPane grid;

    LivraisonService ps = new LivraisonService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            List<Livraison> livraisons = ps.recuperer();
            int row = 0;
            int column = 0;
            for (int i = 0; i < livraisons.size(); i++) {
                //chargement dynamique d'une interface
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Livraison.fxml"));
                AnchorPane pane = loader.load();
               
                //passage de parametres
                LivraisonController controller = loader.getController();
                controller.setLivraison(livraisons.get(i));

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
