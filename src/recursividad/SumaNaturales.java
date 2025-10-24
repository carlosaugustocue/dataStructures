package recursividad;

public class SumaNaturales {
    public static void main(String[] args) {

        int suma = sumaNaturales(5);
        System.out.println(suma);
    }

    public static int sumaNaturales(int numero){

        if (numero == 0 || numero == 1) {
            return 1;
        }

        return numero + sumaNaturales(numero-1);
    }
}
