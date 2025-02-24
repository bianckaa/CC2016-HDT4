/** 
 * Referencia: 
 * - https://www.youtube.com/watch?v=3K1_lj2CABU
 * - https://www.geeksforgeeks.org/list-interface-java-examples/
 * 
 */

import java.util.ListIterator;

public interface IList<T> {
    T get(int index);
    T set(int index, T item);
    void add(int index, T item);
    T remove(int index);
    int indexOf(T item);
    int lastIndexOf(T item);
    ListIterator<T> listIterator();
    int size();
    boolean isEmpty();
}