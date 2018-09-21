/**package test;

import java.util.ArrayList;

import junit.framework.TestCase;
import player.contorller.LevelViewController;
import player.model.Board;
import player.model.Level;
import player.model.PuzzleLevel;
import player.model.Square;
import player.view.GameWindow;
import player.view.JBoardView;
import player.view.JSquareView;
import player.view.LevelView;
import player.view.PuzzleView;

public class PlayertestLevelViewController extends TestCase{
	GameWindow gw =  new GameWindow();
	JBoardView bv;
	LevelView lv;
	ArrayList<JSquareView> sv = new ArrayList<JSquareView>();
	JSquareView sqv;
	ArrayList<String> str;
	Level level;
	ArrayList<String> stage;
	PuzzleView pv = new PuzzleView(1);
	
	
	@Override
	public void setUp(){
		System.out.println("setting it up"); 
		this.gw = new GameWindow();
	}
	@Override 
	public void tearDown(){
		gw.setVisible(false);
	}
	
	public void testSPuzzleLevel() {
		LevelViewController lvc =  new LevelViewController(this.bv, this.sqv);
		ArrayList<Square> squares = new ArrayList<Square>();
		Square s1 = new Square(0, 0);
		Square s2 = new Square(0, 1);
		Square s3 = new Square(0, 2);
		Square s4 = new Square(0, 3);
		s1.setLetter("T");
		s2.setLetter("E");
		s3.setLetter("S");
		s4.setLetter("T");
		s1.setActivated(true);
		s2.setActivated(true);
		s3.setActivated(true);
		s4.setActivated(true);
		squares.add(s1);
		squares.add(s2);
		squares.add(s3);
		squares.add(s4);
		Board board = new Board(squares);
		PuzzleLevel pl = new PuzzleLevel(1, board, false, null, null, 0, 10);
		
		//JSquareView
		//ActionEvent e = new ActionEvent(s1, s1.mouseClick(), "cmd");
		
		
	}
}
**/