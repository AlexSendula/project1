import java.util.ArrayList;

public class Student {
    private String voorNaam;
    private String achterNaam;
    private Integer studentNr;
    private ArrayList<String> behaaldeExamens;

    public Student(String voorNaam, String achterNaam, Integer studentNr) {
        this.voorNaam = voorNaam;
        this.achterNaam = achterNaam;
        this.studentNr = studentNr;
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
}