package listas;

import java.util.LinkedList;

public class ListaNombres {
    public static void main(String[] args) {
        // 1. Declarar una lista LinkedList<String> y agregar cinco nombres
        LinkedList<String> nombres = new LinkedList<>();
        nombres.add("Laura");
        nombres.add("Carlos");
        nombres.add("Ana");
        nombres.add("Jorge");
        nombres.add("María");

        System.out.println("Lista inicial: " + nombres);

        // 2. Mostrar el primer y el último elemento de la lista
        System.out.println("Primer elemento: " + nombres.getFirst());
        System.out.println("Último elemento: " + nombres.getLast());

        // 3. Insertar un nuevo nombre en la segunda posición (índice 1)
        nombres.add(1, "Andrés");
        System.out.println("\nDespués de insertar 'Andrés' en la segunda posición: " + nombres);

        // Eliminar el cuarto elemento (índice 3)
        String eliminado = nombres.remove(3);
        System.out.println("Se eliminó el elemento en la cuarta posición: " + eliminado);
        System.out.println("Lista después de la eliminación: " + nombres);

        // 4. Recorrer la lista e imprimir cada elemento con su posición
        System.out.println("\nListado final con posiciones:");
        for (int i = 0; i < nombres.size(); i++) {
            System.out.println("Posición " + i + ": " + nombres.get(i));
        }

        // 5. Indicar el tamaño final de la lista
        System.out.println("\nTamaño final de la lista: " + nombres.size());
    }
}

