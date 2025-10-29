import java.util.ArrayList;

/**
 * Punto 3: Búsqueda y validación dentro de la lista
 * Conceptos: contains(), indexOf()
 */
public class Punto3Estudiantes {
    
    public static void main(String[] args) {
        // 1. Crear una ArrayList<String> con nombres de estudiantes
        ArrayList<String> estudiantes = new ArrayList<>();
        estudiantes.add("Carlos");
        estudiantes.add("María");
        estudiantes.add("Andrés");
        estudiantes.add("Laura");
        estudiantes.add("Pedro");
        
        System.out.println("=== BÚSQUEDA DE ESTUDIANTES ===\n");
        System.out.println("Lista inicial de estudiantes:");
        mostrarLista(estudiantes);
        
        // 2. Verificar si un estudiante específico está en la lista
        String nombreBuscar = "Daniela";
        System.out.println("\n¿Buscando a '" + nombreBuscar + "'...");
        
        // contains() devuelve true si el elemento existe, false si no
        if (estudiantes.contains(nombreBuscar)) {
            // 3. Si está, mostrar su posición con indexOf()
            // indexOf() devuelve la posición del elemento, o -1 si no existe
            int posicion = estudiantes.indexOf(nombreBuscar);
            System.out.println("✓ '" + nombreBuscar + "' está registrada en la posición: " + posicion);
        } else {
            // 4. Si no está, mostrar un mensaje
            System.out.println("✗ '" + nombreBuscar + "' no se encontró en la lista");
            
            // 5. Agregar el nuevo nombre
            System.out.println("Agregando a '" + nombreBuscar + "' a la lista...");
            estudiantes.add(nombreBuscar);
        }
        
        // Mostrar la lista actualizada
        System.out.println("\n=== Lista actualizada de estudiantes ===");
        mostrarLista(estudiantes);
        
        // Ejemplo adicional: buscar un estudiante que SÍ existe
        System.out.println("\n--- Búsqueda adicional ---");
        String nombreExistente = "María";
        System.out.println("Buscando a '" + nombreExistente + "'...");
        if (estudiantes.contains(nombreExistente)) {
            int posicion = estudiantes.indexOf(nombreExistente);
            System.out.println("✓ '" + nombreExistente + "' está en la posición: " + posicion);
        }
    }
    
    /**
     * Método auxiliar para mostrar el contenido de la lista
     * @param lista ArrayList a mostrar
     */
    private static void mostrarLista(ArrayList<String> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("  [" + i + "] " + lista.get(i));
        }
    }
}
