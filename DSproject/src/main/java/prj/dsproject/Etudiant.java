package prj.dsproject;

import javafx.beans.property.SimpleStringProperty;

public class Etudiant {
    private int id_user;
    private SimpleStringProperty prenom_user, nom_user, mail_user, num_user, num_rue, nom_rue;

    public Etudiant(int i, String pn, String nm, String mu, String num, String nr, String nmr){
        this.id_user=i;
        this.prenom_user=new SimpleStringProperty(pn);
        this.nom_user=new SimpleStringProperty(nm);
        this.mail_user=new SimpleStringProperty(mu);
        this.num_user=new SimpleStringProperty(num);
        this.num_rue=new SimpleStringProperty(nr);
        this.nom_rue=new SimpleStringProperty(nmr);
    }

    public String getNum_rue() {
        return num_rue.get();
    }

    public SimpleStringProperty num_rueProperty() {
        return num_rue;
    }

    public void setNum_rue(String num_rue) {
        this.num_rue.set(num_rue);
    }

    public String getNom_rue() {
        return nom_rue.get();
    }

    public SimpleStringProperty nom_rueProperty() {
        return nom_rue;
    }

    public void setNom_rue(String nom_rue) {
        this.nom_rue.set(nom_rue);
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public SimpleStringProperty getPrenom_user() {
        return prenom_user;
    }

    public SimpleStringProperty prenom_userProperty() {
        return prenom_user;
    }

    public void setPrenom_user(String prenom_user) {
        this.prenom_user.set(prenom_user);
    }

    public String getNom_user() {
        return nom_user.get();
    }

    public SimpleStringProperty nom_userProperty() {
        return nom_user;
    }

    public void setNom_user(String nom_user) {
        this.nom_user.set(nom_user);
    }

    public String getMail_user() {
        return mail_user.get();
    }

    public SimpleStringProperty mail_userProperty() {
        return mail_user;
    }

    public void setMail_user(String mail_user) {
        this.mail_user.set(mail_user);
    }

    public String getNum_user() {
        return num_user.get();
    }

    public SimpleStringProperty num_userProperty() {
        return num_user;
    }

    public void setNum_user(String num_user) {
        this.num_user.set(num_user);
    }



}
