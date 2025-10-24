package recursividad;

public class Potencia {
    int n = 1;
    public static void main(String[] args) {

        int potencia = potencia(2,10);
        System.out.println(potencia);
    }

    public static int potencia(int base, int potencia){

        if (potencia == 1){
            return base;
        }
        if (potencia == 0){
            return 1;
        }

        return base * potencia (base,potencia-1);
    }
}
