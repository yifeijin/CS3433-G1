package player.contorller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


import player.model.Board;
import player.model.Level;
import player.model.LightningLevel;
import player.model.PuzzleLevel;
import player.model.Square;
import player.model.StarAwards;
import player.model.ThemeLevel;

/**
 * Controller to read a txt file and get the information for creating a level.
 * board.
 * <p>
 * @author zluo2
 *
 */
public class LoadLevelController {

	/** Loaded ArrayList of levels */
	protected ArrayList<Level> levels = new ArrayList<Level>();
	/** Number of levels */
	private int NumberOfLevels = 15;
	/** Orignal letters in a theme level */
	public ArrayList<String> letters = new ArrayList<String>();

	/**
	 * LoadLevelController Constructor
	 * <p>
	 * @param levels ArrayList<Level>
	 */
	public LoadLevelController(ArrayList<Level> levels) {
		this.levels = levels;
		readFileList();
	}

	/**
	 * Read all 15 levels from txt files
	 * <p>
	 * @return
	 */
	public void readFileList() {
		String filename; // Level file path
		Level lv;
		// Load files based on filename
		for (int levelnum = 0; levelnum < NumberOfLevels; levelnum++) {
			filename = "player-data/level" + (levelnum + 1) + ".txt";
			lv = readTxtFile(filename);
			levels.add(lv);
		}
	}
	/**
	 * Read  one levels from txt files
	 * <p>
	 * @return
	 */
	public Level readTxtFile(String filename) {
		// Get levelnum
		String number = filename.replaceFirst(".*?(\\d+).*", "$1");
		int levelnum = Integer.parseInt(number);
		Level level = null;
		Board board = loadBoard(filename);
		boolean isLocked = true;
		ArrayList<String> solvedWords = new ArrayList<String>();
		StarAwards record = loadStarAward(filename);
		int score = loadScore("player-data/score"+levelnum+".txt");
		float limitedTime = 30;
		int numOfLimitedMoves = 0;
		ArrayList<String> answers = null;
		String theme = null;
		if (levelnum == 1) {
			isLocked = false;
		}
		try {
			File fp = new File(filename);

			if (fp.isFile() && fp.exists()) {
				FileReader fr = new FileReader(fp);
				BufferedReader br = new BufferedReader(fr);
				String line = null;
				// Put index on line 11
				for (int i = 0; i < 10; i++) {
					br.readLine();
				}
				if (levelnum % 3 == 1) {
					line = br.readLine();
					if (line != null) {
						numOfLimitedMoves = Integer.parseInt(line);
					} else
						System.out.println("Error: No line been read.");
					level = new PuzzleLevel(levelnum, board, isLocked, solvedWords, record, score, numOfLimitedMoves);
				} else if (levelnum % 3 == 2) {
					br.readLine();// move index to line 12
					line = br.readLine();
					if (line != null) {
						limitedTime = Integer.parseInt(line);
					} else
						System.out.println("Error: No line been read.");
					level = new LightningLevel(levelnum, board, isLocked, solvedWords, record, score, limitedTime);
				} else if (levelnum % 3 == 0) {
					board = loadThemeBoard(filename);
					br.readLine();
					br.readLine();// move index to line 13
					line = br.readLine();// Read line 13
					if (line != null) {
						theme = line;
					} else
						System.out.println("Error: No line been read.");
					line = br.readLine();// Read line 14
					if (line != null) {
						answers = new ArrayList<String>(Arrays.asList(line.split(" ")));
					} else
						System.out.println("Error: No line been read.");
					level = new ThemeLevel(levelnum, board, isLocked, solvedWords, record, theme, answers, score);
				}

				br.close();
			} else {
				System.out.println("Error: Cannot find file");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return level;
	}

	/**
	 * Read information about a board from txt file.
	 * @param filename
	 * @return board
	 */
	public Board loadBoard(String filename) {

		ArrayList<Square> squares = new ArrayList<Square>();
		Board board;
		try {
			File fp = new File(filename);
			if (fp.isFile() && fp.exists()) {
				FileReader fr = new FileReader(fp);
				BufferedReader br = new BufferedReader(fr);
				String line = null;
				int numofboardline = 6;
				int numofchar = 6;
				int isactive;
				for (int linenum = 0; linenum < numofboardline; linenum++) {
					line = br.readLine();
					if (line != null) {
						for (int colnum = 0; colnum < numofchar; colnum++) {
							char s = line.charAt(colnum);
							isactive = Character.getNumericValue(s);
							if (isactive == 0) {
								Square sq = new Square(linenum, colnum);
								squares.add(sq);
							} else if (isactive == 1) {
								Square sq = null;
								squares.add(sq);
							}
						}
					} else
						System.out.println("Error: No line been read.");
				}
				br.close();
			} else {
				System.out.println("Error: Cannot find file");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		board = new Board(squares);
		return board;
	}
	/**
	 * Read information on starawards.
	 * @param filename
	 * @return starawards
	 */
	public StarAwards loadStarAward(String filename) {

		StarAwards sa = null;
		int pass = 0;
		int twoStars = 0;
		int threeStars = 0;

		try {
			File fp = new File(filename);
			if (fp.isFile() && fp.exists()) {
				FileReader fr = new FileReader(fp);
				BufferedReader br = new BufferedReader(fr);
				String line = null;
				// Put index on line 8
				for (int i = 0; i < 7; i++) {
					br.readLine();
				}
				// Read line 8
				line = br.readLine();
				if (line != null) {
					pass = Integer.parseInt(line);
				} else
					System.out.println("Error: No line been read.");
				// Read line 9
				line = br.readLine();
				if (line != null) {
					twoStars = Integer.parseInt(line);
				} else
					System.out.println("Error: No line been read.");
				// Read line 10
				line = br.readLine();
				if (line != null) {
					threeStars = Integer.parseInt(line);
				} else
					System.out.println("Error: No line been read.");
				br.close();
			} else {
				System.out.println("Error: Cannot find file");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		sa = new StarAwards(pass, twoStars, threeStars);
		return sa;
	}

	/**
	 * Read hightes score from file.
	 * @param filename
	 * @return int score
	 */
	public int loadScore(String filename) {
		int score = 0;
		try {
			File fp = new File(filename);
			if (fp.isFile() && fp.exists()) {
				FileReader fr = new FileReader(fp);
				BufferedReader br = new BufferedReader(fr);
				String line = br.readLine();;
				try{
					score = Integer.parseInt(line);
				}catch(NumberFormatException ex){ 
					System.out.println("not an integer");
				}
				br.close();
			} else {
				System.out.println("Error: Cannot find file");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return score;
	}
	/**
	 * Read a theme board. 
	 * <p>
	 * It loads both the board shape and letters.
	 * @param filename
	 * @return
	 */
	public Board loadThemeBoard(String filename) {

		ArrayList<Square> squares = new ArrayList<Square>();
		Board board;
		try {
			File fp = new File(filename);
			if (fp.isFile() && fp.exists()) {
				FileReader fr = new FileReader(fp);
				BufferedReader br = new BufferedReader(fr);
				String line = null;
				int numofboardline = 6;
				int numofchar = 6;
				boolean isactive;
				for (int linenum = 0; linenum < numofboardline; linenum++) {
					line = br.readLine();
					if (line != null) {
						for (int colnum = 0; colnum < numofchar; colnum++) {
							String s = Character.toString(line.charAt(colnum));
							isactive = s.matches(".*?(\\d+).*");
							if (!isactive) {
								if (s.equals("Q")){
									Square sq = new Square(linenum, colnum);
									sq.setLetter("Qu");
									letters.add("Qu");
									squares.add(sq);
								} else {
								Square sq = new Square(linenum, colnum);
								sq.setLetter(s);
								letters.add(s);
								squares.add(sq);
								}
							} else if (isactive) {
								Square sq = null;
								squares.add(sq);
							}
						} 
					} else
						System.out.println("Error: No line been read.");
				}
				br.close();
			} else {
				System.out.println("Error: Cannot find file");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		board = new Board(squares);
		return board;
	}
}
