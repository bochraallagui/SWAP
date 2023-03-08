/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ichra
 * @param <T>
 */
public interface IServiceCommande<T>  {
    public void ajouter(T  c) throws SQLException;
    public void ajouter2(T  c) throws SQLException;
    public void supprimer(int c)throws SQLException; 
    public void modifier(T c)  throws SQLException;
    public ArrayList<T> afficher();
    
    
   /* public void ajouter(T c) throws SQLException;
    public void modifier(T c) throws SQLException;
    public void supprimer(T c) throws SQLException;
    public List<T> recuperer(T c) throws SQLException;*/

    
    }
    

