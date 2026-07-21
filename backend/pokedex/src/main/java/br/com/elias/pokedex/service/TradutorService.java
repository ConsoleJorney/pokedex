package br.com.elias.pokedex.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TradutorService {

    private final HttpClient client = HttpClient.newHttpClient();

    public String traduzir(String texto) {

        try {

            String url =
                    "https://translate.googleapis.com/translate_a/single"
                    + "?client=gtx"
                    + "&sl=en"
                    + "&tl=pt"
                    + "&dt=t"
                    + "&q=" + texto.replace(" ", "%20");

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            String body = response.body();

            int inicio = body.indexOf("\"") + 1;
            int fim = body.indexOf("\"", inicio);

            return body.substring(inicio, fim);

        } catch (IOException | InterruptedException e) {

            return texto;

        }

    }

}