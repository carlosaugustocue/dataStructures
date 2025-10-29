import java.util.ArrayList;

/**
 * Punto 5: Recorrido inverso y filtrado
 * Conceptos: recorrido inverso con bucle for, filtrado con condiciones
 */
public class Punto5_Numeros {
    
    public static void main(String[] args) {
        // 1. Crear una ArrayList<Integer> con al menos 10 números enteros
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(15);
        numeros.add(82);
        numeros.add(34);
        numeros.add(91);
        numeros.add(47);
        numeros.add(23);
        numeros.add(68);
        numeros.add(55);
        numeros.add(12);
        numeros.add(76);
        
        System.out.println("=== RECORRIDO Y FILTRADO DE NÚMEROS ===\n");
        
        // 2. Mostrar todos los elementos en orden normal
        System.out.println("Números en orden normal:");
        for (int i = 0; i < numeros.size(); i++) {
            System.out.print(numeros.get(i));
            if (i < numeros.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("\n");
        
        // 3. Recorrer la lista en orden inverso
        // Iniciamos desde el último índice (size()-1) y vamos hacia atrás hasta 0
        System.out.println("Números en orden inverso:");
        for (int i = numeros.size() - 1; i >= 0; i--) {
            System.out.print(numeros.get(i));
            if (i > 0) {
                System.out.print(", ");
            }
        }
        System.out.println("\n");
        
        // 4. Mostrar únicamente los números mayores a 50
        System.out.println("Números mayores a 50:");
        // Usamos un for-each y verificamos la condición dentro del bucle
        for (Integer numero : numeros) {
            if (numero > 50) {
                System.out.println("  • " + numero);
            }
        }
        
        // Información adicional
        System.out.println("\n=== Estadísticas ===");
        contarMayoresA50(numeros);
    }
    
    /**
     * Método auxiliar para contar cuántos números son mayores a 50
     * @param lista ArrayList de números
     */
    private static void contarMayoresA50(ArrayList<Integer> lista) {
        int contador = 0;
        for (Integer numero : lista) {
            if (numero > 50) {
                contador++;
            }
        }
        System.out.println("Total de números mayores a 50: " + contador + " de " + lista.size());
    }
}
