package aula3;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    
    public void cria(InputStream inputStream, String nomeArquivo ) throws Exception{

        //leitura da imagem

        BufferedImage imagemOriginal = ImageIO.read(inputStream);
    

        //cria nova imagem em memoria com transparencia e com tamanho novo

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //copiar a imagem original para a nova imagem (em memoria)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        //configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.DARK_GRAY);
        graphics.setFont(fonte);


        //escrever uma frase na nova imagem
        graphics.drawString("Vale a pena ver de novo! 🎥", 120, novaAltura -100);

        //escrever nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
        

    }

    
    
}
