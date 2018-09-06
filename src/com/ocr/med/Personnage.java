package com.ocr.med;

public abstract class Personnage {
    private int niveau;
    protected int numeroJoueur;
    private int force;
    private int vie;
    protected Arme arme;
    private int agilite;
    private int intelligence;
    public Personnage(int niv,int numJ,int forc,int agil,int intell)throws ConditionException{
        if((niv<=0||niv>100)||(forc<0||forc>100)||(agil<0||agil>100)||(intell<0||intell>100))
            throw new ConditionException(niv,forc,agil,intell);
        else{
            niveau=niv;
            vie=niveau*5;
            numeroJoueur=numJ;
            force=forc;
            agilite=agil;
            intelligence=intell;}
    }
    public abstract void attaquer(Personnage p,Personnage cible,int i);
    public void recevoirDegats (int degats) {
        vie -= degats;
        if (vie < 0) vie = 0;}
    protected void retirerForce (int quantite) {
        force -= quantite;
        if  (force < 0) {

            force = 0;
        }
    }
    //methode pour ajouter d'agilite a un joueur
    protected void gagneAgilite(int quantite){
        agilite+=quantite;
    }
    //méthode pour ajouter des points de vie à un joueur
    protected void boirePotionDeVie (int quantite) {
        int v=niveau*5;//ce variable pour ne pas depasser le vie de depart
        vie += quantite;
        if (vie > v) vie = v;
    }
    //une methode pour savoir si le joueur est vivant ou non
    protected boolean estVivant () {
        if(this.getVie()<=0)
            return true;
        else{
            return false;}
    }
    //une methode pour charger les armes tour par tour
    public abstract void changerArme (Arme nvArme);
    public abstract String toString () ;
    public void afficheEtat(){
        System.out.print("Joueur "+numeroJoueur+" ("+vie+" vitalité)");
    }
    public int getNiveau() {
        return niveau;
    }
//les setters et getters
    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
    protected Arme getArme () {
        return arme;
    }
    public int getNumeroJoueur() {
        return numeroJoueur;
    }

    public void setNumeroJoueur(int numeroJoueur) {
        this.numeroJoueur = numeroJoueur;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }
    public int getVie() {
        return vie;}
    public void setVie(int vie) {
        this.vie = vie;
    }

    public int getAgilite() {
        return agilite;
    }

    public void setAgilite(int agilite) {
        this.agilite = agilite;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int Total() {
        int t=(this.getForce()+this.getAgilite()+this.getIntelligence());
        return t;
    }

    public abstract void display();
}

