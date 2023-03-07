/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author bochra
 */
public class NewFXMain extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException  {
        Parent root = FXMLLoader.load(getClass().getResource("../gui/AjouterReponse.fxml"));
        Scene scene = new Scene(root,800,600); 
        primaryStage.setTitle("Gérer les reclamations");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
