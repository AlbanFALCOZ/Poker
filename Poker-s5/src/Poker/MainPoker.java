package Poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class MainPoker {
    int CARD_NUMBER = 5;
    Carte[] main;
    int[] occurrences = new int[15];

    public MainPoker(Carte[] main) {
        if (main.length != CARD_NUMBER) {
            throw new IllegalArgumentException("Une main de poker doit contenir exactement 5 cartes.");
        }
        this.main = main;
        initialiserOccurrences();

    }


    private void initialiserOccurrences() {
        for (Carte carte : main) {
            int indice = carte.getValue();
            occurrences[indice]++;
        }
    }

    public int triValues() { //trie les valeurs de la main
        ArrayList<Integer> values = new ArrayList<Integer>();
        for (Carte carte : main) {
            values.add(carte.getValue());
        }
        Collections.sort(values, Collections.reverseOrder()); //trie les valeurs de la main dans l'ordre décroissant;
        return values.get(0);

    }

    public boolean suite() {
        ArrayList<Integer> values = new ArrayList<Integer>();
        for (Carte carte : main) {
            values.add(carte.getValue());
        }
        Collections.sort(values);
        for (int i = 0; i < 4; i++) {
            if (values.get(i) != values.get(i + 1) - 1) {
                return false;
            }
        }
        return true;
    }

    public int carteHauteSuite() {
        if (this.suite()) {
            ArrayList<Integer> values = new ArrayList<Integer>();
            for (Carte carte : this.main) {
                values.add(carte.getValue());
            }
            Collections.sort(values, Collections.reverseOrder());
            return values.get(0);
        } else {
            return -1;
        }
    }

    public boolean pair() {
        /*for (Carte carte : main) { //parcourir chaque carte de la main
            int indice = carte.getValue()-2;
            occurrences[indice] += 1;
            if (occurrences[indice] == 2) {
                return true;
            }
        }
        return false;*/

        for (int occurrence : occurrences) {
            if (occurrence == 2) {
                return true;
            }
        }
        return false;
    }

    public boolean deuxPaires() {
        int paires = 0;
        for (int occurrence : occurrences) {
            if (occurrence == 2) {
                paires++;
            }
        }
        return paires == 2;
    }

    public boolean brelan() {
        for (int occurrence : occurrences) {
            if (occurrence == 3) {
                return true;
            }
        }
        return false;
    }

    public int valeurDuBrelan() {
        for (int i = 2; i <= 14; i++) {
            if (occurrences[i] == 3) {
                return i;
            }
        }
        return -1; // Retourne -1 si la main n'a pas de brelan
    }

    public boolean full() {
        boolean troisCartesIdentiques = false;
        boolean deuxCartesIdentiques = false;

        for (int i = 2; i <= 14; i++) {
            if (occurrences[i] == 3) {
                troisCartesIdentiques = true;
            } else if (occurrences[i] == 2) {
                deuxCartesIdentiques = true;
            }
        }

        return troisCartesIdentiques && deuxCartesIdentiques;
    }

    public boolean carre() {
        for (int i = 2; i <= 14; i++) {
            if (occurrences[i] == 4) {
                return true;
            }
        }
        return false;
    }

    public int valeurDuCarre() {
        for (int i = 2; i <= 14; i++) {
            if (occurrences[i] == 4) {
                return i;
            }
        }
        return -1; // Retourne -1 si la main n'a pas de carré
    }


    public String toString() {
        /*String handString = "Main : ";
        for (int i = 0; i < main.length; i++) {
            handString += main[i].toString();
        }
        return handString;
    }*/

        StringBuilder handString = new StringBuilder("Main : ");
        for (Carte carte : main) {
            handString.append(carte).append(" ");
        }
        return handString.toString().trim();

    }

}
