package player.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import player.contorller.ButtonSwitchController;
import player.contorller.RestartGameController;
import player.model.Level;

/**
 * This class display the starting game window for player application, 
 * it contains the game name, team credits, the available levels and the
 * level progress.
 * @author zluo2
 */
public class GameWindow extends JFrame {

	private static final long serialVersionUID = -7357480200628684109L;
	
	public LevelSelection ls = new LevelSelection();
	
	/**
	 * Create the constructor and initialize the game window.
	 */
	public GameWindow() {
		init();
		this.setBounds(20, 20, 700, 700);
		this.setTitle("Vanadium_LetterCraze");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(false);
	}
	/**
	 * Fill the window in GridBagLayout with JLabel and JButton.
	 */
	private void init() {
		JLabel JLetterCraze = new JLabel("LetterCraze");
		JLetterCraze.setVerticalAlignment(JLabel.TOP);
		JLetterCraze.setFont(new Font("Garamond", Font.PLAIN, 60));
		JLabel teamcredits = new JLabel("Zixin Luo, Ming Xu, "
				+ "Emily Hao, Yifei Jin, Fan Mo");
		teamcredits.setFont(new Font("Garamond", Font.PLAIN, 30));
		teamcredits.setVerticalAlignment(JLabel.TOP);
		//Set ContentPane
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setBackground(Color.pink);
		setContentPane(contentPane);
		GridBagLayout layout = new GridBagLayout();
		contentPane.setLayout(layout);
		//JLabel: Game name
		GridBagConstraints s= new GridBagConstraints();
		s.fill = GridBagConstraints.HORIZONTAL;
		s.gridx = 0;
		s.gridy = 0;
		contentPane.add(JLetterCraze, s);
		//JLabel: Team credits
		GridBagConstraints s2= new GridBagConstraints();
		s2.fill = GridBagConstraints.HORIZONTAL;
		s2.weightx = 10.0;
		s2.gridx = 0;
		s2.gridy = 1;
		contentPane.add(teamcredits, s2);
		//JPanel: Panel for displaying JButton
		JPanel boardpane = ls.displayLevelselection();
		boardpane.setBackground(Color.orange);
		GridBagConstraints s3= new GridBagConstraints();
		s3.fill = GridBagConstraints.BOTH;
		s3.insets = new Insets(60,50,150,50);
		s3.gridx = 0;
		s3.gridy = 2;
		s3.weighty=1;
		//JButton: restart game
		JButton restart = new JButton("RESTART GAME");
		GridBagConstraints s4= new GridBagConstraints();
		s4.fill = GridBagConstraints.BASELINE_LEADING;
		s4.gridx = 0;
		s4.gridy = 3;
		contentPane.add(restart, s4);

		for (int i=0; i<15; i++) {
			Level templevel;
			templevel = ls.levels.get(i);
			if (!templevel.isLocked) {
				ls.levelbutton[i].addActionListener(new ButtonSwitchController(this, null, templevel));
			}
		}
		contentPane.add(boardpane, s3);
		restart.addActionListener(new RestartGameController(this));
	}
}
