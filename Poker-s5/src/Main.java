import Poker.Cartes;
import Poker.MainPoker;
public class Main {
    public static void main(String[] args) {
        MainPoker main1 = new MainPoker();
        MainPoker main2 = new MainPoker();
        System.out.print("Main 1 : ");
        main1.ajoutCartes();
        System.out.print("Main 2 : ");
        main2.ajoutCartes();
        main1.toCompare(main2);
    }
}