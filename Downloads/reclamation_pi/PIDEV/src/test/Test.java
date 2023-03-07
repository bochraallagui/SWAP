/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Reclamation;
import entities.Reponse;
import java.sql.SQLException;
import services.ReclamationService;
import services.ReponseService;


/**
 *
 * @author bochra
 */
public class Test {
    
    
    public static void main(String[] args) throws SQLException {
       
        Reclamation r = new Reclamation( 1,"bochra", "allagui", "emaill","reclamation pour des raisons" ,2);
        ReclamationService rs = new ReclamationService();
        rs.AjouterReclamation(r);
        rs.modifier(r);
       
        

    
    
      Reponse e = new Reponse( 1,2,"reclamation traite",3);
        ReponseService es = new ReponseService();
        es.AjouterReponse(e);
        es.modifierReponse(e);
        
      
}}
