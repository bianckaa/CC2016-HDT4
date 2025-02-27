
/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Sección 31
 * Hoja de Trabajo 4
 *
 * Clase Translator
 * Se encarga de convertir una expresión infix a postfix utilizando una pila.
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

    private IStack<Double> stack;

    /**
     * Constructor de la clase Translator.
     * @param stack La pila que se usará para la conversión.
     */
    public Translator(IStack<Double> stack) {
        this.stack = stack;
    }

    /**
     * Convierte una expresión matemática en notación infix a postfix.
     *
     * @param infix La expresión infix a convertir.
     * @return La expresión convertida a postfix.
     */
    public String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        IStack<Character> operators = new StackArrayList<>();  // Pila para operadores

        for (int i = 0; i < infix.length(); i++) {
            char currentChar = infix.charAt(i);

            // Si el carácter es un número, lo agregamos a la salida
            if (Character.isDigit(currentChar)) {
                postfix.append(currentChar);
            
            // Si es un operador, gestionamos la pila de operadores
            } else if (isOperator(currentChar)) {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(currentChar)) {
                    postfix.append(operators.pop());
                }
                operators.push(currentChar);
            
            // Si es un paréntesis izquierdo, lo apilamos
            } else if (currentChar == '(') {
                operators.push(currentChar);
            
            // Si es un paréntesis derecho, procesamos la pila hasta encontrar el paréntesis izquierdo
            } else if (currentChar == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    postfix.append(operators.pop());
                }
                operators.pop();  // Eliminar '(' de la pila
            }
        }

        // Vaciar los operadores restantes
        while (!operators.isEmpty()) {
            postfix.append(operators.pop());
        }

        return postfix.toString();
    }

    /**
     * Verifica si un carácter es un operador válido.
     *
     * @param ch El carácter a verificar.
     * @return true si es un operador, false de lo contrario.
     */
    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    /**
     * Determina la precedencia de un operador.
     *
     * @param operator El operador cuya precedencia se quiere conocer.
     * @return La precedencia del operador.
     */
    private int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
}
