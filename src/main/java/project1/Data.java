package project1;

import java.util.ArrayList;

public class Data extends Main{

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
    }
}
