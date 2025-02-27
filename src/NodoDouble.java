/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Sección 31
 * Hoja de Trabajo 4
 * Integrantes:
 * Diana Sosa 241040
 * Biancka Raxón 24960
 * Ivana Figueroa 24785
 * 
 * 
 *  @param <T> el tipo de elementos que contendra el nodo.
 */

public class NodoDouble<T> {
    T data;
    NodoDouble<T> nextNode;
    NodoDouble<T> previousNode;
    
    public NodoDouble(T data) {
        this.data = data;
        this.nextNode = null;
        this.previousNode = null;
    }
}