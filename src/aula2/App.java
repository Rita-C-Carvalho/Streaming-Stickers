package aula2;

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
        //fazer uma conexão HTTP e buscar os top 250 filmes

        String url = "https://api.mocki.io/v2/549a5d8b/MostPopularTVs";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
    
    
        //extrair só os dados que interessam (título, poster, classificação)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body); 


        // exibir e manipular os dados
        for (Map<String,String> filme : listaDeFilmes) {

            String urlImagem = filme.get("image");
            String titulo = filme.get("title");

            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = titulo + ".png";

            var geradora = new GeradoraDeFigurinhas();
            geradora.cria(inputStream, nomeArquivo);

            System.out.println(filme.get("title"));
            System.out.println();

            //System.out.println(" 🍿 📽 🎬 🍿");
            //System.out.println(" Nome do filme: " + "\u001b[35m"+"\u001b[3m" + filme.get("title") + "\u001b[0m");
            //System.out.println(" \u001b[34m" + filme.get("image" ) + "\u001b[0m");
            

            /*var rating = filme.get("imDbRating");
            var nota = Double.parseDouble(rating);
                if (nota >= 9.0){
                System.out.println(" " + nota + " ⭐ ⭐ ⭐ ⭐ ⭐");
                }else if(nota >= 7.0 && nota < 9.0) {
                    System.out.println(" " + nota + " ⭐ ⭐ ⭐ ⭐");
                }else if(nota >= 5.0 && nota < 7.0) {
                    System.out.println(" " + nota + " ⭐ ⭐ ⭐");
                }else if(nota >= 3.0 && nota < 5.0) {
                    System.out.println(" " + nota + " ⭐ ⭐");
                }else{
                    System.out.println(" " + nota + " ⭐");
                }
            System.out.println("");*/
            
        }
    }
}
