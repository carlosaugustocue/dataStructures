package taller29Octubre;

import java.util.ArrayList;

/**
 * Punto 1: Creación y recorrido de una lista de elementos
 * Conceptos: ArrayList básico, add(), size(), recorridos con for y for-each
 */
public class Punto1Frutas {

    public static void main(String[] args) {
        // 1. Crear una ArrayList<String> llamada frutas
        // ArrayList es una clase que implementa una lista dinámica (crece automáticamente)
        ArrayList<String> frutas = new ArrayList<>();

        // 2. Agregar al menos 5 frutas diferentes usando add()
        frutas.add("Manzana");
        frutas.add("Pera");
        frutas.add("Mango");
        frutas.add("Uva");
        frutas.add("Fresa");

        System.out.println("=== LISTA DE FRUTAS ===\n");

        // 3. Mostrar todos los elementos con un bucle for tradicional
        System.out.println("Recorrido con bucle for tradicional:");
        for (int i = 0; i < frutas.size(); i++) {
            // get(i) obtiene el elemento en la posición i
            System.out.println("Posición " + i + ": " + frutas.get(i));
        }

        System.out.println(); // Línea en blanco

        // 4. Mostrar los mismos elementos usando un bucle for-each (mejorado)
        System.out.println("Recorrido con bucle for-each:");
        for (String fruta : frutas) {

            System.out.println("- " + fruta);
        }

        System.out.println(); // Línea en blanco

        // 5. Mostrar el tamaño total de la lista
        System.out.println("Tamaño total de la lista: " + frutas.size() + " frutas");
    }
}
