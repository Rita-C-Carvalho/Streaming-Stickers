package aula3;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) throws Exception {
        //fazer uma conexão HTTP e buscar os top 250 filmes

        String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
        
        var http = new ClienteHttp();
        String json = http.buscaDados(url);    
    
        


        // exibir e manipular os dados
        for (Map<String,String> conteudo : listaDeConteudos) {

            String urlImagem = conteudo.get("url");
            

            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = titulo + ".png";

            var geradora = new GeradoraDeFigurinhas();
            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.get("title"));
            System.out.println();

            
        }
    }
}
