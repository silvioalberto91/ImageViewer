package imageviewer;

import imageviewer.control.NextImageCommand;
import imageviewer.control.PrevImageCommand;
import imageviewer.persistence.ImageLoader;
import imageviewer.persistence.files.FileImageLoader;
import imageviewer.persistence.web.WebImageLoader;

public class Main {

    public static void main(String[] args) {
        ImageLoader loader = new FileImageLoader("C:\\Users\\Silvione\\Desktop\\ImmProg");
        MainFrame mainFrame = new MainFrame();
        mainFrame.add(new NextImageCommand(mainFrame.getImageDisplay()));
        mainFrame.add(new PrevImageCommand(mainFrame.getImageDisplay()));
        mainFrame.getImageDisplay().display(loader.load());
    }    
}
