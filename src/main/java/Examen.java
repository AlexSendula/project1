import java.util.ArrayList;

public class Examen {
    private Student gemaaktDoor;
    private Vraag bestaatUit;
    private String naam;
    private Double quotering;
    private Integer examenLengte;
    private ArrayList<Vraag> vragenLijst;

    public Examen(String naam, Double quotering, Integer examenLengte, Vraag[] vraag){
        this.naam = naam;
        this.quotering = quotering;
        this.examenLengte = examenLengte;
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