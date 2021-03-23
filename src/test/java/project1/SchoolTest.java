package project1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SchoolTest {
    @Test
    void studentAanmakenTest() {
        InputStream sysInBackup = null;
        ByteArrayInputStream in = new ByteArrayInputStream("Voornaam, Achternaam, 12345678".getBytes());
        System.setIn(in);
        School.studentAanmaken();

        assertEquals(School.studentLijst.get(0).getVoorNaam(), "Voornaam");
        assertEquals(School.studentLijst.get(0).getAchterNaam(), "Achternaam");
        assertEquals(School.studentLijst.get(0).getStudentNr(), 12345678);

        System.setIn(sysInBackup);
    }

    @Test
    void studentVerwijderenTest() {
        Student test = new Student("Voornaam", "Achternaam", 12345678);
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("12345678".getBytes());
        System.setIn(in);
        School.studentVerwijderen();

        assertThrows(NullPointerException.class, () -> School.studentLijst.contains(School.getStudentByNr(12345678)));

        System.setIn(sysInBackup);
    }

    @Test
    void getStudentenTest() {
    }

    @Test
    void getTopStudentTest() {
        Student test = new Student("Voornaam", "Achternaam", 12345678);
        test.setBehaaldeExamens("Rekenen");
        Student test2 = new Student("Voornaam2", "Achternaam2", 87654321);
        test2.setBehaaldeExamens("Rekenen");
        test2.setBehaaldeExamens("Engels");

        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
        School.getTopStudent();

        assertTrue(testOut.toString().contains("Voornaam2"));
        assertFalse(testOut.toString().contains("12345678"));
        assertFalse(testOut.toString().contains("Niemand"));
    }

    @Test
    void getStudentByNrTest() {
        Student test = new Student("Voornaam", "Achternaam", 12345678);
        assertEquals(School.getStudentByNr(12345678), test);
        assertThrows(NullPointerException.class, () -> School.getStudentByNr(87654321));
    }

    @Test
    void getBehaaldeExamensTest() {

    }
}