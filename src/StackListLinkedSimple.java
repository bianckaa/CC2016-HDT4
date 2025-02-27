/** 
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Sección 31
 * Hoja de Trabajo 4
 * Integrantes:
 * - Diana Sosa (241040)
 * - Biancka Raxón (24960)
 * - Ivana Figueroa (24785)
 * 
 * Clase StackListLinkedSimple:
 * Hereda de StackListAbstract, implementando una lista enlazada simple. 
 * 
 * @param <T> tipo de elemento que contendrá la lista.
 */

public class StackListLinkedSimple<T> extends StackListAbstract<T> {
    private NodeSimple<T> stackTop;

    public StackListLinkedSimple() {
        this.stackTop = null;
    }

    @Override
    public void push(T element) {
        NodeSimple<T> newNode = new NodeSimple<>(element);
        newNode.nextNode = stackTop;
        stackTop = newNode;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("La pila esta vacia.");
        }
        T data = stackTop.data;
        stackTop = stackTop.nextNode;
        size--;
        return data;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("La pila está vacia.");
        }
        return stackTop.data;
    }
}
