/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Reclamation;
import entities.Reponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import interfaces.IserviceReclamation;
import static java.time.Clock.system;
import services.serviceReponse;
import services.serviceReclamation;
import utils.MyDB;

/**
 *
 * @author bochra
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        MyDB db=MyDB.getInstance();
        
        Reclamation r1 = new Reclamation(8,"reclamaer ","il y a beaucoup de retard et ",333);
       // Reclamation r2 = new Reclamation( "reclamaer prix" ,"le prix n'est pas compatible ");
//        
 serviceReclamation sr = new serviceReclamation();
 serviceReponse sc = new serviceReponse();
 Reponse c = new Reponse(12,13,"bochra",14);
 
 sc.ajouter2(c);
 System.out.println(sc.afficher());
       //sr.ajouter2(r1); 
       System.out.println(sr.afficher());
       //sr.supprimer(r1);
       //sr.modifier(r1);
    }}
//        
     //   try {
            //sr.ajouter2(r2);
      //  } //catch (SQLException ex) {
      //      System.out.println("Probleme insertion: "+ex.getMessage());
  //  }
      //  System.out.println(sr.afficher());
    

