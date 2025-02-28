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

public class ReaderDocument {
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