import java.util.ArrayList;

/**
 * Punto 4: Combinación y limpieza de listas
 * Conceptos: addAll(), clear(), isEmpty()
 */
public class Punto4Colores {
    
    public static void main(String[] args) {
        // 1. Crear dos ArrayList<String>, cada una con al menos tres colores diferentes
        ArrayList<String> coloresCalidos = new ArrayList<>();
        coloresCalidos.add("Rojo");
        coloresCalidos.add("Naranja");
        coloresCalidos.add("Amarillo");


        
        ArrayList<String> coloresFrios = new ArrayList<>();
        coloresFrios.add("Azul");
        coloresFrios.add("Verde");
        coloresFrios.add("Violeta");
        
        System.out.println("=== COMBINACIÓN Y LIMPIEZA DE LISTAS ===\n");
        
        System.out.println("Lista 1 - Colores cálidos:");
        mostrarLista(coloresCalidos);
        
        System.out.println("\nLista 2 - Colores fríos:");
        mostrarLista(coloresFrios);
        
        // 2. Unir ambas listas en una sola con addAll()
        // addAll() agrega todos los elementos de una colección al final de la lista
        ArrayList<String> todosLosColores = new ArrayList<>();
        todosLosColores.addAll(coloresCalidos);
        todosLosColores.addAll(coloresFrios);
        
        // 3. Mostrar el contenido combinado
        System.out.println("\n=== Lista combinada ===");
        mostrarLista(todosLosColores);
        System.out.println("Total de colores: " + todosLosColores.size());
        
        // 4. Eliminar todos los elementos de la lista usando clear()
        System.out.println("\nLimpiando la lista...");
        todosLosColores.clear();
        
        // 5. Verificar que la lista esté vacía con isEmpty()
        // isEmpty() devuelve true si la lista no tiene elementos, false si tiene alguno
        System.out.println("¿La lista está vacía? " + todosLosColores.isEmpty());
        System.out.println("Tamaño actual: " + todosLosColores.size());
        
        // Demostración adicional
        System.out.println("\n--- Demostración adicional ---");
        System.out.println("Las listas originales no se afectaron:");
        System.out.println("Colores cálidos: " + coloresCalidos);
        System.out.println("Colores fríos: " + coloresFrios);
    }
    
    /**
     * Método auxiliar para mostrar el contenido de la lista
     * @param lista ArrayList a mostrar
     */
    private static void mostrarLista(ArrayList<String> lista) {
        for (String elemento : lista) {
            System.out.println("  • " + elemento);
        }
    }
}
