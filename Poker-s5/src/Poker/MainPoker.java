package Poker;

import java.util.Scanner;

public class MainPoker {

    Carte[] main;
    int[] occurrences = new int[14];

    public MainPoker(Carte[] main){
        this.main = main;

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


}
