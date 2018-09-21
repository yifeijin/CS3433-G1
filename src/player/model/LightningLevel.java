package player.model;

import java.util.ArrayList;

/**
 *  Lightning level model object.
 * @author mxu2, zluo2
 *
 */
public  class LightningLevel extends Level{

	// the time limits
	public float limitedTime;

	public int sec;

	// the used time
	public float usedTime;

	/**
	 * Loghtnign Level Consturctor.
	 * @param levelNumber
	 * @param board
	 * @param isLocked
	 * @param solvedWords
	 * @param record
	 * @param numOfCompleted
	 * @param limitedTime
	 */
	public LightningLevel(int levelNumber, Board board, boolean isLocked,
			ArrayList<String> solvedWords, StarAwards record, int numOfCompleted, float limitedTime) 
	{
		super(levelNumber,  board, isLocked, solvedWords, record, numOfCompleted);
		this.limitedTime = limitedTime;
	}

	/**
	 * get the time left
	 * @return float
	 */
	public float getTimeLeft() {
		return limitedTime - usedTime;
	}

	@Override
	/**
	 * count score
	 * @param String word
	 */
	public int countScore(String word) {
		return this.solvedWords.size();
	}
	/**
	 * Don't apply for lightning
	 */
	@Override
	public int getusedmove() {
		return 0;
	}
	/**
	 * Don't apply for lightning
	 */
	@Override
	public void setusedmove(int usedmoves) {
	}
	/**
	 * Don't apply for lightning
	 */
	@Override
	public int getmaxmove() {
		return 0;
	}
}
