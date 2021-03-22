import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void getVoorNaam() {
        Student student1 = new Student("Jan", "Kees", 11223344);
        assertEquals("Jan",student1.getVoorNaam());
        assertNotEquals("Kees", student1.getVoorNaam());
    }

    @Test
    void getAchterNaam() {
        Student student1 = new Student("Jan", "Kees", 11223344);
        assertEquals("Kees", student1.getAchterNaam());
        assertNotEquals("Jan", student1.getAchterNaam());
    }

    @Test
    void getNaam() {
        Student student1 = new Student("Jan", "Kees", 11223344);
        assertEquals("Jan Kees",student1.getNaam());
        assertNotEquals("Kees Jan", student1.getNaam());
    }

    @Test
    void getStudentNr() {
        Student student1 = new Student("Jan", "Kees", 11223344);
        assertEquals(11223344,student1.getStudentNr());
        assertNotEquals(11223345,student1.getStudentNr());
    }

    @Test
    void getBehaaldeExamens() {
        ArrayList<String> behaaldeExamensTest = new ArrayList<>();
        Student student1 = new Student("Jan", "Kees", 11223344);
        student1.setBehaaldeExamens("Rekenen");
        behaaldeExamensTest.add("Rekenen");
        assertEquals(behaaldeExamensTest,student1.getBehaaldeExamens());
        behaaldeExamensTest.remove(0);
        behaaldeExamensTest.add("Taaltoets");
        assertNotEquals(behaaldeExamensTest,student1.getBehaaldeExamens());

    }
}