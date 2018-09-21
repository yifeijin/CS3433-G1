package player.model;

import java.util.ArrayList;
import java.util.Random;

/**
 * represent a square in the model 
 * @author mxu2, zluo2
 */
public class Square{
	int row;
	int column;
	String letter = null;
	boolean activated = false;

	/**
	 * Suqare constructor
	 * @param row
	 * @param column
	 */
	public Square(int row, int column) {
		this.row = row;
		this.column = column;
	}

	/**
	 * Return the letter of the square.
	 * @return column
	 */
	public String getLetter(){
		return letter;
	}
	/**
	 * Set the letter of the square.
	 * @return column
	 */
	public void setLetter(String s){
		letter = s;
	}
	/**
	 * Set the activated field
	 * @return activated
	 */
	public void setActivated(boolean b) {
		activated = b;
	}
	/**
	 * Return the row of the square.
	 * @return row
	 */
	public int getRow(){
		return row;
	}

	/**
	 * Return the column of the square.
	 * @return column
	 */
	public int getColumn(){
		return column;
	}
	
	/**
	 * generate a random letter to a square
	 * @return String
	 */
	public void getRandomLetter() {
		ArrayList<Double> probabilities = new ArrayList<Double>();
		ArrayList<String> alphabet = new ArrayList<String>();
		
		probabilities.add(12.70);
		probabilities.add(21.76);
		probabilities.add(29.93);
		probabilities.add(37.44);
		probabilities.add(44.41);
		probabilities.add(51.16);
		probabilities.add(57.49);
		probabilities.add(63.58);
		probabilities.add(69.57);
		probabilities.add(73.82);
		probabilities.add(77.85);
		probabilities.add(80.63);
		probabilities.add(83.39);
		probabilities.add(85.8);
		probabilities.add(88.16);
		probabilities.add(90.39);
		probabilities.add(92.41);
		probabilities.add(94.38);
		probabilities.add(96.31);
		probabilities.add(97.8);
		probabilities.add(98.78);
		probabilities.add(99.55);
		probabilities.add(99.7);
		probabilities.add(99.85);
		probabilities.add(99.95);
		probabilities.add(100.02);
		
		alphabet.add("E");
		alphabet.add("T");
		alphabet.add("A");
		alphabet.add("O");
		alphabet.add("I");
		alphabet.add("N");
		alphabet.add("S");
		alphabet.add("H");
		alphabet.add("R");
		alphabet.add("D");
		alphabet.add("L");
		alphabet.add("C");
		alphabet.add("U");
		alphabet.add("M");
		alphabet.add("W");
		alphabet.add("F");
		alphabet.add("G");
		alphabet.add("Y");
		alphabet.add("P");
		alphabet.add("B");
		alphabet.add("V");
		alphabet.add("K");
		alphabet.add("J");
		alphabet.add("X");
		alphabet.add("Qu");
		alphabet.add("Z");
		
		// generate random double between 0 to 100.02
		Random random = new Random();
		double rand = random.nextDouble();
		double scaled = rand * 100.02;
		
		// find the position of the random double in the probability range and get the corresponding letter
		for (int i = 0; i < probabilities.size(); i++) {
			if (scaled <= probabilities.get(i)) {
				this.letter = alphabet.get(i);
				break;
			}else continue;
		}
		return;
	}
}
