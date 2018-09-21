package player.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import player.contorller.ButtonSwitchController;
import player.contorller.LightningViewController;
import player.model.LightningLevel;
import player.model.LoadedLevels;

/**
 * representing a lightning level view object
 * @author mxu2,zluo2
 *
 */
public class LightningView extends LevelView {

	public JLabel timer;
	JPanel emptyBar1; // empty bar
	JPanel emptyBar2; // empty bar
	JPanel emptyBar3; // empty bar
	JPanel emptyBar4; // empty bar
	JPanel emptyBar5; // empty bar
	JPanel emptyBar6; // empty bar
	LoadedLevels loadlv = new LoadedLevels();
	public LightningLevel ltnLevel;

	/**
	 * LightningView Constructor.
	 */
	private static final long serialVersionUID = -6576130848678636229L;

	public LightningView (int levelnum) {
		this.levelnum = levelnum;
		init();
	}
	/**
	 * Initialize a LightningView/
	 */
	public void init() {
		ltnLevel = (LightningLevel) loadlv.getLevel(levelnum);
		ltnLevel.score = 0;
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setBackground(Color.pink);
		setContentPane(contentPane);

		// Title
		title = new JLabel("LIGHTNING LEVEL " + ltnLevel.levelNumber);
		title.setVerticalAlignment(JLabel.CENTER);
		title.setHorizontalAlignment(SwingConstants.LEADING);
		title.setFont(new Font("title", Font.ROMAN_BASELINE, 40));
		title.setForeground(Color.BLUE);

		// SCORE
		score = new JLabel("SCORE: " + ltnLevel.score);
		score.setVerticalAlignment(JLabel.CENTER);
		score.setHorizontalAlignment(SwingConstants.CENTER);
		score.setFont(new Font("score", Font.PLAIN, 15));
		score.setForeground(Color.BLACK);
		score.setBackground(Color.WHITE);
		score.setOpaque(true);

		// Timer
		timer = new JLabel("TIME: " + ltnLevel.getTimeLeft());
		timer.setVerticalAlignment(JLabel.CENTER);
		timer.setHorizontalAlignment(SwingConstants.CENTER);
		timer.setFont(new Font("time", Font.PLAIN, 15));
		timer.setForeground(Color.BLACK);
		timer.setBackground(Color.WHITE);
		timer.setOpaque(true);

		// Board
		board = new JBoardView(ltnLevel.board);

		// empty bar
		emptyBar0 = new JPanel();
		emptyBar0.setBackground(Color.pink);

		// submit
		submit = new JButton("SUBMIT");

		// empty bar
		emptyBar1 = new JPanel();
		emptyBar1.setBackground(Color.pink);
		
		//Reset
		reset = new JButton("RESET BOARD");

		// empty bar
		emptyBar2 = new JPanel();
		emptyBar2.setBackground(Color.pink);

		// QUIT
		quit = new JButton("QUIT");

		// empty bar
		emptyBar3 = new JPanel();
		emptyBar3.setBackground(Color.pink);

		// selected word
		ArrayList<String> str = new ArrayList<String>();
		str.add("Selected Word:");
		model= new DefaultListModel<ArrayList<String>>();
		selectedWords = new JList<ArrayList<String>>(model);
		model.addElement(str);

		// empty bar
		emptyBar4 = new JPanel();
		emptyBar4.setBackground(Color.pink);


		// empty bar
		emptyBar5 = new JPanel();
		emptyBar5.setBackground(Color.pink);


		// empty bar
		emptyBar6 = new JPanel();
		emptyBar6.setBackground(Color.pink);


		// Star1
		firstStar = new JButton();
		ImageIcon star = new ImageIcon("src/img/star.png");
		firstStar.setIcon(star);

		// Star2
		secondStar = new JButton();
		secondStar.setIcon(star);

		// Star3
		thirdStar = new JButton();
		thirdStar.setIcon(star);


		GridBagLayout layout = new GridBagLayout();
		contentPane.setLayout(layout);
		contentPane.add(title);
		contentPane.add(score);
		contentPane.add(timer);
		contentPane.add(board);
		contentPane.add(emptyBar0);
		contentPane.add(submit);
		contentPane.add(emptyBar1);
		contentPane.add(emptyBar2);
		contentPane.add(reset);
		contentPane.add(quit);
		contentPane.add(emptyBar3);
		contentPane.add(selectedWords);
		contentPane.add(emptyBar4);
		contentPane.add(emptyBar5);
		contentPane.add(emptyBar6);
		contentPane.add(firstStar);
		contentPane.add(secondStar);
		contentPane.add(thirdStar);

		GridBagConstraints s= new GridBagConstraints();
		s.fill = GridBagConstraints.BOTH;

		// Title
		s.gridwidth= 7;
		s.gridheight = 2;
		s.weightx = 0;
		s.weighty= 0;
		layout.setConstraints(title, s);

		// SCORE
		s.gridwidth= 0;
		s.gridheight = 1;
		s.weightx = 0;
		s.weighty= 0;
		layout.setConstraints(score, s);


		// Timer
		s.gridwidth=0;
		s.gridheight = 1;
		s.weightx = 0;
		s.weighty=0;
		layout.setConstraints(timer, s);

		// Board
		s.gridwidth=6;
		s.gridheight = 6;
		s.weightx = 1;
		s.weighty= 1;
		layout.setConstraints(board, s);


		// empty bar
		s.gridwidth= 1;
		s.gridheight = 1;
		s.weightx = 0;
		s.weighty= 0;
		layout.setConstraints(emptyBar0, s);

		// emptybar
		s.gridwidth= 0;
		s.gridheight = 1;
		s.weightx = 0;
		s.weighty=0;
		layout.setConstraints(submit, s);

		// empty bar
		s.gridwidth= 1;
		s.gridheight = 1;
		s.weightx = 0;
		s.weighty= 0;
		layout.setConstraints(emptyBar1, s);

		// Reset
		s.gridwidth= 0;
		s.gridheight = 1;
		s.weightx = 0;
		s.weighty=0;
		layout.setConstraints(reset, s);

		// empty bar
		s.gridwidth= 1;
		s.gridheight = 1;
		s.weightx = 0;
		s.weighty= 0;
		layout.setConstraints(emptyBar2, s);

		// QUIT
		s.gridwidth= 0;
		s.gridheight = 1;
		s.weightx = 0;
		s.weighty= 0;
		layout.setConstraints(quit, s);

		// empty bar
		s.gridwidth= 1;
		s.gridheight = 1;
		s.weightx = 0;
		s.weighty= 0;
		layout.setConstraints(emptyBar3, s);

		// Selected Words
		s.gridwidth= 0;
		s.gridheight = 3;
		s.weightx = 0;
		s.weighty= 1;
		layout.setConstraints(selectedWords, s);

		// empty bar
		s.gridwidth= 1;
		s.gridheight = 1;
		s.weightx = 0;
		s.weighty= 0;
		layout.setConstraints(emptyBar4, s);

		// empty bar
		s.gridwidth= 1;
		s.gridheight = 1;
		s.weightx = 0;
		s.weighty= 0;
		layout.setConstraints(emptyBar5, s);

		// empty bar
		s.gridwidth= 6;
		s.gridheight = 1;
		s.weightx = 1;
		s.weighty= 0;
		layout.setConstraints(emptyBar6, s);

		// star1
		s.gridwidth= 1;
		s.gridheight = 1;
		s.weightx = 0;
		s.weighty=0;
		layout.setConstraints(firstStar, s);

		// star2
		s.gridwidth= 1;
		s.gridheight = 1;
		s.weightx = 0;
		s.weighty=0;
		layout.setConstraints(secondStar, s);

		// star3
		s.gridwidth=0;
		s.gridheight = 1;
		s.weightx = 0;
		s.weighty=0;
		layout.setConstraints(thirdStar, s);
		quit.addActionListener(new ButtonSwitchController(null, this, ltnLevel));
		submit.addActionListener(new LightningViewController(this, ltnLevel));
		reset.addActionListener(new LightningViewController(this, ltnLevel));
	}
	/**
	 * Don't apply for lightning level.
	 */
	@Override
	public JLabel getMovesLeft() {
		return null;
	}
	/**
	 * Don't apply for lightning level.
	 */
	@Override
	public void setMovesLeft(String str) {		
	}
}
