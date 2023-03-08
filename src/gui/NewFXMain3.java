/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;



/**
 *
 * @author ichra
 */
public class NewFXMain3 extends Application{

    private String name;

    @Override
    public void start(Stage primaryStage) throws Exception {
             
    Parent root = FXMLLoader.load(getClass().getResource("AjouterCommande.fxml"));
    primaryStage.setTitle("Gérer les produits");
    primaryStage.setScene(new Scene(root));
    primaryStage.show();
    
    
    
    }
    public static void main(String[] args){
        launch();
    }
    
}
