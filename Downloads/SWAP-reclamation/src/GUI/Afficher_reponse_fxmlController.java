/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import entities.Reponse;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import services.serviceReponse;
import javafx.scene.input.DataFormat;



/**
 * FXML Controller class
 *
 * @author HP
 */
public class Afficher_reponse_fxmlController implements Initializable {
	 @FXML
	    private TextField maail;
	 
    @FXML
    private ListView<Reponse> list_rep;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        serviceReponse s = new serviceReponse();
        ObservableList<Reponse> items = s.getall();
        list_rep.setItems(items);
        // TODO
    }    
    public static void sendMail(String recepient) throws MessagingException{
        System.out.println("Prepared to send email");
        Properties properties=new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        String myEmailAccount="bochra.allagui@esprit.tn";
        String password="201JFT4364";
        Session session=Session.getInstance(properties,new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(myEmailAccount,password);
                
            }
        });
        //fMxQk.iKB.Ga:r9 mdp shiha
        //owpaukfevselwved
        Message message=prepareMessage(session,myEmailAccount,recepient);
        Transport.send(message);
        System.out.println("Message sent succesfully");
    }
        private static Message prepareMessage(Session session, String myEmailAccount,String recepient){
        try {
            Message message=new MimeMessage(session);
            message.setFrom(new InternetAddress(myEmailAccount));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Reclamation Accepte");
            message.setText("Bonjour cher(e) abonne(é),votre Reclamation est accepte 🙂");
            return message;
                    } catch (MessagingException ex) {
//            Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, ex);
System.out.println(ex.getMessage());
        }
        return null;
        }
        public static void sendMailR(String recepient) throws MessagingException{
            System.out.println("Prepared to send email");
            Properties properties=new Properties();
            properties.put("mail.smtp.auth","true");
            properties.put("mail.smtp.starttls.enable","true");
            properties.put("mail.smtp.host","smtp.gmail.com");
            properties.put("mail.smtp.port","587");
            String myEmailAccount="bochra.alllagui@esprit.tn";
            String password="201JFT4364";
            Session session=Session.getInstance(properties,new Authenticator(){
                @Override
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(myEmailAccount,password);
                    
                }
            });
            
            Message message=prepareMessage(session,myEmailAccount,recepient);
            Transport.send(message);
            System.out.println("Message sent succesfully");
        }
        
        @FXML
        public  void Mail( ) throws MessagingException, SQLException{
        String m=maail.getText();
     
      sendMail(m);}
        
      @FXML
      public  void MailR( ) throws MessagingException{
      String mr=maail.getText();
      sendMailR(mr);
      
    }
      public class DataHandler {
    	    // propriétés, constructeurs, méthodes, etc.
    	}
      

        @FXML
        private void handleClicks(ActionEvent event) {
        }

        @FXML
        private void goToCategoryList(MouseEvent event) {
        }
}
