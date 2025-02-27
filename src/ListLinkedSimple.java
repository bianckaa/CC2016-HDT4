/** 
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Sección 31
 * Hoja de Trabajo 4
 * Integrantes:
 * - Diana Sosa (241040)
 * - Biancka Raxón (24960)
 * - Ivana Figueroa (24785)
 * 
 * Clase ListLinkedSimple:
 * Hereda de ListAbstract, implementando una lista enlazada simple. 
 * 
 * @param <T> tipo de elemento que contendrá la lista.
 */

public class ListLinkedSimple<T> extends ListAbstract<T> {
    private NodeSimple<T> firstNode;
    private int size;

    /** 
     * Constructor que inicializa una lista vacía.
     */
    public ListLinkedSimple() {
        this.firstNode = null;
        this.size = 0;
    }

    /** 
     * Agrega un elemento en la posición especificada de la lista.
     * 
     * @param index posición donde se insertará el elemento.
     * @param element elemento a agregar en la lista.
     */
    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Indice no encontrado.");
        }

        NodeSimple<T> newNode = new NodeSimple<>(element);

        if (index == 0) { 
            newNode.nextNode = firstNode;
            firstNode = newNode;
        } else { 
            NodeSimple<T> currentNode = firstNode;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.nextNode;
            }
            newNode.nextNode = currentNode.nextNode;
            currentNode.nextNode = newNode;
        }
        size++;
    }

    /** 
     * Elimina el elemento en la posición especificada de la lista.
     * 
     * @param index posición del elemento a eliminar.
     * @return dato del nodo que fue eliminado.
     */
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Indice no encontrado.");
        }

        T removedDataNode;
        if (index == 0) { 
            removedDataNode = firstNode.data;
            firstNode = firstNode.nextNode;
        } else { 
            NodeSimple<T> currentNode = firstNode;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.nextNode;
            }
            removedDataNode = currentNode.nextNode.data;
            currentNode.nextNode = currentNode.nextNode.nextNode;
        }
        size--;
        return removedDataNode;
    }
}

