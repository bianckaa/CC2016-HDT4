/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Hoja de Trabajo 4
 * 
 * Clase UI
 * Controla la ejecución principal del programa. Lee expresiones desde un archivo,
 * las convierte de notación infix a postfix y evalúa el resultado.
 * 
 */

import java.util.List;

public class UI {

    public static void main(String[] args) {
        // Instancias de las clases principales
        ReaderDocument reader = new ReaderDocument();
        Translator translator = new Translator();
        Calculator calculator = new Calculator();

        // Leer el archivo "datos.txt"
        List<String> expressions = reader.readFile("datos.txt");

        // Procesar cada expresión
        for (String infixExpression : expressions) {
            System.out.println("Expresión infix: " + infixExpression);

            // Convertir de infix a postfix
            String postfixExpression = translator.infixToPostfix(infixExpression);
            System.out.println("Expresión postfix: " + postfixExpression);

            // Evaluar la expresión postfix
            double result = calculator.evaluate(postfixExpression);
            System.out.println("Resultado: " + result);
            System.out.println("-------------------------------");
        }
    }
}
