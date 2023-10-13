package Poker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainPokerTest {

        @Test
        public void testMainPoker() {
            MainPoker mainPoker = new MainPoker();
            assertNotNull(mainPoker);
        }

        @Test
        public void testVerifMain() {
            MainPoker mainPoker = new MainPoker();

            mainPoker.Main = new Cartes(5, "Tr");
            assertTrue(mainPoker.verifMain());


            mainPoker.Main = new Cartes(1, "Tr");
            assertFalse(mainPoker.verifMain());

            mainPoker.Main = new Cartes(11, "Tr");
            assertFalse(mainPoker.verifMain());
        }

/*        @Test
        public void testAjoutCartes() {
            MainPoker mainPoker = new MainPoker();
            mainPoker.ajoutCartes();

}*/

        @Test
        public void testToCompare() {
            MainPoker mainPoker1 = new MainPoker();
            MainPoker mainPoker2 = new MainPoker();

            mainPoker1.Main = new Cartes(10, "Tr");
            mainPoker2.Main = new Cartes(5, "Tr");
            mainPoker1.toCompare(mainPoker2);

            mainPoker1.Main = new Cartes(5, "Tr");
            mainPoker2.Main = new Cartes(10, "Tr");
            mainPoker1.toCompare(mainPoker2);

            mainPoker1.Main = new Cartes(5, "Tr");
            mainPoker2.Main = new Cartes(5, "Ca");
            mainPoker1.toCompare(mainPoker2);
        }
    }
