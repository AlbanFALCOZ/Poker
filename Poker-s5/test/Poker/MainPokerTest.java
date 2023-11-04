package Poker;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainPokerTest {
    private MainPoker mainPoker;
    private MainPoker mainPokerAvecDeuxPaires;
    private MainPoker mainPokerSansDeuxPaires;

    @Before
    public void setUp() {
        // Créez une main de poker pour chaque test
        Carte[] main = {
                new Carte('A', "Tr"),
                new Carte(4, "Tr"),
                new Carte(6, "Tr"),
                new Carte('A', "Tr"),
                new Carte(10, "Tr")
        };
        mainPoker = new MainPoker(main);

        // Créez une main de poker avec deux paires
        Carte[] mainAvecDeuxPaires = {
                new Carte(3, "Tr"),
                new Carte(3, "Tr"),
                new Carte(6, "Tr"),
                new Carte(6, "Tr"),
                new Carte(10, "Tr")
        };
        mainPokerAvecDeuxPaires = new MainPoker(mainAvecDeuxPaires);

        // Créez une main de poker sans deux paires
        Carte[] mainSansDeuxPaires = {
                new Carte(3, "Tr"),
                new Carte(4, "Tr"),
                new Carte(6, "Tr"),
                new Carte(8, "Tr"),
                new Carte(10, "Tr")
        };
        mainPokerSansDeuxPaires = new MainPoker(mainSansDeuxPaires);


    }

    @Test
    public void testTriValues() {
        // Teste si les valeurs des cartes sont triées correctement
        // Les valeurs de cartes triées devraient être [14, 14, 10, 6, 4]
        assertEquals(14, mainPoker.triValues());
    }

    @Test
    public void testPair() {
        // Teste si la main contient une paire de cartes de même valeur
        // Dans ce cas, la main contient deux cartes de valeur A
        assertTrue(mainPoker.pair());

        // Créez une nouvelle main sans paire
        Carte[] mainSansPaire = {
                new Carte(3, "Tr"),
                new Carte(4, "Tr"),
                new Carte(6, "Tr"),
                new Carte(8, "Tr"),
                new Carte(10, "Tr")
        };
        MainPoker mainPokerSansPaire = new MainPoker(mainSansPaire);

        // Dans cette main, il n'y a pas de paire
        assertFalse(mainPokerSansPaire.pair());
        assertFalse(mainPokerSansPaire.suite());
    }


    @Test
    public void testDeuxPaires() {
        // La main contient effectivement deux paires
        assertTrue(mainPokerAvecDeuxPaires.deuxPaires());
        // La main n'a pas deux paires
        assertFalse(mainPokerSansDeuxPaires.deuxPaires());
    }


    @Test
    public void testBrelan() {
        // Teste si la main contient un brelan de cartes de même valeur
        // Dans ce cas, la main ne contient pas de brelan
        assertFalse(mainPoker.brelan());
        assertEquals(-1, mainPoker.valeurDuBrelan());

        // Créez une nouvelle main avec brelan
        Carte[] mainAvecBrelan = {
                new Carte('A', "Tr"),
                new Carte('A', "Tr"),
                new Carte('A', "Tr"),
                new Carte(8, "Tr"),
                new Carte(10, "Tr")
        };
        MainPoker mainPokerAvecBrelan = new MainPoker(mainAvecBrelan);

        // Dans cette main, il y a un brelan
        assertTrue(mainPokerAvecBrelan.brelan());
        assertFalse(mainPokerAvecBrelan.pair());
        assertEquals(14, mainPokerAvecBrelan.valeurDuBrelan());
    }

    @Test
    public void testSuite() {
        Carte[] mainAvecSuite = {
                new Carte(10, "Tr"),
                new Carte('V', "Tr"),
                new Carte('D', "Tr"),
                new Carte('R', "Tr"),
                new Carte('A', "Tr")
        };

        MainPoker mainPokerAvecSuite = new MainPoker(mainAvecSuite);
        assertTrue(mainPokerAvecSuite.suite());

        Carte[] mainSansSuite = {
                new Carte(3, "Tr"),
                new Carte(4, "Tr"),
                new Carte(6, "Tr"),
                new Carte(8, "Tr"),
                new Carte(10, "Tr")
        };

        MainPoker mainPokerSansSuite = new MainPoker(mainSansSuite);
        assertFalse(mainPokerSansSuite.suite());
    }

    @Test
    public void testCarteHauteSuite() {
        Carte[] mainAvecSuite = {
                new Carte(10, "Tr"),
                new Carte('V', "Tr"),
                new Carte('D', "Tr"),
                new Carte('R', "Tr"),
                new Carte('A', "Tr")
        };
        MainPoker mainPokerAvecSuite = new MainPoker(mainAvecSuite);
        int result = mainPokerAvecSuite.carteHauteSuite();

        assertEquals(14, result);

        Carte[] mainSansSuite = {
                new Carte(3, "Tr"),
                new Carte(4, "Tr"),
                new Carte(6, "Tr"),
                new Carte(8, "Tr"),
                new Carte(10, "Tr")
        };
        MainPoker mainPokerSansSuite = new MainPoker(mainSansSuite);
        int result2 = mainPokerSansSuite.carteHauteSuite();

        assertEquals(-1, result2);
    }


    @Test
    public void testFull() {
        Carte[] fullHand = {
                new Carte(2, "Tr"),
                new Carte(2, "Co"),
                new Carte(2, "Ca"),
                new Carte(3, "Pi"),
                new Carte(3, "Tr")
        };

        MainPoker mainPoker = new MainPoker(fullHand);

        assertTrue(mainPoker.full());
        assertFalse(mainPoker.deuxPaires());
        assertTrue(mainPoker.pair());
        assertTrue(mainPoker.brelan());
        assertFalse(mainPoker.suite());

        Carte[] nonFullHand = {
                new Carte(2, "Tr"),
                new Carte(2, "Co"),
                new Carte(4, "Ca"),
                new Carte(3, "Pi"),
                new Carte(3, "Tr")
        };

        MainPoker mainPoker2 = new MainPoker(nonFullHand);

        assertFalse(mainPoker2.full());
        assertFalse(mainPoker2.brelan());
        assertTrue(mainPoker2.deuxPaires());
        assertTrue(mainPoker2.pair());
    }

    @Test
    public void testCarre() {
        Carte[] nonCarreHand = {
                new Carte(2, "Tr"),
                new Carte(2, "Co"),
                new Carte(4, "Ca"),
                new Carte(3, "Pi"),
                new Carte(3, "Tr")
        };

        MainPoker mainPoker = new MainPoker(nonCarreHand);

        assertFalse(mainPoker.carre());

        Carte[] carreHand = {
                new Carte(2, "Tr"),
                new Carte(2, "Co"),
                new Carte(2, "Ca"),
                new Carte(2, "Pi"),
                new Carte(3, "Tr")
        };

        MainPoker mainPoker2 = new MainPoker(carreHand);
        assertTrue(mainPoker2.carre());
        assertEquals(2, mainPoker2.valeurDuCarre());

    }

    @Test
    public void testToString() {
        // Teste la représentation textuelle de la main
        String expected = "Main : 14 de Tr 4 de Tr 6 de Tr 14 de Tr 10 de Tr";
        assertEquals(expected, mainPoker.toString());
    }
}
