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
