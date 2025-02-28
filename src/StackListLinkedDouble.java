/** 
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Sección 31
 * Hoja de Trabajo 4
 * Integrantes:
 * - Diana Sosa (241040)
 * - Biancka Raxón (24960)
 * - Ivana Figueroa (24785)
 * 
 * Clase StackListLinkedDouble:
 * Hereda de StackListAbstract, implementando una lista doblemente enlazada. 
 * 
 * @param <T> tipo de elemento que contendrá la pila.
 */

public class StackListLinkedDouble<T> extends StackListAbstract<T> {
    private NodeDouble<T> stackTop;

    /** 
     * Constructor que inicializa una pila vacía usando nodos dobles.
     */
    public StackListLinkedDouble() {
        this.stackTop = null;
    }

    /** 
     * Agrega un elemento en la parte superior de la pila.
     * 
     * @param element elemento a agregar en la pila.
     */
    @Override
    public void push(T element) {
        NodeDouble<T> newNode = new NodeDouble<>(element);
    
        if (stackTop != null) { 
            stackTop.nextNode = newNode;
            newNode.previousNode = stackTop;
        }
        
        stackTop = newNode;
        size++;
    }

    /** 
     * Elimina el elemento superior de la pila.
     * 
     * @return elemento eliminado de la pila.
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("La pila esta vacia.");
        }
        T data = stackTop.data;
        stackTop = stackTop.previousNode;
        if (stackTop != null) {
            stackTop.nextNode = null;
        }
        size--;
        return data;
    }

    /** 
     * Obtiene el elemento superior de la pila sin eliminarlo.
     * 
     * @return elemento superior de la pila.
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("La pila esta vacia.");
        }
        return stackTop.data;
    }
    
}