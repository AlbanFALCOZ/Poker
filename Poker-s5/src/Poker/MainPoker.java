package Poker;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainPoker {

    private Cartes[] main = new Cartes[2];
    private Scanner myScan;
    private String name;

    public MainPoker(){
        this.myScan = new Scanner(System.in);
        /*
        for(int i = 2; i <= 10; i++){
            dictVal.put(String.valueOf(i),i);
        }
        */

    }
    public boolean verifMain() {
        return carte.getValue() >= 2 && carte.getValue() <= 14;
        /*if (this.Main.getValue()<=10 && this.Main.getValue()>=2) return true;
        return false;*/
    }

    public void ajoutCartes() {
        //System.out.println(this.name + " : ");
        for (int i = 0; i < 2; i++) {
            int value = myScan.nextInt();
            String color = myScan.next(); //lire la couleur
            Cartes carte = new Cartes(value, color);
            if (verifMain(carte)) {
                this.main[i] = carte;
            } else {
                System.out.println("Valeur invalide. Entrez une valeur entre 2 et 14."); //14 pour As
                i--;
            }
        }
        /*
        this.Main = new Cartes(myScan.nextInt(),"Tr");
        if (!verifMain()) ajoutCartes();*/
    }


    public boolean isConsecutive(MainPoker other) {
        int diff1 = Math.abs(this.main[0].getValue() - this.main[1].getValue());
        int diff2 = Math.abs(other.main[0].getValue() - other.main[1].getValue());
        return diff1 == 1 || diff2 == 1 || diff1 == 12 || diff2 == 12; // Vérification des suites, en incluant la combinaison As-Roi
    }


    public void toCompare(MainPoker other){
        int thisSum = this.main[0].getValue() + this.main[1].getValue();
        int otherSum = other.main[0].getValue() + other.main[1].getValue();

        if (thisSum > otherSum) {
            System.out.println("La main 1 a gagnée !");
        }
        else if (thisSum < otherSum) {
            System.out.println("La main 2 a gagnée !");
        }
        else {
            System.out.println("Egalité !");
        }

        if(isConsecutive(this) || isConsecutive(other)){
            System.out.println("Il y a une suite dans au moins une des mains.");
        }
    }

}
