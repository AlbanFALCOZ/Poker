package Poker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainPokerTest {

    Carte[] testMain = {
            new Carte(3,"Tr"),
            new Carte(4,"Tr"),
            new Carte(6,"Tr"),
            new Carte(8,"Tr"),
            new Carte(10,"Tr")
    };
    @Test
    void testPair() {
        MainPoker pokerMain = new MainPoker(testMain);
        assertFalse(pokerMain.pair());

    }

}