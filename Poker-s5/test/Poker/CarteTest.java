package Poker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarteTest {

        @Test
        void getValue() {
            Carte carte = new Carte(5, "Tr");
            assertEquals(5, carte.getValue());
        }

        @Test
        void getColor() {
            Carte carte = new Carte(5, "Tr");
            assertEquals("Tr", carte.getColor());
        }

        @Test
        void testToString() {
            Carte carte = new Carte(5, "Tr");
            assertEquals("5 de Tr", carte.toString());
        }

}