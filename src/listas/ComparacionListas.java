package listas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ComparacionListas {
    public static void main(String[] args) {
        // 1. Declarar un ArrayList<Integer> y un LinkedList<Integer>
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // 2. Llenar ambas listas con los mismos 10 números enteros
        for (int i = 1; i <= 10; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        System.out.println("ArrayList inicial: " + arrayList);
        System.out.println("LinkedList inicial: " + linkedList);

        // 3. Eliminar los números pares de cada lista
        arrayList.removeIf(num -> num % 2 == 0);
        linkedList.removeIf(num -> num % 2 == 0);

        // 4. Comparar los tamaños finales y mostrar los elementos restantes
        System.out.println("\nArrayList después de eliminar pares: " + arrayList);
        System.out.println("Tamaño final ArrayList: " + arrayList.size());

        System.out.println("\nLinkedList después de eliminar pares: " + linkedList);
        System.out.println("Tamaño final LinkedList: " + linkedList.size());

        // 5. Comentario sobre la experiencia
        System.out.println("\nComentario:");
        System.out.println("Modificar ambas listas fue igual de sencillo con removeIf().");
        System.out.println("Sin embargo, en operaciones de eliminación frecuentes, LinkedList es más eficiente,");
        System.out.println("ya que no requiere desplazar elementos como el ArrayList.");
    }
}
