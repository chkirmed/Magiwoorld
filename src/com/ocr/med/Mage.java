package com.ocr.med;

public class Mage extends Personnage {
    public Mage(int niv, int numJ, int force, int agilite, int intelligence) throws ConditionException {
        super(niv, numJ, force, agilite, intelligence);
        super.Total();
    }

    public void display() {
        System.out.println("hohohi je suis le " + this.getClass().getSimpleName() + " joueur " + this.getNumeroJoueur() + " niveau " + this.getNiveau() + " je possede " + (this.getNiveau() * 5) + " de vitalité, " + this.getForce() + " de force et " + this.getAgilite() + " d'agilité et " + this.getIntelligence() + " d'intelligence!");
    }

    public void attaquer(Personnage p, Personnage c, int i) {
        if (i == 1) {
            int degats;
            degats = arme.getNbDegats();
            c.recevoirDegats(degats);
            System.out.println("le joueur" + c.numeroJoueur + " perd " + degats + " points");
        }
        if (i == 2) {
            int gagne = arme.getNbEffet();
            p.boirePotionDeVie(gagne);
        }
    }

    public void changerArme(Arme nvArme) {
        arme = nvArme;
    }

    public String toString() {
        return "Le joueur " + super.numeroJoueur + " " + arme.toString();
    }

    public String afficheSorte() {
        return "Le joueur " + super.numeroJoueur + " " + arme.afficheArme() + " en points de vie";
    }
}
