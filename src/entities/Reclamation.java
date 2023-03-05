/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author bochra
 */
public class Reclamation{
    private int id;
    private String objectif ;
    private String text ; 
    private int iduser;

    public Reclamation( String objectif ,String text,int iduser) {
  
        this.objectif= objectif;
        this.text= text;
        this.iduser=iduser;
    }

    public Reclamation(int id, String objectif ,String text ,int iduser) {
        this.id = id;
        this.objectif= objectif;
        this.text= text; 
        this.iduser=iduser;
       
    }

    public Reclamation() {
    }

    public Reclamation(String text, String text0) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        this.objectif= text;
        this.text= text0; 
    }
    
    //getters / setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  

    public String  getobjectif() {
        return objectif;
    }

    public void setobjectif(String objectif) {
        this.objectif= objectif ;
    }
    
      public String  gettext() {
        return text ;
    }

    public void settext(String text) {
        this.text= text ;
    }
    
    public  int getiduser() {
        return iduser;
    }

    public void setiduser(int iduser) {
        this.iduser = iduser;
    }
    
    //toString
    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ",  obejectif=" + objectif +  ", text=" + text +  '}';
    }
    
}


