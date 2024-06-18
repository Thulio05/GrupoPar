package br.upe;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import br.upe.ResultadoMegasena;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class ResultadoMegasenaTest extends TestCase {
    /** Número de dezenas esperadas no resultado da mega-sena. */
    private final static int NUMERO_DE_DEZENAS = 6;

    /**
     * Teste do método obtemUltimoResultado()
     */
    @Test
    public void testObtemUltimoResultado() {
        String[] ultimoResultado = ResultadoMegasena.obtemUltimoResultado();
        assertNotNull(ultimoResultado);
        assertTrue(ultimoResultado.length == NUMERO_DE_DEZENAS);
    }
}
