/** 
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Sección 31
 * Hoja de Trabajo 4
 * Integrantes:
 * - Diana Sosa (241040)
 * - Biancka Raxón (24960)
 * - Ivana Figueroa (24785)
 * 
 * Clase abstracta ListAbstract:
 * Implementación parcial de la interfaz IList. 
 * 
 * @param <T> tipo de elemento que contendrá la lista.
 */

public abstract class ListAbstract<T> implements IList<T> {
    protected int size;
    
    /** 
     * Verifica si la lista está vacía.
     * 
     * @return true si la lista está vacia, false si contiene elementos.
     */
    @Override
    public boolean isEmpty(){
        return size() == 0;
    }

    /** 
     * Obtiene el tamaño actual de la lista.
     * 
     * @return numero de elementos en la lista.
     */
    @Override
    public int size() {
        return size;
    }
}
