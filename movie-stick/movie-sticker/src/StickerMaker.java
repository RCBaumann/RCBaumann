import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickerMaker {

    void makeStick(InputStream inputStream, String nameImg) throws IOException {

        //leitura da imagem
        //InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX128_CR0,3,128,176_AL_.jpg").openStream();
        BufferedImage imagePoster = ImageIO.read(inputStream);
        
        //cria nova imagem tranpsarente e redimensionada
        int imgWidth = imagePoster.getWidth();
        int imgHeigth = imagePoster.getHeight();
        int newHeigth = imgHeigth + 200;
        BufferedImage newImage = new BufferedImage(imgWidth, newHeigth, BufferedImage.TRANSLUCENT);

        //copiar a imagem original para nova imagem (em memoria)
        Graphics2D graphics =(Graphics2D) newImage.getGraphics();
        graphics.drawImage(imagePoster, 0, 0, null);

        //configurar fonte]
        var font = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setFont(font);
        graphics.setColor(Color.YELLOW);

        //escrever uma frease na nova imagem
        graphics.drawString("SHOW DE BOLA", 100, newHeigth -100);

        //escrever nova imagem em arquivo
        ImageIO.write(newImage, "png", new File(nameImg));

    }
    
}
