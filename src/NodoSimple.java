/** 
 * Referencia: 
 * - https://stackoverflow.com/questions/60288770/getint-index-method-in-java
 * 
 * 
 */

public class NodoSimple<T> {
    T data;
    NodoSimple<T> nextNode;

    public NodoSimple(T data) {
        this.data = data;
        this.nextNode = null;
    }
}


