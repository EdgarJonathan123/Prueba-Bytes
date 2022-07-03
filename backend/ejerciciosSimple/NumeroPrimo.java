
import java.util.List;
import java.util.LinkedList;

public class NumeroPrimo {

    public static void main(String[] args) {
        numerosPrimos();
    }

    public static void numerosPrimos(){

        Integer primero10Primos = 0;

        int i = 0;
        while (primero10Primos<10){
            Boolean esprimo = esPrimo(i);
            if(esprimo){
                primero10Primos++;
                System.out.println("Numero Primo ["+primero10Primos+"]: "+i);
            }
            i++;
        }

    }

    public static Boolean esPrimo(Integer numero){
        if (numero == 0 || numero == 1 || numero == 4) {
            return false;
        }
        for (int x = 2; x < numero / 2; x++) {
            if (numero % x == 0)
                return false;
        }
        return true;
    }

}
