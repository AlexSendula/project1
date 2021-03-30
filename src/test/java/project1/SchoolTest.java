package project1;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class SchoolTest {
    School school = new School(new Menu());

    @Test
    void studentAanmakenTest() {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("Voornaam, Achternaam, 45678123".getBytes());
        System.setIn(in);

        school.studentAanmaken();

        assertEquals(school.getStudentLijst().get(3).getVoorNaam(), "Voornaam");
        assertEquals(school.getStudentLijst().get(3).getAchterNaam(), "Achternaam");
        assertEquals(school.getStudentLijst().get(3).getStudentNr(), 45678123);

        System.setIn(sysInBackup);
    }

    @Test
    void studentVerwijderenTest() {
        Student test= new Student("Voornaam", "Achternaam", 65432178);
        school.getStudentLijst().add(test);

        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("65432178".getBytes());
        System.setIn(in);

        school.studentVerwijderen();

        assertThrows(NullPointerException.class, () -> school.getStudentLijst().contains(school.getStudentByNr(65432178)));

        System.setIn(sysInBackup);
    }

    @Test
    void getStudentenTest() {
        PrintStream sysOutBackup = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        school.getStudenten();

        assertTrue(output.toString().contains("12345678       Voornaam1 Achternaam1"));
        assertTrue(output.toString().contains("22345678       Voornaam2 Achternaam2"));
        assertTrue(output.toString().contains("32345678       Voornaam3 Achternaam3"));

        System.setOut(sysOutBackup);
    }

    @Test
    void getTopStudentTest() {
        PrintStream sysInBackup = System.out;
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
        school.getTopStudent();

        assertTrue(testOut.toString().contains("Voornaam1"));
        assertFalse(testOut.toString().contains("45714578"));
        assertFalse(testOut.toString().contains("Niemand"));

        System.setOut(sysInBackup);
    }

    @Test
    void getStudentByNrTest() {
        Student test = new Student("Voornaam", "Achternaam", 45127854);
        school.getStudentLijst().add(test);
        assertEquals(school.getStudentByNr(45127854), test);
        assertThrows(NullPointerException.class, () -> school.getStudentByNr(87412541));
    }

    @Test
    void getBehaaldeExamensTest() {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("12345678".getBytes());
        System.setIn(in);

        PrintStream sysOutBackup = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        school.getBehaaldeExamens();

        assertTrue(output.toString().contains("Voornaam1 Achternaam1"));

        System.setIn(sysInBackup);
        System.setOut(sysOutBackup);
    }
}