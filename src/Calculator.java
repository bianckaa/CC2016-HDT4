/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Sección 31
 * Hoja de Trabajo 4
 *
 * Clase Calculator
 * Se encarga de evaluar una expresión en notación postfix.
 *
 * Integrantes:
 * - Diana Sosa (241040)
 * - Biancka Raxón (24960)
 * - Ivana Figueroa (24785)
 *
 * @author Diana Sosa, Biancka Raxón, Ivana Figueroa
 * @version 1.1
 */

 public class Calculator {
    
    private IStack<Double> stack;

    /**
     * Constructor de la clase Calculator.
     * @param stack La pila que se usará para evaluar las expresiones postfix.
     */
    public Calculator(IStack<Double> stack) {
        this.stack = stack;
    }

    /**
     * Evalúa una expresión matemática en notación postfix.
     *
     * @param postfix La expresión en notación postfix.
     * @return El resultado de la evaluación de la expresión.
     * @throws IllegalArgumentException Si la expresión contiene errores (como un número de operadores incorrecto).
     */
    public double evaluate(String postfix) {
        for (int i = 0; i < postfix.length(); i++) {
            char currentChar = postfix.charAt(i);

            // Si el carácter es un número, lo apilamos
            if (Character.isDigit(currentChar)) {
                stack.push((double) (currentChar - '0'));  // Convertimos el char a su valor numérico

            // Si el carácter es un operador, realizamos la operación
            } else if (isOperator(currentChar)) {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = performOperation(operand1, operand2, currentChar);
                stack.push(result);
            }
        }

        // El resultado final debe ser el único elemento en la pila
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Error en la expresión postfix.");
        }

        return stack.pop();
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
     * Realiza una operación matemática entre dos operandos.
     *
     * @param operand1 El primer operando.
     * @param operand2 El segundo operando.
     * @param operator El operador a aplicar.
     * @return El resultado de la operación.
     */
    private double performOperation(double operand1, double operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("División por cero.");
                }
                return operand1 / operand2;
            case '^':
                return Math.pow(operand1, operand2);
            default:
                throw new IllegalArgumentException("Operador desconocido: " + operator);
        }
    }
}
