package br.upe;

public class Main {
    public static void main( String[] args ) {
        String[] resultado = ResultadoMegaSena.obtemUltimoResultado();
        for(String num: resultado) System.out.println(num);
    }
}

