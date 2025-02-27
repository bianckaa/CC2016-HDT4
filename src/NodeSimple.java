/** 
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Sección 31
 * Hoja de Trabajo 4
 * Integrantes:
 * - Diana Sosa (241040)
 * - Biancka Raxón (24960)
 * - Ivana Figueroa (24785)
 * 
 * Referencia: 
 * - https://stackoverflow.com/questions/60288770/getint-index-method-in-java
 * 
 * @param <T> el tipo de elementos que contendra el nodo.
 */

public class NodeSimple<T> {
    T data;
    NodeSimple<T> nextNode;

    public NodeSimple(T data) {
        this.data = data;
        this.nextNode = null;
    }
}


