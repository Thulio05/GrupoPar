package br.upe;

import org.json.JSONArray;
import org.json.JSONObject;

//hello, deyvid
public class Main {
    public static void main( String[] args ){
        String[] resultado = ResultadoMegasena.obtemUltimoResultado();
        for (String dezena: resultado) {
            System.out.print(dezena + ",");
        }
    }
}
