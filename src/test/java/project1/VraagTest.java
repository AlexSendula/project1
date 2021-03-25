package project1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VraagTest {
    @Test
    void getVraagTest() {
        Vraag vraag1 = new Vraag("2+2 = ?", "4");
        assertEquals("2+2 = ?", vraag1.getVraag());
        assertNotEquals("1+2 = ?", vraag1.getVraag());
    }

    @Test
    void getAntwoordTest() {
        Vraag vraag1 = new Vraag("Wat is je favoriete snack?", "Chips");
        assertEquals("Chips", vraag1.getAntwoord());
        assertNotEquals("Kroepoek", vraag1.getAntwoord());
    }
}
