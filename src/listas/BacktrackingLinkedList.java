package listas;

import java.util.LinkedList;

public class BacktrackingLinkedList {

    public static void main(String[] args) {
        // 1. Crear una LinkedList<String> con un conjunto de letras
        LinkedList<String> letras = new LinkedList<>();
        letras.add("A");
        letras.add("B");
        letras.add("C");
        letras.add("D");

        System.out.println("Letras disponibles: " + letras);
        System.out.println("\nCombinaciones posibles de longitud 2:\n");

        // 2. Llamar al método recursivo de backtracking
        generarCombinaciones(letras, new LinkedList<>(), 2);
    }

    /**
     * Método recursivo con backtracking para generar todas las combinaciones posibles
     * de una longitud dada usando únicamente LinkedList.
     *
     * @param letras    Lista de letras disponibles
     * @param actual    Combinación actual en construcción
     * @param longitud  Longitud deseada de las combinaciones
     */
    public static void generarCombinaciones(LinkedList<String> letras, LinkedList<String> actual, int longitud) {
        // Caso base: cuando la combinación tiene la longitud deseada, se muestra
        if (actual.size() == longitud) {
            System.out.println(String.join("", actual));
            return;
        }

        // 3. Recorrer cada letra disponible
        for (String letra : letras) {
            // Evitar repetir la misma letra en la combinación actual
            if (actual.contains(letra)) {
                continue;
            }

            // Paso 1 del backtracking: agregar la letra actual
            actual.add(letra);

            // Llamada recursiva: construir el resto de la combinación
            generarCombinaciones(letras, actual, longitud);

            // Paso 2 del backtracking: eliminar la última letra agregada (retroceso)
            actual.removeLast();
        }
    }
}

