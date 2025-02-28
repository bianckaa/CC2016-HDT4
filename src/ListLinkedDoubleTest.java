import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListLinkedDoubleTest {

    private ListLinkedDouble<Integer> list;

    @BeforeEach
    public void setUp() {
        list = new ListLinkedDouble<>();
    }

    @Test
    public void testAddAndRemoveSingleElement() {
        list.add(0, 10);                   // Agregar un elemento
        assertEquals(10, list.remove(0));  // Removerlo y verificar
    }

    @Test
    public void testAddMultipleElements() {
        list.add(0, 10);
        list.add(1, 20);
        list.add(2, 30);

        assertEquals(10, list.remove(0));  // Remover el primer elemento
        assertEquals(20, list.remove(0));  // Remover el siguiente
        assertEquals(30, list.remove(0));  // Remover el último
    }

    @Test
    public void testAddAtBeginning() {
        list.add(0, 10);
        list.add(0, 20);  // Insertar al inicio

        assertEquals(20, list.remove(0));  // Verificar que el primero es 20
        assertEquals(10, list.remove(0));  // Y luego 10
    }

    @Test
    public void testAddAtEnd() {
        list.add(0, 10);
        list.add(1, 20);  // Insertar al final

        assertEquals(10, list.remove(0));
        assertEquals(20, list.remove(0));
    }

    @Test
    public void testRemoveFromMiddle() {
        list.add(0, 10);
        list.add(1, 20);
        list.add(2, 30);

        assertEquals(20, list.remove(1));  // Eliminar del medio
        assertEquals(10, list.remove(0));  // Queda el primero
        assertEquals(30, list.remove(0));  // Y el último
    }

    @Test
    public void testInvalidRemove() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @Test
    public void testAddInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(5, 99));  // Fuera de rango
    }
}
