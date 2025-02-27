/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Hoja de Trabajo 4
 * 
 * Clase Calculator
 * Evalúa expresiones en notación postfix.
 * Parte de la calculadora de la Hoja de Trabajo 4 (UVG).
 * 
 * @version 1.0
 */

 import java.util.Stack;

 public class Calculator {
 
     /**
      * Evalúa una expresión en notación postfix.
      * 
      * @param expression Expresión en notación postfix.
      * @return Resultado de la evaluación.
      * @throws IllegalArgumentException Si la expresión es inválida.
      */
     public double evaluate(String expression) {
         Stack<Double> stack = new Stack<>();
 
         for (char token : expression.toCharArray()) {
             if (Character.isDigit(token)) {
                 stack.push((double) Character.getNumericValue(token));
             } else {
                 if (stack.size() < 2) {
                     throw new IllegalArgumentException("Expresión postfix inválida.");
                 }
                 double b = stack.pop();
                 double a = stack.pop();
 
                 switch (token) {
                     case '+':
                         stack.push(a + b);
                         break;
                     case '-':
                         stack.push(a - b);
                         break;
                     case '*':
                         stack.push(a * b);
                         break;
                     case '/':
                         if (b == 0) {
                             throw new ArithmeticException("División por cero.");
                         }
                         stack.push(a / b);
                         break;
                     case '^':
                         stack.push(Math.pow(a, b));
                         break;
                     default:
                         throw new IllegalArgumentException("Operador desconocido: " + token);
                 }
             }
         }
 
         if (stack.size() != 1) {
             throw new IllegalArgumentException("Expresión postfix inválida.");
         }
 
         return stack.pop();
     }
 }
 