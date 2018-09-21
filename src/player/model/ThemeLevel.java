package player.model;

import java.util.ArrayList;

/**
 * represent a theme level
 * @author mxu2, zluo2
 *
 */
public class ThemeLevel extends Level{

	// the theme of the level
	String theme;

	// the solutions
	public ArrayList<String> answers;

	/**
	 * ThemeLevel Constructor.
	 * @param levelNumber
	 * @param board
	 * @param isLocked
	 * @param solvedWords
	 * @param record
	 * @param theme
	 * @param answers
	 * @param numOfCorrects
	 */
	public ThemeLevel(int levelNumber, Board board, boolean isLocked,
			ArrayList<String> solvedWords, StarAwards record, String theme, ArrayList<String> answers, int numOfCorrects) {
		super(levelNumber, board, isLocked, solvedWords, record, numOfCorrects);
		this.theme = theme;
		this.answers = answers;
	}

	/**
	 * get the theme of the level
	 * @return String
	 */
	public String getTheme() {
		return theme;
	}
	/**
	 * Calculate the score
	 * @param word
	 * @return int score
	 */
	@Override
	public int countScore(String word) {
		return this.solvedWords.size();
	}

	/**
	 * Don't apply for theme level
	 */
	@Override
	public int getusedmove() {
		return 0;
	}
	/**
	 * Don't apply for theme level
	 */
	@Override
	public void setusedmove(int usedmoves) {		
	}
	/**
	 * Don't apply for theme level
	 */
	@Override
	public int getmaxmove() {
		return 0;
	}
}
