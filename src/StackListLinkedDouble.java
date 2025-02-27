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