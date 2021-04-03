package project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class School {
    private ArrayList<Student> studentLijst = new ArrayList<>();
    public ArrayList<Examen> examenLijst = new ArrayList<>();
    private Menu menu;

    public School(Menu menu) {
        this.menu = menu;
        this.leesResultaten();
        Data.initializeData(this);
    }

    // Studenten
    public void studentAanmaken() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Voornaam, achternaam, studentnummer");
            String[] studentGegevens = scanner.nextLine().split(", ");
            String studentNr = studentGegevens[2];
            if (bestaatStudent(Integer.parseInt(studentNr)) != null){
                throw new Exception();
            }
            studentLijst.add(new Student(studentGegevens));
        } catch (Exception ignored) {
            System.out.println("Ongeldige invoer, probeer het nogmaals.");
        }
    }

    public void studentVerwijderen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geef het studentennummer om te verwijderen");
        try {
            Student student = getStudentByNr(scanner.nextInt());
            studentLijst.remove(student);
        } catch (Exception ignored) {
            System.out.println("Ongeldige invoer, probeer het nogmaals.");
        }
    }

    public void getStudenten() {
        menu.leegScherm();
        Main.streepje();
        System.out.println("Studentnummer  Naam");
        for (Student student : studentLijst) {
            System.out.println(student.getStudentNr() + "       " + student.getVoorNaam() + " " + student.getAchterNaam());
        }
        Main.streepje();
    }

    public ArrayList<Student> getStudentLijst() {
        return studentLijst;
    }

    public void getTopStudent() {
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
                menu.leegScherm();
                Main.streepje();
                System.out.println("De student(en) met de meest behaalde examens zijn:");
                for (Student temp : topStudenten) {
                    System.out.println(temp.getNaam());
                }
                Main.streepje();

            }
        }

        if (i == studentLijst.size()) {
            menu.leegScherm();
            Main.streepje();
            System.out.println("Niemand heeft een examen gehaald.");
            Main.streepje();
            menu.menu(0);
        }
    }

    public Student getStudentByNr(Integer sNr) {
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

    public Student bestaatStudent(Integer sNr){ //deze wordt gebruikt bij aanmaken student
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

    public void getBehaaldeExamens() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Studentnummer: ");
        try {
            Student student = getStudentByNr(scanner.nextInt());

            menu.leegScherm();
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
            menu.leegScherm();
            Main.streepje();
            System.out.println("StudentNr bestaat niet. Probeer het opnieuw.");
            Main.streepje();
        }
    }

    // Examens
    public void getExamens() {
        menu.leegScherm();
        Main.streepje();
        System.out.println("Alle beschikbare examens:");
        for (Examen examen : examenLijst) {
            System.out.println(examen.getNaam());
        }
        Main.streepje();
    }

    public Examen getExamenBijNaam(String naam) throws Exception {
        for (Examen examen : examenLijst) {
            if (examen.getNaam().equals(naam)) {
                return examen;
            }
        }
        throw new Exception();
    }

    public void examenAfnemen() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wat is je studentnummer?");
        String studentnummer = scanner.nextLine();
        Student student = null;
        try {
            student = getStudentByNr(Integer.parseInt(studentnummer));
        } catch (Exception ignored) {
            menu.leegScherm();
            System.out.println("Ongeldige invoer, probeer nogmaals.");
            menu.menu(0);
        }

        System.out.println("Kies een examen");
        for (Examen examen : examenLijst) {
            System.out.println(examen.getNaam());
        }

        try {
            Examen examen = getExamenBijNaam(scanner.nextLine());
            menu.leegScherm();

            if (examen.loopVragenlijst()) {
                student.addBehaaldeExamens(examen.getNaam());
                System.out.println("Gefeliciteerd, je hebt de examen gehaald!");
            } else {
                menu.leegScherm();
                System.out.println("Je hebt het examen niet gehaald, probeer het opnieuw.\n");
            }
        } catch (Exception ignored) {

        }
    }

    //naar file schrijven
    public void slaResultatenOp() {
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
            //System.out.println("Successful");
        } catch (IOException exception) {
            //System.out.println("Error");
            exception.printStackTrace();
        }
    }

    public void leesResultaten() { //bij het handmatig toevoegen in de tekstfile moet je geen enter achterlaten aan het einde
        try {
            File file = new File("resources/resultaten.txt");
            Scanner scanner = new Scanner(file);
            String gegevens = "";
            int getal = 0;
            while (scanner.hasNextLine()) {
                gegevens = scanner.nextLine();
                String[] input = gegevens.split(", ");
                studentLijst.add(new Student(input));

                for (int i = 3; i < input.length; i++) {
                    studentLijst.get(getal).addBehaaldeExamens(input[i]);
                }
                getal++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            //System.out.println("Error");
            e.printStackTrace();
        }
    }

}
