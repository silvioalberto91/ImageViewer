package imageviewer.model;

import java.io.InputStream;

public interface Image {

    public InputStream inputStream();

    public Image next();
    public Image prev();
    
}
