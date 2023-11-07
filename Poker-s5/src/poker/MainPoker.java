package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class MainPoker {
    int CARD_NUMBER = 5;
    Carte[] main;
    int[] occurrences = new int[15]; //Cette liste contient le nombre d'occurences de chaque carte. Ex : Si nous avons 2 deux, la liste contiendra
    int[] occurencesCouleur = new int[4];
    ArrayList<Integer> valuesSorted = new ArrayList<Integer>();

    public MainPoker(Carte[] main) {
        if (main.length != CARD_NUMBER) {
            throw new IllegalArgumentException("Une main de poker doit contenir exactement 5 cartes.");
        }
        if (!verifMain(main)) {
            throw new IllegalArgumentException("Vous avez rentré deux fois la même carte");
        }
        this.main = main;
        initialiserOccurrences();
    }

    public boolean verifMain(Carte[] main) {
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 5; j++) {
                if (!main[i].verifCarte(main[j])) return false;
            }
        }
        return true;
    }

    public boolean mainDifferente(MainPoker other) {
        for(int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!main[i].verifCarte(other.main[j])) {
                    System.out.println(main[i] + " se trouve dans les deux mains");
                    return false;
                }
            }
        }
        return true;
    }

    private void initialiserOccurrences() {
        for (Carte carte : main) {
            int indice = carte.getValue();
            occurrences[indice]++;
            String color = carte.getColor();
            if (color.equals("Ca")) occurencesCouleur[0]++;
            else if (color.equals("Co")) occurencesCouleur[1]++;
            else if (color.equals("Pi")) occurencesCouleur[2]++;
            else occurencesCouleur[3]++;
        }
    }

    public int triValues() { //trie les valeurs de la main
        ArrayList<Integer> values = new ArrayList<Integer>();
        for (Carte carte : main) {
            values.add(carte.getValue());
        }
        Collections.sort(values, Collections.reverseOrder()); //trie les valeurs de la main dans l'ordre décroissant;
        valuesSorted = values;
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
        if (brelan() && pair()) return true;
        return false;
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



    public boolean couleur(){ //fonction qui retourne vrai si toutes les cartes ont la meme couleur
        String couleurIndice0=main[0].getColor();
        boolean samecolor=true;
        for(int i=1; i< main.length; i++){
            if(!main[i].getColor().equals(couleurIndice0)){
                samecolor=false;
                break;
            }
        }
        return samecolor;
    }
    public boolean straightFlush(){
        if(suite()&&couleur()) return true;
        return false;
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
