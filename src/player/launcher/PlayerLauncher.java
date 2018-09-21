package player.launcher;

import player.view.LaunchWindow;

/**
 * LetterCraze LaunchWindow.
 * <p>
 * Introduction:
 * It starts with a splash screen with team credits on it. Then,
 * the splash screen will disappear and all 15 levels will shows
 * up for playing.
 * @author zluo2
 */

public class PlayerLauncher {
	
	public static void main(String[] args) {
		new LaunchWindow(true);	
	}
}
