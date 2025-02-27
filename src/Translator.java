/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Sección 31
 * Hoja de Trabajo 4
 * Integrantes:
 * - Diana Sosa (241040)
 * - Biancka Raxón (24960)
 * - Ivana Figueroa (24785)
 * 
 * Clase que se encarga de leer archivos y convertir expresiones infix a postfix.
 * 
 * @author Diana Sosa, Biancka Raxón, Ivana Figueroa
 * @version 1.0
 * 
 */

 import java.util.Stack;

 public class Translator {
 
     /**
      * Determina la precedencia de los operadores.
      * 
      * @param ch Operador a evaluar.
      * @return Valor de precedencia (entre más alto, mayor prioridad).
      */
     private int preced(char ch) {
         if (ch == '+' || ch == '-') {
             return 1;  
         } else if (ch == '*' || ch == '/') {
             return 2;  
         } else if (ch == '^') {
             return 3;  
         } else {
             return 0;  
         }
     }
 
     /**
      * Convierte una expresión infix a postfix.
      * 
      * @param infix Expresión en notación infix.
      * @return Expresión convertida a notación postfix.
      */
     public String inToPost(String infix) {
         Stack<Character> stk = new Stack<>();
         stk.push('#');  
         StringBuilder postfix = new StringBuilder();  
 
         for (int i = 0; i < infix.length(); i++) {
             char currentChar = infix.charAt(i);
 
             if (Character.isLetterOrDigit(currentChar)) {
                 postfix.append(currentChar);  
             } else if (currentChar == '(') {
                 stk.push('(');  
             } else if (currentChar == '^') {
                 stk.push('^');  
             } else if (currentChar == ')') {
                 while (stk.peek() != '#' && stk.peek() != '(') {
                     postfix.append(stk.pop());
                 }
                 stk.pop();  
             } else {
                 if (preced(currentChar) > preced(stk.peek())) {
                     stk.push(currentChar);  
                 } else {
                     while (stk.peek() != '#' && preced(currentChar) <= preced(stk.peek())) {
                         postfix.append(stk.pop());  
                     }
                     stk.push(currentChar);  
                 }
             }
         }
 
         while (stk.peek() != '#') {
             postfix.append(stk.pop());
         }
 
         return postfix.toString();
     }
 }
 