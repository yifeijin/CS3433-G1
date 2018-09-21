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
import player.contorller.ThemeViewController;
import player.model.LoadedLevels;
import player.model.ThemeLevel;

/**
 * representing a theme level view object
 * @author mxu2, zluo2
 *
 */
public class ThemeView extends LevelView {

	JLabel theme;
	JPanel emptyBar1; // empty bar
	JPanel emptyBar2; // empty bar
	JPanel emptyBar3; // empty bar
	JPanel emptyBar4; // empty bar
	JPanel emptyBar5; // empty bar
	JPanel emptyBar6; // empty bar
	public LoadedLevels loadlv = new LoadedLevels();
	ThemeLevel thmLevel;

	/**
	 * ThemeView Constructor.
	 */
	private static final long serialVersionUID = -6576130848678636229L;

	public ThemeView (int levelnum) {
		this.levelnum = levelnum;
		init();
	}

	/**
	 * Initialize a theme view.
	 */
	public void init() {
		thmLevel = (ThemeLevel) loadlv.getLevel(levelnum);
		thmLevel.score = 0;
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setBackground(Color.pink);
		setContentPane(contentPane);

		// Title
		title = new JLabel("THEME LEVEL " + thmLevel.levelNumber);
		title.setVerticalAlignment(JLabel.CENTER);
		title.setHorizontalAlignment(SwingConstants.LEADING);
		title.setFont(new Font("title", Font.ROMAN_BASELINE, 40));
		title.setForeground(Color.BLUE);

		// SCORE
		score = new JLabel("SCORE: " + thmLevel.score);
		score.setVerticalAlignment(JLabel.CENTER);
		score.setHorizontalAlignment(SwingConstants.CENTER);
		score.setFont(new Font("score", Font.PLAIN, 15));
		score.setForeground(Color.BLACK);
		score.setBackground(Color.WHITE);
		score.setOpaque(true);


		// theme
		theme = new JLabel("THEME: " + thmLevel.getTheme());
		theme.setVerticalAlignment(JLabel.CENTER);
		theme.setHorizontalAlignment(SwingConstants.CENTER);
		theme.setFont(new Font("theme", Font.PLAIN, 15));
		theme.setForeground(Color.BLACK);
		theme.setBackground(Color.WHITE);
		theme.setOpaque(true);

		// Board
		board = new JBoardView(thmLevel.board);

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
		contentPane.add(theme);
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


		// theme
		s.gridwidth=0;
		s.gridheight = 1;
		s.weightx = 0;
		s.weighty=0;
		layout.setConstraints(theme, s);

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

		// RESET BOARD
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

		// RESET
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
		quit.addActionListener(new ButtonSwitchController(null, this, thmLevel));
		submit.addActionListener(new ThemeViewController(this,thmLevel));
		reset.addActionListener(new ThemeViewController(this,thmLevel));

	
	}

	@Override
	public JLabel getMovesLeft() {
		return null;
	}

	@Override
	public void setMovesLeft(String str) {		
	}
}
