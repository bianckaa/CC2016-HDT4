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
public class Translator {

    private IStack<Character> stack;

    /**
     * Constructor de la clase Translator.
     * Inicializa el stack de tipo IStack que se usará para la conversión.
     *
     * @param stack Implementación de la pila a utilizar
     */
    public Translator(IStack<Character> stack) {
        this.stack = stack;
    }

    /**
     * Convierte una expresión matemática de notación infix a postfix.
     * 
     * La conversión se realiza utilizando una pila para manejar operadores y paréntesis.
     * Los números de varios dígitos son tratados correctamente y separados por espacios.
     *
     * @param infix La expresión matemática en notación infix
     * @return La expresión convertida en notación postfix
     * @throws IllegalArgumentException Si la expresión tiene paréntesis desbalanceados
     */
    public String infixToPostfix(String infix) {
        IStack<Character> stk = new StackVector<>();
        stk.push('#');  // Símbolo de referencia para indicar el fondo de la pila
        StringBuilder postfix = new StringBuilder();  // Almacena el resultado en notación postfix

        for (int i = 0; i < infix.length(); i++) {
            char currentChar = infix.charAt(i);

            // Ignorar espacios en blanco
            if (Character.isWhitespace(currentChar)) {
                continue;
            }

            // Si es un número (puede tener más de un dígito)
            if (Character.isDigit(currentChar)) {
                StringBuilder number = new StringBuilder();
                // Acumulamos todos los dígitos de un número
                while (i < infix.length() && Character.isDigit(infix.charAt(i))) {
                    number.append(infix.charAt(i));
                    i++;
                }
                // Decrementamos i para que el siguiente ciclo no salte un carácter
                i--; 
                postfix.append(number.toString()).append(" ");  // Agregar número a postfix con espacio
            }
            // Si es un paréntesis de apertura, lo apilamos
            else if (currentChar == '(') {
                stk.push('(');
            }
            // Si es un paréntesis de cierre, vaciamos la pila hasta encontrar '('
            else if (currentChar == ')') {
                while (stk.peek() != '#' && stk.peek() != '(') {
                    postfix.append(stk.pop()).append(" ");
                }
                if (stk.peek() == '(') {
                    stk.pop();  // Desapilamos el paréntesis de apertura
                } else {
                    throw new IllegalArgumentException("Error: Paréntesis desbalanceados.");
                }
            }
            // Si es un operador
            else {
                // Desapilar mientras haya operadores de mayor o igual precedencia
                while (stk.peek() != '#' && preced(currentChar) <= preced(stk.peek())) {
                    postfix.append(stk.pop()).append(" ");
                }
                stk.push(currentChar);
            }
        }

        // Desapilar los operadores restantes
        while (stk.peek() != '#') {
            if (stk.peek() == '(') {
                throw new IllegalArgumentException("Error: Paréntesis desbalanceados.");
            }
            postfix.append(stk.pop()).append(" ");
        }

        return postfix.toString().trim();  // Eliminar el último espacio adicional
    }

    /**
     * Determina la precedencia de un operador.
     * 
     * Los operadores con mayor precedencia tienen un valor numérico mayor.
     * 
     * @param operator El operador cuyo valor de precedencia se debe determinar
     * @return El valor de precedencia del operador
     */
    private int preced(char operator) {
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
                return -1;  // No es un operador válido
        }
    }
}
