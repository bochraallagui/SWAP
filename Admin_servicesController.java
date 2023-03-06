package gui;

import entities.Categorie;
import entities.Service;
import java.io.IOException;
import java.net.URL;
import static java.sql.JDBCType.NULL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.CategorieS;
import services.ServiceS;

public class Admin_servicesController implements Initializable{

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
    private TextField PrixF;
    @FXML
    private DatePicker dateF;

    

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

   @FXML
    private ChoiceBox<String> choice;

    @FXML
    private ChoiceBox<String> choiceC =new ChoiceBox();


    

    @FXML
    private Button refreshByn;

     ServiceS s =new ServiceS();
    CategorieS c =new CategorieS();
    
    
   @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        ObservableList<String> items = FXCollections.observableArrayList();
      try {
             List<Categorie> categories=c.recuperer();
         
        for (Categorie c1 : categories) {
            items.add(c1.getType_categorie());
        }
        choiceC.setItems(items);
        choiceC.setValue(items.get(0));
        } catch (SQLException ex) {
            System.out.println("error type" + ex.getMessage());
         }        
        
        try{
            choice.getItems().addAll("CASH", "CARTE BANCAIRE"); 
             choice.setValue("CASH");
      
             List<Service> ser = s.recuperer();
            ObservableList<Service> olp = FXCollections.observableArrayList(ser);
            Descriptionc.setCellValueFactory(new PropertyValueFactory<> ("description_service"));
            Datec.setCellValueFactory(new PropertyValueFactory<> ("date_service"));
            Prixc.setCellValueFactory(new PropertyValueFactory<> ("prix_service"));
            Categoriec.setCellValueFactory(new PropertyValueFactory<> ("fk_id_categorie"));
            typePc.setCellValueFactory(new PropertyValueFactory<> ("type_paiement_service"));
            
            tableServices.setItems(olp);
           
        } catch (SQLException ex) { 
            System.out.println("error cash" + ex.getMessage());
        }
    }


    @FXML
    void Ajouter(ActionEvent event) throws SQLException {
        
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
        p.setDate_service(String.valueOf(dateF.getValue()));
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
    void Modifier(ActionEvent event) throws SQLException {
         Service u = tableServices.getSelectionModel().getSelectedItem();
        int idu = u.getId_service();
         String ss = choiceC.getSelectionModel().getSelectedItem();
        List<Categorie> categories= c.recuperer();
       
        for (Categorie c1 : categories) {
        if(c1.getType_categorie().equals(ss))
        {
            int idC=c1.getId_categorie();
      
        
        Service p = new Service();
        if ((DescriptionF.getText().isEmpty())||(PrixF.getText().isEmpty()) )
                            {Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("");
                            alert.setHeaderText("type est vide");
                            alert.showAndWait();}
        else{
        p.setDescription_service(DescriptionF.getText());
        p.setDate_service(String.valueOf(dateF.getValue()));
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
    }}}

    }

    @FXML
    void Supprimer(ActionEvent event) throws SQLException {
Service u = tableServices.getSelectionModel().getSelectedItem();
       s.supprimer(u);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("supp");
            alert.setHeaderText("succès.");
            alert.showAndWait();
    }

    @FXML
    void close(ActionEvent event) {
Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void getData(MouseEvent event) {
Service u = tableServices.getSelectionModel().getSelectedItem();
       
        DescriptionF.setText(u.getDescription_service());
        PrixF.setText(String.valueOf(u.getPrix_service()));
        
    }

    @FXML
    void page_categories(ActionEvent event) throws IOException {
Parent newPage = FXMLLoader.load(getClass().getResource("Admin_categories.fxml"));
        Scene scene = btn_categories.getScene();
        scene.setRoot(newPage);
    }

    @FXML
    void page_feedbacks(ActionEvent event) throws IOException {
        Parent newPage = FXMLLoader.load(getClass().getResource("Admin_feedback.fxml"));
        Scene scene = btn_feedbacks.getScene();
        scene.setRoot(newPage);
    }

    @FXML
    void page_livraisons(ActionEvent event) throws IOException {
Parent newPage = FXMLLoader.load(getClass().getResource("Admin_livraisons.fxml"));
        Scene scene = btn_livraisons.getScene();
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

    @FXML
    void refresh(ActionEvent event) {
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

    
}
