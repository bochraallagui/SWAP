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
    private int id_rec;
    private String objectif ;
    private String text ; 
    private int fk_id_utilisateur;

    public Reclamation( String objectif ,String text,int fk_id_utilisateur) {
  
        this.objectif= objectif;
        this.text= text;
        this.fk_id_utilisateur=fk_id_utilisateur;
    }

    public Reclamation(int id_rec, String objectif ,String text ,int fk_id_utilisateur) {
        this.id_rec = id_rec;
        this.objectif= objectif;
        this.text= text; 
        this.fk_id_utilisateur=fk_id_utilisateur;
       
    }

    public Reclamation() {
    }

    public Reclamation(String text, String text0) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        this.objectif= text;
        this.text= text0; 
    }
    
    //getters / setters

    public Reclamation(String text2, String objectif2, int id2, int id_rec2) {
		// TODO Auto-generated constructor stub
	}

	public Reclamation(int id_rec2, String filterBadWords, String filterBadWords2) {
		// TODO Auto-generated constructor stub
	}

	public int getId_rec() {
        return id_rec;
    }

    public void setId_rec(int id_rec) {
        this.id_rec = id_rec;
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
    
    public  int getfk_id_utilisateur() {
        return fk_id_utilisateur;
    }

    public void setfk_id_utilisateur(int fk_id_utilisateur) {
        this.fk_id_utilisateur = fk_id_utilisateur;
    }
    
    //toString
    @Override
    public String toString() {
        return "Reclamation{" + "id_rec=" + id_rec + ",  objectif=" + objectif +  ", text=" + text + ", fk_id_utilisateur=" + fk_id_utilisateur + '}';
    }}

	
    



