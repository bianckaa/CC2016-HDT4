import java.util.Scanner;

/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Sección 31
 * Hoja de Trabajo 4
 * Integrantes:
 * Diana Sosa 241040
 * Biancka Raxón 24960
 * Ivana Figueroa 24785
 * 
 * La clase UI es responsable de interactuar con el usuario a través de la consola,
 * permitiéndole seleccionar diferentes estructuras de datos y mostrando los resultados 
 * de la evaluación de expresiones infix a postfix.
 * 
 * Esta clase contiene métodos para:
 * - Seleccionar el tipo de estructura (Pila o Lista).
 * - Seleccionar la implementación específica de Pila (Array, Vector, Lista Simple Enlazada, Lista Doble Enlazada).
 * - Seleccionar la implementación específica de Lista (Simplemente Enlazada, Doblemente Enlazada).
 * - Mostrar el resultado de la conversión y evaluación de expresiones infix a postfix.
 * 
 * Utiliza la clase Scanner para leer las entradas del usuario desde la consola.
 */
public class UI {
    
    // Instancia del objeto Scanner para leer entradas del usuario.
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Permite al usuario seleccionar entre una Pila o una Lista.
     * 
     * @return La selección del usuario: "pila" o "lista".
     */
    public static String seleccionarEstructura() {
        System.out.println("\nSeleccione una estructura:");
        System.out.println("1. Pila");
        System.out.println("2. Lista");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return (opcion == 1) ? "pila" : "lista";
    }

    /**
     * Permite al usuario seleccionar la implementación específica de una Pila.
     * 
     * @return El nombre de la implementación seleccionada de Pila.
     */
    public static String seleccionarPila() {
        System.out.println("\nSeleccione la implementación de Pila:");
        System.out.println("1. Array");
        System.out.println("2. Vector");
        System.out.println("3. Lista Simple Enlazada");
        System.out.println("4. Lista Doble Enlazada");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return switch (opcion) {
            case 1 -> "PilaArray";
            case 2 -> "PilaVector";
            case 3 -> "PilaLista (Lista Simple)";
            case 4 -> "PilaLista (Lista Doble)";
            default -> "PilaArray";
        };
    }

    /**
     * Permite al usuario seleccionar la implementación específica de una Lista.
     * 
     * @return El nombre de la implementación seleccionada de Lista.
     */
    public static String seleccionarLista() {
        System.out.println("\nSeleccione la implementación de Lista:");
        System.out.println("1. Simplemente Enlazada");
        System.out.println("2. Doblemente Enlazada");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return (opcion == 1) ? "ListaSimple" : "ListaDoble";
    }

    /**
     * Muestra el resultado de la conversión de una expresión infix a postfix, 
     * junto con el resultado de la evaluación y el tipo de implementación utilizada.
     * 
     * @param infix La expresión en notación infix.
     * @param postfix La expresión convertida a notación postfix.
     * @param resultado El resultado de evaluar la expresión postfix.
     * @param tipoImplementacion El tipo de implementación utilizada (Pila o Lista).
     */
    public static void mostrarResultado(String infix, String postfix, int resultado, String tipoImplementacion) {
        System.out.println("\nExpresión Infix: " + infix);
        System.out.println("Expresión Postfix: " + postfix);
        System.out.println("Resultado: " + resultado);
        System.out.println("Implementación utilizada: " + tipoImplementacion);
    }
}
