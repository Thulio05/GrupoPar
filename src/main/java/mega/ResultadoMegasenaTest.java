package mega;

import junit.framework.TestCase;

public class ResultadoMegasenaTest extends TestCase {
    private final static int NUMERO_DE_DEZENAS = 6;

    public void testObtemUltimoResultado() {
        String[] ultimoResultado = ResultadoMegasena.obtemUltimoResultado();
        assertNotNull(ultimoResultado);
        assertEquals(NUMERO_DE_DEZENAS, ultimoResultado.length);
    }
}

