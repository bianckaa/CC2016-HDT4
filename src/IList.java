/** 
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Sección 31
 * Hoja de Trabajo 4
 * Integrantes:
 * - Diana Sosa (241040)
 * - Biancka Raxón (24960)
 * - Ivana Figueroa (24785)
 * 
 * Interfaz IList:
 * Define los métodos que se pueden realizar con una lista.
 *
 * Referencia: 
 * - https://www.youtube.com/watch?v=3K1_lj2CABU
 * - https://www.geeksforgeeks.org/list-interface-java-examples/
 * 
 * @param <T> tipo de elemento que contendrá la lista.
 */


public interface IList<T> {
    /** T get(int index);
    T set(int index, T item); */
    void add(int index, T item); 
    T remove(int index);
    /** int indexOf(T item);
    int lastIndexOf(T item);
    ListIterator<T> listIterator(); */
    int size();
    boolean isEmpty();
}