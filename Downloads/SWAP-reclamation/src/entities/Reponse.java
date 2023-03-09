/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author bochra
 */
public class Reponse {  
    private int id_reponse,fk_id_reclamation,fk_id_admin;
     private String message_rep,etat;

     public Reponse () {
    }

    public Reponse(int id_reponse, int fk_id_reclamation,  String message_rep,int fk_id_admin,String etat) {
        this.id_reponse = id_reponse;
        this.fk_id_reclamation = fk_id_reclamation;
        
        this.message_rep = message_rep;
        
        this.etat = etat;
        
    }

    public Reponse(int id_reponse2, String message_rep2, String etat2) {
		// TODO Auto-generated constructor stub
	}

	public Reponse(String text, String text2, int parseInt) {
		// TODO Auto-generated constructor stub
	}

	public Reponse(int i, int j, String string, int k) {
		// TODO Auto-generated constructor stub
	}

	public Reponse(int parseInt, String text, int parseInt2, String text2) {
		// TODO Auto-generated constructor stub
	}

	public int getId_reponse() {
        return id_reponse;
    }

    public void setId_reponse(int id_reponse) {
        this.id_reponse = id_reponse;
    }

    public int getFk_id_reclamation() {
        return fk_id_reclamation;
    }

    public void setFk_id_reclamation(int fk_id_reclamation) {
        this.fk_id_reclamation = fk_id_reclamation;
    }

    public int getFk_id_admin() {
        return fk_id_admin;
    }

    public void setFk_id_admin(int fk_id_admin) {
        this.fk_id_admin = fk_id_admin;
    }

    public String getMessage_rep() {
        return message_rep;
    }

    public void setMessage_rep(String message_rep) {
        this.message_rep = message_rep;
    }
    
    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
    

    @Override
    public String toString() {
        return "Reponse{" + "id_reponse=" + id_reponse + ", fk_id_reclamation=" + fk_id_reclamation + ", message_rep=" + message_rep + ", fk_id_admin=" + fk_id_admin +", etat="+etat+ '}';
    }}