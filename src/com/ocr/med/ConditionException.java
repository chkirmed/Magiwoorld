package com.ocr.med;

public class ConditionException extends Exception {
    public ConditionException(int niv,int forc,int agil,int intell){
        System.out.println("le niveau doit entre 1 et 100" );
        System.out.println("la force,agil,intell doivent etre entre 0 et 100" );
    }
}

