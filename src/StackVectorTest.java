import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StackVectorTest {

    private StackVector<Integer> stack;

    @BeforeEach
    public void setUp() {
        stack = new StackVector<>();
    }

    @Test
    public void testPush() {
        stack.push(10);
        assertEquals(1, stack.size(), "La pila debe tener un elemento después de push.");
        assertEquals(10, stack.peek(), "El elemento en la cima debe ser 10.");
    }

    @Test
    public void testPop() {
        stack.push(20);
        stack.push(30);
        int value = stack.pop();

        assertEquals(30, value, "El valor eliminado debe ser 30.");
        assertEquals(1, stack.size(), "La pila debe tener un tamaño de 1 después de pop.");
    }

    @Test
    public void testPopEmptyStack() {
        Exception exception = assertThrows(RuntimeException.class, () -> stack.pop());
        assertEquals("esta vacia la pila", exception.getMessage(), "Debe lanzar una excepción si la pila está vacía.");
    }

    @Test
    public void testPeek() {
        stack.push(40);
        stack.push(50);

        assertEquals(50, stack.peek(), "El valor en la cima debe ser 50.");
        assertEquals(2, stack.size(), "La pila no debe cambiar de tamaño después de peek.");
    }

    @Test
    public void testPeekEmptyStack() {
        Exception exception = assertThrows(RuntimeException.class, () -> stack.peek());
        assertEquals("esta vacia la pila", exception.getMessage(), "Debe lanzar una excepción si la pila está vacía.");
    }

    @Test
    public void testSize() {
        assertEquals(0, stack.size(), "La pila debe estar vacía inicialmente.");

        stack.push(60);
        stack.push(70);
        stack.push(80);

        assertEquals(3, stack.size(), "La pila debe contener 3 elementos.");
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty(), "La pila debe estar vacía al inicio.");

        stack.push(90);
        assertFalse(stack.isEmpty(), "La pila no debe estar vacía después de agregar un elemento.");

        stack.pop();
        assertTrue(stack.isEmpty(), "La pila debe estar vacía después de eliminar todos los elementos.");
    }
}
