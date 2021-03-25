package project1;

import java.util.ArrayList;

public class Examen {
    private Student gemaaktDoor;
    private Vraag bestaatUit;
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
}