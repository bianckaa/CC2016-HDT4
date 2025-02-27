/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Sección 31
 * Hoja de Trabajo 4
 *
 * Clase que se encarga de convertir expresiones en notación infix a postfix.
 *
 * Integrantes:
 * - Diana Sosa (241040)
 * - Biancka Raxón (24960)
 * - Ivana Figueroa (24785)
 *
 * @author Diana Sosa, Biancka Raxón, Ivana Figueroa
 * @version 1.1
 */
public class Translator {

    private IStack<Character> stack;

    /**
     * Constructor de la clase Translator.
     * @param stack La pila que se usará para la conversión de infix a postfix.
     */
    public Translator(IStack<Character> stack) {
        this.stack = stack;
    }

    /**
     * Determina la precedencia de los operadores matemáticos.
     *
     * @param ch El operador a evaluar.
     * @return Un entero que representa la precedencia del operador (mayor valor, mayor prioridad).
     *         - '+' o '-' tienen precedencia 1
     *         - '*' o '/' tienen precedencia 2
     *         - '^' tiene precedencia 3
     *         - Otros caracteres tienen precedencia 0
     */
    private int preced(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else if (ch == '^') {
            return 3;
        } else {
            return 0;
        }
    }

    /**
     * Convierte una expresión en notación infix a notación postfix.
     * Utiliza una pila para gestionar los operadores y sigue las reglas de precedencia y asociatividad.
     *
     * Reglas principales:
     * - Los operandos se agregan directamente a la salida.
     * - Los operadores se apilan según su precedencia.
     * - Los paréntesis de apertura '(' se apilan directamente.
     * - Los paréntesis de cierre ')' vacían la pila hasta encontrar el correspondiente '('.
     * - El operador '^' (potencia) tiene asociatividad derecha, a diferencia de otros operadores.
     *
     * @param infix La expresión matemática en notación infix.
     * @return Una cadena que representa la expresión en notación postfix.
     * @throws IllegalArgumentException Si los paréntesis están desbalanceados.
     */
    public String infixToPostfix(String infix) {
        stack.push('#');  // Símbolo de referencia para indicar el fondo de la pila
        StringBuilder postfix = new StringBuilder();  // Almacena el resultado en notación postfix

        for (int i = 0; i < infix.length(); i++) {
            char currentChar = infix.charAt(i);

            // Ignorar espacios en blanco
            if (Character.isWhitespace(currentChar)) {
                continue;
            }

            // Si es un operando (número o letra), lo añadimos directamente a la salida
            if (Character.isLetterOrDigit(currentChar)) {
                postfix.append(currentChar);

            // Si es un paréntesis de apertura, lo apilamos
            } else if (currentChar == '(') {
                stack.push('(');

            // Si es un paréntesis de cierre, vaciamos la pila hasta encontrar '('
            } else if (currentChar == ')') {
                while (stack.peek() != '#' && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (stack.peek() == '(') {
                    stack.pop();  // Desapilamos el paréntesis de apertura
                } else {
                    throw new IllegalArgumentException("Error: Paréntesis desbalanceados.");
                }

            // Si es un operador
            } else {
                // Manejar el operador de potencia con asociatividad derecha
                if (currentChar == '^') {
                    stack.push(currentChar); 
                } else {
                    // Desapilar mientras haya operadores de mayor o igual precedencia
                    while (stack.peek() != '#' && preced(currentChar) <= preced(stack.peek())) {
                        postfix.append(stack.pop());
                    }
                    stack.push(currentChar);
                }
            }
        }

        // Desapilar los operadores restantes
        while (stack.peek() != '#') {
            if (stack.peek() == '(') {
                throw new IllegalArgumentException("Error: Paréntesis desbalanceados.");
            }
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }
}
