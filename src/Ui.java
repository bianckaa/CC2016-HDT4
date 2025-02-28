import java.util.Scanner;

public class UI {
    private static final Scanner scanner = new Scanner(System.in);

    public static String seleccionarEstructura() {
        System.out.println("\nSeleccione una estructura:");
        System.out.println("1. Pila");
        System.out.println("2. Lista");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return (opcion == 1) ? "pila" : "lista";
    }

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

    public static String seleccionarLista() {
        System.out.println("\nSeleccione la implementación de Lista:");
        System.out.println("1. Simplemente Enlazada");
        System.out.println("2. Doblemente Enlazada");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return (opcion == 1) ? "ListaSimple" : "ListaDoble";
    }

    public static void mostrarResultado(String infix, String postfix, int resultado, String tipoImplementacion) {
        System.out.println("\nExpresión Infix: " + infix);
        System.out.println("Expresión Postfix: " + postfix);
        System.out.println("Resultado: " + resultado);
        System.out.println("Implementación utilizada: " + tipoImplementacion);
    }
}
