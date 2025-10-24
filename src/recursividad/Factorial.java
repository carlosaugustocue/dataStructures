package recursividad;

public class Factorial {
    public static void main(String[] args) {

        int factorial = factorial(5);
        System.out.println(factorial);
    }

    public static int factorial(int numero){

        if(numero == 0){
            return 1 ;
        }

        return numero * factorial(numero-1);
    }
}
