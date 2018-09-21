package player.contorller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import player.view.GameWindow;
import player.view.LaunchWindow;

/**
 * Controller for restart the game.
 * <p>
 * Introductin:
 * it removes all the stored highest score and restart the game.
 * @author zluo2
 *
 */
public class RestartGameController implements ActionListener{
	
	private GameWindow gw;
	
	/**
	 * Constructor for restart game
	 * @param gw
	 */
	public RestartGameController(GameWindow gw) 
	{
		this.gw = gw;
	}
	/**
	 * Clear highestest in scorefiles.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0; i < 15; i++)
		{
			try {
				//Read Score first and compare with the corrent score
				File fp = new File("player-data/score"+(i+1)+".txt");
				//Rewrite is large than older score
				if (fp.isFile() && fp.exists()) {
					FileWriter scoreWriter = new FileWriter(fp, false); // false to overwrite old score.
					scoreWriter.write("0");
					scoreWriter.close();
				} else {
					System.out.println("Error: Cannot find file");
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		gw.setVisible(false);
		gw.dispose();
		new LaunchWindow(false);
	}

}
