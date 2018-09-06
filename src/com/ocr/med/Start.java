package com.ocr.med;

import java.util.ArrayList;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        Personnage personne = null;
        //creation une liste des personnage
        ArrayList<Personnage> al = new ArrayList<Personnage>();
        //creation des tableaux pour stocker les sorts de chaque personnage
        String[] sortGuerier = {"coup d'epée", "coup de rage"};
        String[] sortMage = {"Boule de Feu", "Soin"};
        String[] sortRodeur = {"tir à l'arc", "concentration"};
        int i = 1;
        Scanner sc = new Scanner(System.in);
        for (i = 1; i <= 2; i++) {
            System.out.println("creation du personnage de joueur " + i);
            System.out.println(" Veuillez choisir la classe de votre personnage (1:Guerier , 2:Rodeur , 3:Mage)");
            int nbrSel = sc.nextInt();
            if (nbrSel > 3) {
                System.out.println("vous devez entrer un nombre entre 1 et3");
                //pour revenir au récent personnage
                i = i - 1;
            } else {
            }
            switch (nbrSel) {
                case 1:
                    System.out.println("Niveau du personnage?");
                    int nivPer = sc.nextInt();
                    System.out.println("Force du personnage?");
                    int forPer = sc.nextInt();
                    System.out.println("Agilité du personnage?");
                    int agPer = sc.nextInt();
                    System.out.println("Intelligence du personnage?");
                    int intelPer = sc.nextInt();
                    int total = forPer + agPer + intelPer;
                    if (total > nivPer) {
                        System.out.println("Attention le total force + agilité + intelligence doit être égal au niveau du joueur.");
                        i = i - 1;
                        break;
                    } else {
                        try {
                            personne = new Guerier(nivPer, i, forPer, agPer, intelPer);
                        } catch (ConditionException e) {
                            e.printStackTrace();
                        }
                        //addition la personne à la liste du personnage
                        al.add(personne);
                        personne.display();
                    }

                    break;
                case 2:
                    System.out.println("Niveau du personnage?");
                    int nivPer2 = sc.nextInt();
                    System.out.println("Force du personnage?");
                    int forPer2 = sc.nextInt();
                    System.out.println("Agilité du personnage?");
                    int agPer2 = sc.nextInt();
                    System.out.println("Intelligence du personnage?");
                    int intelPer2 = sc.nextInt();
                    int total2 = forPer2 + agPer2 + intelPer2;
                    if (total2 > nivPer2) {
                        System.out.println("Attention le total force + agilité + intelligence doit être égal au niveau du joueur.");
                        i = i - 1;
                        break;
                    }
                    try {
                        personne = new Rodeur(nivPer2, i, forPer2, agPer2, intelPer2);
                    } catch (ConditionException e) {
                        e.printStackTrace();
                    }
                    al.add(personne);
                    personne.display();

                    break;
                case 3:
                    System.out.println("Niveau du personnage?");
                    int nivPer3 = sc.nextInt();
                    System.out.println("Force du personnage?");
                    int forPer3 = sc.nextInt();
                    System.out.println("Agilité du personnage?");
                    int agPer3 = sc.nextInt();
                    System.out.println("Intelligence du personnage?");
                    int intelPer3 = sc.nextInt();
                    int total3 = forPer3 + agPer3 + intelPer3;
                    if (total3 > nivPer3) {
                        System.out.println("Attention le total force + agilité + intelligence doit être égal au niveau du joueur.");
                        i = i - 1;
                        break;
                    }
                    try {
                        personne = new Mage(nivPer3, i, forPer3, agPer3, intelPer3);
                    } catch (ConditionException e) {
                        e.printStackTrace();
                    }
                    al.add(personne);
                    personne.display();

                    break;
            }
        }
        int j = 0, k = 1, temp;
        while (!al.get(j).estVivant() && !al.get(k).estVivant()) {
            al.get(j).afficheEtat();
            System.out.println("choisir votre action(1:attaque basique , 2:attaque spéciale)");
            int select = sc.nextInt();
            if (al.get(j) instanceof Guerier) {
                if (select == 1) {
                    al.get(j).changerArme(new Arme(sortGuerier[select - 1], al.get(j).getForce(), 0));
                    System.out.println(al.get(j).toString());
                    al.get(j).attaquer(al.get(j), al.get(k), select);
                    //cette permetation nous permet de balancer entre 0 et 1
                    temp = k;
                    k = j;
                    j = temp;
                }
                if (select == 2) {
                    al.get(j).changerArme(new Arme(sortGuerier[select - 1], al.get(j).getForce() * 2, al.get(j).getForce() / 2));
                    System.out.println(al.get(j).toString());
                    al.get(j).attaquer(al.get(j), al.get(k), select);
                    temp = k;
                    k = j;
                    j = temp;
                }

            } else {
                if (al.get(j) instanceof Rodeur) {
                    if (select == 1) {
                        al.get(j).changerArme(new Arme(sortRodeur[select - 1], al.get(j).getAgilite(), 0));
                        System.out.println(al.get(j).toString());
                        al.get(j).attaquer(al.get(j), al.get(k), select);
                        temp = k;
                        k = j;
                        j = temp;
                    }
                    if (select == 2) {
                        al.get(j).changerArme(new Arme(sortRodeur[select - 1], 0, al.get(j).getNiveau() / 2));
                        System.out.println(((Rodeur) al.get(j)).afficheSorte());
                        al.get(j).attaquer(al.get(j), al.get(k), select);
                        temp = k;
                        k = j;
                        j = temp;
                    }
                } else {
                    if (al.get(j) instanceof Mage) {
                        if (select == 1) {
                            al.get(j).changerArme(new Arme(sortMage[select - 1], al.get(j).getIntelligence(), 0));
                            System.out.println(al.get(j).toString());
                            al.get(j).attaquer(al.get(j), al.get(k), select);
                            temp = k;
                            k = j;
                            j = temp;
                        }
                        if (select == 2) {
                            al.get(j).changerArme(new Arme(sortMage[select - 1], 0, al.get(j).getIntelligence() * 2));
                            System.out.println(((Mage) al.get(j)).afficheSorte());
                            al.get(j).attaquer(al.get(j), al.get(k), select);
                            temp = k;
                            k = j;
                            j = temp;
                        }
                    }
                }
            }
        }
        if(al.get(j).estVivant())
            System.out.println("le joueur "+al.get(j).getNumeroJoueur()+ " est perdu");
    }
}
