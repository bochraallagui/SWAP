/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Produit;
import java.sql.SQLException;
import services.ProduitService;
import utils.MyDB;


/**
 *
 * @author Skander
 */
public class Test {
    
    
    public static void main(String[] args) throws SQLException {
    	 MyDB db =MyDB.getInstance();
       
        
            Produit p = new Produit( 1,350, "Achat", "Beauté","Parfum");
            ProduitService ps = new ProduitService();
           
        
            ps.ajouter2(p); 
            System.out.println(ps.afficher());

    }
    
}
