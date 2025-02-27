import java.util.List;
import java.util.Scanner;

public class UI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menú principal
        System.out.println("Seleccione el tipo de estructura:");
        System.out.println("1. Pilas");
        System.out.println("2. Listas");

        int choice = scanner.nextInt();
        IStack<Double> stack = null;

        // Selección de pila o lista
        if (choice == 1) {
            // Menú para Pilas
            System.out.println("Seleccione la implementación de la pila:");
            System.out.println("1. StackArrayList");
            System.out.println("2. StackVector");
            System.out.println("3. StackListLinkedSimple");
            System.out.println("4. StackListLinkedDouble");

            int option = scanner.nextInt();

            // Selección de la pila
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
                default:
                    System.out.println("Opción no válida. Saliendo...");
                    scanner.close();
                    System.exit(0);
            }

        } else if (choice == 2) {
            // Menú para Listas
            System.out.println("Seleccione la implementación de la lista:");
            System.out.println("1. Lista Array");
            System.out.println("2. Lista Vector");
            System.out.println("3. Lista Enlazada Simple");
            System.out.println("4. Lista Enlazada Doble");

            int option = scanner.nextInt();

            // Aquí se podrían agregar las implementaciones de listas si es necesario
            System.out.println("Has seleccionado una lista. Por favor, implementa su funcionamiento.");

            // Aquí asumo que para listas se manejarían otras clases diferentes, que no forman parte del código actual

        } else {
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
