package view;

import javax.swing.*;
import java.awt.*;

/**
 * Splash Screen object.
 * <p>
 * Represents the splash screen.
 */
public class SplashScreen extends JWindow {
    private int duration;

    /**
     * Constructor.
     *
     * @param d duration of Splash in second
     */
    public SplashScreen(int d) {
        duration = d;
    }

    /**
     * Shows Splash.
     * <p>
     * A simple little method to show a title screen in the center of the
     * screen for the amount of time given in the constructor.
     */
    public void showSplash() {
        JPanel content = (JPanel) getContentPane();
        content.setBackground(Color.white);

        // Set the window's bounds, centering the window
        int width = 1000;
        int height = 500;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        setBounds(x, y, width, height);


        // Build the splash screen
        Color oraRed = new Color(156, 20, 20, 255);
        content.setBorder(BorderFactory.createLineBorder(oraRed, 10));


        SplashS Names = new SplashS();
        content.add(Names, BorderLayout.CENTER);
        // Display it
        setVisible(true);

        // Wait a little while, maybe while loading resources
        try {
            Thread.sleep(duration);
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(false);
    }

    /**
     * Shows Splash and exits.
     * <p>
     * Shows the splash screen and then exit the splash screen.
     */
    public void showSplashAndExit() {
        showSplash();
    }

}