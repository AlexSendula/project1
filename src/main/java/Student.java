import java.lang.reflect.Array;
import java.util.ArrayList;

public class Student {
    private String voorNaam;
    private String achterNaam;
    private Integer studentNr;
    private ArrayList<String> behaaldeExamens;

    private static ArrayList<Student> studentLijst = new ArrayList<Student>(); //toevoeging studenten arraylist

    public Student(String voorNaam, String achterNaam, Integer studentNr) {
        this.voorNaam = voorNaam;
        this.achterNaam = achterNaam;
        this.studentNr = studentNr;
        studentLijst.add(this);
    }

    public String getVoorNaam() {
        return voorNaam;
    }

    public String getAchterNaam() {
        return achterNaam;
    }

    public Integer getStudentNr() {
        return studentNr;
    }

    public ArrayList<String> getBehaaldeExamens() {
        return behaaldeExamens;
    }


    public static void studentAanmaken(String voorNaam, String achterNaam, Integer studentNr) {
        new Student(voorNaam, achterNaam, studentNr);
    }

    public static void studentVerwijderen(Integer studentNr) {
        studentLijst.removeIf(e -> (e.getStudentNr().equals(studentNr)));

    }
}