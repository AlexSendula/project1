import org.junit.Test;
import project1.Examen;
import project1.Vraag;

import static org.junit.jupiter.api.Assertions.*;

class ExamenTest {

    @Test
   public void getNaam() {
         Vraag[] vragenWiskunde = {new Vraag("zit een vraag  ?","antwoord"),
                new Vraag("zit een vraag  ","antwoord")};
        Examen test = new Examen("Wiskunde",10.0,100, vragenWiskunde);

        assertEquals("Wiskunde",test.getNaam());
    }

    @Test
    public void getQuotering(){
        Vraag[] vragenWiskunde = {new Vraag("zit een vraag  ?","antwoord"),
                new Vraag("zit een vraag  ","antwoord")};
        Examen test = new Examen("Wiskunde",10.0,100, vragenWiskunde);

        assertEquals(10.0,test.getQuotering());
    }

    @Test
    public void getExamenLengte() {
        Vraag[] vragenWiskunde = {new Vraag("zit een vraag  ?","antwoord"),
                new Vraag("zit een vraag  ","antwoord")};
        Examen test = new Examen("Wiskunde",10.0,100, vragenWiskunde);
        assertEquals(100,test.getExamenLengte());
    }

    @Test
    public void getVragenLijst() {
        Vraag[] vragenWiskunde = {new Vraag("zit een vraag  ?","antwoord"),
                new Vraag("zit een vraag  ","antwoord")};
        Examen test = new Examen("Wiskunde",10.0,100, vragenWiskunde);

        assertEquals(vragenWiskunde,test.getVragenLijst());
    }
}