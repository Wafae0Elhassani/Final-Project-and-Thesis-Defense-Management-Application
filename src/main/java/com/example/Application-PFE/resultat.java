package com.example.chatapplication;

public class resultat
{
    private  String nom;
    private String moyenne;

    public resultat(String nom,String moyenne)
    {
        this.moyenne = moyenne;
        this.nom=nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public void setMoyenne(String moyenne)
    {
        this.moyenne = moyenne;
    }

    public String getNom()
    {
        return nom;
    }

    public String getMoyenne()
    {
        return moyenne;
    }
}
