package listas;

import java.util.LinkedList;

public class RecursividadLinkedList {

    public static void main(String[] args) {
        // 1. Declarar una LinkedList<Integer> con al menos 7 valores
        LinkedList<Integer> numeros = new LinkedList<>();
        numeros.add(3);
        numeros.add(5);
        numeros.add(2);
        numeros.add(8);
        numeros.add(1);
        numeros.add(4);
        numeros.add(6);

        System.out.println("Lista inicial: " + numeros);

        // 2. Llamar al método recursivo para calcular la suma
        int sumaTotal = sumarRecursivo(numeros);

        // 3. Mostrar el resultado final
        System.out.println("Suma total de los elementos: " + sumaTotal);
    }

    /**
     * Método recursivo que calcula la suma de todos los elementos de la lista.
     * En cada llamada elimina el primer elemento y lo suma al resultado de la llamada siguiente.
     */
    public static int sumarRecursivo(LinkedList<Integer> lista) {
        // Caso base: si la lista está vacía, devuelve 0
        if (lista.isEmpty()) {
            return 0;
        }

        // Toma el primer elemento
        int primero = lista.removeFirst();

        // Llama recursivamente al método con el resto de la lista
        int sumaRestante = sumarRecursivo(lista);

        // Retorna el valor actual más la suma de los restantes
        return primero + sumaRestante;
    }
}

