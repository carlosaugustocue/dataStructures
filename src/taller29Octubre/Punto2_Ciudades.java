package taller29Octubre;

import java.util.ArrayList;

/**
 * Punto 2: Inserción, modificación y eliminación de elementos
 * Conceptos: add(index, elemento), set(index, elemento), remove(index)
 */
public class Punto2_Ciudades {

    public static void main(String[] args) {
        // 1. Crear una ArrayList<String> con nombres de tres ciudades
        ArrayList<String> ciudades = new ArrayList<>();




        ciudades.add("Bogotá");
        ciudades.add("Cali");
        ciudades.add("Medellín");

        System.out.println("=== GESTIÓN DE CIUDADES ===\n");
        System.out.println("Lista inicial:");
        mostrarLista(ciudades);

        // 2. Insertar una nueva ciudad en la segunda posición (índice 1)
        // add(index, elemento) inserta el elemento en la posición indicada
        // Los elementos posteriores se desplazan a la derecha
        ciudades.add(1, "Cartagena");
        System.out.println("\nDespués de insertar 'Cartagena' en posición 1:");
        mostrarLista(ciudades);

        // 3. Cambiar el nombre de la tercera ciudad (índice 2) por otro
        // set(index, elemento) reemplaza el elemento en la posición indicada
        ciudades.set(2, "Barranquilla");
        System.out.println("\nDespués de cambiar la ciudad en posición 2 por 'Barranquilla':");
        mostrarLista(ciudades);

        // 4. Eliminar la primera ciudad (índice 0)
        // remove(index) elimina el elemento en la posición indicada
        // Los elementos posteriores se desplazan a la izquierda
        ciudades.remove(0);
        System.out.println("\nDespués de eliminar la primera ciudad:");
        mostrarLista(ciudades);

        // 5. Mostrar el contenido final de la lista
        System.out.println("\n=== Lista final de ciudades ===");
        mostrarLista(ciudades);
    }

    /**
     * Método auxiliar para mostrar el contenido de la lista
     * @param lista ArrayList a mostrar
     */
    private static void mostrarLista(ArrayList<String> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("[" + i + "] " + lista.get(i));
        }
    }
}
