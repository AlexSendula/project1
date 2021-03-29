package project1;

import java.util.*;

public class Student {
    private String voorNaam;
    private String achterNaam;
    private Integer studentNr;
    private ArrayList<String> behaaldeExamens = new ArrayList<>();

    public Student(String voorNaam, String achterNaam, Integer studentNr) {
        if (studentNr.toString().length() != 8) {
            throw new IllegalArgumentException();
        }

        this.voorNaam = voorNaam;
        this.achterNaam = achterNaam;
        this.studentNr = studentNr;
    }

    public Student(String[] input) {
        if (input[2].length() != 8) {
            throw new IllegalArgumentException();
        }

        this.voorNaam = input[0];
        this.achterNaam = input[1];
        this.studentNr = Integer.parseInt(input[2]);
    }

    public String getVoorNaam() {
        return voorNaam;
    }

    public String getAchterNaam() {
        return achterNaam;
    }

    public String getNaam(){
        return voorNaam + " " + achterNaam;
    }

    public Integer getStudentNr() {
        return studentNr;
    }

    public ArrayList<String> getBehaaldeExamens() {
            return behaaldeExamens;
    }

    public void addBehaaldeExamens(String examen){
        this.behaaldeExamens.add(examen);
    }
}