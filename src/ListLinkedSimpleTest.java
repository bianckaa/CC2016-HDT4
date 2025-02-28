import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListLinkedSimpleTest {

    private ListLinkedSimple<Integer> list;

    @BeforeEach
    public void setUp() {
        list = new ListLinkedSimple<>();
    }

    @Test
    public void testAddAndRemoveSingleElement() {
        list.add(0, 42); // Agregar un único elemento
        assertEquals(42, list.remove(0)); // Eliminar y verificar el elemento
    }

    @Test
    public void testAddMultipleElements() {
        list.add(0, 10);
        list.add(1, 20);
        list.add(2, 30);

        assertEquals(10, list.remove(0)); // Remover el primer elemento
        assertEquals(20, list.remove(0)); // Remover el segundo
        assertEquals(30, list.remove(0)); // Remover el último
    }

    @Test
    public void testAddAtBeginning() {
        list.add(0, 10);
        list.add(0, 20); // Agregar al inicio

        assertEquals(20, list.remove(0)); // Verificar el primer elemento
        assertEquals(10, list.remove(0)); // Verificar el siguiente
    }

    @Test
    public void testAddAtEnd() {
        list.add(0, 10);
        list.add(1, 20); // Agregar al final

        assertEquals(10, list.remove(0)); // El primer elemento
        assertEquals(20, list.remove(0)); // El último elemento
    }

    @Test
    public void testRemoveFromMiddle() {
        list.add(0, 10);
        list.add(1, 20);
        list.add(2, 30);

        assertEquals(20, list.remove(1)); // Remover del medio
        assertEquals(10, list.remove(0)); // Remover el primero
        assertEquals(30, list.remove(0)); // Remover el último
    }

    @Test
    public void testInvalidRemove() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0)); // Remover de lista vacía
    }

    @Test
    public void testAddInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(5, 99)); // Índice fuera de rango
    }

    @Test
    public void testRemoveLastElement() {
        list.add(0, 100);
        list.add(1, 200);

        assertEquals(200, list.remove(1)); // Remover último
        assertEquals(100, list.remove(0)); // Remover primero

        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0)); // No hay más elementos
    }
}
