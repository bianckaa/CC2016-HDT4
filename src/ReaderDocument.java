/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Hoja de Trabajo 4
 * 
 * Clase ReaderDocument
 * Lee las expresiones desde un archivo de texto.
 * Parte de la calculadora de la Hoja de Trabajo 4 (UVG).
 * 
 * @version 1.0
 */

 import java.io.*;

 /**
  * La clase ReaderDocument es responsable de leer una expresión desde un archivo de texto.
  * Utiliza un BufferedReader para leer el contenido línea por línea y luego lo concatena
  * en una sola cadena que representa la expresión completa.
  * 
  * Esta clase es parte de la implementación de la calculadora de la Hoja de Trabajo 4 de
  * la Universidad del Valle de Guatemala (UVG), para convertir y evaluar expresiones infix a postfix.
  */
 public class ReaderDocument {
     
     /**
      * Lee el contenido de un archivo de texto y lo devuelve como una sola cadena de texto.
      * 
      * @param archivo El nombre del archivo que contiene la expresión.
      * @return La expresión leída del archivo, representada como una cadena.
      */
     public static String leerExpresion(String archivo) {
         StringBuilder expresion = new StringBuilder();
         try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
             String linea;
             while ((linea = br.readLine()) != null) {
                 expresion.append(linea).append(" ");
             }
         } catch (IOException e) {
             System.out.println("Error al leer el archivo: " + e.getMessage());
         }
         return expresion.toString().trim();
     }
 }
 