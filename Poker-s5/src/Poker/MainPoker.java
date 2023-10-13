package Poker;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainPoker {

    protected Cartes Main;
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
        if (this.Main.getValue()<=10 && this.Main.getValue()>=2) return true;
        return false;
    }
    public void ajoutCartes() {
        System.out.println("Main : ");
        this.Main = new Cartes(myScan.nextInt(),"Tr");
        if (!verifMain()) ajoutCartes();
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
