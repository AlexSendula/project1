package project1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Examen {
    private String naam;
    private Double quotering;
    private Integer examenLengte;
    public static ArrayList<Vraag> vragenLijst;

    public Examen(String naam, Double quotering, Integer examenLengte, ArrayList<Vraag> vragenLijst){
        this.naam = naam;
        this.quotering = quotering;
        this.examenLengte = examenLengte;
        this.vragenLijst = vragenLijst;
    }

    public String getNaam() {
        return naam;
    }

    public Double getQuotering() {
        return quotering;
    }

    public Integer getExamenLengte() {
        return examenLengte;
    }

    public ArrayList<Vraag> getVragenLijst() {
        return vragenLijst;
    }

    public boolean loopVragenlijst() throws Exception{
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        Collections.shuffle(vragenLijst);

        try {
            int aantalCorrect = 0;

            for (int i = 0; i < examenLengte; i++) {
                Vraag vraag = vragenLijst.get(i);

                System.out.println("Vraag:");
                System.out.println(vraag.getVraag());
                System.out.println("Antwoord:");
                String input = scanner.nextLine();
                if (input.equals(vraag.getAntwoord())) {
                    menu.leegScherm();
                    System.out.println("Correct!\n");
                    aantalCorrect++;
                } else {
                    menu.leegScherm();
                    System.out.printf("Fout! \nVraag: %s\njouw antwoord: %s, het correcte antwoord: %s\n\n",vraag.getVraag(), input, vraag.getAntwoord());
                }
            }

            return (100.0 / examenLengte * aantalCorrect) >= quotering;

        } catch (Exception ignored) {
            menu.leegScherm();
            System.out.println("Ongeldige invoer, probeer opnieuw.");
        }
        throw new Exception();
    }
}