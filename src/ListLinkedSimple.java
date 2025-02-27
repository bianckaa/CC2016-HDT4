public class ListLinkedSimple<T> extends ListAbstract<T> {
    private NodeSimple<T> firstNode;
    private int size;

    public ListLinkedSimple() {
        this.firstNode = null;
        this.size = 0;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        NodeSimple<T> newNode = new NodeSimple<>(item);

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
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        T removedData;
        if (index == 0) { 
            removedData = firstNode.data;
            firstNode = firstNode.nextNode;
        } else { 
            NodeSimple<T> currentNode = firstNode;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.nextNode;
            }
            removedData = currentNode.nextNode.data;
            currentNode.nextNode = currentNode.nextNode.nextNode;
        }
        size--;
        return removedData;
    }

    @Override
    public int size() {
        return size;
    }
}

