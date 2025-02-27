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
    
    @Override
    public boolean isEmpty(){
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
