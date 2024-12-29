import java.util.*;

public class P1006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine()); // Leer número de casos
        
        for (int i = 0; i < T; i++) {
            String linea = sc.nextLine();
            System.out.println(hacerBailarina(linea));
        }
    }
    
    public static String hacerBailarina(String texto) {
        if (texto.isEmpty()) return "";
        
        StringBuilder resultado = new StringBuilder();
        boolean mayuscula = true; // Empezamos con mayúscula
        
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            
            // Si es una letra
            if (Character.isLetter(c)) {
                if (mayuscula) {
                    resultado.append(Character.toUpperCase(c));
                } else {
                    resultado.append(Character.toLowerCase(c));
                }
                mayuscula = !mayuscula; // Alternar entre mayúscula y minúscula
            } else {
                // Si no es letra, mantener el carácter original y el patrón
                resultado.append(c);
                if (c != ' ') { // Si no es espacio, alternar el patrón
                    mayuscula = !mayuscula;
                }
            }
        }
        
        return resultado.toString();
    }
}