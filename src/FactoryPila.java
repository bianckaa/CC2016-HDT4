public class FactoryPila<T> {
    public static <T> StackAbstract<T> getPila(String tipo) {
        return switch (tipo.toLowerCase()) {
            case "array" -> new StackArrayList<>();
            case "vector" -> new StackVector<>();
            default -> throw new IllegalArgumentException("Tipo de pila no válido");
        };
    }
}
