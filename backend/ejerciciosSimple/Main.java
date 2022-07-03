
import java.util.List;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        numerosPrimos();
        System.out.println("la frase RECONOCER es palindroma? "+esPalindroma("RECONOCER"));
    }

    public static Boolean esPalindroma(String frase){

        String fraseAlRevez = darVuelta(frase);

        return fraseAlRevez.equals(frase);
    }
    public static String darVuelta(String frase){

        String fraseAlRevez = "";
        for (int i = frase.length()-1; i >= 0; i--) {
            fraseAlRevez+= frase.charAt(i);
        }
        return fraseAlRevez;
    }

    public static void numerosPrimos(){

        Integer primero10Primos = 0;

        int i = 0;
        while (primero10Primos<10){
            Boolean esprimo = esPrimo(i);
            if(esprimo){
                primero10Primos++;
                System.out.println("esprimo: "+i);
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
