package player.model;

/**
 * Representation of a star conditions.
 * @author mxu2
 */
public class StarAwards {
	// number of score to pass the level
	public int pass;
	
	// number of score to get two stars
	public int twoStars;
	
	// number of score to get three stars
	public int threeStars;
	/**
	 * StarAwards Constructor.
	 * @param pass
	 * @param twoStars
	 * @param threeStars
	 */
	public StarAwards(int pass, int twoStars, int threeStars) {
		this.pass = pass;
		this.twoStars = twoStars;
		this.threeStars = threeStars;
	}
	
}