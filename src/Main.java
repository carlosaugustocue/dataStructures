//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        String c = a;

        long inicio = System.currentTimeMillis();

        for(int i = 0; i <= 1000; i++){
            c = c.concat(a).concat(b).concat("\n");
        }

        long fin = System.currentTimeMillis();

        System.out.println(fin - inicio);
    }
}