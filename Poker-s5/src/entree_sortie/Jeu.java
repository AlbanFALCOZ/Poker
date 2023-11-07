package entree_sortie;

import poker.MainPoker;
import poker.Carte;

import java.util.Scanner;


public class Jeu {

    private final Scanner myScan;

    private MainPoker firstHand;
    private MainPoker secondHand;
    private static int numberOfHand = 1;

    public Jeu() {
        myScan = new Scanner(System.in);
    }


    public MainPoker readHand() {
        System.out.println("Main " + numberOfHand + " : ");
        String[] hand = myScan.nextLine().split(" ");
        Carte[] listCard = new Carte[hand.length];

        for (int i = 0; i < hand.length; i++) {
            Carte carte;
            if (hand[i].length() == 3 || hand[i].length() == 4) {
                // Extrait la valeur et la couleur de la carte
                String valueStr = hand[i].substring(0, hand[i].length() - 2);
                String color = hand[i].substring(hand[i].length() - 2);

                // Convertit la valeur en entier
                int value = 0;
                if (valueStr.equals("10") || valueStr.equals("V") || valueStr.equals("D") || valueStr.equals("R") || valueStr.equals("A")) {
                    switch (valueStr) {
                        case "10":
                            value = 10;
                            break;
                        case "V":
                            value = 'V'; // Valet
                            break;
                        case "D":
                            value = 'D'; // Dame
                            break;
                        case "R":
                            value = 'R'; // Roi
                            break;
                        case "A":
                            value = 'A'; // As
                            break;
                    }
                } else {
                    try {
                        value = Integer.parseInt(valueStr);
                    } catch (NumberFormatException e) {
                        System.out.println("Problème : " + hand[i] + " n'est pas une carte valide. Veuillez recommencer");
                        return readHand();
                    }
                }
                carte = new Carte(value, color);
                if ((carte.getValue() == -1) || (carte.getColor().equals("Err"))) {
                    System.out.println("Problème : " + hand[i] + " n'est pas une carte valide. Veuillez recommencer");
                    return readHand();
                }
            } else {
                System.out.println("Problème : " + hand[i] + " n'est pas une carte valide. Veuillez recommencer");
                return readHand();
            }
            listCard[i] = carte;
        }
        numberOfHand++;
        return new MainPoker(listCard);
    }

    public void startGame() {
        firstHand = readHand();
        secondHand = readHand();
        while (!firstHand.mainDifferente(secondHand)) {
            System.out.println("Veuillez rentrer la main à nouveau");
            numberOfHand--;
            secondHand = readHand();
        }
        int maxfirst = firstHand.triValues();
        int maxsecond = secondHand.triValues();
        if (maxfirst > maxsecond) {
            System.out.println("Main 1 gagne");
        } else if (maxfirst < maxsecond) {
            System.out.println("Main 2 gagne");
        } else {
            System.out.println("Egalité");
        }

    }


}

