package Entrée_sortie;
import Poker.MainPoker;
import Poker.Carte;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Jeu {

    private Scanner myScan;
    private MainPoker firstHand;
    private MainPoker secondHand;

    public Jeu() {
        Scanner myScan = new Scanner(System.in);
    }

    public void readHand() {
        System.out.println("Main 1 : ");
        String hand[] = myScan.next().split(" ");
        if (hand.length <= 0) {
            System.out.println("Problème lors de la lecture de la main");
            readHand();
        }
        else {
            for (int i = 0; i < hand.length; i++) {
                //String handValue = hand[i].replaceAll("\\D+","");
                Carte carte = new Carte(parseInt(hand[i].substring(1)),"Tr");
            }
        }
    }
}
