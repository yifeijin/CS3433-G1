package player.model;

/**
 * This class represents a level
 * @author mxu2, zluo2
 */

import java.util.ArrayList;

/**
 * Level model object.
 * @author zluo2, mxu2
 *
 */
public abstract class Level {
	public int levelNumber;
	public Board board;
	public boolean isLocked;
	public ArrayList<String> solvedWords = new ArrayList<String>();
	public StarAwards record;
	public int score;
	public ArrayList<ArrayList<String>> stages = new ArrayList<ArrayList<String>>();

	/**
	 * Level Constructor.
	 * @param levelNumber
	 * @param board
	 * @param isLocked
	 * @param solvedWords
	 * @param record
	 */
	public Level(int levelNumber, Board board,boolean isLocked, 
			ArrayList<String> solvedWords, StarAwards record, int score){
		this.levelNumber = levelNumber;
		this.board = board;
		this.isLocked = isLocked;
		this.solvedWords = solvedWords;
		this.record = record;
		this.score = score;
	}

	/**
	 * check the word is in the WordTable
	 * @return boolean
	 */
	public boolean inWordTable(String word) {
		return WordTable.isWord(word);
	}
	
	/**
	 * count the score
	 */
	abstract public int countScore(String word);
	
	/**
	 * check if the player passed the level
	 */
	public boolean isPassed() {
		return this.score >= record.pass;
	}
	/**
	 * get used move in puzzle level
	 */
	abstract public int getusedmove();
	/**
	 * set used move in puzzle level
	 * @param usedmoves
	 */
	abstract public void setusedmove(int usedmoves);
	/**
	 * get max moves in puzzle level
	 */
	abstract public int getmaxmove();	
}
