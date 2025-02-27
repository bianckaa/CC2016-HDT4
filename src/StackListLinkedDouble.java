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

    public StackListLinkedDouble() {
        this.stackTop = null;
    }

    @Override
    public void push(T element) {
        NodeDouble<T> newNode = new NodeDouble<>(element);
        if (stackTop == null) {
            newNode.previousNode = stackTop;
            stackTop.nextNode = newNode;
        }
        stackTop = newNode;
        size++;
    }

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

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("La pila esta vacia.");
        }
        return stackTop.data;
    }
    
}