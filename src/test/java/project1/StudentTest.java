package project1;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    @Test
    void getVoorNaamTest() {
        Student test = new Student("Test", "Test", 18094171);
        assertEquals("Test", test.getVoorNaam());
        assertNotEquals("Steve", test.getVoorNaam());

        Student student1 = new Student("Jan", "Kees", 11223344);
        assertEquals("Jan",student1.getVoorNaam());
        assertNotEquals("Kees", student1.getVoorNaam());
    }

    @Test
    void getAchterNaamTest() {
        Student test = new Student("Test", "Test", 18094171);
        assertEquals("Test", test.getAchterNaam());
        assertNotEquals("van der Test", test.getAchterNaam());

        Student student1 = new Student("Jan", "Kees", 11223344);
        assertEquals("Kees", student1.getAchterNaam());
        assertNotEquals("Jan", student1.getAchterNaam());
    }

    @Test
    void getNaamTest() {
        Student test = new Student("Test", "Test", 18094171);
        assertEquals("Test Test", test.getNaam());
        assertNotEquals("Test van der Test", test.getVoorNaam());

        Student student1 = new Student("Jan", "Kees", 11223344);
        assertEquals("Jan Kees",student1.getNaam());
        assertNotEquals("Kees Jan", student1.getNaam());
    }

    @Test
    void getStudentNrTest() {
        Student test = new Student("Test", "Test", 18094171);
        assertEquals(18094171, test.getStudentNr());
        assertNotEquals(12345678, test.getStudentNr());

        Student student1 = new Student("Jan", "Kees", 11223344);
        assertEquals(11223344,student1.getStudentNr());
        assertNotEquals(11223345,student1.getStudentNr());
    }

    @Test
    void getBehaaldeExamensTest() {
        Student test = new Student("Test", "Test", 18094171);
        test.setBehaaldeExamens("Rekenen");
        test.setBehaaldeExamens("Engels");

        ArrayList<String> TestArrayList = new ArrayList<>();
        TestArrayList.add("Rekenen");
        TestArrayList.add("Engels");
        assertTrue(TestArrayList.equals(test.getBehaaldeExamens()));

        ArrayList<String> TestArrayList2 = new ArrayList<>();
        TestArrayList2.add("Rekenen");
        TestArrayList2.add("Reqs");
        assertFalse(TestArrayList2.equals(test.getBehaaldeExamens()));

        ArrayList<String> behaaldeExamensTest = new ArrayList<>();
        Student student1 = new Student("Jan", "Kees", 11223344);
        student1.setBehaaldeExamens("Rekenen");
        behaaldeExamensTest.add("Rekenen");
        assertEquals(behaaldeExamensTest,student1.getBehaaldeExamens());
        behaaldeExamensTest.remove(0);
        behaaldeExamensTest.add("Taaltoets");
        assertNotEquals(behaaldeExamensTest,student1.getBehaaldeExamens());
    }

    @Test
    void setBehaaldeExamens() {
        Student test = new Student("Test", "Test", 18094171);
        Student test2 = new Student("Test2", "Test2", 12345678);
        test.setBehaaldeExamens("Rekenen");
        assertTrue(!test.getBehaaldeExamens().isEmpty());
        assertTrue(test2.getBehaaldeExamens().isEmpty());
    }
}