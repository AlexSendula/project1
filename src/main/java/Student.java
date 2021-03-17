import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    public String getNaam(){
        return voorNaam + " " + achterNaam;
    }

    public Integer getStudentNr() {
        return studentNr;
    }

    public ArrayList<String> getBehaaldeExamens() {
            return behaaldeExamens;
    }

    public void setBehaaldeExamens(String examen){
        this.behaaldeExamens.add(examen);
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

    public static ArrayList<Student> topStudent(){
        ArrayList<Student> topStudenten = new ArrayList<Student>();
        Collections.sort(studentLijst, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int aantalExamens1 = s1.getBehaaldeExamens().size();
                int aantalExamens2 = s2.getBehaaldeExamens().size();

                return aantalExamens2-aantalExamens1;
            }
        });

        if(studentLijst.isEmpty()) {
            return null;
        }

        topStudenten.add(studentLijst.get(0));

        int i = 1;
        for (Student student : studentLijst.subList(1, studentLijst.size())) {
            int studentBehaaldeExamens = student.getBehaaldeExamens().size();
            int topStudentBehaaldeExamens = topStudenten.get(0).getBehaaldeExamens().size();

            if(student.getBehaaldeExamens().isEmpty()){
                i++;
            }

            if(studentBehaaldeExamens == topStudentBehaaldeExamens) {
                topStudenten.add(student);
            }
            else if(studentBehaaldeExamens < topStudentBehaaldeExamens){
                return topStudenten;
            }
        }

        if(i == studentLijst.size()){
            return null;
        }
        return topStudenten;
    }

    public static void studentAanmaken() {
        Scanner scanner = new Scanner(System.in);
        String studentNr = "0";
        String voorNaam = null;
        String achterNaam = null;
        boolean studentNrCorrect = false;
        System.out.print("Geef uw voornaam: ");
        while (voorNaam == null) {
            voorNaam = scanner.nextLine();
            if (voorNaam.isBlank()){
                System.out.println("Voornaam mag niet leeg zijn");
                System.out.print("Probeer het opnieuw: ");
                voorNaam = null;
            }
        }
        System.out.print("Geef uw achternaam: ");
        while (achterNaam == null) {
            achterNaam = scanner.nextLine();
            if (achterNaam.isBlank()){
                System.out.println("Achternaam mag niet leeg zijn");
                System.out.print("Probeer het opnieuw: ");
                achterNaam = null;
            }
        }
        studentNrCorrect = false;
        System.out.print("Geef uw studentennummer: ");
        while (studentNrCorrect == false) {
            studentNr = scanner.nextLine();
            if (studentNr.matches("[0-9]+")) {
                if (studentNr.length() <= 8 && studentNr.length()>0 && !studentNr.equals("0")) {

                    if (!studentLijst.isEmpty()) {
                        if (getStudentByNr(Integer.parseInt(studentNr)) == null) {
                            studentNrCorrect = true;
                        } else {
                            System.out.println("Het studentennummer is al in gebruik");
                            System.out.print("Probeer het opnieuw: ");
                            studentNrCorrect = false;
                        }
                    } else {
                        studentNrCorrect = true;
                    }

                } else {
                    System.out.println("Het studentennummer mag maximaal 8 getallen bevatten");
                    System.out.print("Probeer het opnieuw: ");
                    studentNrCorrect = false;

                }
            } else {
                System.out.println("Het studentennummer moet een getal zijn");
                System.out.print("Probeer het opnieuw: ");
                studentNrCorrect = false;

            }
        }
            new Student(voorNaam, achterNaam, Integer.parseInt(studentNr));
        Main.menu(0);
    }

    public static void studentVerwijderen() {
        Scanner scanner = new Scanner(System.in);
        String studentNr = null;
        System.out.println("Geef het studentennummer om te verwijderen");
        while (studentNr == null) {
            studentNr = scanner.nextLine();
            if (studentNr.matches("[0-9]+")) {
                if (studentNr.length() <= 8 && studentNr.length()>0 && !studentNr.equals("0")) {
                    Integer studentNrInt = Integer.parseInt(studentNr);
                    studentLijst.removeIf(e -> (e.getStudentNr() == studentNrInt));
                } else {
                    System.out.println("Het studentennummer mag maximaal 8 getallen bevatten");
                    System.out.print("Probeer het opnieuw: ");
                    studentNr = null;
                }
            } else {
                System.out.println("Het studentennummer moet een getal zijn");
                System.out.print("Probeer het opnieuw: ");
                studentNr = null;
            }
        }
        Main.menu(0);
    }
}