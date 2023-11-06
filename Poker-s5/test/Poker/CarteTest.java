package Poker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarteTest {

        @Test
        void getValue() {
            Carte carte = new Carte(5, "Tr");
            assertEquals(5, carte.getValue());
            Carte carte2 = new Carte('V', "Tr");
            assertEquals(11, carte2.getValue());
            Carte carte3 = new Carte('D', "Tr");
            assertEquals(12, carte3.getValue());
            Carte carte4 = new Carte('R', "Tr");
            assertEquals(13, carte4.getValue());
            Carte carte5 = new Carte('A', "Tr");
            assertEquals(14, carte5.getValue());
            Carte carte6 = new Carte('Z', "Tr");
            assertEquals(-1, carte6.getValue());
            Carte carte7 = new Carte(-1, "Tr");
            assertEquals(-1, carte7.getValue());
        }


        @Test
        void getColor() {
            Carte carte = new Carte(5, "Tr");
            assertEquals("Tr", carte.getColor());
        }

        @Test
        void wrongColor() {
            Carte carte = new Carte(5, "He");
            assertEquals("Err", carte.getColor());
        }

        @Test
        void testToString() {
            Carte carte = new Carte(5, "Tr");
            assertEquals("5 de Tr", carte.toString());
        }

}