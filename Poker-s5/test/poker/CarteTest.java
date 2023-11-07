package poker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarteTest {

    public Carte _5Tr;
    public Carte _VTr;
    public Carte _DTr;
    public Carte _RTr;
    public Carte _ATr;
    public Carte _ZTr; //Wrong value
    public Carte _1Tr; //Wrong value
    public Carte _5He; //Wrong Color


        @BeforeEach
        public void setUp() {
            _5Tr = new Carte(5, "Tr");
            _VTr = new Carte('V', "Tr");
            _DTr = new Carte('D', "Tr");
            _RTr = new Carte('R', "Tr");
            _ATr = new Carte('A', "Tr");
            _ZTr = new Carte('Z', "Tr");
            _1Tr = new Carte(-1, "Tr");
            _5He = new Carte(5, "He");
        }

        @Test
        void getValue() {
            assertEquals(5, _5Tr.getValue());
            assertEquals(11, _VTr.getValue());
            assertEquals(12, _DTr.getValue());
            assertEquals(13, _RTr.getValue());
            assertEquals(14, _ATr.getValue());
            assertEquals(-1, _ZTr.getValue());
            assertEquals(-1, _1Tr.getValue());
        }


        @Test
        void getColor() {
            assertEquals("Tr", _5Tr.getColor());
        }

        @Test
        void wrongColor() {
            assertEquals("Err", _5He.getColor());
        }


        @Test
        void sameCard() {
            Carte _5Tr_2 = new Carte(5, "Tr");
            Carte _6Tr = new Carte(6, "Tr");
            Carte _5Ca = new Carte(5, "Ca");
            assertFalse(_5Tr.verifCarte(_5Tr_2)); //Meme carte
            assertTrue(_5Tr.verifCarte(_6Tr)); //Value differente
            assertTrue(_5Tr.verifCarte(_5Ca)); //Couleur differente
        }

        @Test
        void testToString() {
            assertEquals("5 de Tr", _5Tr.toString());
        }

}