package imageviewer.ui.swing;

import imageviewer.model.Image;
import imageviewer.ui.ImageDisplay;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class SwingImageDisplay extends JPanel implements ImageDisplay {
    private Image image;
    
    @Override
    public void paint(Graphics g) {
        g.drawImage(bitmap(), 0, 0, this.getWidth(), this.getHeight(), null);
    }

    private BufferedImage bitmap() {
        try {
            return ImageIO.read(image.inputStream());
        } catch (IOException ex) {
            return null;
        }
    }

    @Override
    public void display(Image image) {
        this.image = image;
        this.repaint();
    }

    @Override
    public Image currentImage() {
        return image;
    }

    public String getName(){
        return image.toString();
    }
}
