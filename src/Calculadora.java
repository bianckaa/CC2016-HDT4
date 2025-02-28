/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Sección 31
 * Hoja de Trabajo 4
 *
 * Clase Calculator
 * Se encarga de evaluar una expresión en notación postfix.
 *
 * Integrantes:
 * - Diana Sosa 241040
 * - Biancka Raxón 24960
 * - Ivana Figueroa 24785
 *
 * @author Diana Sosa, Biancka Raxón, Ivana Figueroa
 * @version 1.1
 */

 import java.util.Stack;

 /**
  * La clase Calculadora es responsable de evaluar una expresión matemática en notación postfix
  * utilizando una pila. La expresión postfix se procesa carácter por carácter, y cuando se encuentra
  * un operador, se aplican las operaciones correspondientes a los dos últimos operandos de la pila.
  */
 public class Calculadora {
 
     /**
      * Evalúa una expresión matemática en notación postfix.
      * 
      * @param postfix La expresión en notación postfix que se desea evaluar.
      * @return El resultado de la evaluación de la expresión.
      */
     public static int evaluarPostfix(String postfix) {
         Stack<Integer> pila = new Stack<>();
 
         // Recorre la expresión postfix carácter por carácter.
         for (char c : postfix.toCharArray()) {
             if (Character.isDigit(c)) {
                 // Si el carácter es un dígito, lo agrega a la pila.
                 pila.push(c - '0');
             } else {
                 // Si el carácter es un operador, aplica la operación sobre los dos últimos operandos.
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
 
         // Retorna el resultado final, que es el único valor restante en la pila.
         return pila.pop();
     }
 }
 