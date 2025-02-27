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

 import java.io.BufferedReader;
 import java.io.FileReader;
 import java.io.IOException;
 import java.util.ArrayList;
 import java.util.List;
 
 public class ReaderDocument {
 
     /**
      * Lee un archivo de texto y devuelve una lista con las expresiones.
      * 
      * @param fileName Nombre del archivo a leer.
      * @return Lista de expresiones leídas del archivo.
      */
     public List<String> readFile(String fileName) {
         List<String> expressions = new ArrayList<>();
 
         try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
             String line;
             while ((line = br.readLine()) != null) {
                 expressions.add(line);
             }
         } catch (IOException e) {
             System.err.println("Error al leer el archivo: " + e.getMessage());
         }
 
         return expressions;
     }
 }
 