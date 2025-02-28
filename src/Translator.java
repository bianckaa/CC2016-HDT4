/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Sección 31
 * Hoja de Trabajo 4
 *
 * Clase Translator
 * Esta clase se encarga de convertir una expresión matemática en notación infix a postfix.
 * Utiliza una pila para manejar operadores y paréntesis, y garantiza que los números de
 * varios dígitos sean manejados correctamente, separados por espacios.
 *
 * Integrantes:
 * - Diana Sosa (241040)
 * - Biancka Raxón (24960)
 * - Ivana Figueroa (24785)
 *
 * @author Diana Sosa, Biancka Raxón, Ivana Figueroa
 * @version 1.1
 */
import java.util.Stack;

public class Translator {
    public static String convertir(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> pila = new Stack<>();

        for (char c : infix.toCharArray()) {
            if (Character.isDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                pila.push(c);
            } else if (c == ')') {
                while (!pila.isEmpty() && pila.peek() != '(') {
                    postfix.append(pila.pop());
                }
                pila.pop();
            } else {
                while (!pila.isEmpty() && prioridad(c) <= prioridad(pila.peek())) {
                    postfix.append(pila.pop());
                }
                pila.push(c);
            }
        }

        while (!pila.isEmpty()) {
            postfix.append(pila.pop());
        }

        return postfix.toString();
    }

    private static int prioridad(char operador) {
        return switch (operador) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> -1;
        };
    }
}
