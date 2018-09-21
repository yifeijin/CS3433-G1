package player.view;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import player.model.Level;
/**
 * Abstruct levelview object.
 * @author zluo2
 *
 */
public abstract class LevelView extends JFrame{

	public Level level;
	public JLabel title;
	public JBoardView board;
	public JLabel score;
	public JButton submit;
	public JButton undo;
	public JButton reset;
	public JButton quit;
	public JList<ArrayList<String>> selectedWords; 
	public JButton firstStar;
	public JButton secondStar;
	public JButton thirdStar; 
	public LevelSelection ls = new LevelSelection();
	protected JPanel emptyBar0;
	public int levelnum;
	public DefaultListModel<ArrayList<String>> model;
	
	/**
	 * Get a boardview.
	 * @return board JBoardView
	 */
	public JBoardView getBoardView() {
		return board;
	}
	
	/**
	 * LevelView Constructor.
	 */
	private static final long serialVersionUID = -5115256372952120325L;
	public LevelView () {
		this.setSize(700,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(false);   
	}
	
	/**
	 * get the level
	 * @return level
	 */
	public Level getLevel() {
		return this.level;
	}
	/**
	 * Get puzzle moves left.
	 * @return JLable
	 */
	abstract public JLabel getMovesLeft();
	/**
	 * Set puzzle moves left.
	 * @return
	 */
	abstract public void setMovesLeft(String str);

}
