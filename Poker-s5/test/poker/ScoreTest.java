
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


}



