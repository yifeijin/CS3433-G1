package player.model;

import java.util.ArrayList;


/**
 * This class represents a board in the model
 * <p>
 * @author zluo2, mxu2
 */
public class Board {

	/** The list of squares that form the board */
	public ArrayList<Square> squares = new ArrayList<Square>();
	/**
	 * Constructor for board.
	 * <p>
	 * @param squares
	 */
	public Board(ArrayList<Square> squares) {
		this.squares = squares;
	}

	/**
	 * Assign letter to all the squares if the squares don't have letter
	 * @return void
	 */
	public void assignLetterToAllSquares() {
		for (Square s : squares) {
			if(s != null) {
				s.getRandomLetter();
			}
		}
	}

	/**
	 * Assign letter to all null squares after flowing up
	 * @return void
	 */
	public void assignLetterToNullSquares() {
		for (Square s : squares) {
			if(s != null){
				if (s.getLetter() == null) {
					s.getRandomLetter();
				}
			}
		}
	}
	/**
	 * Assign letter to all active squares with given letters
	 * @return void
	 */
	public void assignGivenLetters(ArrayList<String> letters) {
		int k = 0;
		for(int i=0; i<36; i++){
			if(squares.get(i) != null){
				squares.get(i).setLetter(letters.get(k));
				k++;
			}

		}
	}
	/**
	 * Get square based on row and col.
	 * @return square
	 */
	public Square getSquare(int row, int col)
	{
		Square sq = null;
		for (int j = 0; j <=5; j++) {
			for (int i = 0; i <=5; i++) {
				if(i==row&&j==col) {
					int index = i*6+j;
					if(index >35) {
						return null;
					} else {
						sq = squares.get(index);
					}
				}
			}
		}
		return sq;
	}
	/**
	 * Get only the letters store in the squares.
	 * @return ArrayList(String)
	 */
	public ArrayList<String> getLetters()
	{
		ArrayList<String> letters = new ArrayList<String>();
		for (Square sq: squares) {
			if(sq!=null){
			letters.add(sq.getLetter());
			}
		}
		return letters;
	}
}