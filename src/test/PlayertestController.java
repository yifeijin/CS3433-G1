package test;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JButton;

import junit.framework.TestCase;
import player.contorller.LevelViewController;
import player.contorller.LightningViewController;
import player.contorller.ThemeViewController;
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
import player.view.JSquareView;
import player.view.LevelSelection;
import player.view.LightningView;
import player.view.PuzzleView;
import player.view.ThemeView;

public class PlayertestController extends TestCase {
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
		sq[0].setActivated(true);
		sq[0].setLetter("p"); 
		sq[1] = new Square(1,0);
		sq[1].setActivated(true);
		sq[1].setLetter("i"); 
		sq[2] = new Square(2,0);
		sq[2].setActivated(true);
		sq[2].setLetter("z"); 
		sq[3] = new Square(3,0);
		sq[3].setActivated(true);
		sq[3].setLetter("z"); 
		sq[4] = new Square(4,0);
		sq[4].setActivated(true);
		sq[4].setLetter("a"); 
		sq[5] = new Square(5,0);
		sq[5].setActivated(true);
		sq[5].setLetter("s"); 

		ArrayList<Square> pca = new ArrayList<Square>();
		pca.add(sq[0]);
		pca.add(sq[1]);
		pca.add(sq[2]);
		pca.add(sq[3]);
		pca.add(sq[4]);
		pca.add(sq[5]);
		
		PuzzleView pv = new PuzzleView(1); 
		Board bd = new Board(pca);
		StarAwards achieve = new StarAwards(1,2,3);
		ArrayList<String> solvedWords = new ArrayList<String>(); 
		solvedWords.add("eat"); 
		solvedWords.add("drink");
		PuzzleLevel pl =  new PuzzleLevel(1, bd, false, solvedWords, achieve, 20, 5);	
		LevelViewController lvc= new LevelViewController(pv, pl); 
		Color color = Color.orange; 
		JSquareView jsv = new JSquareView(sq[0], color); 
		jsv.setBackground(color);
		MouseEvent event = new MouseEvent(jsv, MouseEvent.BUTTON1, 0, 0, 100, 100, 1, false); 
		lvc.mouseClicked(event);
		event.setSource(jsv);
		JButton sumbit = new JButton("SUMBIT"); 
		ActionEvent e = new ActionEvent(sumbit, ActionEvent.ACTION_PERFORMED, "SUBMIT"); 
		lvc.actionPerformed(e);
		JButton undo = new JButton("UNDO"); 
		ActionEvent e2 = new ActionEvent(undo, ActionEvent.ACTION_PERFORMED, "UNDO"); 
		lvc.actionPerformed(e2);
		JButton resetBoard = new JButton("resetBoard"); 
		ActionEvent e3 = new ActionEvent(resetBoard, ActionEvent.ACTION_PERFORMED, "RESET BOARD"); 
		lvc.actionPerformed(e3);
		JButton Quit = new JButton("Quit"); 
		ActionEvent e4 = new ActionEvent(Quit, ActionEvent.ACTION_PERFORMED, "QUIT"); 
		lvc.actionPerformed(e4);
		lvc.flowup();
		lvc.isConnect(); 
		lvc.changeIcon();
	}
	public void test2(){ 
		Square[] sq = new Square[6];
		sq[0] = new Square(0,0);
		sq[0].setActivated(true);
		sq[0].setLetter("p"); 
		sq[1] = new Square(1,0);
		sq[1].setActivated(true);
		sq[1].setLetter("i"); 
		sq[2] = new Square(2,0);
		sq[2].setActivated(true);
		sq[2].setLetter("z"); 
		sq[3] = new Square(3,0);
		sq[3].setActivated(true);
		sq[3].setLetter("z"); 
		sq[4] = new Square(4,0);
		sq[4].setActivated(true);
		sq[4].setLetter("a"); 
		sq[5] = new Square(5,0);
		sq[5].setActivated(true);
		sq[5].setLetter("s"); 

		ArrayList<Square> pca = new ArrayList<Square>();
		pca.add(sq[0]);
		pca.add(sq[1]);
		pca.add(sq[2]);
		pca.add(sq[3]);
		pca.add(sq[4]);
		pca.add(sq[5]);
		
		LightningView pv = new LightningView(2); 
		Board bd = new Board(pca);
		StarAwards achieve = new StarAwards(1,2,3);
		ArrayList<String> solvedWords = new ArrayList<String>(); 
		solvedWords.add("eat"); 
		solvedWords.add("drink");
		LightningLevel pl =  new LightningLevel(1, bd, false, solvedWords, achieve, 20, 5);	
		LightningViewController lvc= new LightningViewController(pv, pl); 
		Color color = Color.orange; 
		JSquareView jsv = new JSquareView(sq[0], color); 
		jsv.setBackground(color);
		JButton sumbit = new JButton("SUMBIT"); 
		ActionEvent e = new ActionEvent(sumbit, ActionEvent.ACTION_PERFORMED, "SUBMIT"); 
		lvc.actionPerformed(e);
		JButton undo = new JButton("UNDO"); 
		ActionEvent e2 = new ActionEvent(undo, ActionEvent.ACTION_PERFORMED, "UNDO"); 
		lvc.actionPerformed(e2);
		JButton resetBoard = new JButton("resetBoard"); 
		ActionEvent e3 = new ActionEvent(resetBoard, ActionEvent.ACTION_PERFORMED, "RESET BOARD"); 
		lvc.actionPerformed(e3);
		JButton Quit = new JButton("Quit"); 
		ActionEvent e4 = new ActionEvent(Quit, ActionEvent.ACTION_PERFORMED, "QUIT"); 
		lvc.actionPerformed(e4);
		lvc.flowup();
		lvc.isConnect(); 
		lvc.changeIcon();
	}
	public void test3(){ 
		Square[] sq = new Square[6];
		sq[0] = new Square(0,0);
		sq[0].setActivated(true);
		sq[0].setLetter("p"); 
		sq[1] = new Square(1,0);
		sq[1].setActivated(true);
		sq[1].setLetter("i"); 
		sq[2] = new Square(2,0);
		sq[2].setActivated(true);
		sq[2].setLetter("z"); 
		sq[3] = new Square(3,0);
		sq[3].setActivated(true);
		sq[3].setLetter("z"); 
		sq[4] = new Square(4,0);
		sq[4].setActivated(true);
		sq[4].setLetter("a"); 
		sq[5] = new Square(5,0);
		sq[5].setActivated(true);
		sq[5].setLetter("s"); 

		ArrayList<Square> pca = new ArrayList<Square>();
		pca.add(sq[0]);
		pca.add(sq[1]);
		pca.add(sq[2]);
		pca.add(sq[3]);
		pca.add(sq[4]);
		pca.add(sq[5]);
		
		ThemeView pv = new ThemeView(3); 
		Board bd = new Board(pca);
		StarAwards achieve = new StarAwards(1,2,3);
		ArrayList<String> solvedWords = new ArrayList<String>(); 
		solvedWords.add("eat"); 
		solvedWords.add("drink");
		ArrayList<String> answers = new ArrayList<String>(); 
		answers.add("eat"); 
		answers.add("drink");
		answers.add("food");
		ThemeLevel pl = new ThemeLevel(3, bd, true, solvedWords, achieve, "dailyLife", answers, 2); 		
		ThemeViewController lvc= new ThemeViewController(pv, pl); 
		Color color = Color.orange; 
		JSquareView jsv = new JSquareView(sq[0], color); 
		jsv.setBackground(color);
		JButton sumbit = new JButton("SUMBIT"); 
		ActionEvent e = new ActionEvent(sumbit, ActionEvent.ACTION_PERFORMED, "SUBMIT"); 
		lvc.actionPerformed(e);
		JButton undo = new JButton("UNDO"); 
		ActionEvent e2 = new ActionEvent(undo, ActionEvent.ACTION_PERFORMED, "UNDO"); 
		lvc.actionPerformed(e2);
		JButton Quit = new JButton("Quit"); 
		ActionEvent e4 = new ActionEvent(Quit, ActionEvent.ACTION_PERFORMED, "QUIT"); 
		lvc.actionPerformed(e4);
		lvc.flowup();
		lvc.isConnect(); 
		lvc.changeIcon();
	}
	
}
