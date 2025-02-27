/** 
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Sección 31
 * Hoja de Trabajo 4
 * Integrantes:
 * - Diana Sosa (241040)
 * - Biancka Raxón (24960)
 * - Ivana Figueroa (24785)
 * 
 * Clase abstracta StackListAbstract:
 * Hereda de la clase StackAbstract, implementandola parcialmente
 * 
 * @param <T> tipo de elemento que contendrá la pila.
 */

public abstract class StackListAbstract<T> extends StackAbstract<T> {
    protected int size;

    public StackListAbstract() {
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    public abstract void push(T element);  
    public abstract T pop();  
    public abstract T peek();
}
