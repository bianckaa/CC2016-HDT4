import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StackListLinkedDoubleTest {
    private StackListLinkedDouble<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new StackListLinkedDouble<>();
    }

    @Test
    void testPush() {
        stack.push(10);
        assertEquals(10, stack.peek());
        
        stack.push(20);
        assertEquals(20, stack.peek());
    }

    @Test
    void testPop() {
        stack.push(10);
        stack.push(20);
        
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
    }

    @Test
    void testPopOnEmptyStack() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            stack.pop();
        });
        assertEquals("La pila esta vacia.", exception.getMessage());
    }

    @Test
    void testPeek() {
        stack.push(15);
        assertEquals(15, stack.peek());
        
        stack.push(25);
        assertEquals(25, stack.peek());
    }

    @Test
    void testPeekOnEmptyStack() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            stack.peek();
        });
        assertEquals("La pila esta vacia.", exception.getMessage());
    }
}
