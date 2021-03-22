import org.junit.jupiter.api.Test;
import project1.Vraag;

import static org.junit.jupiter.api.Assertions.*;

class VraagTest {

    @Test
    void getVraag() {
        Vraag vraag = new Vraag("vraag1" , "");
        String vraag1 = "vraag";
        assertEquals("vraag1",vraag.getVraag());
    }

    @Test
    void getAntwoord(){
        Vraag vraag = new Vraag("" , "compleet ");
        assertEquals("compleet",vraag.getAntwoord());
    }
}