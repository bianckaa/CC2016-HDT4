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

    /** 
     * Agrega un elemento en la posición indicada de la lista.
     * 
     * @param index posición en la que se insertará el elemento.
     * @param item elemento a agregar.
     */
    void add(int index, T item); 

    /** 
     * Elimina el elemento en la posición indicada de la lista.
     * 
     * @param index posición del elemento a eliminar.
     * @return elemento que fue eliminado.
     */
    T remove(int index);
    /** int indexOf(T item);
    int lastIndexOf(T item);
    ListIterator<T> listIterator(); */

    /** 
     * Obtiene el número de elementos en la lista.
     * 
     * @return tamaño de la lista.
     */
    int size();

    /** 
     * Verifica si la lista está vacía.
     * 
     * @return true si la lista no contiene elementos, false en caso contrario.
     */
    boolean isEmpty();
}