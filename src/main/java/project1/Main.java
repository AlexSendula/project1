package project1;

import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        School.leesResultaten();
        Data.initializeData();
        menu(0);
    }

    public static void menu(int leegScherm) {
        /**
         This is the menu interface of the program.
         1 = will flush screen before showing menu interface.
         0 = will directly show menu interface.
         @param Allows for 1 or 0 as input.
         **/

        School school = new School();

        if (leegScherm == 1) {
            leegScherm();
        }

        System.out.println("1) Lijst met examens");
        System.out.println("2) Lijst met studenten");
        System.out.println("3) Nieuwe student inschrijven");
        System.out.println("4) Student verwijderen");
        System.out.println("5) Examen afnemen");
        System.out.println("6) Welke examens heeft student gehaald?");
        System.out.println("7) Welke student heeft de meeste examens gehaald?");
        System.out.println("0) Exit");

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
                    school.getExamens();
                    menu(0);
                    break;
                case 2:
                    school.getStudenten();
                    menu(0);
                    break;
                case 3:
                    school.studentAanmaken();
                    menu(0);
                    break;
                case 4:
                    school.studentVerwijderen();
                    menu(0);
                    break;
                case 5:

                    break;
                case 6:
                    school.getBehaaldeExamens();
                    menu(0);
                    break;
                case 7:
                    school.getTopStudent();
                    break;
            }
        } else {
            menu(1);
        }
    }

    public static void sluitProgramma() {
        School.slaResultatenOp(); //resultaten opslaan
        leegScherm();
        System.out.println("Doei");
        System.exit(0);
    }

    public static void leegScherm() {
        for (int i = 0; i < 20; i++) {
            System.out.println("\n");
        }
    }

    //deze functie maakt shi wahed lijn niffo hode
    public static void streepje() {
        Stream.generate(()->"-").limit(50).forEach(System.out::print);
        System.out.println();
    }
}
