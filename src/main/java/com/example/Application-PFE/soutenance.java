package com.example.chatapplication;

public class soutenance
{
    private String nom;
    private String heure;
    private String mois;
    private String jour;
    private String année;
    private String minute;

    private String salle;

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public soutenance(String nom, String jour,String mois,String année,String salle, String heure, String minute)
    {
        this.nom=nom;
        this.salle=salle;
        this.année = année;
        this.heure=heure;
        this.minute=minute;
        this.mois=mois;
        this.jour=jour;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure= heure;
    }

    public String getAnnée() {
        return année;
    }

    public void setAnnée(String année) {
        this.année = année;
    }
}
