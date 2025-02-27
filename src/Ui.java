/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Sección 31
 * Hoja de Trabajo 4
 *
 * Clase UI
 * Controla la ejecución principal del programa. Permite al usuario seleccionar
 * la implementación de la pila o lista, y luego procesa expresiones matemáticas
 * de notación infix a postfix, evaluando el resultado.
 *
 * El usuario puede elegir entre diferentes implementaciones de pilas o listas,
 * y la conversión de infix a postfix se realiza utilizando la clase Translator.
 * Luego, la clase Calculator evalúa la expresión postfix.
 *
 * Integrantes:
 * - Diana Sosa (241040)
 * - Biancka Raxón (24960)
 * - Ivana Figueroa (24785)
 *
 * @author Diana Sosa, Biancka Raxón, Ivana Figueroa
 * @version 1.1
 */
import java.util.List;
import java.util.Scanner;

public class UI {

    /**
     * Método principal que controla la ejecución del programa.
     * Permite al usuario elegir entre diferentes implementaciones de pilas o listas.
     * Luego procesa las expresiones matemáticas de un archivo y las evalúa.
     *
     * @param args Argumentos de línea de comandos (no utilizados en este caso)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menú para seleccionar la implementación de la pila o lista
        System.out.println("Seleccione la implementación para la pila o lista:");
        System.out.println("1. StackArrayList");
        System.out.println("2. StackVector");
        System.out.println("3. StackListLinkedSimple");
        System.out.println("4. StackListLinkedDouble");
        System.out.println("5. Lista doblemente encadenada");
        System.out.println("6. Lista simplemente encadenada");

        int option = scanner.nextInt();
        IStack<Double> stack = null;

        // Selección de la implementación de pila/lista
        switch (option) {
            case 1:
                stack = new StackArrayList<>();
                break;
            case 2:
                stack = new StackVector<>();
                break;
            case 3:
                stack = new StackListLinkedSimple<>();
                break;
            case 4:
                stack = new StackListLinkedDouble<>();
                break;
            case 5:
                // Aquí iría la implementación para lista doblemente encadenada si es necesario
                break;
            case 6:
                // Aquí iría la implementación para lista simplemente encadenada si es necesario
                break;
            default:
                System.out.println("Opción no válida. Saliendo...");
                scanner.close();
                System.exit(0);
        }

        // Instancias de las clases principales
        ReaderDocument reader = new ReaderDocument();
        Translator translator = new Translator(stack);
        Calculator calculator = new Calculator(stack);

        // Leer el archivo "datos.txt"
        List<String> expressions = reader.readFile("datos.txt");

        // Verifica si el archivo tiene expresiones
        if (expressions.isEmpty()) {
            System.out.println("El archivo está vacío o no contiene expresiones válidas.");
            scanner.close();
            return;
        }

        // Procesar cada expresión
        for (String infixExpression : expressions) {
            System.out.println("Expresión infix: " + infixExpression);

            try {
                // Convertir de infix a postfix
                String postfixExpression = translator.infixToPostfix(infixExpression);
                System.out.println("Expresión postfix: " + postfixExpression);

                // Evaluar la expresión postfix
                double result = calculator.evaluate(postfixExpression);
                System.out.println("Resultado: " + result);
            } catch (Exception e) {
                System.out.println("Error al procesar la expresión: " + e.getMessage());
            }

            System.out.println("-------------------------------");
        }

        // Cerrar el scanner
        scanner.close();
    }
}
