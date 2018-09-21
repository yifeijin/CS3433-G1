package player.view;

/**
 * This class start the splashscreen and gamewindow
 * @author zluo2
 *
 */
public class LaunchWindow {

	GameWindow gw;	
	Boolean display;
	public LaunchWindow(boolean display){
		this.display = display;
		init();
	}

	public void init() {
		new SplashScreen(2000, display);
		this.gw = new GameWindow();
		gw.setVisible(true);
	}
}