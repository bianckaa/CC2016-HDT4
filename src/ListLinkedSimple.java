public class ListLinkedSimple<T> extends ListAbstract<T> {
    private NodeSimple<T> firstNode;
    private int size;

    public ListLinkedSimple() {
        this.firstNode = null;
        this.size = 0;
    }

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

