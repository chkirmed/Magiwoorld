package com.ocr.med;

public class Arme
{
    private String nom;
    private int attaque;
    private int effet;
    public Arme (String nom, int attaque,int effet) {
        this.nom = nom;
        this.attaque = attaque;
        this.effet=effet;
    }
    // une methode pour jouer tour par tour
    public void changer (String nvNom, int nvAttaque,int nveffet) {
        nom = nvNom;
        attaque = nvAttaque;
        effet = nveffet;
    }
    protected int getNbDegats () {
        return attaque;
    }
    public int getNbEffet(){
        return effet;
    }
    public String toString () {
        return " utilise "+nom+" et inflige : "+attaque+" dommage\n";
    }
    public String afficheArme(){
        return " utilise "+nom+" et gagne : "+effet+"\n";
    }
}


