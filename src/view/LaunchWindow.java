package view;

import model.BuilderModel;

/**
 * Launch Splash window object.
 * <p>
 * Launches the Splash Window.
 */
public class LaunchWindow {
    BuilderWindow lvlBuilder;
    BuilderModel builder;
    boolean splasher;

    /**
     * Constructor.
     *
     * @param builder  Builder model
     * @param splasher splasher boolean
     */
    public LaunchWindow(BuilderModel builder, boolean splasher) {
        this.builder = builder;
        this.lvlBuilder = new BuilderWindow(null);
        this.splasher = splasher;
        init();
    }

    /**
     * Constructor.
     *
     * @param builder Builder model
     */
    public LaunchWindow(BuilderModel builder) {
        this.builder = builder;
        this.lvlBuilder = new BuilderWindow(new BuilderModel());
        this.splasher = true;
        init();
    }

    /**
     * Init method.
     * <p>
     * Initializes all the setting about splash window.
     */
    public void init() {
        if (splasher) {
            SplashScreen splash = new SplashScreen(5000);
            splash.showSplashAndExit();
        }
        lvlBuilder.setVisible(true);
    }

    /**
     * @return Builder window
     */
    public BuilderWindow getLvlBuilder() {
        return lvlBuilder;
    }

}
