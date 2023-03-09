/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import com.itextpdf.text.DocumentException;
import entities.Livraison;
import entities.Point_relais;
import entities.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.management.Notification;
import static jdk.internal.org.jline.utils.Colors.s;
import jfxtras.labs.scene.control.MiniIconButton.AnimationType;
import org.controlsfx.control.Notifications;
import services.LivraisonService;
import services.Point_relaisService;
import services.UserServie;
import services.QrCode;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class Admin_livraisonsController implements Initializable {

    @FXML
    private Button btn_utilisateurs;
    @FXML
    private Button btn_categories;
    @FXML
    private Button btn_services;
    @FXML
    private Button btn_produits;
    @FXML
    private Button btn_feedbacks;
    @FXML
    private Button btn_reclamations;
    @FXML
    private Button btn_livraisons;
    @FXML
    private Button refreshByn;
    @FXML
    private DatePicker dateF;
    @FXML
    private TextField adresse_livraisonF;
    @FXML
    private TextField prix_livraisonF;
    @FXML
    private ChoiceBox<String> choice;
    @FXML
    private TableView<Livraison> tableLivraison;
    @FXML
    private TableColumn<Livraison,  String> dateC;
    @FXML
    private TableColumn<Livraison,  Integer> prixC;
    @FXML
    private TableColumn<Livraison,  String> adresseC;
    @FXML
    private TableColumn<Livraison,  Integer> livreurC;
    @FXML
    private TableView<Point_relais> tablePoint;
    @FXML
    private TableColumn<Point_relais,  String> pointC;
    @FXML
    private TableColumn<Point_relais,  String> regionC;
    @FXML
    private TableColumn<Point_relais,  Integer> horaireC;
    @FXML
    private TextField pointF;
    @FXML
    private TextField regionF;
    @FXML
    private TextField horaireF;
    @FXML
    private TextField searchField;
    
     
    LivraisonService ls = new LivraisonService();
    UserServie us = new UserServie();
    Point_relaisService ps = new Point_relaisService();
    QrCode qr = new QrCode();
   
   


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
        
       ObservableList<String> items = FXCollections.observableArrayList();
        try {
             List<User> users=us.recuperer();
         
        for (User u1 : users) {
            if(u1.getRole().equals("livreur"))
        
            items.add(u1.getNom()+" "+ u1.getPrenom());
        }
        choice.setItems(items);
        choice.setValue(items.get(0));        
        } catch (SQLException ex){
            System.out.println("error2" + ex.getMessage());
         }  
        
        
        try{
             List<Livraison> livraisons = ls.recuperer();
             ObservableList<Livraison> olp = FXCollections.observableArrayList(livraisons);
             
            tableLivraison.setItems(olp);
           
            
            
            livreurC.setCellValueFactory(new PropertyValueFactory<> ("fk_id_livreur"));
            adresseC.setCellValueFactory(new PropertyValueFactory<> ("adresse_livraison"));
            dateC.setCellValueFactory(new PropertyValueFactory<> ("date_livraison"));
            prixC.setCellValueFactory(new PropertyValueFactory<> ("prix_livraison"));
            
            
           
        } catch (SQLException ex) { 
            System.out.println("error3" + ex.getMessage());
        }
        
        //point de relais
        try{
             List<Point_relais> points = ps.recuperer();
             ObservableList<Point_relais> olp1 = FXCollections.observableArrayList(points);
             
            tablePoint.setItems(olp1);
            pointC.setCellValueFactory(new PropertyValueFactory<> ("adresse_pointderelais"));
            regionC.setCellValueFactory(new PropertyValueFactory<> ("region"));
            horaireC.setCellValueFactory(new PropertyValueFactory<> ("horaire"));
            
        } catch (SQLException ex) { 
            System.out.println("error1" + ex.getMessage());
        }
    }  
    
    

    @FXML
    private void page_utilisateurs(ActionEvent event) throws IOException {
         Parent newPage = FXMLLoader.load(getClass().getResource("Admin_utilisateur.fxml"));
        Scene scene = btn_utilisateurs.getScene();
        scene.setRoot(newPage);
    }

    @FXML
    private void page_categories(ActionEvent event) throws IOException {
        Parent newPage = FXMLLoader.load(getClass().getResource("Admin_categories.fxml"));
        Scene scene = btn_categories.getScene();
        scene.setRoot(newPage);
    }

    @FXML
    private void page_services(ActionEvent event) throws IOException {
        Parent newPage = FXMLLoader.load(getClass().getResource("Admin_services.fxml"));
        Scene scene = btn_services.getScene();
        scene.setRoot(newPage);
    }

    @FXML
    private void page_produits(ActionEvent event) throws IOException {
        Parent newPage = FXMLLoader.load(getClass().getResource("Admin_produits.fxml"));
        Scene scene = btn_produits.getScene();
        scene.setRoot(newPage);
    }

    @FXML
    private void page_feedbacks(ActionEvent event) throws IOException {
        Parent newPage = FXMLLoader.load(getClass().getResource("Admin_feedbacks.fxml"));
        Scene scene = btn_feedbacks.getScene();
        scene.setRoot(newPage);
    }

    @FXML
    private void page_reclamations(ActionEvent event) throws IOException {
        Parent newPage = FXMLLoader.load(getClass().getResource("Admin_reclamations.fxml"));
        Scene scene = btn_reclamations.getScene();
        scene.setRoot(newPage);
    }

    
    
    
    @FXML
    private void AjouterLivraison(ActionEvent event) throws SQLException {
    String ss = choice.getSelectionModel().getSelectedItem();
        List<User> users= us.recuperer();
       
        for (User u1 : users) {
        if((u1.getNom()+" "+u1.getPrenom()).equals(ss))
        {
            int idL=u1.getId();
     
        
        Livraison p = new Livraison();
        if ((adresse_livraisonF.getText().isEmpty())||(prix_livraisonF.getText().isEmpty()))
                            {Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("");
                            alert.setHeaderText("field vide");
                            alert.showAndWait();}
        else{
        p.setAdresse_livraison(adresse_livraisonF.getText());
        p.setDate_livraison(String.valueOf(dateF.getValue()));
        p.setPrix_livraison(Integer.parseInt(prix_livraisonF.getText()));
        p.setFk_id_livreur(idL);
        try {
            ls.ajouter(p);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ajout");
            alert.setHeaderText("succès.");
            alert.showAndWait();
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

}}
    }

    @FXML
    private void SupprimerLivraison(ActionEvent event) throws SQLException {
        Livraison u = tableLivraison.getSelectionModel().getSelectedItem();
        
          ls.supprimer(u);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("supp");
            alert.setHeaderText("succès.");
            alert.showAndWait();
    }

    @FXML
    private void ModifierLivraison(ActionEvent event) throws SQLException {
        
     Livraison l = tableLivraison.getSelectionModel().getSelectedItem();
String ss = choice.getSelectionModel().getSelectedItem();
        List<User> users= us.recuperer();
       
        for (User u1 : users) {
        if((u1.getNom()+" "+u1.getPrenom()).equals(ss))
        {
            int idL=u1.getId();
     
        
        Livraison p = new Livraison();
        if ((adresse_livraisonF.getText().isEmpty())||(prix_livraisonF.getText().isEmpty()))
                            {Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("");
                            alert.setHeaderText("field vide");
                            alert.showAndWait();}
        else{
        p.setAdresse_livraison(adresse_livraisonF.getText());
        p.setDate_livraison(String.valueOf(dateF.getValue()));
        p.setPrix_livraison(Integer.parseInt(prix_livraisonF.getText()));
        p.setFk_id_livreur(idL);
        p.setId_livraison(l.getId_livraison());
        try {
            ls.modifier(p);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("modif");
            alert.setHeaderText("succès.");
            alert.showAndWait();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }}}}

    @FXML
    private void close(ActionEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void refresh(ActionEvent event) {
         try{
             List<Livraison> livraisons = ls.recuperer();
             ObservableList<Livraison> olp = FXCollections.observableArrayList(livraisons);
             
            tableLivraison.setItems(olp);
           
            
            
            livreurC.setCellValueFactory(new PropertyValueFactory<> ("fk_id_livreur"));
            adresseC.setCellValueFactory(new PropertyValueFactory<> ("adresse_livraison"));
            dateC.setCellValueFactory(new PropertyValueFactory<> ("date_livraison"));
            prixC.setCellValueFactory(new PropertyValueFactory<> ("prix_livraison"));
            
            
           
        } catch (SQLException ex) { 
            System.out.println("error" + ex.getMessage());
        }
         
         //point de relais
        try{
             List<Point_relais> points = ps.recuperer();
             ObservableList<Point_relais> olp1 = FXCollections.observableArrayList(points);
             
            tablePoint.setItems(olp1);
            pointC.setCellValueFactory(new PropertyValueFactory<> ("adresse_pointderelais"));
            regionC.setCellValueFactory(new PropertyValueFactory<> ("region"));
            horaireC.setCellValueFactory(new PropertyValueFactory<> ("horaire"));
            
        } catch (SQLException ex) { 
            System.out.println("error1" + ex.getMessage());
        }
    }

    @FXML
    private void getData(MouseEvent event) {
        Livraison u = tableLivraison.getSelectionModel().getSelectedItem();
        Point_relais p = tablePoint.getSelectionModel().getSelectedItem();
        
        
        pointF.setText(p.getAdresse_pointderelais());
        regionF.setText(p.getRegion());
        horaireF.setText(Integer.toString(p.getHoraire()));
        
        ///fields
        
        
            adresse_livraisonF.setText(u.getAdresse_livraison());
            prix_livraisonF.setText(Integer.toString(u.getPrix_livraison()));
            
         ObservableList<String> items = FXCollections.observableArrayList();
         int i=-1;
         int j=0;
            try {
             List<User> users=us.recuperer();
         
        for (User u1 : users) {
            if(u1.getRole().equals("livreur"))
            {items.add(u1.getNom()+" "+ u1.getPrenom());
            i++;}
            
            
            if(u1.getId() == u.getFk_id_livreur())
               j= i;
        }
                
        
        choice.setItems(items);
        choice.setValue(items.get(j));
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
         }  
            
    }
    
    
   
     @FXML
    private void handleSearchButton(ActionEvent event) {
         String searchQuery = searchField.getText();
    try {
        List<Livraison> searchResults = ls.rechercherParAdresse(searchQuery);
        tableLivraison.setItems(FXCollections.observableArrayList(searchResults));
    } catch (SQLException e) {
        // Gérer l'exception
    }
    }

    @FXML
    private void generePDFS(ActionEvent event) throws DocumentException, FileNotFoundException {
          LivraisonService as = new LivraisonService();
        as.createPDF(tableLivraison);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("PDF créé avec succès !");
        alert.showAndWait();
    }

    ///////////////////////////////////////point de relais///////////////
   
    
    @FXML
    private void AjouterPoint(ActionEvent event) throws SQLException {
        
     Livraison u = tableLivraison.getSelectionModel().getSelectedItem();
        Point_relais p =new Point_relais();
        if (u.getAdresse_livraison().isEmpty())
            {Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("");
                            alert.setHeaderText("click sur livraison ");
                            alert.showAndWait();}
        
        
        
        else if (pointF.getText().isEmpty()||(regionF.getText().isEmpty()))
                            {Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("");
                            alert.setHeaderText("field vide");
                            alert.showAndWait();}
        else{
            
        p.setFk_id_livraisonp(u.getId_livraison());
        
        p.setAdresse_pointderelais(pointF.getText());
        
        p.setRegion(regionF.getText());
        
        p.setHoraire(Integer.parseInt(horaireF.getText()));
        
        ps.ajouter(p);
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("ajout");
                            alert.setHeaderText("succes");
                            alert.showAndWait();
        }   
    }

    @FXML
    private void SupprimerPoint(ActionEvent event) throws SQLException {
        Point_relais u = tablePoint.getSelectionModel().getSelectedItem();
        
          ps.supprimer(u);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("supp");
            alert.setHeaderText("succès.");
            alert.showAndWait();
    }

    @FXML
    private void ModifierPoint(ActionEvent event) throws SQLException {
        Point_relais p =tablePoint.getSelectionModel().getSelectedItem();
        Point_relais p1 = new Point_relais();
        p1.setAdresse_pointderelais(pointF.getText());
        p1.setFk_id_livraisonp(p.getFk_id_livraisonp());
  
        p1.setRegion(regionF.getText());
        
        p1.setHoraire(Integer.parseInt(horaireF.getText()));
        
        p1.setId_pointderelais(p.getId_pointderelais());
        ps.modifier(p1);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("modif");
            alert.setHeaderText("succès.");
            alert.showAndWait();
    }

   @FXML
    private void TrierPoint(ActionEvent event) throws SQLException {
        // Créer une Comparator personnalisée pour trier les réclamations par objet en ordre croissant
        Comparator<Point_relais> comparator = Comparator.comparingInt(Point_relais::getHoraire).reversed(); {

        	ObservableList<Point_relais> sortedList = FXCollections.observableArrayList(tablePoint.getItems());
        	FXCollections.sort(sortedList, comparator);
        	tablePoint.setItems(sortedList);

            
            tablePoint.setItems(tablePoint.getItems());
        }
    }
    
    
/////IMPLEMENTATION/////////
@FXML
   public void qr(ActionEvent event) throws IOException, WriterException, com.google.zxing.WriterException {
       Livraison  p =new  Livraison();
    // Récupérer la ligne sélectionnée dans la TableView
    Livraison l = tableLivraison.getSelectionModel().getSelectedItem();

    // Récupérer l'adresse de livraison de l'objet sélectionné
    String qrCodeText =l.getAdresse_livraison();
    System.out.println(qrCodeText);

    // Générer le QR code
    String filePath = "C:/Users/hp/OneDrive/Bureau/3A/jd.png";
    int size = 100;
    String fileType = "png";
    File qrFile = new File(filePath);
    qr.createQRImage(qrFile, qrCodeText, size, fileType);
    System.out.println("DONE");
    }

}
