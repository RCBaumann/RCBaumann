import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        // fazer conexao HTTP e buscar os top 250 filmes
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI address = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(address).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // extrair dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listMovies = parser.parse(body);        

        // exibir e manipular dados da API
        var builderSticker = new StickerMaker();
        for (Map<String,String> movie : listMovies) {
            
            String urlImage = movie.get("image");
            String title = movie.get("title");
            
            InputStream inputStream = new URL (urlImage).openStream();            
            String nameImg = title + ".png";

            builderSticker.makeStick(inputStream, nameImg);


            System.out.println("Titulo: " + movie.get("title"));
            System.out.println();
        }
    }
}
