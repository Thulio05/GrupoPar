package br.upe;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class ResultadoMegaSena {
    private final static String URL = "https://servicebus2.caixa.gov.br/portaldeloterias/api/megasena/";
    private final static String MARCA_INICIAL_RETORNO = "\"dezenasSorteadasOrdemSorteio\": [";
    private final static String MARCA_FINAL_RETORNO = "]";

    public static String[] obtemUltimoResultado() {
        try (CloseableHttpClient httpclient = HttpClientBuilder.create().build()) {
            HttpGet request = new HttpGet(URL);

            ResponseHandler<String> responseHandler = new BasicResponseHandler();

            String html = httpclient.execute(request, responseHandler);

            return obterDezenas(html);
        } catch (Exception e) {
            throw new RuntimeException("Um erro inesperado ocorreu.", e);
        }
    }

    private static String[] obterDezenas(String html) {
        int start = html.indexOf(MARCA_INICIAL_RETORNO);
        int end = html.indexOf(MARCA_FINAL_RETORNO, start);

        return html.substring(MARCA_INICIAL_RETORNO.length() + start, end)
                .replaceAll("\n", "")
                .replaceAll(" ", "")
                .replaceAll("\"", "")
                .split(",");

    }
}