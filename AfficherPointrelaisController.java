/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import entities.Pointrelais;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import services.PointrelaisService;

/**
 *
 * @author hp
 */
public class AfficherPointrelaisController {
    @FXML
    private GridPane grid1;

    PointrelaisService ps = new PointrelaisService();

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    public void initialize(URL url, ResourceBundle rb) {
        try {
            List<Pointrelais> pointrelais = ps.recuperer();
            int row = 0;
            int column = 0;
            for (int i = 0; i < pointrelais.size(); i++) {
                //chargement dynamique d'une interface
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Livraison.fxml"));
                AnchorPane pane = loader.load();
               
                //passage de parametres
                LivraisonController controller = loader.getController();
                controller.setPointrelais(pointrelais.get(i));

                grid1.add(pane, column, row);
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
