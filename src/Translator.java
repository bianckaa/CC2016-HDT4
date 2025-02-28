import java.util.Stack;

public class Translator {
    public static String convertir(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> pila = new Stack<>();

        for (char c : infix.toCharArray()) {
            if (Character.isDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                pila.push(c);
            } else if (c == ')') {
                while (!pila.isEmpty() && pila.peek() != '(') {
                    postfix.append(pila.pop());
                }
                pila.pop();
            } else {
                while (!pila.isEmpty() && prioridad(c) <= prioridad(pila.peek())) {
                    postfix.append(pila.pop());
                }
                pila.push(c);
            }
        }

        while (!pila.isEmpty()) {
            postfix.append(pila.pop());
        }

        return postfix.toString();
    }

    private static int prioridad(char operador) {
        return switch (operador) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> -1;
        };
    }
}
