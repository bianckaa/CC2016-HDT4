/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Hoja de Trabajo 4
 * 
 * Clase FactoryPila
 * Fábrica para crear instancias de diferentes implementaciones de Pila (ArrayList, Vector).
 * Se utiliza para abstraer la creación de pilas según el tipo seleccionado por el usuario.
 * 
 * @version 1.0
 */

 public class FactoryPila<T> {
    
    /**
     * Crea una instancia de una implementación de Pila según el tipo especificado.
     * 
     * @param tipo El tipo de pila que se desea crear (puede ser "array" o "vector").
     * @return Una instancia de la implementación de Pila correspondiente al tipo especificado.
     * @throws IllegalArgumentException Si el tipo proporcionado no es válido.
     */
    public static <T> StackAbstract<T> getPila(String tipo) {
        return switch (tipo.toLowerCase()) {
            case "array" -> new StackArrayList<>();
            case "vector" -> new StackVector<>();
            default -> throw new IllegalArgumentException("Tipo de pila no válido");
        };
    }
}
