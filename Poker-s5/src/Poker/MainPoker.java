package Poker;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainPoker {

    private Cartes Main;
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

    public void ajoutCartes() {
        //System.out.println(this.name + " : ");
        this.Main = new Cartes(myScan.nextInt(),"Tr");
    }

    public void toCompare(MainPoker other){
        if (this.Main.getValue() > other.Main.getValue()) {
            System.out.println("La main 1 a gagnée !");
        }
        else if (this.Main.getValue() < other.Main.getValue()) {
            System.out.println("La main 2 a gagnée !");
        }
        else {
            System.out.println("Egalité !");
        }
    }

}
