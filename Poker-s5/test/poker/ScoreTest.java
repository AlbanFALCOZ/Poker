
package poker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



class ScoreTest {

    private MainPoker hand;
    private Score score;



    @BeforeEach
    void setUp() {
        Carte[] cartes = {
                new Carte(10, "Ca"),
                new Carte(10, "Co"),
                new Carte(10, "Pi"),
                new Carte(3, "Tr"),
                new Carte(3, "Ca")
        };
        hand = new MainPoker(cartes);
        score = new Score(hand);
    }


    @Test
    void testScoreForFull() {
        int result = score.calculateScoreHand();
        assertEquals(6, result, "Le score pour un full devrait être 6");
    }
    @Test
    void testCompareHand(){
        /*
        Carte[] cartes1 = {
                new Carte(10, "Ca"),
                new Carte(10, "Co"),
                new Carte(10, "Pi"),
                new Carte(3, "Tr"),
                new Carte(2, "Ca")
        };
        MainPoker main1= new MainPoker(cartes1);
        Score score1=new Score(main1);
        Carte[] cartes2={
                new Carte(10, "Tr"),
                new Carte(9, "Co"),
                new Carte(2, "Pi"),
                new Carte(2, "Tr"),
                new Carte(4, "Tr")
        };
        */


        Carte[] cartes3 = {
                new Carte(10, "Ca"),
                new Carte(9, "Co"),
                new Carte(8, "Pi"),
                new Carte(7, "Tr"),
                new Carte(6, "Ca")
        };
        MainPoker main3= new MainPoker(cartes3);
        Score score3=new Score(main3);
        Carte[] cartes4={
                new Carte(10, "Tr"),
                new Carte(9, "Co"),
                new Carte(8, "Pi"),
                new Carte(7, "Tr"),
                new Carte(5, "Tr")
        };
        MainPoker main4= new MainPoker(cartes4);
        Score score4=new Score(main4);
        assertEquals("Main 3 a gagné",score3.compareHand(score4));


    }

}



