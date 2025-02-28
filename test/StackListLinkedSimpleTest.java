import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackListLinkedSimpleTest {
    private StackListLinkedSimple<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new StackListLinkedSimple<>();
    }

    @Test
    void testPush() {
        stack.push(10);
        assertFalse(stack.isEmpty());
        assertEquals(10, stack.peek());
    }

    @Test
    void testPop() {
        stack.push(20);
        stack.push(30);
        assertEquals(30, stack.pop());
        assertEquals(20, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void testPopThrowsExceptionWhenEmpty() {
        Exception exception = assertThrows(RuntimeException.class, () -> stack.pop());
        assertEquals("La pila esta vacia.", exception.getMessage());
    }

    @Test
    void testPeek() {
        stack.push(40);
        assertEquals(40, stack.peek());
        assertFalse(stack.isEmpty());
    }

    @Test
    void testPeekThrowsExceptionWhenEmpty() {
        Exception exception = assertThrows(RuntimeException.class, () -> stack.peek());
        assertEquals("La pila está vacia.", exception.getMessage());
    }
}
