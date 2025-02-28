public class FactoryList<T> {
    public static <T> ListAbstract<T> getLista(String tipo) {
        return switch (tipo.toLowerCase()) {
            case "simple" -> new ListLinkedSimple<>();
            case "doble" -> new ListLinkedDouble<>();
            default -> throw new IllegalArgumentException("Tipo de lista no válido");
        };
    }
}

