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
import player.contorller.LevelViewController;
import player.model.LoadedLevels;
import player.model.PuzzleLevel;

/**
 * representing a puzzle level view object
 * @author mxu2, zluo2
 *
 */
public class PuzzleView extends LevelView {

	JLabel movesLeft;
	JPanel emptyBar1; // empty bar
	JPanel emptyBar2; // empty bar
	JPanel emptyBar3; // empty bar
	JPanel emptyBar4; // empty bar
	JPanel emptyBar5; // empty bar
	JPanel emptyBar6;
	Color nocolor = new Color(0,0,0,0);
	LoadedLevels loadlv = new LoadedLevels();
	PuzzleLevel puzzleLevel;
	
	
	/**
	 * PuzzleView consturctor
	 */
	private static final long serialVersionUID = -6576130848678636229L;

	public PuzzleView (int levelnum) {
		this.levelnum = levelnum;
		init();
	}

	/**
	 * Initialize a PuzzleView.
	 */
	public void init() {
		puzzleLevel = (PuzzleLevel) loadlv.getLevel(levelnum);
		puzzleLevel.score = 0;
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setBackground(Color.pink);
		setContentPane(contentPane);

		// Title
		title = new JLabel("PUZZLE LEVEL " + puzzleLevel.levelNumber);
		title.setVerticalAlignment(JLabel.CENTER);
		title.setHorizontalAlignment(SwingConstants.LEADING);
		title.setFont(new Font("title", Font.ROMAN_BASELINE, 40));
		title.setForeground(Color.BLUE);


		// SCORE
		score = new JLabel("SCORE: " + puzzleLevel.getScore());
		score.setVerticalAlignment(JLabel.CENTER);
		score.setHorizontalAlignment(SwingConstants.CENTER);
		score.setFont(new Font("score", Font.PLAIN, 15));
		score.setForeground(Color.BLACK);
		score.setBackground(Color.WHITE);
		score.setOpaque(true);


		// number of moves left
		movesLeft = new JLabel("MOVES LEFT: " + puzzleLevel.getNumOfMovesLeft());
		movesLeft.setVerticalAlignment(JLabel.CENTER);
		movesLeft.setHorizontalAlignment(SwingConstants.CENTER);
		movesLeft.setFont(new Font("moves left", Font.PLAIN, 15));
		movesLeft.setForeground(Color.BLACK);
		movesLeft.setBackground(Color.WHITE);
		movesLeft.setOpaque(true);

		// Board
		board = new JBoardView(puzzleLevel.board);
		// empty bar
		emptyBar0 = new JPanel();
		emptyBar0.setBackground(Color.pink);

		// reset board
		reset = new JButton("RESET BOARD");

		// empty bar
		emptyBar1 = new JPanel();
		emptyBar1.setBackground(Color.pink);

		// QUIT
		quit = new JButton("QUIT");


		// empty bar
		emptyBar2 = new JPanel();
		emptyBar2.setBackground(Color.pink);

		// undo
		undo = new JButton("UNDO");

		// empty bar
		emptyBar3 = new JPanel();
		emptyBar3.setBackground(Color.pink);

		// submit
		submit = new JButton("SUBMIT");

		// empty bar
		emptyBar4 = new JPanel();
		emptyBar4.setBackground(Color.pink);

		// selected word
		ArrayList<String> str = new ArrayList<String>();
		str.add("Selected Word:");
		model= new DefaultListModel<ArrayList<String>>();
		selectedWords = new JList<ArrayList<String>>(model);
		model.addElement(str);

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
		contentPane.add(movesLeft);
		contentPane.add(board);
		contentPane.add(emptyBar0);
		contentPane.add(reset);
		contentPane.add(emptyBar1);
		contentPane.add(quit);
		contentPane.add(emptyBar2);
		contentPane.add(undo);
		contentPane.add(emptyBar3);
		contentPane.add(submit);
		contentPane.add(emptyBar4);
		contentPane.add(selectedWords);
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

		// QUIT
		s.gridwidth= 0;
		s.gridheight = 1;
		s.weightx = 0;
		s.weighty= 0;
		layout.setConstraints(score, s);


		// SCORE
		s.gridwidth=0;
		s.gridheight = 1;
		s.weightx = 0;
		s.weighty=0;
		layout.setConstraints(movesLeft, s);

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
		layout.setConstraints(reset, s);

		// empty bar
		s.gridwidth= 1;
		s.gridheight = 1;
		s.weightx = 0;
		s.weighty= 0;
		layout.setConstraints(emptyBar1, s);

		// UNDO
		s.gridwidth= 0;
		s.gridheight = 1;
		s.weightx = 0;
		s.weighty=0;
		layout.setConstraints(quit, s);

		// empty bar
		s.gridwidth= 1;
		s.gridheight = 1;
		s.weightx = 0;
		s.weighty= 0;
		layout.setConstraints(emptyBar2, s);

		// MOVES LEFT
		s.gridwidth= 0;
		s.gridheight = 1;
		s.weightx = 0;
		s.weighty= 0;
		layout.setConstraints(undo, s);

		// empty bar
		s.gridwidth= 1;
		s.gridheight = 1;
		s.weightx = 0;
		s.weighty= 0;
		layout.setConstraints(emptyBar3, s);

		// SUBMIT
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
		layout.setConstraints(emptyBar4, s);

		// Selected Words
		s.gridwidth= 0;
		s.gridheight = 2;
		s.weightx = 0;
		s.weighty= 1;
		layout.setConstraints(selectedWords, s);

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
		quit.addActionListener(new ButtonSwitchController(null, this, puzzleLevel));
		reset.addActionListener(new LevelViewController(this, puzzleLevel));
		submit.addActionListener(new LevelViewController(this, puzzleLevel));
		undo.addActionListener(new LevelViewController(this, puzzleLevel));

	}

	/**
	 * Get the mooves left label.
	 */
	@Override
	public JLabel getMovesLeft() {
		return this.movesLeft;
	}
	/**
	 * Set the mooves left label
	 */
	@Override
	public void setMovesLeft(String str) {
		this.movesLeft.setText(str);
	}
}
