package project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class School {
    public static ArrayList<Student> studentLijst = new ArrayList<>();
    public static ArrayList<Examen> examenLijst = new ArrayList<>();

    // School methods
    public static void studentAanmaken() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Voornaam, achternaam, studentnummer");
            String[] studentGegevens = scanner.nextLine().split(", ");
            String studentNr = studentGegevens[2];
            if (bestaatStudent(Integer.parseInt(studentNr)) != null){
                throw new Exception();
            }
            new Student(studentGegevens[0], studentGegevens[1], Integer.parseInt(studentGegevens[2]));
        } catch (Exception ignored) {
            System.out.println("Ongeldige invoer, probeer het nogmaals.");
        }
    }

    public static void studentVerwijderen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geef het studentennummer om te verwijderen");
        try {
            Student student = getStudentByNr(scanner.nextInt());
            studentLijst.remove(student);
        } catch (Exception ignored) {
            System.out.println("Ongeldige invoer, probeer het nogmaals.");
        }
    }

    public static void getStudenten() {
        Main.leegScherm();
        Main.streepje();
        System.out.println("Studentnummer  Naam");
        for (Student student : studentLijst) {
            System.out.println(student.getStudentNr() + "       " + student.getVoorNaam() + " " + student.getAchterNaam());
        }
        Main.streepje();
    }

    public static void getTopStudent() {
        ArrayList<Student> topStudenten = new ArrayList<>();
        studentLijst.sort((s1, s2) -> {
            int aantalExamens1 = s1.getBehaaldeExamens().size();
            int aantalExamens2 = s2.getBehaaldeExamens().size();

            return aantalExamens2 - aantalExamens1;
        });

        if (!studentLijst.isEmpty()) {
            topStudenten.add(studentLijst.get(0));
        }

        int i = 1;
        for (Student student : studentLijst.subList(1, studentLijst.size())) {
            int studentBehaaldeExamens = student.getBehaaldeExamens().size();
            int topStudentBehaaldeExamens = topStudenten.get(0).getBehaaldeExamens().size();

            if (student.getBehaaldeExamens().isEmpty()) {
                i++;
            }

            if (studentBehaaldeExamens == topStudentBehaaldeExamens) {
                topStudenten.add(student);
            } else if (studentBehaaldeExamens < topStudentBehaaldeExamens) {
                Main.leegScherm();
                Main.streepje();
                System.out.println("De student(en) met de meest behaalde examens zijn:");
                for (Student temp : topStudenten) {
                    System.out.println(temp.getNaam());
                }
                Main.streepje();

            }
        }

        if (i == studentLijst.size()) {
            Main.leegScherm();
            Main.streepje();
            System.out.println("Niemand heeft een examen gehaald.");
            Main.streepje();
            Main.menu(0);
        }
    }

    public static Student getStudentByNr(Integer sNr) {
        try {
            for (Student student : studentLijst) {
                if (student.getStudentNr().equals(sNr)) {
                    return student;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        throw new NullPointerException();
    }

    public static Student bestaatStudent(Integer sNr){ //deze wordt gebruikt bij aanmaken student
        try {
            for (Student student : studentLijst) {
                if (student.getStudentNr().equals(sNr)) {
                    return student;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void getExamens() {
        Main.leegScherm();
        Main.streepje();
        System.out.println("Alle beschikbare examens:");
        for (Examen examen : examenLijst) {
            System.out.println(examen.getNaam());
        }
        Main.streepje();
    }

    public static void getBehaaldeExamens() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Studentnummer: ");
        try {
            Student student = getStudentByNr(scanner.nextInt());

            Main.leegScherm();
            Main.streepje();

            if (student.getBehaaldeExamens().isEmpty()) {
                System.out.printf("%s heeft nog geen examens gehaald.\n", student.getVoorNaam() + " " + student.getAchterNaam());
            } else {
                System.out.printf("%s heeft de volgende examens gehaald:\n", student.getVoorNaam() + " " + student.getAchterNaam());
                for (String temp : student.getBehaaldeExamens()) {
                    System.out.println(temp);
                }
            }
            Main.streepje();
        } catch (Exception ignored) {
            Main.leegScherm();
            Main.streepje();
            System.out.println("StudentNr bestaat niet. Probeer het opnieuw.");
            Main.streepje();
        }
    }


    //test voor naar file schrijven
    public static void slaResultatenOp() {
        try {
            FileWriter writer = new FileWriter("resources/resultaten.txt");
            String tekst = "";

            for (Student student : studentLijst) {
                tekst = tekst+student.getVoorNaam()+", "+student.getAchterNaam()+", "+student.getStudentNr();
                for (String temp : student.getBehaaldeExamens()) {
                    tekst = tekst+", "+temp;
                }
                tekst = tekst+"\n";

            }
            tekst = tekst.substring(0, tekst.length() - 1);
            writer.write(tekst);
            writer.close();
            System.out.println("Successful");
        } catch (IOException exception) {
            System.out.println("error");
            exception.printStackTrace();
        }
    }

    public static void leesResultaten() { //bij het handmatig toevoegen in de tekstfile moet je geen enter achterlaten aan het einde
        try {
            File file = new File("resources/resultaten.txt");
            Scanner scanner = new Scanner(file);
            String gegevens = "";
            int getal = 0;
            while (scanner.hasNextLine()) {
                gegevens = scanner.nextLine();
                String[] input = gegevens.split(", ");
                new Student(input[0], input[1], Integer.parseInt(input[2]));
                for (int i = 3; i < input.length; i++) {
                    studentLijst.get(getal).setBehaaldeExamens(input[i]);
                }
                getal++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
