package com.example.chatapplication;

public class etd {

    private String nom;
    private String note1;
    private String note2;
    private String note3;
    private String note4;

    private String note5;

    private String note6;

    public String getNote6() {
        return note6;
    }

    public void setNote6(String note6) {
        this.note6 = note6;
    }

    public String getNote5() {
        return note5;
    }

    public void setNote5(String note5) {
        this.note5 = note5;
    }


    public etd(String nom) {
        this.nom = nom;
    }

    public etd(String nom, String note5, String note6, String note2, String note3) {
        this.nom = nom;
        this.note5=note5;
        this.note6=note6;
        this.note2=note2;
        this.note3=note3;
    }

    public String getNote4() {
        return note4;
    }

    public void setNote4(String note4) {
        this.note4 = note4;
    }

    public String getNote1() {
        return note1;
    }

    public void setNote1(String note1) {
        this.note1 = note1;
    }

    public String getNote3() {
        return note3;
    }

    public void setNote3(String note3) {
        this.note3 = note3;
    }

    public String getNote2() {
        return note2;
    }

    public void setNote2(String note2) {
        this.note2 = note2;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
