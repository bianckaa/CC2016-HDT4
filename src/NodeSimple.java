/** 
 * Referencia: 
 * - https://stackoverflow.com/questions/60288770/getint-index-method-in-java
 * 
 * 
 */

public class NodeSimple<T> {
    T data;
    NodeSimple<T> nextNode;

    public NodeSimple(T data) {
        this.data = data;
        this.nextNode = null;
    }
}


