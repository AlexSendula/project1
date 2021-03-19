import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

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
                    School.toonStudenten();
                    menu(0);
                    break;
                case 3:
                    School.studentAanmaken();
                    menu(0);
                    break;
                case 4:
                    School.studentVerwijderen();

                    break;
                case 5:

                    break;
                case 6:
                    School.overzichtBehaaldeExamens();
                    break;
                case 7:
                    School.getTopStudent();
                    break;
            }
        } else {
            menu(1);
        }
    }

    public static void sluitProgramma() {
        System.exit(0);
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






}
