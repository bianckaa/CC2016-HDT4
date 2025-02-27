public class ListLinkedDouble<T> extends ListAbstract<T> {
    private NodeDouble<T> firstNode;
    private NodeDouble<T> lastNode;
    private int size;

    public ListLinkedDouble() {
        this.firstNode = null;
        this.lastNode = null;
        this.size = 0;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Indice no encontrado.");
        }

        NodeDouble<T> newNode = new NodeDouble<>(item);

        if (index == 0) { 
            if (firstNode == null) { 
                firstNode = lastNode = newNode;
            } else {
                newNode.nextNode = firstNode;
                firstNode.previousNode = newNode;
                firstNode = newNode;
            }
        } else if (index == size) { 
            lastNode.nextNode = newNode;
            newNode.previousNode = lastNode;
            lastNode = newNode;
        } else {  
            NodeDouble<T> currentNode = firstNode;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.nextNode;
            }
            newNode.nextNode = currentNode.nextNode;
            newNode.previousNode = currentNode;
            currentNode.nextNode.previousNode = newNode;
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
            if (firstNode != null) {
                firstNode.previousNode = null;
            } else {
                lastNode = null;
            }
        } else if (index == size - 1) {  
            removedDataNode = lastNode.data;
            lastNode = lastNode.previousNode;
            if (lastNode != null) {
                lastNode.nextNode = null;
            } else {
                firstNode = null;
            }
        } else { 
            NodeDouble<T> currentNode = firstNode;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.nextNode;
            }
            removedDataNode = currentNode.data;
            currentNode.previousNode.nextNode = currentNode.nextNode;
            currentNode.nextNode.previousNode = currentNode.previousNode;
        }
        size--;
        return removedDataNode;
    }
}
