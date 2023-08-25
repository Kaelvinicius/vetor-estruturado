package application;

import entities.Vetor;

public class Principal {
    public static void main(String[] args) throws Exception {
        Vetor vetor = new Vetor(2);
        vetor.adiciona("elemento 1");
        vetor.adiciona("elemento 2");
        vetor.adiciona("elemento 3");
        System.out.println(vetor);

        vetor.adiciona("elemento 4");
        vetor.adiciona("elemento 5");
        System.out.println("\n");
        System.out.println(vetor);


        System.out.println("\n");
        vetor.remove(3);
        System.out.println(vetor);
    }
}
