/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Categorie;
import entities.Service;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import services.CategorieS;
import services.ServiceS;

/**
 * FXML Controller class
 *
 * @author Maissa
 */
public class AfficherServController implements Initializable {

    @FXML
    private TableView<Service> tableServices;
    @FXML
    private TableColumn<Service, String> Descriptionc;
    @FXML
    private TableColumn<Service, String> Datec;
    @FXML
    private TableColumn<Service, Integer> Prixc;
    @FXML
    private TableColumn<Service, String> typePc;
    @FXML
    private TableColumn<Service, Integer> Categoriec;
    @FXML
    private TextField DescriptionF;
    @FXML
    private DatePicker DateF;
    @FXML
    private TextField PrixF;
     @FXML
    ChoiceBox<String> choice= new ChoiceBox<>();
     
     @FXML
    ChoiceBox<String> choiceC= new ChoiceBox<>();

    /**
     * Initializes the controller class.
     */
    ServiceS s =new ServiceS();
    CategorieS c =new CategorieS();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            choice.getItems().addAll("CASH", "CARTE BANCAIRE"); 
             choice.setValue("CASH");
             
             
             
             ///les types cat
             List<Categorie> categories;
         try {
             categories = c.recuperer();
         
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Categorie c1 : categories) {
            items.add(c1.getType_categorie());
        }
        choiceC.setItems(items);
        } catch (SQLException ex) {
             Logger.getLogger(AfficherServController.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
         
             List<Service> ser = s.recuperer();
            ObservableList<Service> olp = FXCollections.observableArrayList(ser);
            Descriptionc.setCellValueFactory(new PropertyValueFactory<> ("description_service"));
            Datec.setCellValueFactory(new PropertyValueFactory<> ("date_service"));
            Prixc.setCellValueFactory(new PropertyValueFactory<> ("prix_service"));
            Categoriec.setCellValueFactory(new PropertyValueFactory<> ("fk_id_categorie"));
            typePc.setCellValueFactory(new PropertyValueFactory<> ("type_paiement_service"));
            
            tableServices.setItems(olp);
           
        } catch (SQLException ex) { 
            System.out.println("error" + ex.getMessage());
        }
        
    }  
     @FXML
    private void Ajouter(ActionEvent event) throws SQLException {
        
        String ss = choiceC.getSelectionModel().getSelectedItem();
        List<Categorie> categories= c.recuperer();
       
        for (Categorie c1 : categories) {
        if(c1.getType_categorie().equals(ss))
        {
            int idC=c1.getId_categorie();
      
        
        Service p = new Service();
        if ((DescriptionF.getText().isEmpty())||(PrixF.getText().isEmpty()))
                            {Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("");
                            alert.setHeaderText("type est vide");
                            alert.showAndWait();}
        else{
        p.setDescription_service(DescriptionF.getText());
        p.setDate_service(String.valueOf(DateF.getValue()));
        p.setPrix_service(Integer.valueOf(PrixF.getText()));
        p.setType_paiement_service(choice.getValue());
        p.setFk_id_categorie(idC);
        try {
            s.ajouter(p);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ajout");
            alert.setHeaderText("succès.");
            alert.showAndWait();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }}
        }
    }
    
    
     @FXML
    private void Modifier(ActionEvent event) throws SQLException {
        Service u = tableServices.getSelectionModel().getSelectedItem();
        int idu = u.getId_service();
         String ss = choiceC.getSelectionModel().getSelectedItem();
        List<Categorie> categories= c.recuperer();
       
        for (Categorie c1 : categories) {
        if(c1.getType_categorie().equals(ss))
        {
            int idC=c1.getId_categorie();
      
        
        Service p = new Service();
        if ((DescriptionF.getText().isEmpty())||(PrixF.getText().isEmpty()))
                            {Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("");
                            alert.setHeaderText("type est vide");
                            alert.showAndWait();}
        else{
        p.setDescription_service(DescriptionF.getText());
        p.setDate_service(String.valueOf(DateF.getValue()));
        p.setPrix_service(Integer.valueOf(PrixF.getText()));
        p.setType_paiement_service(choice.getValue());
        p.setFk_id_categorie(idC);
        p.setId_service(idu);
        try {
            s.modifier(p);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("modif");
            alert.setHeaderText("succès.");
            alert.showAndWait();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }}}}
        
     @FXML
    private void Supprimer(ActionEvent event) throws SQLException {
        Service u = tableServices.getSelectionModel().getSelectedItem();
        s.supprimer(u);
    }
        
        
     @FXML
    private void Refresh(ActionEvent event) {
        try{
            
             List<Service> ser = s.recuperer();
            ObservableList<Service> olp = FXCollections.observableArrayList(ser);
            Descriptionc.setCellValueFactory(new PropertyValueFactory<> ("description_service"));
            Datec.setCellValueFactory(new PropertyValueFactory<> ("date_service"));
            Prixc.setCellValueFactory(new PropertyValueFactory<> ("prix_service"));
            Categoriec.setCellValueFactory(new PropertyValueFactory<> ("fk_id_categorie"));
            typePc.setCellValueFactory(new PropertyValueFactory<> ("type_paiement_service"));
            
            tableServices.setItems(olp);
           
        } catch (SQLException ex) { 
            System.out.println("error" + ex.getMessage());
        }
    }
        
        @FXML
    private void getData(MouseEvent event){
        
        Service u = tableServices.getSelectionModel().getSelectedItem();
       
        DescriptionF.setText(u.getDescription_service());
        PrixF.setText(String.valueOf(u.getPrix_service()));
        
    }
    
    
    
}
