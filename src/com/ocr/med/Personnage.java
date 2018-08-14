package com.ocr.med;

public abstract class Personnage {
    int niveau;
    int vie;
    int force;
    int agile;
    int intelligence;
    int numjoueur;
    public Personnage(int num,int niv,int v,int f,int ag,int inte){
        this.niveau=niv;
        this.force=f;
        this.vie=vie;
        this.agile=ag;
        this.intelligence=inte;
        this.numjoueur=num;
    }
}
