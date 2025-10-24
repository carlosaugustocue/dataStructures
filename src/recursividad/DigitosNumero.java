package recursividad;

public class DigitosNumero {
    public static int contarDigitos(int n) {
        // Caso base
        if (n < 10 && n > -10) {
            return 1;
        }
        // Caso recursivo
        return 1 + contarDigitos(n / 10);
    }

    public static void main(String[] args) {
        System.out.println("Dígitos de 12345: " + contarDigitos(12345)); // Salida: 5
    }

}
