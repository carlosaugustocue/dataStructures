package taller29Octubre;


import java.util.ArrayList;
import java.util.List;

public class CopiaArrayList {

    public static void main(String[] args) {

        List<String> estudiantes = new ArrayList<>();
        estudiantes.add("Laura");

        List<String> docentes = new ArrayList<>(estudiantes); // misma referencia

        estudiantes.add("Carlos");
        estudiantes.add("Ana");

        // Recorriendo estudiantes
        System.out.println("Estudiantes:");
        for (String e : estudiantes) {
            System.out.println(e);
        }

        // Recorriendo docentes
        System.out.println("\nDocentes:");
        for (String d : docentes) {
            System.out.println(d);
        }
    }
}
