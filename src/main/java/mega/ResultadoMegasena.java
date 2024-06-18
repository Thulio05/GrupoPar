package mega;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.ResponseHandler;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

public class ResultadoMegasena {
    private final static String URL = "http://www1.caixa.gov.br/_newincludes/home_2011/resultado_megasena.asp";

    /**
     * Método que se conecta ao site da CEF para obter as dezenas do último sorteio.
     * @return array de Strings, onde cada elemento é uma dezena sorteada.
     */
    public static String[] obtemUltimoResultado() {
        HttpClient httpclient = new DefaultHttpClient();
        try {
            HttpGet httpget = new HttpGet(URL);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String html = httpclient.execute(httpget, responseHandler);
            return obterDezenas(html);
        } catch (Exception e) {
            throw new RuntimeException("Um erro inesperado ocorreu.", e);
        } finally {
            httpclient.getConnectionManager().shutdown();
        }
    }

    /**
     * Tratamento da resposta HTML obtida pelo método obtemUltimoResultado().
     * @param html resposta HTML obtida
     * @return array de Strings, onde cada elemento é uma dezena sorteada.
     */
    private static String[] obterDezenas(String html) {
        int parteInicial = html.indexOf("<div id='concurso_resultado'>") + 29;
        int parteFinal = html.indexOf("</div>");
        String extracao = html.substring(parteInicial, parteFinal).replaceAll(" ", "");
        return extracao.split("-");
    }
}
