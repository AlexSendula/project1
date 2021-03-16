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