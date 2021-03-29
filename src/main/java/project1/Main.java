package project1;

import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        School school = new School();
        school.leesResultaten();
        Data.initializeData(school);
        school.menu(0);
    }

    public static void sluitProgramma(School school) {
        school.slaResultatenOp(); //resultaten opslaan
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
