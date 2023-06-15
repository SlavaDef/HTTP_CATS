package goIt.com.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

public class Utils {
    public int getConnect(int code) {
        String uri = "https://http.cat/" + code + ".jpg";
        HttpRequest.BodyPublishers.noBody();
        HttpResponse<String> response = null;
        response = getResponse(uri);
        return response.statusCode();
    }

    private HttpResponse<String> getResponse(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.of(5, SECONDS))
                .GET()
                .build();
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
