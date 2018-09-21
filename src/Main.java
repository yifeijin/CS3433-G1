import model.BuilderModel;
import view.BuilderWindow;
import view.LaunchWindow;

import javax.swing.*;

/**
 * Main class.
 */
public class Main {

    /**
     * Main Class
     *
     * @param args Arguments from command line
     */
    public static void main(String[] args) {

        // create model first
        BuilderModel model = new BuilderModel();
        LaunchWindow app = new LaunchWindow(model);

        // then launch application
        BuilderWindow window = new BuilderWindow(model);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}

