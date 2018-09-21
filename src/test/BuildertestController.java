package test;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JTextField;

import controller.BoardButtonController;
import controller.DeleteButtonController;
import controller.EditLevelButtonController;
import controller.SaveButtonController;
import controller.TextFieldFocusController;
import junit.framework.TestCase;
import model.BuilderModel;
import model.PuzzleLevelModel;
import model.ThemeLevelModel;
import view.BuilderWindow;
import view.PuzzleView;
import view.ThemeView;

public class BuildertestController extends TestCase {
	BuilderModel model = new BuilderModel();
	BuilderWindow window; 
	File dataFile1 = new File("data/level1.txt");
	PuzzleLevelModel lm = new PuzzleLevelModel(dataFile1, 1); 
	PuzzleView lv= new PuzzleView(lm); 


	@Override
	public void setUp(){
		System.out.println("setting it up"); 
		this.window = new BuilderWindow(model);
		this.model.setCurrentLevelNumber(16); 
	}
	@Override 
	public void tearDown(){
		window.setVisible(false);
	}

	public void testBoard(){
		File dataFile1 = new File("data/level1.txt");
		PuzzleLevelModel lm = new PuzzleLevelModel(dataFile1, 1); 
		PuzzleView lv= new PuzzleView(lm); 
		JButton[][] buttons = lv.getButtons();
		BoardButtonController BBC = new BoardButtonController(lv);
		ActionEvent e = new ActionEvent(buttons[0][2], ActionEvent.ACTION_PERFORMED, "cmd");
		BBC.actionPerformed(e);
		
	}
	
	public void testDeleteButton(){
		File dataFile1 = new File("data/PuzzleDefault.txt");
		PuzzleLevelModel lm = new PuzzleLevelModel(dataFile1, 1); 
		PuzzleView lv= new PuzzleView(lm); 
		JButton DeleteButton = lv.getDeleteButton(); 
		DeleteButtonController DBC = new DeleteButtonController(lv);
		ActionEvent e = new ActionEvent(DeleteButton, ActionEvent.ACTION_PERFORMED, "cmd");
		DBC.actionPerformed(e);

	}
	public void testDeleteButtonTheme(){
		File dataFile1 = new File("data/ThemeDefault1.txt");
		ThemeLevelModel lm = new ThemeLevelModel(dataFile1, 1); 
		ThemeView lv= new ThemeView(lm); 
		JButton DeleteButton = lv.getDeleteButton(); 
		DeleteButtonController DBC = new DeleteButtonController(lv);
		ActionEvent e = new ActionEvent(DeleteButton, ActionEvent.ACTION_PERFORMED, "cmd");
		DBC.actionPerformed(e);
	}
	public void testDeleteButtonTheme2(){
		File dataFile1 = new File("data/ThemeDefault2.txt");
		ThemeLevelModel lm = new ThemeLevelModel(dataFile1, 1); 
		ThemeView lv= new ThemeView(lm); 
		JButton DeleteButton = lv.getDeleteButton(); 
		DeleteButtonController DBC = new DeleteButtonController(lv);
		ActionEvent e = new ActionEvent(DeleteButton, ActionEvent.ACTION_PERFORMED, "cmd");
		DBC.actionPerformed(e);
	}
	public void testDeleteButtonTheme3(){
		File dataFile1 = new File("data/ThemeDefault3.txt");
		ThemeLevelModel lm = new ThemeLevelModel(dataFile1, 1); 
		ThemeView lv= new ThemeView(lm); 
		JButton DeleteButton = lv.getDeleteButton(); 
		DeleteButtonController DBC = new DeleteButtonController(lv);
		ActionEvent e = new ActionEvent(DeleteButton, ActionEvent.ACTION_PERFORMED, "cmd");
		DBC.actionPerformed(e);
	}
	public void testDeleteButtonTheme4(){
		File dataFile1 = new File("data/ThemeDefault4.txt");
		ThemeLevelModel lm = new ThemeLevelModel(dataFile1, 1); 
		ThemeView lv= new ThemeView(lm); 
		JButton DeleteButton = lv.getDeleteButton(); 
		DeleteButtonController DBC = new DeleteButtonController(lv);
		ActionEvent e = new ActionEvent(DeleteButton, ActionEvent.ACTION_PERFORMED, "cmd");
		DBC.actionPerformed(e);
	}
	public void testDeleteButtonTheme5(){
		File dataFile1 = new File("data/ThemeDefault5.txt");
		ThemeLevelModel lm = new ThemeLevelModel(dataFile1, 1); 
		ThemeView lv= new ThemeView(lm); 
		JButton DeleteButton = lv.getDeleteButton(); 
		DeleteButtonController DBC = new DeleteButtonController(lv);
		ActionEvent e = new ActionEvent(DeleteButton, ActionEvent.ACTION_PERFORMED, "cmd");
		DBC.actionPerformed(e);
	}
	
	public void testEditLevelButton(){
		BuilderModel bm = new BuilderModel(); 
		BuilderWindow bw = new BuilderWindow(bm);
		bm.setCurrentLevelNumber(9); 
		JButton EditLevelButton = bw.getPuzzleButton(); 
		JButton[] ELB = bw.getButtons(); 
		EditLevelButtonController ELBC = new EditLevelButtonController(bw);
		ActionEvent e = new ActionEvent(ELB[1], ActionEvent.ACTION_PERFORMED, "cmd");
		ELBC.actionPerformed(e);
	}
	public void testSaveButton(){	
		SaveButtonController DBC = new SaveButtonController(this.lv);
		JButton SaveButton = this.lv.getSaveButton(); 
		ActionEvent e = new ActionEvent(SaveButton, ActionEvent.ACTION_PERFORMED, "cmd");
		DBC.actionPerformed(e);
		/**File dataFile2 = new File("data/PuzzleTest2.txt");
		PuzzleLevelModel lm2 = new PuzzleLevelModel(dataFile2, 1); 
		PuzzleView lv2= new PuzzleView(lm2); 
		SaveButtonController DBC2 = new SaveButtonController(lv2);
		JButton SaveButton2 = lv2.getSaveButton(); 
		ActionEvent ae = new ActionEvent(SaveButton2, ActionEvent.ACTION_PERFORMED, "cmd");
		DBC2.actionPerformed(ae);
		**/
	}
	public void testTextField(){
		JTextField text = new JTextField(); 
		TextFieldFocusController tff = new TextFieldFocusController(text); 
		FocusEvent e = new FocusEvent(text, 0);
		tff.focusGained(e);
		tff.focusLost(e);
	}
		
}
