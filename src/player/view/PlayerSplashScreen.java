package player.view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.SplashScreen;

/**
 * Player Splash screen object
 * @author zluo2
 */
public class PlayerSplashScreen extends Thread {
	/**
	 * Run and exit splash screen on selected duration.
	 */
	public void run() {
		try {
			SplashScreen splash = SplashScreen.getSplashScreen();
			Graphics2D g = splash.createGraphics();
			g.setColor(Color.green);
			g.drawString(splash.getBounds().toString(), 10, 30);
			g.drawString("LetterCraze", 10, 50);
			splash.update();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
