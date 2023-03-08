/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author ichra
 */
import entities.Commande;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import static jdk.nashorn.internal.runtime.Debug.id;
import services.CommandeService;
import utils.MyDB;

public class AjouterCommandeController implements Initializable{
    
    private TextField Prix_produit;
    
    @FXML
    private TextField Prix_produit1;
    
    @FXML
    private Button btndéconnexion;
    
    @FXML
    private Button btnlivraison;
    
    @FXML
    private Button btnproduits;
    
    @FXML
    private Button btnreclamations;
    
    @FXML
    private Button btnservices;
    
    @FXML
    private Button btnutilisateurs;
    
    @FXML
    private Pane pnlCustomer;
    
    @FXML
    private Pane pnlMenus;
    
    @FXML
    private Pane pnlOrders;
    
    @FXML
    private Pane pnlOverview;
    @FXML
    private TextField id1;
    private TextField Type_produit2;
    @FXML
    private TextField total;
    @FXML
    private DatePicker datePicker;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void AjouterCommande(ActionEvent event) throws SQLException {
        if (Prix_produit1.getText().isEmpty() && Prix_produit1.getText().isEmpty() && Prix_produit.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR, "données invalide(s)", ButtonType.OK);
            a.showAndWait();            
        } else {            
            try {
                Commande r1 = new Commande( Integer.parseInt(Prix_produit1.getText()), 
                        Float.parseFloat(total.getText()), Date.valueOf(datePicker.getValue()));                
                
                CommandeService s = new CommandeService();
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
    private void SupprimerCommande(ActionEvent event) throws SQLException {
        
        CommandeService s = new CommandeService();
        
        s.supprimer(Integer.parseInt(id1.getText()));
        
    }
    
    @FXML
    private void EnregistrerCommande(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("AfficherProduitController.fxml"));
        AnchorPane anchorPane;
        anchorPane = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(anchorPane));
        stage.show();
        CommandeService s = new CommandeService();
        
    }

    @FXML
    private void ModifierCommande(ActionEvent event) throws SQLException {
        Connection connection;
        Statement ste;
        connection = MyDB.getInstance().getCon();
        CommandeService s = new CommandeService();
        Commande r = new Commande();        
        r = s.Onerec(Integer.parseInt(id1.getText()));
        String requete = "UPDATE commande SET Prix_produit1=?, Type_produit2=?, total=?, where id1=?";
        PreparedStatement pst = connection.prepareStatement(requete);
        
        pst.setInt(1, Integer.parseInt(Prix_produit1.getText()));
        
        pst.setString(2, Prix_produit1.getText());
        pst.setString(2, Type_produit2.getText());
        pst.setString(2, total.getText());
        
        pst.setInt(3, Integer.parseInt(id1.getText()));
        pst.executeUpdate();
        System.out.println(" commande Modifiée! ");
        Alert a = new Alert(Alert.AlertType.INFORMATION, "Modif effectue", ButtonType.OK);
        a.showAndWait();        
    }
    
    @FXML
    void goToCategoryList(MouseEvent event) {
        
    }
    
    @FXML
    void handleClicks(ActionEvent event) {
        
    }
    
    void handleProductDetail(MouseEvent event) {
        
    }
    
}
