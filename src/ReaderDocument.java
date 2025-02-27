/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Sección 31
 * Hoja de Trabajo 4
 * Integrantes:
 * - Diana Sosa (241040)
 * - Biancka Raxón (24960)
 * - Ivana Figueroa (24785)
 * 
 * Clase que se encarga de leer archivos y convertir expresiones infix a postfix.
 * 
 * @author Diana Sosa, Biancka Raxón, Ivana Figueroa
 * @version 1.0
 */
public class ReaderDocument {

    /**
     * Lee el contenido de un archivo y lo devuelve como una cadena.
     * 
     * @param fileName el nombre del archivo a leer.
     * @return el contenido del archivo como una cadena.
     */
    public String readFromFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    /**
     * Convierte una expresión infix en una expresión postfix.
     * 
     * @param infixExpression la expresión infix a convertir.
     * @return la expresión postfix resultante.
     */
    public String infixToPostfix(String infixExpression) {
        IStack<Character> stack = new StackArrayList<>();
        StringBuilder postfix = new StringBuilder();
        
        for (int i = 0; i < infixExpression.length(); i++) {
            char currentChar = infixExpression.charAt(i);
            
            // Si el carácter es un número o una letra, lo agregamos directamente al postfix
            if (Character.isLetterOrDigit(currentChar)) {
                postfix.append(currentChar);
            } 
            // Si es un operador, lo procesamos
            else if (currentChar == '(') {
                stack.push(currentChar);
            } 
            else if (currentChar == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // Elimina el '(' de la pila
            } 
            else if (isOperator(currentChar)) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(currentChar)) {
                    postfix.append(stack.pop());
                }
                stack.push(currentChar);
            }
        }
        
        // Vaciar la pila
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        
        return postfix.toString();
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

    /**
     * Devuelve la precedencia de un operador.
     * 
     * @param operator el operador a evaluar.
     * @return la precedencia del operador (mayor número significa mayor precedencia).
     */
    private int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }
}

