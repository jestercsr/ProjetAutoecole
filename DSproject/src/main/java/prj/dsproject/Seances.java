package prj.dsproject;

import javafx.beans.property.SimpleStringProperty;

public class Seances {

    private SimpleStringProperty nom_user, prenom_user, date_eve, nom_emp, heure_debut, heure_fin;

    public Seances(String nu, String pu, String ne, String de, String deb, String fin){
        this.prenom_user=new SimpleStringProperty(pu);
        this.nom_user=new SimpleStringProperty(nu);
        this.nom_emp=new SimpleStringProperty(ne);
        this.date_eve=new SimpleStringProperty(de);
        this.heure_debut=new SimpleStringProperty(deb);
        this.heure_fin=new SimpleStringProperty(fin);
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

    public String getPrenom_user() {
        return prenom_user.get();
    }

    public SimpleStringProperty prenom_userProperty() {
        return prenom_user;
    }

    public void setPrenom_user(String prenom_user) {
        this.prenom_user.set(prenom_user);
    }

    public String getNom_emp() {
        return nom_emp.get();
    }

    public SimpleStringProperty nom_empProperty() {
        return nom_emp;
    }

    public void setNom_emp(String nom_emp) {
        this.nom_emp.set(nom_emp);
    }

    public String getDate_eve() {
        return date_eve.get();
    }

    public SimpleStringProperty date_eveProperty() {
        return date_eve;
    }

    public void setDate_eve(String date_eve) {
        this.date_eve.set(date_eve);
    }

    public String getHeure_debut() {
        return heure_debut.get();
    }

    public SimpleStringProperty heure_debutProperty() {
        return heure_debut;
    }

    public void setHeure_debut(String heure_deb) {
        this.heure_debut.set(heure_deb);
    }

    public String getHeure_fin() {
        return heure_fin.get();
    }

    public SimpleStringProperty heure_finProperty() {
        return heure_fin;
    }

    public void setHeure_fin(String heure_fin) {
        this.heure_fin.set(heure_fin);
    }
}

