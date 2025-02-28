import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalculadoraTest {

    @Test
    void testEvaluarPostfix_Suma() {
        assertEquals(7, Calculadora.evaluarPostfix("34+"));
    }

    @Test
    void testEvaluarPostfix_Resta() {
        assertEquals(2, Calculadora.evaluarPostfix("53-"));
    }

    @Test
    void testEvaluarPostfix_Multiplicacion() {
        assertEquals(15, Calculadora.evaluarPostfix("35*"));
    }

    @Test
    void testEvaluarPostfix_Division() {
        assertEquals(2, Calculadora.evaluarPostfix("84/"));
    }

    @Test
    void testEvaluarPostfix_OperacionCompuesta() {
        assertEquals(14, Calculadora.evaluarPostfix("34+52*+"));
    }

    @Test
    void testEvaluarPostfix_OperacionConCero() {
        assertEquals(0, Calculadora.evaluarPostfix("50*"));
    }

    @Test
    void testEvaluarPostfix_DivisionPorUno() {
        assertEquals(5, Calculadora.evaluarPostfix("51/"));
    }

    @Test
    void testEvaluarPostfix_OperacionNegativa() {
        assertEquals(-1, Calculadora.evaluarPostfix("34-"));
    }

    @Test
    void testEvaluarPostfix_ErrorExpresionInvalida() {
        assertThrows(Exception.class, () -> Calculadora.evaluarPostfix("34+*"));
    }
}