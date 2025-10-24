package recursividad;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PotenciaTest {

    @Test
    public void testPotenciaCero() {
        assertEquals(1, Potencia.potencia(2, 0));
    }

    @Test
    public void testPotenciaUno() {
        assertEquals(2, Potencia.potencia(2, 1));
    }

    @Test
    public void testPotenciaNormal() {
        assertEquals(1024, Potencia.potencia(2, 10));
    }

    @Test
    public void testBaseGrande() {
        assertEquals(125, Potencia.potencia(5, 3));
    }

    @Test
    public void testBaseCero() {
        assertEquals(0, Potencia.potencia(0, 5));
    }

    @Test
    public void testBaseUno() {
        assertEquals(1, Potencia.potencia(1, 100));
    }

    @Test
    public void testPotenciaAlta() {
        assertEquals(1048576, Potencia.potencia(2, 20));
    }

    @Test
    public void testBaseNegativa() {
        assertEquals(-8, Potencia.potencia(-2, 3));
    }

    @Test
    public void testBaseNegativaExponentePar() {
        assertEquals(16, Potencia.potencia(-2, 4));
    }

    @Test
    public void testDiezAlCuadrado() {
        assertEquals(100, Potencia.potencia(10, 2));
    }
}