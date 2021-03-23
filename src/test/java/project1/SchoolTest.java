package project1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class SchoolTest {
    @Test
    void studentAanmakenTest() {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("Test, Test, 12345678".getBytes());
        System.setIn(in);
        School.studentAanmaken();

        assertTrue(!School.studentLijst.isEmpty());
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
    }

    @Test
    void getStudentByNrTest() {
        Student test = new Student("Dylan", "van der Stam", 18094171);
        Assertions.assertTrue(School.getStudentByNr(18094171).equals(test));
    }

    @Test
    void getBehaaldeExamensTest() {

    }
}