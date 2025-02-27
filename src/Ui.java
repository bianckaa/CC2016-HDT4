import java.util.List;
import java.util.Scanner;

public class UI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Seleccionar implementación de la pila
        System.out.println("Seleccione la implementación de la pila:");
        System.out.println("1. StackArrayList");
        System.out.println("2. StackVector");
        System.out.println("3. StackListLinkedSimple");
        System.out.println("4. StackListLinkedDouble");

        int optionPila = scanner.nextInt();
        IStack<Double> stack = null;

        // Selección de la implementación de pila
        switch (optionPila) {
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
                System.out.println("Opción no válida para la pila. Saliendo...");
                scanner.close();
                System.exit(0);
        }

        // Menú de selección para la implementación de listas
        System.out.println("Seleccione la implementación de la lista:");
        System.out.println("1. Lista Array");
        System.out.println("2. Lista Doblemente Enlazada");

        int optionLista = scanner.nextInt();
        IStack<Double> list = null;

        // Selección de la implementación de lista
        switch (optionLista) {
            case 1:
                list = new StackArrayList<>();
                break;
            case 2:
                list = new StackListLinkedDouble<>();
                break;
            default:
                System.out.println("Opción no válida para la lista. Saliendo...");
                scanner.close();
                System.exit(0);
        }

        // Instancias de las clases principales
        ReaderDocument reader = new ReaderDocument();
        Translator translator = new Translator(stack);  // Utiliza la pila seleccionada
        Calculator calculator = new Calculator(stack);  // Utiliza la pila seleccionada

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
                String postfixExpression = translator.infixToPostfix(infixExpression.replaceAll("\\s+", ""));
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