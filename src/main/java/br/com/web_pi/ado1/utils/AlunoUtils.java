package br.com.web_pi.ado1.utils;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Optional;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.web_pi.ado1.models.Endereco;

public class AlunoUtils {
    public static String generatedRa() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-", "").substring(0, 10);
    }

    public static Optional<Endereco> getEndereco(String cep) throws  Exception {
        cep = cep.replaceAll("[^0-9]", "");
        if (cep.length() != 8) {
            throw new IllegalArgumentException("CEP inválido");
        }

        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://viacep.com.br/ws/%s/json/".formatted(cep)))
                .timeout(Duration.ofSeconds(5))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.body().contains("error")) {
            throw new IllegalArgumentException("CEP inválido");
        }

        ObjectMapper mapper = new ObjectMapper();
        return Optional.ofNullable(mapper.readValue(response.body().replaceAll("-", ""), Endereco.class));
    }
}
