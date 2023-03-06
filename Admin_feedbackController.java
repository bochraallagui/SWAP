/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author ASUS
 */
public class Admin_feedbackController implements Initializable{

    
    @FXML
    private Button btn_categories;

    @FXML
    private Button btn_feedbacks;

    @FXML
    private Button btn_livraisons;

    @FXML
    private Button btn_produits;

    @FXML
    private Button btn_reclamations;

    @FXML
    private Button btn_services;

    @FXML
    private Button btn_utilisateurs;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    @FXML
    private void refresh(ActionEvent event){
        
    }
    @FXML
    private void close(ActionEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    @FXML
    private void afficherS(ActionEvent event) {
        try{
            Parent loader = FXMLLoader.load(getClass().getResource("AfficherFeedback.fxml"));
            Scene scene = new Scene(loader);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @FXML
    private void afficherP(ActionEvent event) {
         try{
            Parent loader = FXMLLoader.load(getClass().getResource("AfficherFeedbackP.fxml"));
            Scene scene = new Scene(loader);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @FXML
    void page_categories(ActionEvent event) throws IOException {
    Parent newPage = FXMLLoader.load(getClass().getResource("Admin_categories.fxml"));
        Scene scene = btn_categories.getScene();
        scene.setRoot(newPage);
    }

    @FXML
    void page_livraisons(ActionEvent event) throws IOException {
        Parent newPage = FXMLLoader.load(getClass().getResource("Admin_livraisons.fxml"));
        Scene scene = btn_livraisons.getScene();
        scene.setRoot(newPage);
    }

    @FXML
    void page_services(ActionEvent event) throws IOException {
    Parent newPage = FXMLLoader.load(getClass().getResource("Admin_services.fxml"));
        Scene scene = btn_services.getScene();
        scene.setRoot(newPage);
    }

    @FXML
    void page_produits(ActionEvent event) {

    }

    @FXML
    void page_reclamations(ActionEvent event) throws IOException {
        Parent newPage = FXMLLoader.load(getClass().getResource("Admin_reclamations.fxml"));
        Scene scene = btn_reclamations.getScene();
        scene.setRoot(newPage);
    }

    @FXML
    void page_utilisateurs(ActionEvent event) throws IOException {
        Parent newPage = FXMLLoader.load(getClass().getResource("Admin_utilisateur.fxml"));
        Scene scene = btn_utilisateurs.getScene();
        scene.setRoot(newPage);

    }
}
