/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Hoja de Trabajo 4
 * 
 * Clase FactoryList
 * Fábrica para crear instancias de diferentes implementaciones de Lista (Simple o Doble).
 * Se utiliza para abstraer la creación de listas según el tipo seleccionado por el usuario.
 * 
 * @version 1.0
 */

 public class FactoryList<T> {
    
    /**
     * Crea una instancia de una implementación de Lista según el tipo especificado.
     * 
     * @param tipo El tipo de lista que se desea crear (puede ser "simple" o "doble").
     * @return Una instancia de la implementación de Lista correspondiente al tipo especificado.
     * @throws IllegalArgumentException Si el tipo proporcionado no es válido.
     */
    public static <T> ListAbstract<T> getLista(String tipo) {
        return switch (tipo.toLowerCase()) {
            case "simple" -> new ListLinkedSimple<>();
            case "doble" -> new ListLinkedDouble<>();
            default -> throw new IllegalArgumentException("Tipo de lista no válido");
        };
    }
}
