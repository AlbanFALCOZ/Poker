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

    public void readHand(MainPoker PokerHand) { //
        System.out.println("Main 1 : ");
        String hand[] = myScan.next().split(" ");
        if (hand.length >= 6) {
            System.out.println("Problème lors de la lecture de la main");
            readHand(PokerHand);
        }
        else {
            Carte listCard[] = new Carte[hand.length];
            for (int i = 0; i < hand.length; i++) {
                Carte carte;
                if (hand[i].length() == 4)  {
                    carte = new Carte(parseInt(hand[i].substring(0,1)),"Tr");
                }
                else {
                    carte = new Carte(parseInt(hand[i].substring(0,2)),"Tr");
                }
                if (carte.getValue() == -1) {
                    System.out.println("Problème : " + hand[i] + " n'est pas une carte. Veuillez recommencer");
                    readHand(PokerHand);
                }
                listCard[i] = carte;
            }
            PokerHand = new MainPoker(listCard);
        }
    }

    public void startGame(){
        readHand(this.firstHand);
        readHand(this.secondHand);
        System.out.println(firstHand);
        System.out.println(secondHand);
    }
}
