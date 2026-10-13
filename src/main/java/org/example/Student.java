package org.example;

import java.util.ArrayList;
import java.util.List;

public class Student{
    private String nume;
    private String prenume;
    private String grupa;
    private List<Integer> note;

    public Student(String nume, String prenume, String grupa) {
        this.nume = nume;
        this.prenume = prenume;
        this.grupa = grupa;
        this.note = new ArrayList<>();
    }

    public String getNume() { return nume; }
    public String getPrenume() { return prenume; }
    public String getGrupa() { return grupa; }
    public List<Integer> getNote() { return note; }

    public void adaugaNota(int nota) {
        note.add(nota);
    }

    public boolean esteIntegralist() {
        for (int nota : note) {
            if (nota < 5) return false;
        }
        return true;
    }

    public double medie() {
        if (note.isEmpty()) return 0;
        double suma = 0;
        for (int nota : note) {
            suma += nota;
        }
        return suma / note.size();
    }

    public int numarRestante() {
        int nr = 0;
        for (int nota : note) {
            if (nota < 5) nr++;
        }
        return nr;
    }

    public String toString() {
        return String.format("Grupa: %s | Nume: %-10s %-10s | Note: %s | Medie: %.2f | Restanțe: %d",
                grupa, nume, prenume, note.toString(), medie(), numarRestante());
    }
}