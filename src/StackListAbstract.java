/** 
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Sección 31
 * Hoja de Trabajo 4
 * Integrantes:
 * - Diana Sosa 241040
 * - Biancka Raxón 24960
 * - Ivana Figueroa 24785
 * 
 * Clase abstracta StackListAbstract:
 * Hereda de la clase StackAbstract, implementandola parcialmente
 * 
 * @param <T> tipo de elemento que contendrá la pila.
 */

public abstract class StackListAbstract<T> extends StackAbstract<T> {
    protected int size;

    /** 
     * Constructor que inicializa la pila vacía.
     */
    public StackListAbstract() {
        this.size = 0;
    }

    /** 
     * Verifica si la pila está vacía.
     * 
     * @return true si la pila está vacía, false si contiene elementos.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /** 
     * Obtiene el tamaño actual de la pila.
     * 
     * @return numero de elementos en la pila.
     */
    @Override
    public int size() {
        return size;
    }

    /** 
     * Agrega un elemento a la pila y que debe ser 
     * implementado en las clases que heredan de esta. 
     * 
     * @param element elemento a agregar a la pila.
     */
    public abstract void push(T element);  

    /** 
     * Elimina el elemento superior de la pila y que debe ser 
     * implementado en las clases que heredan de esta. 
     * 
     * @return elemento eliminado de la pila.
     */
    public abstract T pop();  

    /** 
     * Obtiene el elemento superior de la pila sin eliminarlo y debe ser 
     * implementado en las clases que heredan de esta. 
     * 
     * @return elemento superior de la pila.
     */
    public abstract T peek();
}
