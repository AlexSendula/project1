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

    public static void sluitProgramma() {
        System.out.println("Doei");
        System.exit(0);
    }

    //deze functie maakt shi wahed lijn niffo hode
    public static void streepje() {
        Stream.generate(()->"-").limit(50).forEach(System.out::print);
        System.out.println();
    }
}
