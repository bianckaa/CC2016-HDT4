/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Sección 31
 * Hoja de Trabajo 4
 *
 * Clase UI
 * Controla la ejecución principal del programa. Lee expresiones desde un archivo,
 * las convierte de notación infix a postfix y evalúa el resultado.
 * Permite al usuario seleccionar la implementación de la pila a utilizar.
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
 
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
 
         // Seleccionar implementación de la pila
         System.out.println("Seleccione la implementación de la pila:");
         System.out.println("1. StackArrayList");
         System.out.println("2. StackVector");
         System.out.println("3. StackListLinkedSimple");
         System.out.println("4. StackListLinkedDouble");
 
         int option = scanner.nextInt();
         IStack<Character> stack = null;
 
         // Selección de la implementación de pila
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
 
