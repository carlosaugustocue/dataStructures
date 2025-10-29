/**
 * Clase Tarea - Representa una tarea con nombre, descripción y estado
 * Esta clase es un modelo de datos (POJO - Plain Old Java Object)
 */
public class Tarea {
    // Atributos de la clase
    private String nombre;
    private String descripcion;
    private String estado; // "pendiente", "en progreso", o "completada"
    
    /**
     * Constructor de la clase Tarea
     * @param nombre Nombre de la tarea
     * @param descripcion Descripción detallada de la tarea
     * @param estado Estado inicial de la tarea
     */
    public Tarea(String nombre, String descripcion, String estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }
    
    // Métodos getter y setter
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    /**
     * Método toString() para mostrar los datos de la tarea de forma legible
     * @return String con la información de la tarea
     */
    @Override
    public String toString() {
        return String.format("[%s] %s - %s", 
            estado.toUpperCase(), 
            nombre, 
            descripcion);
    }
}
