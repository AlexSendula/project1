package project1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SchoolTest {
    @Test
    void studentAanmakenTest() {
    }

    @Test
    void studentVerwijderenTest() {
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