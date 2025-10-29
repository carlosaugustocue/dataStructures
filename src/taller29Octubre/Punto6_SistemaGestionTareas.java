import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Punto 6: Sistema de Gestión de Tareas
 * Sistema completo para administrar tareas con diferentes estados
 */
public class Punto6_SistemaGestionTareas {
    
    // ArrayList global para almacenar las tareas
    private static ArrayList<Tarea> listaTareas = new ArrayList<>();
    
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════");
        System.out.println("    SISTEMA DE GESTIÓN DE TAREAS");
        System.out.println("═══════════════════════════════════════════\n");
        
        // Agregar tareas iniciales (mínimo 5)
        inicializarTareas();
        
        // Demostración de todas las operaciones
        System.out.println("1. MOSTRAR TODAS LAS TAREAS");
        System.out.println("───────────────────────────────────────────");
        mostrarTodasLasTareas();
        
        System.out.println("\n2. BUSCAR UNA TAREA POR NOMBRE");
        System.out.println("───────────────────────────────────────────");
        buscarTareaPorNombre("Estudiar Java");
        
        System.out.println("\n3. ACTUALIZAR ESTADO DE UNA TAREA");
        System.out.println("───────────────────────────────────────────");
        actualizarEstadoTarea("Hacer mercado", "completada");
        
        System.out.println("\n4. ELIMINAR UNA TAREA COMPLETADA");
        System.out.println("───────────────────────────────────────────");
        eliminarTareasCompletadas();
        
        System.out.println("\n5. MOSTRAR SOLO LAS TAREAS PENDIENTES");
        System.out.println("───────────────────────────────────────────");
        mostrarTareasPorEstado("pendiente");
        
        System.out.println("\n6. ORDENAR TAREAS ALFABÉTICAMENTE");
        System.out.println("───────────────────────────────────────────");
        ordenarTareasAlfabeticamente();
        
        System.out.println("\n7. CONTAR TAREAS POR ESTADO");
        System.out.println("───────────────────────────────────────────");
        contarTareasPorEstado();
        
        System.out.println("\n8. LIMPIAR LISTA COMPLETA");
        System.out.println("───────────────────────────────────────────");
        limpiarListaCompleta();
    }
    
    /**
     * Inicializa la lista con 5 tareas de ejemplo
     */
    private static void inicializarTareas() {
        listaTareas.add(new Tarea("Hacer mercado", "Comprar frutas y verduras", "pendiente"));
        listaTareas.add(new Tarea("Estudiar Java", "Repasar ArrayList y Collections", "en progreso"));
        listaTareas.add(new Tarea("Enviar reporte", "Enviar reporte mensual al jefe", "pendiente"));
        listaTareas.add(new Tarea("Ejercicio", "Ir al gimnasio por 1 hora", "en progreso"));
        listaTareas.add(new Tarea("Llamar al banco", "Consultar sobre la tarjeta de crédito", "pendiente"));
    }
    
    /**
     * Muestra todas las tareas en la lista
     */
    private static void mostrarTodasLasTareas() {
        if (listaTareas.isEmpty()) {
            System.out.println("⚠ No hay tareas en la lista.");
            return;
        }
        
        for (int i = 0; i < listaTareas.size(); i++) {
            System.out.println((i + 1) + ". " + listaTareas.get(i));
        }
        System.out.println("\nTotal: " + listaTareas.size() + " tarea(s)");
    }
    
    /**
     * Busca una tarea por su nombre
     * @param nombre Nombre de la tarea a buscar
     */
    private static void buscarTareaPorNombre(String nombre) {
        boolean encontrada = false;
        
        for (Tarea tarea : listaTareas) {
            if (tarea.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("✓ Tarea encontrada:");
                System.out.println("  " + tarea);
                encontrada = true;
                break;
            }
        }
        
        if (!encontrada) {
            System.out.println("✗ No se encontró ninguna tarea con el nombre '" + nombre + "'");
        }
    }
    
    /**
     * Actualiza el estado de una tarea existente
     * @param nombre Nombre de la tarea
     * @param nuevoEstado Nuevo estado de la tarea
     */
    private static void actualizarEstadoTarea(String nombre, String nuevoEstado) {
        boolean actualizada = false;
        
        for (Tarea tarea : listaTareas) {
            if (tarea.getNombre().equalsIgnoreCase(nombre)) {
                String estadoAnterior = tarea.getEstado();
                tarea.setEstado(nuevoEstado);
                System.out.println("✓ Tarea actualizada:");
                System.out.println("  Nombre: " + tarea.getNombre());
                System.out.println("  Estado anterior: " + estadoAnterior);
                System.out.println("  Estado nuevo: " + nuevoEstado);
                actualizada = true;
                break;
            }
        }
        
        if (!actualizada) {
            System.out.println("✗ No se pudo actualizar. Tarea no encontrada.");
        }
    }
    
    /**
     * Elimina todas las tareas que estén en estado "completada"
     */
    private static void eliminarTareasCompletadas() {
        int cantidadEliminadas = 0;
        
        // Recorremos la lista desde el final para evitar problemas al eliminar
        for (int i = listaTareas.size() - 1; i >= 0; i--) {
            if (listaTareas.get(i).getEstado().equalsIgnoreCase("completada")) {
                System.out.println("  Eliminando: " + listaTareas.get(i).getNombre());
                listaTareas.remove(i);
                cantidadEliminadas++;
            }
        }
        
        if (cantidadEliminadas > 0) {
            System.out.println("✓ Se eliminaron " + cantidadEliminadas + " tarea(s) completada(s)");
        } else {
            System.out.println("⚠ No hay tareas completadas para eliminar");
        }
    }
    
    /**
     * Muestra solo las tareas que tienen un estado específico
     * @param estado Estado a filtrar ("pendiente", "en progreso", "completada")
     */
    private static void mostrarTareasPorEstado(String estado) {
        int contador = 0;
        
        System.out.println("Tareas con estado '" + estado + "':");
        for (Tarea tarea : listaTareas) {
            if (tarea.getEstado().equalsIgnoreCase(estado)) {
                System.out.println("  • " + tarea.getNombre() + " - " + tarea.getDescripcion());
                contador++;
            }
        }
        
        if (contador == 0) {
            System.out.println("  No hay tareas con estado '" + estado + "'");
        } else {
            System.out.println("\nTotal: " + contador + " tarea(s)");
        }
    }
    
    /**
     * Ordena las tareas alfabéticamente por nombre
     */
    private static void ordenarTareasAlfabeticamente() {
        // Usamos Collections.sort() con un Comparator personalizado
        Collections.sort(listaTareas, new Comparator<Tarea>() {
            @Override
            public int compare(Tarea t1, Tarea t2) {
                return t1.getNombre().compareToIgnoreCase(t2.getNombre());
            }
        });
        
        System.out.println("✓ Tareas ordenadas alfabéticamente:");
        mostrarTodasLasTareas();
    }
    
    /**
     * Cuenta cuántas tareas hay en cada estado
     */
    private static void contarTareasPorEstado() {
        int pendientes = 0;
        int enProgreso = 0;
        int completadas = 0;
        
        for (Tarea tarea : listaTareas) {
            String estado = tarea.getEstado().toLowerCase();
            
            if (estado.equals("pendiente")) {
                pendientes++;
            } else if (estado.equals("en progreso")) {
                enProgreso++;
            } else if (estado.equals("completada")) {
                completadas++;
            }
        }
        
        System.out.println("Estadísticas de tareas:");
        System.out.println("  📋 Pendientes: " + pendientes);
        System.out.println("  ⏳ En progreso: " + enProgreso);
        System.out.println("  ✅ Completadas: " + completadas);
        System.out.println("  ━━━━━━━━━━━━━━━━");
        System.out.println("  📊 Total: " + listaTareas.size());
    }
    
    /**
     * Limpia toda la lista de tareas
     */
    private static void limpiarListaCompleta() {
        if (listaTareas.isEmpty()) {
            System.out.println("⚠ La lista ya está vacía.");
            return;
        }
        
        int cantidadTareas = listaTareas.size();
        listaTareas.clear();
        
        System.out.println("✓ Se eliminaron " + cantidadTareas + " tarea(s)");
        System.out.println("¿La lista está vacía? " + listaTareas.isEmpty());
        System.out.println("Tamaño actual: " + listaTareas.size());
    }
}
