/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Sección 31
 * Hoja de Trabajo 4
 *
 * Clase que se encarga de evaluar expresiones en notación postfix.
 *
 * Integrantes:
 * - Diana Sosa (241040)
 * - Biancka Raxón (24960)
 * - Ivana Figueroa (24785)
 *
 * @author Diana Sosa, Biancka Raxón, Ivana Figueroa
 * @version 1.1
 */

/**
 * La clase Calculator evalúa expresiones matemáticas en notación postfix.
 */
public class Calculator {

    /**
     * Evalúa una expresión en notación postfix y retorna el resultado.
     *
     * @param postfix La expresión matemática en notación postfix.
     * @return El resultado de la evaluación como un número decimal (double).
     * @throws IllegalArgumentException Si la expresión es inválida.
     */
    public double evaluate(String postfix) {
        IStack<Double> stack = new StackVector<>();

        for (int i = 0; i < postfix.length(); i++) {
            char currentChar = postfix.charAt(i);

            // Ignorar espacios en blanco
            if (Character.isWhitespace(currentChar)) {
                continue;
            }

            // Si es un número, lo convertimos a double y lo apilamos
            if (Character.isDigit(currentChar)) {
                stack.push((double) (currentChar - '0'));

            } else {
                // Deben haber al menos dos operandos en la pila
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Expresión postfix inválida.");
                }

                double b = stack.pop();
                double a = stack.pop();

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
