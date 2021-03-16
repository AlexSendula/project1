import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private String voorNaam;
    private String achterNaam;
    private Integer studentNr;
    private ArrayList<String> behaaldeExamens = new ArrayList<String>();
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

    public static Student getStudentByNr(Integer sNr) {
        try {
            for (Student student : studentLijst) {
                if (student.studentNr.equals(sNr)) {
                    return student;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<String> getBehaaldeExamens() {
            return behaaldeExamens;
    }

    public static void overzichtBehaaldeExamens(){
        System.out.println("Studentnummer: ");
        Scanner scn = new Scanner(System.in);
        Integer sNr = scn.nextInt();

        Student student = Student.getStudentByNr(sNr);

        if(student != null) {
            if (student.getBehaaldeExamens().isEmpty()) {
                System.out.printf("%s heeft nog geen examens gehaald.\n", student.getVoorNaam() + " " + student.getAchterNaam());
            } else {
                System.out.printf("%s heeft de volgende examens gehaald:\n", student.getVoorNaam() + " " + student.getAchterNaam());
                for (String temp : student.getBehaaldeExamens()) {
                    System.out.println(temp);
                }
            }
            Main.menu(0);
        }
        else{
            System.out.println("StudentNr bestaat niet. Probeer het opnieuw.");
            overzichtBehaaldeExamens();
        }
    }

    public static void studentAanmaken(String voorNaam, String achterNaam, Integer studentNr) {
        new Student(voorNaam, achterNaam, studentNr);
        Main.menu(0);
    }

    public static void studentVerwijderen(Integer studentNr) {
        studentLijst.removeIf(e -> (e.getStudentNr().equals(studentNr)));
    }
}