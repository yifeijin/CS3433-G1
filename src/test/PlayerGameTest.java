/**
 * 
 */
package test;

import java.util.ArrayList;
import junit.framework.TestCase;
import player.model.Board;
import player.model.Level;
import player.model.LightningLevel;
import player.model.StarAwards;
import player.model.ThemeLevel;
import player.view.GameWindow;
import player.view.LaunchWindow;
import player.view.LevelView;
import player.view.LightningView;
import player.view.PlayerSplashScreen;
import player.view.PuzzleView;
import player.view.SplashScreen;
import player.view.ThemeView;
import player.model.PuzzleLevel;
import player.model.Square;

/**
 * @author eyhao
 *
 */
public class PlayerGameTest extends TestCase {

	public void test(){		
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
		
		
		Square head = sq[0];
		int levelNum = 1;
		int allowedMove =10;
		int allowedTime = 100;
		boolean locked = false;
		Level[] lv = new Level[3];
		Board bd = new Board(pca);
		Board bd1 = new Board(pca);
		StarAwards achieve = new StarAwards(1,2,3);
		ArrayList<String> solvedWords = new ArrayList<String>(); 
		ArrayList<String> answers = new ArrayList<String>(); 
		solvedWords.add("eat"); 
		solvedWords.add("drink");
		answers.add("eat"); 
		answers.add("drink"); 
		answers.add("food"); 
		lv[0] = new PuzzleLevel(levelNum, bd, locked, solvedWords, achieve, 20, allowedMove);
		lv[1] = new LightningLevel(levelNum, bd, true, solvedWords, achieve, 20, allowedTime);
		lv[2] = new ThemeLevel(levelNum, bd, true, solvedWords, achieve, "dailyLife", answers, 2); 


		head.setLetter("a");
		assertEquals("a", head.getLetter()); 
		head.setLetter(null);
		assertEquals(null, head.getLetter()); 
		head.getRandomLetter();
		
		bd.assignLetterToAllSquares();
		bd1.assignLetterToNullSquares();
		bd.getSquare(0, 0);
		bd.getLetters(); 
		
		ArrayList<Level> levels = new ArrayList<Level>();
		levels.add(lv[0]); 
		levels.add(lv[1]); 
		levels.add(lv[2]); 
		levels.get(1); 
		
		lv[1].getmaxmove(); 
		lv[1].countScore("eat");
		
		LightningView lV = new LightningView(2); 
		//lV.updateBoardView(bd);
	}
	public void test2(){
		
		PuzzleView pv = new PuzzleView(1); 
		pv.setMovesLeft("2");
		pv.getMovesLeft(); 
		pv.getLevel(); 
		
		LightningView lV = new LightningView(2); 
		lV.setMovesLeft("3"); 
		lV.getMovesLeft(); 
		
		ThemeView tv = new ThemeView(3); 
		tv.setMovesLeft("4");
		tv.getMovesLeft(); 
	}
	public void test3(){
		SplashScreen ss = new SplashScreen(2000, true); 
		PlayerSplashScreen pss = new PlayerSplashScreen(); 
		pss.run();
	}
	public void test4(){
		LaunchWindow lw = new LaunchWindow(true); 
		GameWindow gw = new GameWindow(); 
	}
/**	public void test5(){
		ArrayList<Square> pca2 = new ArrayList<Square>();
		pca2.add(new Square(0, 0,"a", true));
		pca2.add(new Square(0, 1,"b", true));
		pca2.add(new Square(0, 2,"c", true));
		pca2.add(new Square(0, 3, "d", true));
		pca2.add(new Square(1, 0,"e", false));
		pca2.add(new Square(1, 1, "f", true));
		ArrayList<String> letters = new ArrayList<String>(); 
		letters.add("a"); 
		letters.add("b"); 
		letters.add("c"); 
		letters.add("d"); 
		letters.add("e"); 
		Board bd2 = new Board(pca2);
		bd2.assignGivenLetters(letters);
		//bd2.getLetters(); 
	}**/
	
}
