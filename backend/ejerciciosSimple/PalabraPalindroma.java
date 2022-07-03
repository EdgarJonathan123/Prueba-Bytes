
import java.util.List;
import java.util.LinkedList;

public class PalabraPalindroma {

    public static void main(String[] args) {
		
		for(int i = 0; i< args.length; i++) {
            try {
                String actualParam = String.valueOf(args[i]);
                Boolean esPalindroma = esPalindroma(actualParam);
                String respuesta = esPalindroma?"si es palindroma ":"no es palindroma" ;
                System.out.println(String.format("La palabra '%s' es palindroma? %s", actualParam,respuesta ));
            }
            catch (Exception e) {
                System.out.println(e);
            }
		}
    }

    public static Boolean esPalindroma(String frase){
        frase  = frase.toLowerCase();
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

}
