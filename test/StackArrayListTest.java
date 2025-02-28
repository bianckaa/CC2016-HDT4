import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Pruebas unitarias para la clase StackArrayList.
 */
public class StackArrayListTest {

    private StackArrayList<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new StackArrayList<>();
    }

    @Test
    void testPush() {
        stack.push(10);
        assertEquals(1, stack.size(), "El tamaño de la pila debería ser 1 después de un push.");
        assertEquals(10, stack.peek(), "El elemento en la cima debería ser 10.");
    }

    @Test
    void testPop() {
        stack.push(20);
        stack.push(30);
        int popped = stack.pop();

        assertEquals(30, popped, "El elemento eliminado debería ser 30.");
        assertEquals(1, stack.size(), "El tamaño de la pila debería ser 1 después de un pop.");
    }

    @Test
    void testPeek() {
        stack.push(40);
        assertEquals(40, stack.peek(), "El elemento en la cima debería ser 40.");
        assertEquals(1, stack.size(), "El tamaño de la pila no debería cambiar después de un peek.");
    }

    @Test
    void testIsEmpty() {
        assertTrue(stack.isEmpty(), "La pila debería estar vacía al inicio.");
        stack.push(50);
        assertFalse(stack.isEmpty(), "La pila no debería estar vacía después de un push.");
    }

    @Test
    void testSize() {
        assertEquals(0, stack.size(), "El tamaño inicial de la pila debería ser 0.");
        stack.push(60);
        stack.push(70);
        assertEquals(2, stack.size(), "El tamaño de la pila debería ser 2 después de dos push.");
    }

    @Test
    void testPopEmptyStack() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            stack.pop();
        });
        assertEquals("esta vacia la pila", exception.getMessage(), "Debería lanzar una excepción al hacer pop en una pila vacía.");
    }

    @Test
    void testPeekEmptyStack() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            stack.peek();
        });
        assertEquals("esta vacia la pila", exception.getMessage(), "Debería lanzar una excepción al hacer peek en una pila vacía.");
    }
} 
