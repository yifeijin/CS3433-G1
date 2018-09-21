package player.model;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Represent a puzzle level object
 * @author mxu2, zluo2
 *
 */
public class PuzzleLevel extends Level{

	// the maximum number of move
	int numOfLimitedMoves;

	// the number of happened moves
	int numOfUsedMoves = 0;

	/**
	 * PuzzleLevel Constructor.
	 * @param levelNumber
	 * @param board
	 * @param isLocked
	 * @param solvedWords
	 * @param record
	 * @param score
	 * @param numOfLimitedMoves
	 */
	public PuzzleLevel(int levelNumber, Board board, boolean isLocked,
			ArrayList<String> solvedWords, StarAwards record, int score, int numOfLimitedMoves) {
		super(levelNumber, board,  isLocked, solvedWords, record, score);
		this.numOfLimitedMoves = numOfLimitedMoves;
	}

	/**
	 * get numOfLimitedMoves
	 * @return int numOfLimitedMoves
	 */
	public int getNumOfLimitedMoves() {
		return numOfLimitedMoves;
	}

	/**
	 * get numOfUsedMoves
	 * @return int numOfUsedMoves
	 */
	public int getNumOfUsedMoves() {
		return numOfUsedMoves;
	}

	/**
	 * calculate the number of moves left
	 * @return int
	 */
	public int getNumOfMovesLeft() {
		return numOfLimitedMoves - numOfUsedMoves;
	}

	/**
	 * get score
	 * @return int
	 */
	public int getScore() {
		return this.score;
	}
	
	/**
	 * get score for each letter
	 * @return int
	 */
	public int letterScore(String l) {
		if (l.equals("e") || l.equals("t")) {
			return 1;
		}
		else if (l.equals("a") || l.equals("o") || l.equals("i") || l.equals("n") || l.equals("s") || l.equals("h") || l.equals("r")){
			return 2;
		}
		else if (l.equals("d") || l.equals("l") || l.equals("c") || l.equals("u") || l.equals("m") || l.equals("w")) {
			return 3;
		}
		else if (l.equals("f") || l.equals("g") || l.equals("y") || l.equals("p") || l.equals("b")) {
			return 4;
		}
		else if (l.equals("v") || l.equals("k")) {
			return 5;
		}
		else if (l.equals("j") || l.equals("x")) {
			return 7;
		}
		else if (l.equals("z")){
			return 8;
		}
		else {
			return 11;
		}
	}


	/**
	 * calculate the score for each word selected.
	 * @return int
	 */
	@Override
	public int countScore(String word) {
		
		if(inWordTable(word)) {
			int result = 0;
			
			// split the string
			String[] StringTokens = word.toLowerCase().split("");
			
			// get the length of the word
			int wordLength = StringTokens.length;
			
			// convert an array into an arrayList
			ArrayList<String> tokens = new ArrayList<String>(Arrays.asList(StringTokens));
			
			for(int i = 0; i < tokens.size() ; i++) {
				if ((i != tokens.size() - 1) && tokens.get(i).equals("q") && tokens.get(i+1).equals("u")) {
					
					// combine q with u
					String newToken = tokens.get(i) + tokens.get(i+1);
					
					// change q to qu
					tokens.set(i, newToken);
					
					// remove u from the arraylist
					tokens.remove(i+1);
					
					wordLength--;
				}
			}
			
			if (wordLength <= 1) {
				return 0;
			}
			else if(wordLength == 2) {
				return letterScore(tokens.get(0)) + letterScore(tokens.get(1));
			}
			else {
				for (String s : tokens) {
					
					// count score for each token
					result += letterScore(s);
				}
				result = result * (wordLength - 2);
				return result;
			}
		}else return 0;
	}



	@Override
	public int getusedmove() {
		return this.numOfUsedMoves;
	}



	@Override
	public void setusedmove(int usedmoves) {
		this.numOfUsedMoves = usedmoves;
	}



	@Override
	public int getmaxmove() {
		return this.numOfLimitedMoves;
	}


}
