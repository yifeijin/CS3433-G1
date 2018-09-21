package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import junit.framework.TestCase;
import player.model.Board;
import player.model.Level;
import player.model.LightningLevel;
import player.model.LoadedLevels;
import player.model.PuzzleLevel;
import player.model.Square;
import player.model.StarAwards;
import player.model.StringFileIterator;
import player.model.ThemeLevel;
import player.view.GameWindow;
import player.view.LevelSelection;
import player.view.PuzzleView;

public class PlayerTestPlayerModel extends TestCase {
	LevelSelection ls; 
	GameWindow window; 

	@Override
	public void setUp(){
		System.out.println("setting it up"); 
		this.window = new GameWindow();
		//window.setVisible(true); 
	}
	@Override 
	public void tearDown(){
		window.setVisible(false);
	}
	public void test1(){ 
		Square[] sq = new Square[6];
		sq[0] = new Square(0,0);
		sq[1] = new Square(1,0);
		sq[2] = new Square(2,0);
		sq[3] = new Square(3,0);
		sq[4] = new Square(4,0);
		sq[5] = new Square(5,0);

		ArrayList<Square> pca = new ArrayList<Square>();
		Square s1 = new Square(0, 0);
		Square s2 = new Square(0, 1);
		Square s3 = new Square(0, 2);
		Square s4 = new Square(0, 3);
		Square s5 = new Square(1, 0);
		Square s6 = new Square(1, 1);
		s1.setLetter("a");
		s2.setLetter("b");
		s3.setLetter("c");
		s4.setLetter("d");
		s5.setLetter("e");
		s6.setLetter("f");
		s1.setActivated(true);
		s2.setActivated(true);
		s3.setActivated(true);
		s4.setActivated(true);
		s5.setActivated(false);
		s6.setActivated(true);
		pca.add(s1);
		pca.add(s2);
		pca.add(s3);
		pca.add(s4);
		pca.add(s5);
		pca.add(s6);

		int levelNum = 1;
		int allowedMove =10;
		int allowedTime = 100;
		boolean locked = false;
		int highestScore = 20; 
		Board bd = new Board(pca);
		StarAwards achieve = new StarAwards(1,2,3);
		ArrayList<String> solvedWords = new ArrayList<String>(); 
		ArrayList<String> answers = new ArrayList<String>(); 
		solvedWords.add("eat"); 
		solvedWords.add("drink");
		answers.add("eat"); 
		answers.add("drink"); 
		answers.add("food"); 
		PuzzleLevel pl =  new PuzzleLevel(levelNum, bd, locked, solvedWords, achieve, 20, highestScore);	
		pl.countScore("ate"); 
		pl.countScore("funny");
		pl.countScore("a"); 
		pl.countScore("ha"); 
		pl.isPassed(); 
		pl.getScore(); 
		pl.setusedmove(5);
		assertEquals(5, pl.getusedmove()); 
		pl.getmaxmove(); 
		//assertEquals(allowedMove, pl.getNumOfLimitedMoves()); 
		pl.getNumOfUsedMoves(); 
		pl.getNumOfMovesLeft(); 
		assertEquals(2, pl.letterScore("a")); 
		assertEquals(1, pl.letterScore("t")); 
		assertEquals(3, pl.letterScore("d")); 
		assertEquals(4, pl.letterScore("f")); 
		assertEquals(5, pl.letterScore("v")); 
		assertEquals(7, pl.letterScore("j")); 
		assertEquals(8, pl.letterScore("z")); 
		assertEquals(2, pl.letterScore("o")); 
		assertEquals(1, pl.letterScore("t")); 
		assertEquals(3, pl.letterScore("l")); 
		assertEquals(4, pl.letterScore("g")); 
		assertEquals(5, pl.letterScore("k")); 
		assertEquals(7, pl.letterScore("x")); 
		assertEquals(8, pl.letterScore("z")); 	

		LightningLevel ll = new LightningLevel(levelNum, bd, true, solvedWords, achieve, 20, allowedTime);
		ll.getTimeLeft(); 
		ll.countScore("ate"); 
		//just for the coverage 
		ll.getusedmove(); 
		ll.setusedmove(2); 
		ll.getmaxmove(); 

		ThemeLevel tl = new ThemeLevel(levelNum, bd, true, solvedWords, achieve, "dailyLife", answers, 2); 
		assertEquals("dailyLife", tl.getTheme()); 
		tl.countScore("funny"); 
		//just for the coverage 
		tl.getusedmove(); 
		tl.setusedmove(2); 
		tl.getmaxmove(); 
		
		LoadedLevels LL = new LoadedLevels(); 
		ArrayList<Level> levels = new ArrayList<Level>(); 
		levels.add(pl); 
		levels.add(ll); 
		levels.add(tl); 
		//LL.setLevels(levels);
		LL.unlocklevels(2); 
		PuzzleView pv = new PuzzleView(1); 
		pv.getLevel(); 
		pv.getBoardView(); 
		
		LevelSelection ls = new LevelSelection(); 
		ls.setIcon(pl); 
	}
	public void test2() throws FileNotFoundException{
		File dataFile1 = new File("data/PuzzleTest.txt"); 
		StringFileIterator SFI = new StringFileIterator(dataFile1); 
		SFI.hasNext(); 
		SFI.next(); 
	}
}
