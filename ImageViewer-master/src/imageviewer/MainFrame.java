package imageviewer;

import imageviewer.control.Command;
import imageviewer.ui.ImageDisplay;
import imageviewer.ui.swing.SwingImageDisplay;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
    private ImageDisplay imageDisplay;
    private Map<String, Command> commands = new HashMap<>();
    

    public MainFrame() {
        this.setTitle("Image Viewer");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.add(image());
        this.add(toolbar(), BorderLayout.SOUTH);
        this.setVisible(true);
    }
    
    public void add(Command command) {
        commands.put(command.name(), command);
    }
    
    
    private Component toolbar() {
        JPanel panel = new JPanel();
        panel.add(button("prev"));
        panel.add(new JLabel("                                                                                "));
        panel.add(button("next"));
        return panel;
    }

    private Component image() {
        final SwingImageDisplay display = new SwingImageDisplay();
        imageDisplay = display;
        return display;
    }
    
    
    
    
    

    private Component button(String name) {
        JButton button = new JButton(icon(name));
        button.setBackground(Color.WHITE);
        button.addActionListener(execute(name));
        return button;
    }

    private Icon icon(String name) {
        return new ImageIcon("res/" + name + ".png");
    }

    public ImageDisplay getImageDisplay() {
        return imageDisplay;
    }

    private ActionListener execute(final String command) {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get(command).execute();
            }
        };
    }

    
}
