package Poker;

import java.util.ArrayList;
import java.util.Collections;

public class MainPoker {
    int CARD_NUMBER=5;
    Carte[] main;
    int[] occurrences = new int[14];

    public MainPoker(Carte[] main){
        this.main = main;

    }
    public ArrayList<Integer> triValues(){ //trie les valeurs de la main
        ArrayList<Integer> values = new ArrayList<Integer>();
        for(Carte carte: main){
            values.add(carte.getValue());
        }
        Collections.sort(values);
        return values;

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
