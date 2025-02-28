/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Sección 31
 * Hoja de Trabajo 4
 *
 * Clase Calculator
 * Se encarga de evaluar una expresión en notación postfix.
 *
 * Integrantes:
 * - Diana Sosa (241040)
 * - Biancka Raxón (24960)
 * - Ivana Figueroa (24785)
 *
 * @author Diana Sosa, Biancka Raxón, Ivana Figueroa
 * @version 1.1
 */

 import java.util.Stack;

 public class Calculadora {
     public static int evaluarPostfix(String postfix) {
         Stack<Integer> pila = new Stack<>();
 
         for (char c : postfix.toCharArray()) {
             if (Character.isDigit(c)) {
                 pila.push(c - '0');
             } else {
                 int b = pila.pop();
                 int a = pila.pop();
                 switch (c) {
                     case '+' -> pila.push(a + b);
                     case '-' -> pila.push(a - b);
                     case '*' -> pila.push(a * b);
                     case '/' -> pila.push(a / b);
                 }
             }
         }
 
         return pila.pop();
     }
 }
 