import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static ArrayList<Student> studentLijst = new ArrayList<>();

    public static void main(String[] args) {
        Student test = new Student("Dylan", "van der Stam", 18094171);
        test.setBehaaldeExamens("Rekenen");
        test.setBehaaldeExamens("Rekenen");
        Student test2 = new Student("Alex", "Sendula", 12345678);
        test2.setBehaaldeExamens("Rekenen");
        test2.setBehaaldeExamens("Rekenen");
        Student test3 = new Student("Emre", "Cakici", 87654321);
        test3.setBehaaldeExamens("Rekenen");
        test3.setBehaaldeExamens("Rekenen");
        menu(0);
    }

    public static void menu(int leegScherm) {
        /**
         This is the menu interface of the program.
         1 = will flush screen before showing menu interface.
         0 = will directly show menu interface.
         @param Allows for 1 or 0 as input.
         **/

        if (leegScherm == 1) {
            leegScherm();
        }

        System.out.println("\n");
        System.out.println("1) Lijst met examens");
        System.out.println("2) Lijst met studenten");
        System.out.println("3) Nieuwe student inschrijven");
        System.out.println("4) Student verwijderen");
        System.out.println("5) Examen afnemen");
        System.out.println("6) Welke examens heeft student gehaald?");
        System.out.println("7) Welke student heeft de meeste examens gehaald?");
        System.out.println("0) exit");

        int menuKeuze = 0;

        try {
            Scanner scanner = new Scanner(System.in);
            menuKeuze = scanner.nextInt();
        } catch (Exception ignored) {
            menu(1);
        }

        //Voeg hier de methods toe aan de hand van outputlines hierboven.
        if (menuKeuze >= 0 && menuKeuze <=7) {
            switch (menuKeuze) {
                case 0:
                    sluitProgramma();
                    break;
                case 1:

                    break;
                case 2:
                    toonStudenten();
                    menu(0);
                    break;
                case 3:
                    studentAanmaken();
                    menu(0);
                    break;
                case 4:
                    Student.studentVerwijderen();

                    break;
                case 5:

                    break;
                case 6:
                    overzichtBehaaldeExamens();
                    break;
                case 7:
                    getTopStudent();
                    break;
            }
        } else {
            menu(1);
        }
    }

    public static void sluitProgramma() {
        System.exit(0);
    }

    public static void toonStudenten() {
        for (Student student : studentLijst) {
            System.out.println(student.getNaam());
        }
    }

    public static void studentAanmaken() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Voornaam, achternaam, studentnummer");
            new Student(scanner.nextLine().split(", "));
        } catch (Exception ignored) {
            System.out.println("Ongeldige invoer, probeer het nogmaals.");
            menu(0);
        }
    }

    public static void leegScherm() {
        for (int i = 0; i < 20; i++) {
            System.out.println("\n");
        }
    }

    //deze functie maakt shi wahed lijn niffo hode
    public static void streepje(){
        Stream.generate(()->"-").limit(50).forEach(System.out::print);
        System.out.println();
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

    public static ArrayList<Student> topStudent(){
        ArrayList<Student> topStudenten = new ArrayList<>();
        studentLijst.sort((s1, s2) -> {
            int aantalExamens1 = s1.getBehaaldeExamens().size();
            int aantalExamens2 = s2.getBehaaldeExamens().size();

            return aantalExamens2 - aantalExamens1;
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

    public static void getTopStudent(){
        ArrayList<Student> topStudenten = topStudent();
        if(topStudenten != null) {
            leegScherm();
            streepje();
            System.out.println("De student(en) met de meest behaalde examens zijn:");
            for (Student student : topStudenten) {
                System.out.println(student.getNaam());
            }
            streepje();
            menu(0);
        }
        else {
            leegScherm();
            streepje();
            System.out.println("Niemand heeft een examen gehaald.");
            streepje();
            menu(0);
        }
    }
}


//Alex
//Sendula
//1234578

//Voornaam, Achternaam, Studentnummer
//Alex, Sendula, 12345678
//Alex, Sendula, 12345678
//Alex, Sendula, 12345678
//Alex, Sendula, 12345678
//Alex, Sendula, 12345678
//Alex, Sendula, 12345678
//Alex, Sendula, 12345678
//Alex, Sendula, 12345678
//Alex, Sendula, 12345678
//Alex, Sendula, 12345678
//Alex, Sendula, 12345678
//Alex, Sendula, 12345678
//Alex, Sendula, 12345678
//Alex, Sendula, 12345678
//Alex, Sendula, 12345678
//Alex, Sendula, 12345678
//Alex, Sendula, 12345678
//Alex, Sendula, 12345678
//Alex, Sendula, 12345678
//Alex, Sendula, 12345678
//Alex, Sendula, 12345678
//Alex, Sendula, 12345678
//Alex, Sendula, 12345678