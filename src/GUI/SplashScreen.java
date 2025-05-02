package GUI;

import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JFrame {

    private JProgressBar progressBar;

    public SplashScreen() {
        setUndecorated(true);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel label = new JLabel();
        ImageIcon picture = new ImageIcon(getClass().getResource("/GUI/Intro.png"));
        Image image = picture.getImage();
        Image resizedImage = image.getScaledInstance(600, 400, Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(resizedImage));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);

        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        add(progressBar, BorderLayout.SOUTH);
    }

    public void startLoading() {
    	new Thread(() -> {
            for (int i = 0; i <= 100; i++) {
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                progressBar.setValue(i);
            }
            dispose();
            
            GUI g = new GUI();
            g.setVisible(true);
        }).start();
    }
}
