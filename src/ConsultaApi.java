import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {
    double cambio = 0;

    public double consulta (String base, String objetivo) {
        String direccion = "https://v6.exchangerate-api.com/v6/993dca353dbc163bbe30396d/pair/" +
                base + "/" + objetivo;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            Gson gson = new Gson();
            TasaDeCambio tasaDeCambio = gson.fromJson(json, TasaDeCambio.class);
            return cambio = tasaDeCambio.conversion_rate();
        } catch (IOException | InterruptedException e) {
            System.out.println("Ocurrió un error: ");
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
