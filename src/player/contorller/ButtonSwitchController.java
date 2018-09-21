package player.contorller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import player.view.LevelView;
import player.view.LightningView;
import player.view.PuzzleView;
import player.view.ThemeView;
import player.model.Level;
import player.view.GameWindow;

/**
 * Controller for buttons that handle the switch between frames.
 * <p>
 * Introduction:
 * It handles two type of buttons. One on the main screen which 
 * will direct the player to selected level screen. The other is
 * on the level screen that allows the player to quit the level and 
 * go back to main screen.
 * <p>
 * More detail:
 * The quit button on the level screen have an additional function
 * of storing the player's current score and depend wheter to unlock the 
 * next level.
 * 
 * @author zluo2
 */
public class ButtonSwitchController implements ActionListener {

	protected GameWindow gw;
	protected LevelView lv;
	protected String dir;
	protected Level level;

	public ButtonSwitchController(GameWindow gw, LevelView lv, Level level) {
		this.lv = lv;
		this.level = level;
		this.gw = gw;
	}

	/**
	 * Switch between main game window and level screen.
	 * <p>
	 * Switch between two frams with button 15 level images and quit.
	 * It also writes the new highest score in a txt file. 
	 * @param e actionevent
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("QUIT")) {
			int score = 0;
			try {
				//Read Score first and compare with the corrent score
				File scorefile = new File("player-data/score"+level.levelNumber+".txt");
				if (scorefile.isFile() && scorefile.exists()) {
					FileReader fr = new FileReader(scorefile);
					BufferedReader br = new BufferedReader(fr);
					String line = br.readLine();;
					try{
						score = Integer.parseInt(line);
					}catch(NumberFormatException ex){ 
					}
					br.close();
				}
				if(score < level.score) {
					//Rewrite is large than older score
					if (scorefile.isFile() && scorefile.exists()) {
						FileWriter scoreWriter = new FileWriter(scorefile, false); // false to overwrite old score.
						scoreWriter.write(""+level.score);
						scoreWriter.close();
					} else {
						System.out.println("Error: Cannot find file");
					}
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			GameWindow newgw = new GameWindow();
			newgw.setVisible(true);
			lv.setVisible(false);
			lv.dispose();
		} else {
			LevelView lv = getLevelType((JButton) e.getSource());
			lv.setVisible(true);
			gw.setVisible(false);
			gw.dispose();
		}
	}

	public LevelView getLevelType(JButton level) {
		String command = level.getActionCommand();
		String number = command.replaceFirst(".*?(\\d+).*", "$1");
		int levelnum = Integer.parseInt(number);
		if (levelnum % 3 == 1) {
			return new PuzzleView(levelnum);
		} else if (levelnum % 3 == 2) {
			LightningView ltv =  new LightningView(levelnum);
			new Timer().schedule(new TimerTask(){

				int second = (int) ltv.ltnLevel.limitedTime;
				@Override
				public void run() {
					ltv.timer.setText("Timer: "+second--);
					if (second == -1) {
						TimeOut.infoBox("You run out of time! Please quit this level!", "Message");
						ltv.submit.setEnabled(false);
						ltv.reset.setEnabled(false);
						cancel();
					}

					ltv.timer.setHorizontalAlignment(SwingConstants.CENTER);
					ltv.timer.setVerticalAlignment(JLabel.CENTER);
					ltv.timer.setFont(new Font("time", Font.PLAIN, 15));
					ltv.timer.setForeground(Color.BLACK);
					ltv.timer.setBackground(Color.WHITE);
					ltv.timer.setOpaque(true);
				}

			},0, 1000);

			return ltv;
		} else if (levelnum % 3 == 0) {
			return new ThemeView(levelnum);
		} else {
			return null;
		}
	}
}