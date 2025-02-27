/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Sección 31
 * Hoja de Trabajo 4
 *
 * Clase Calculator
 * Evalúa expresiones matemáticas en notación postfix.
 *
 * Integrantes:
 * - Diana Sosa (241040)
 * - Biancka Raxón (24960)
 * - Ivana Figueroa (24785)
 *
 * @version 1.1
 */
public class Calculator {

    private IStack<Double> stack;  // Instancia de la pila

    /**
     * Constructor que recibe la pila a utilizar.
     *
     * @param stack La pila que se usará para almacenar los operandos durante la evaluación.
     */
    public Calculator(IStack<Double> stack) {
        this.stack = stack;
    }

    /**
     * Evalúa una expresión en notación postfix y retorna el resultado.
     *
     * @param postfix La expresión matemática en notación postfix.
     * @return El resultado de la evaluación como un número decimal (double).
     * @throws IllegalArgumentException Si la expresión es inválida.
     */
    public double evaluate(String postfix) {
        // Iterar sobre cada carácter de la expresión postfix
        for (int i = 0; i < postfix.length(); i++) {
            char currentChar = postfix.charAt(i);

            // Ignorar espacios en blanco
            if (Character.isWhitespace(currentChar)) {
                continue;
            }

            // Si el carácter es un número (puede ser un dígito o parte de un número mayor)
            if (Character.isDigit(currentChar)) {
                StringBuilder numStr = new StringBuilder();
                // Leer el número completo (puede ser más de un dígito)
                while (i < postfix.length() && (Character.isDigit(postfix.charAt(i)) || postfix.charAt(i) == '.')) {
                    numStr.append(postfix.charAt(i));
                    i++;
                }
                // Convertir el número a double y apilarlo
                stack.push(Double.parseDouble(numStr.toString()));
                i--; // Retroceder el índice para compensar el incremento extra del bucle
            } else {
                // Deben haber al menos dos operandos en la pila para realizar la operación
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Expresión postfix inválida.");
                }

                double b = stack.pop();
                double a = stack.pop();

                // Realizar la operación correspondiente
                switch (currentChar) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        if (b == 0) {
                            throw new ArithmeticException("División por cero.");
                        }
                        stack.push(a / b);
                        break;
                    case '^':
                        stack.push(Math.pow(a, b));
                        break;
                    default:
                        throw new IllegalArgumentException("Operador no válido: " + currentChar);
                }
            }
        }

        // Al finalizar, debe haber exactamente un resultado en la pila
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Expresión postfix inválida.");
        }

        return stack.pop();
    }
}
