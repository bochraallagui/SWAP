/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;




public class User {
    
    private int id;
    private String nom, prenom,role,adresse,email,password;
    private String date_naissance;
    private int  num_tel;
    

    public User() {
    }

    public User(int id, String nom, String prenom, String role, String adresse, int num_tel, String email, String password, String date_naissance) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.adresse = adresse;
        this.num_tel = num_tel;
        this.email = email;
        this.password = password;
        this.date_naissance = date_naissance;
    }

    public User(int id) {
        this.id = id;
    }

    public User(int id,String nom, String prenom, String adresse, int num_tel, String password) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.num_tel = num_tel;
        this.password = password;
    }

    public User(String nom, String prenom, String role, String adresse, int num_tel, String email, String password, String date_naissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.adresse = adresse;
        this.num_tel = num_tel;
        this.email = email;
        this.password = password;
        this.date_naissance = date_naissance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
            this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {       
            this.prenom = prenom;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
            this.role = role;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
            this.adresse = adresse;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(int num_tel) {
            this.num_tel = num_tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
            this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
            this.password = password;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
            this.date_naissance = date_naissance;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", role=" + role + ", adresse=" + adresse + ", num_tel=" + num_tel + ", email=" + email + ", password=" + password + ", date_naissance=" + date_naissance + '}';
    }

   
    
    
    
    
}
