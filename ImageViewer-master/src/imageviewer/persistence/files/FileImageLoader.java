package imageviewer.persistence.files;

import imageviewer.model.Image;
import imageviewer.persistence.ImageLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.InputStream;

public class FileImageLoader implements ImageLoader {
    
    private final File[] files;

    public FileImageLoader(String folder) {
        files = new File(folder).listFiles(withImageExtension());
    }
    
    @Override
    public Image load() {
        return imageAt(0);
    }

    public Image imageAt(final int index) {
        return new Image() {

            @Override
            public InputStream inputStream() {
                try {
                    return new FileInputStream(files[index]);
                } catch (FileNotFoundException ex) {
                    return null;
                }
            }

            @Override
            public Image next() {
                if (index == files.length - 1) return imageAt(0);
                return imageAt(index+1);
            }

            @Override
            public Image prev() {
                if (index == 0) return imageAt(files.length - 1);
                return imageAt(index-1);
            }
        };
    }

    private FilenameFilter withImageExtension() {
        return new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith("jpg");
            }
        };
    }

    
}
