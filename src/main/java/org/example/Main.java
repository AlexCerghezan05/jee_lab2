import org.example.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> studenti = new ArrayList<>();
        studenti.add(new Student("Popescu", "Marian", "225_3"));
        studenti.add(new Student("Popescu", "Maria", "225_3"));
        studenti.add(new Student("Popa", "Marian", "225_3"));
        studenti.add(new Student("Bica", "Irina", "225_3"));
        studenti.add(new Student("Badea", "Ion", "225_1"));
        studenti.add(new Student("Cacoveanu", "Andreea", "225_1"));
        studenti.add(new Student("Onofrei", "Mircea", "225_1"));

        Random rand = new Random();

        // a)
        for (Student s : studenti) {
            for (int i = 0; i < 5; i++) {
                s.adaugaNota(rand.nextInt(7) + 4);
            }
        }

        // b1) Afișare alfabetica, pe grupe
        studenti.sort(Comparator.comparing(Student::getGrupa)
                .thenComparing(Student::getNume)
                .thenComparing(Student::getPrenume));

        System.out.println(" Studenti ordonati (Grupa, Nume, Prenume) ");
        for (Student s : studenti) {
            System.out.println(s);
        }

        // b2) Descrescător după medii - pentru integraliști
        List<Student> integralisti = studenti.stream()
                .filter(Student::esteIntegralist)
                .sorted((s1, s2) -> Double.compare(s2.medie(), s1.medie()))
                .collect(Collectors.toList());

        System.out.println(" Integralisti (Medie descrescator) ");
        for (Student s : integralisti) {
            System.out.println(s);
        }

        // b3) Crescător după numărul de restanțe - pentru restanțieri
        List<Student> restantieri = studenti.stream()
                .filter(s -> !s.esteIntegralist())
                .sorted(Comparator.comparingInt(Student::numarRestante))
                .collect(Collectors.toList());

        System.out.println(" Restantieri (Numar restante crescator) ");
        for (Student s : restantieri) {
            System.out.println(s);
        }
    }
}