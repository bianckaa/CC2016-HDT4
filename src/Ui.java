import java.util.List;
import java.util.Scanner;

/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Sección 31
 * Hoja de Trabajo 4
 *
 * Clase UI
 * Controla la ejecución principal del programa. Lee expresiones desde un archivo,
 * las convierte de notación infix a postfix y evalúa el resultado.
 * Permite al usuario seleccionar la implementación de la pila y lista a utilizar.
 *
 * Integrantes:
 * - Diana Sosa (241040)
 * - Biancka Raxón (24960)
 * - Ivana Figueroa (24785)
 *
 * @author Diana Sosa, Biancka Raxón, Ivana Figueroa
 * @version 1.1
 */

public class UI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menú para seleccionar implementación de la pila
        System.out.println("Seleccione la implementación de la pila:");
        System.out.println("1. StackArrayList");
        System.out.println("2. StackVector");
        System.out.println("3. StackListLinkedSimple");
        System.out.println("4. StackListLinkedDouble");

        int optionPila = scanner.nextInt();
        IStack<Double> pila = null;

        // Selección de la implementación de pila
        switch (optionPila) {
            case 1:
                pila = new StackArrayList<>();
                break;
            case 2:
                pila = new StackVector<>();
                break;
            case 3:
                pila = new StackListLinkedSimple<>();
                break;
            case 4:
                pila = new StackListLinkedDouble<>();
                break;
            default:
                System.out.println("Opción no válida. Saliendo...");
                scanner.close();
                System.exit(0);
        }

        // Menú para seleccionar implementación de la lista
        System.out.println("Seleccione la implementación de la lista:");
        System.out.println("1. Lista Simple");
        System.out.println("2. Lista Doble");
        
        int optionLista = scanner.nextInt();
        // Dependiendo de la opción, instanciamos el tipo de lista (en este caso, solo es demostración)
        switch (optionLista) {
            case 1:
                // Aquí pondrías tu implementación de lista simple si es necesario
                System.out.println("Lista Simple seleccionada.");
                break;
            case 2:
                // Aquí pondrías tu implementación de lista doble si es necesario
                System.out.println("Lista Doble seleccionada.");
                break;
            default:
                System.out.println("Opción no válida para listas.");
                scanner.close();
                System.exit(0);
        }

        // Instancias de las clases principales
        ReaderDocument reader = new ReaderDocument();
        Translator translator = new Translator(pila);  // Usamos la pila seleccionada
        Calculator calculator = new Calculator(pila);  // Usamos la pila seleccionada

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

            // Eliminar los espacios de la expresión
            infixExpression = infixExpression.replaceAll("\\s+", "");

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
