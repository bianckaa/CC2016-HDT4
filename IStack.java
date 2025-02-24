/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Sección 31
 * Hoja de Trabajo 4
 * Integrantes:
 * Diana Sosa 241040
 * Biancka Raxón 24960
 * Ivana Figueroa 24785
 * 
 * Interface IStack:
 * plantea las operaciones que se pueden realizar en una stack
 * 
 * @param <T> el tipo de elementos que contendrá la pila.
 */
 
public interface IStack<T>{


    /**
     * Agrega un elemento en la parte superior de la pila.
     *
     * @param element elemento que se agregara.
     */
    void push(T element);

    /**
     * elimina y decuelve el elemento que se encuentra en la parte superior de la pila.
     *
     * @return elemento de la parte superior de la pila.
     */
    T pop();

    /**
     * decuelve el elemento que se encuentra en la parte superior de la pila.
     *
     * @return elemento de la parte superior de la pila.
     */
    T peek();


    /**
     * verifica si la pila no esta vacia.
     *
     * @return true para cuando esta vacia, false cuando no esta vacia.
     */
    boolean isEmpty();


    /**
     *  regresa el numero de elementos de la pila.
     *
     * @return  tamano de la pila.
     */
    int size();
}