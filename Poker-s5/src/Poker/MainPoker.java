package Poker;

import java.util.Scanner;

public class MainPoker {

    Carte[] main;
    int[] occurrences = new int[14];

    public MainPoker(Carte[] main){
        this.main=main;
    }

    public boolean pair() {
        for (Carte carte : main) { //parcourir chaque carte de la main
            int indice = carte.getValue()-2;
            occurrences[indice] += 1;

            if (occurrences[indice] == 2) {
                return true;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        Carte[] testMain = {
                new Carte(3,"Tr"),
                new Carte(4,"Tr"),
                new Carte(6,"Tr"),
                new Carte(8,"Tr"),
                new Carte(10,"Tr")
        };
        MainPoker pokerMain = new MainPoker(testMain);
        System.out.println(pokerMain.pair()); // devrait retourner true
    }

    public String toString() {
        String handString = "Main : ";
        for (int i = 0; i < main.length; i++) {
            handString += main[i].toString();
        }
        return handString;
    }

}
