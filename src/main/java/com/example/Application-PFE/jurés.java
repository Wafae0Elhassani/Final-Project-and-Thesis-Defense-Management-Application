package com.example.chatapplication;

public class jurés {

    String nom;
    String pres;
    String rap1;
    String rap2;

    public jurés(String nom,String pres,String rap1,String rap2) {
        this.nom = nom;
        this.pres= pres;
        this.rap1=rap1;
        this.rap2=rap2;
    }

    public jurés(String nom)
    {
        this.nom = nom;
    }

    public jurés(String pres,String rap1,String rap2) {
        this.pres= pres;
        this.rap1=rap1;
        this.rap2=rap2;
    }



    public String getRap2() {
        return rap2;
    }

    public void setRap2(String rap2) {
        this.rap2 = rap2;
    }

    public String getRap1() {
        return rap1;
    }

    public void setRap1(String rap1) {
        this.rap1 = rap1;
    }

    public String getPres() {
        return pres;
    }

    public void setPres(String pres) {
        this.pres = pres;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

