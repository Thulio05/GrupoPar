package br.upe;

import junit.framework.TestCase;

public class ResultadoMegaSenaTest extends TestCase {
    private final static int NUMERO_DE_DEZENAS = 6;

    public void testObtemUltimoResultado() {
        String[] ultimoResultado = ResultadoMegaSena.obtemUltimoResultado();
        assertNotNull(ultimoResultado);
        assertEquals( ultimoResultado.length, NUMERO_DE_DEZENAS );
    }
}