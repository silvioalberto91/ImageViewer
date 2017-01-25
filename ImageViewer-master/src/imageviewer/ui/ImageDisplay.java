package imageviewer.ui;

import imageviewer.model.Image;

public interface ImageDisplay {

    public Image currentImage();
    public void display(Image image);

    
}
