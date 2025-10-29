package jcf;


import java.util.*;

public class EjemploList {
    public static void main(String[] args) {
        // 1) Crear lista de estudiantes
        List<String> estudiantes = new ArrayList<>();
        estudiantes.add("Laura");
        estudiantes.add("Carlos");
        estudiantes.add("Ana");
        estudiantes.add("Mateo");

        // 2) Mostrar primer y último estudiante
        System.out.println("Primer estudiante: " + estudiantes.get(0));
        System.out.println("Último estudiante: " + estudiantes.get(estudiantes.size() - 1));

        // 3) Insertar un nuevo estudiante en la posición 1
        estudiantes.add(1, "Juliana");

        // 4) Eliminar el tercer elemento (índice 2)
        estudiantes.remove(2);

        // 5) Recorrer lista con bucle for-each
        System.out.println("Lista final de estudiantes:");
        for (String nombre : estudiantes) {
            System.out.println("- " + nombre);
        }
    }
}

