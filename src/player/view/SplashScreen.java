package player.view;

import java.awt.*;
import javax.swing.*;

/** This class display the splashwindow and set the duration
 * 
 * @author zluo2
 *
 */
public class SplashScreen extends JWindow {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5521979393766696651L;
	private int duration;
	private boolean display;

	/**
	 * SplashScreen constructor.
	 * @param d
	 * @param display
	 */
	public SplashScreen(int d, boolean display) {
		this.duration = d;
		this.display = display;
		showSplash();
	}

	/**
	 * Set the splashscreen layout and content.
	 */
	public void showSplash() {

		//Set Content Panel
		JPanel content = new JPanel();
		this.setContentPane(content);
		content.setBackground(Color.WHITE);

		// Center the window
		int width = 700;
		int height = 300;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width-width)/2;
		int y = (screen.height-height)/2;
		setBounds(x,y,width,height);

		// Build the splash screen
		Color navy = new Color(65, 105, 225);
		content.setBorder(BorderFactory.createLineBorder(navy, 10));

		JLabel game = new JLabel("LetterCraze");
		game.setFont(new Font("Garamond", Font.PLAIN, 100));
		JLabel groupname = new JLabel("Group: Vanadium");
		groupname.setFont(new Font("Garamond", Font.PLAIN, 60));
		JLabel teamcredits = new JLabel("Zixin Luo, Ming Xu, "
				+ "Emily Hao, Yifei Jin, Fan Mo");
		teamcredits.setFont(new Font("Garamond", Font.PLAIN, 23));

		content.add(game);
		content.add(groupname);
		content.add(teamcredits);
		// Display it
		if(display) {
			setVisible(true);

			//Make the splashscreen stay for the given duration
			try 
			{ 
				Thread.sleep(duration); 
			} catch (Exception e) {}//!!!

			setVisible(false);
		}
	}
}