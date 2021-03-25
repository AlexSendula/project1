package project1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ExamenTest {


    @Test
    public void getNaam() {
        Examen examen = new Examen("OPT1" , 10.0,20,Examen.vragenLijst);
        assertEquals("OPT1",examen.getNaam());
        assertNotEquals("opt1",examen.getNaam());
    }

    @Test
    public void getQuotering(){
        Examen examen = new Examen("Wiskunde",10.0,100, Examen.vragenLijst);
        assertEquals(10.0,examen.getQuotering());
        assertNotEquals(20 ,examen.getExamenLengte());
    }

    @Test
    public void getExamenLengte() {
        Examen examen = new Examen("OPT1",10.0,100, Examen.vragenLijst);
        assertEquals(100,examen.getExamenLengte());
        assertNotEquals(101 , examen.getExamenLengte());
    }

    @Test
    public void getVragenLijst() {
        Examen examen = new Examen("OPT2",10.0,100, Examen.vragenLijst);
        assertEquals(examen.getVragenLijst(),examen.getVragenLijst());

    }
}