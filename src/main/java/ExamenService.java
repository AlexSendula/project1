public class ExamenService {

    private static final Vraag[] vragenWiskunde = {new Vraag("zit een vraag  ?","antwoord"),
                                                   new Vraag("zit een vraag  ","antwoord")};


    private static final Vraag[] vragenOPT1 = {new Vraag("zit een vraag ?","antwoord"),
            new Vraag("zit een vraag ","antwoord")};
    private static final Vraag [] vragenOPT2 = {new Vraag("" , "")};


       private static final Examen[]  examens = {new Examen("Wiskunde",10.0,100, vragenWiskunde) ,
                                               new Examen("OPT1",10.0 , 10,vragenOPT1),
                                                new Examen("REQS " , 10.0,10,vragenOPT2)};

       public static void printExamens(){
           for (int i = 0;i < examens.length; i++ ){
               System.out.println(i+1 + ")  "+examens[i].getNaam());

           }
       }

}
