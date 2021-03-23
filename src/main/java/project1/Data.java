package project1;

import java.util.ArrayList;

public class Data {

    public static void initializeData() {
        ArrayList<ArrayList<Vraag>> collectieVragenLijst = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            collectieVragenLijst.add(new ArrayList<Vraag>());
        }

        int index = 0;
        for (ArrayList<Vraag> vragenLijst : collectieVragenLijst) {
            for (int i = 0; i < 10; i++) {
                vragenLijst.add(new Vraag("Q"+index+"."+i, "A"+index+"."+i));
            }
            School.examenLijst.add(new Examen("Examen"+index,55.0,10, collectieVragenLijst.get(index)));
            index++;
        }

        Student dylan = new Student("Dylan", "van der Stam", 18094171);
        Student emre = new Student("Alex", "Sendula", 12345678);
        Student alex = new Student("Emre", "Cakici", 87654321);

        dylan.setBehaaldeExamens(School.examenLijst.get(0).getNaam());
        dylan.setBehaaldeExamens(School.examenLijst.get(1).getNaam());
        dylan.setBehaaldeExamens(School.examenLijst.get(2).getNaam());

        emre.setBehaaldeExamens(School.examenLijst.get(0).getNaam());
        emre.setBehaaldeExamens(School.examenLijst.get(1).getNaam());
        emre.setBehaaldeExamens(School.examenLijst.get(2).getNaam());
    }
}
