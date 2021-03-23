package project1;

import java.util.*;

public class Student {
    private String voorNaam;
    private String achterNaam;
    private Integer studentNr;
    private ArrayList<String> behaaldeExamens = new ArrayList<>();
    private static ArrayList<Student> studentLijst = Student.studentLijst; //toevoeging studenten arraylist

    public Student(String voorNaam, String achterNaam, Integer studentNr) {
        if (studentNr.toString().length() != 8) {
            throw new IllegalArgumentException();
        }

        this.voorNaam = voorNaam;
        this.achterNaam = achterNaam;
        this.studentNr = studentNr;
        School.studentLijst.add(this);
    }

    public Student(String[] input) {
        if (input[2].length() != 8) {
            throw new IllegalArgumentException();
        }

        this.voorNaam = input[0];
        this.achterNaam = input[1];
        this.studentNr = Integer.parseInt(input[2]);
        School.studentLijst.add(this);
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

    public void setBehaaldeExamens(String examen){
        this.behaaldeExamens.add(examen);
    }
}