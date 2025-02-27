/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Sección 31
 * Hoja de Trabajo 4
 * Integrantes:
 * - Diana Sosa (241040)
 * - Biancka Raxón (24960)
 * - Ivana Figueroa (24785)
 * 
 * Clase que se encarga de evaluar expresiones en notación postfix.
 * 
 * @author Diana Sosa, Biancka Raxón, Ivana Figueroa
 * @version 1.0
 */
public class Calculator {

    /**
     * Evalúa una expresión en notación postfix.
     * 
     * @param postfixExpression la expresión postfix a evaluar.
     * @return el resultado de la evaluación.
     */
    public int evaluatePostfix(String postfixExpression) {
        IStack<Integer> stack = new StackArrayList<>();
        
        for (int i = 0; i < postfixExpression.length(); i++) {
            char currentChar = postfixExpression.charAt(i);
            
            // Si el carácter es un número, lo apilamos
            if (Character.isDigit(currentChar)) {
                stack.push(Character.getNumericValue(currentChar));
            } 
            // Si es un operador, realizamos la operación
            else if (isOperator(currentChar)) {
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOperator(a, b, currentChar);
                stack.push(result);
            }
        }
        
        return stack.pop(); // Resultado final
    }

    /**
     * Aplica un operador entre dos operandos.
     * 
     * @param a el primer operando.
     * @param b el segundo operando.
     * @param operator el operador a aplicar.
     * @return el resultado de la operación.
     */
    private int applyOperator(int a, int b, char operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                throw new IllegalArgumentException("Operador no válido");
        }
    }

    /**
     * Verifica si el carácter es un operador válido.
     * 
     * @param ch el carácter a verificar.
     * @return true si el carácter es un operador; false en caso contrario.
     */
    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
}
