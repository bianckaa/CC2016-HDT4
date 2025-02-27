import java.util.Scanner;

/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Sección 31
 * Hoja de Trabajo 4
 * Integrantes:
 * - Diana Sosa (241040)
 * - Biancka Raxón (24960)
 * - Ivana Figueroa (24785)
 * 
 * Clase principal de la interfaz de usuario para interactuar con el programa.
 * Permite ingresar una expresión infix, convertirla a postfix y mostrar el resultado.
 * 
 * @author Diana Sosa, Biancka Raxón, Ivana Figueroa
 * @version 1.0
 */
public class UI {

    /**
     * Método principal que ejecuta la interfaz de usuario.
     * Solicita una expresión infix, la convierte a postfix y muestra el resultado de la evaluación.
     * 
     * @param args los argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReaderDocument readerDocument = new ReaderDocument();
        Calculator calculator = new Calculator();
        
        System.out.println("Ingrese una expresión infix: ");
        String infixExpression = scanner.nextLine();

        // Convertir infix a postfix
        String postfixExpression = readerDocument.infixToPostfix(infixExpression);
        System.out.println("Expresión Postfix: " + postfixExpression);
        
        // Evaluar la expresión postfix
        int result = calculator.evaluatePostfix(postfixExpression);
        System.out.println("Resultado: " + result);
        
        scanner.close();
    }
}
