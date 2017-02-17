package v2.ihm;

import java.util.Scanner;

import v2.Saisie;

public class SaisieConsole implements Saisie {

    private static final Scanner sc = new Scanner(System.in);

    public String lireChaine(String prompt) {
    	
        System.out.print(prompt);
        return sc.nextLine();
    }
    
}
