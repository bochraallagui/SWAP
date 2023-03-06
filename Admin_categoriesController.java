package gui;

import entities.Categorie;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.CategorieS;

public class Admin_categoriesController implements Initializable{

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
    private Button refreshByn;

   @FXML
    private TableView<Categorie> table;
    @FXML
    private TableColumn<Categorie, String> typeC;
    @FXML
    private TextField typeF;
    
    
    
     CategorieS c = new CategorieS();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
             List<Categorie> cat = c.recuperer();
            ObservableList<Categorie> olp = FXCollections.observableArrayList(cat);
            typeC.setCellValueFactory(new PropertyValueFactory<> ("type_categorie"));
            table.setItems(olp);
           
        } catch (SQLException ex) { 
            System.out.println("error" + ex.getMessage());
        }
    }    

    @FXML
    void AjouterCommande(ActionEvent event) throws SQLException {
  Categorie p = new Categorie();
  boolean test=false;
  List<Categorie> categories = c.recuperer();
  for (Categorie c1 :categories)
      if (c1.getType_categorie().equals(typeF.getText()))
              test=true;
  //type deja trouvee
  if(test==true)
      {Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("");
                            alert.setHeaderText("type est deja ajouté");
                            alert.showAndWait();}
  //type vide 
       else if (typeF.getText().isEmpty())
                            {Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("");
                            alert.setHeaderText("type est vide");
                            alert.showAndWait();}
        else{
        p.setType_categorie(typeF.getText());
        try {
            c.ajouter(p);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ajout");
            alert.setHeaderText("succès.");
            alert.showAndWait();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    }

    @FXML
    void ModifierCommande(ActionEvent event) throws SQLException {
 Categorie cat=table.getSelectionModel().getSelectedItem();
 boolean test=false;
  List<Categorie> categories = c.recuperer();
  for (Categorie c1 :categories)
      if (c1.getType_categorie().equals(typeF.getText()))
              test=true;
  //type deja trouvee
  if(test==true)
      {Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("");
                            alert.setHeaderText("type est deja trouvé");
                            alert.showAndWait();}
  else{
                Categorie cat1=new Categorie(cat.getId_categorie(),typeF.getText());
                c.modifier(cat1);
                
                
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("modif");
            alert.setHeaderText("succès.");
            alert.showAndWait();
    }}

    @FXML
    void SupprimerCommande(ActionEvent event) throws SQLException {
Categorie u = table.getSelectionModel().getSelectedItem();
        c.supprimer(u);
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
Categorie cat=table.getSelectionModel().getSelectedItem();
        typeF.setText(cat.getType_categorie());
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
    void page_services(ActionEvent event) throws IOException {
       Parent newPage = FXMLLoader.load(getClass().getResource("Admin_services.fxml"));
        Scene scene = btn_services.getScene();
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
             List<Categorie> cat = c.recuperer();
            ObservableList<Categorie> olp = FXCollections.observableArrayList(cat);
            typeC.setCellValueFactory(new PropertyValueFactory<> ("type_categorie"));
            table.setItems(olp);
           
        } catch (SQLException ex) { 
            System.out.println("error" + ex.getMessage());
        }
    }

}
