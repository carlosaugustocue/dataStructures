package arreglos;

public class Array {
    public static void main(String[] args) {
        // Sin array: variables separadas
//        int numero1 = 10;
//        int numero2 = 20;
//        int numero3 = 30;
//
//        // Con array: todo en una estructura
//        int[] numeros = {10, 20, 30};

        //int[] numeros = new int[5];   Array de 5 elementos (inicializados en 0)
        //int numeros[] = new int[5];   También válido, pero menos usado



        int[] numeros;              // Declarar
        numeros = new int[5];       // Crear array de 5 elementos
        numeros[0] = 10;            // Asignar valores
        numeros[1] = 20;
        System.out.println(numeros[0]);
    }
}
