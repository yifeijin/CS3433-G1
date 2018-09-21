/**package test;

import java.io.File;

import model.BuilderModel;
import model.PuzzleLevelModel;
import view.BuilderWindow;
import view.PuzzleView;
import junit.framework.TestCase;

public class BuildertestBuilderController2 extends TestCase {
	BuilderModel model = new BuilderModel();
	BuilderWindow window; 
	File dataFile1 = new File("data/level1.txt");
	PuzzleLevelModel lm = new PuzzleLevelModel(dataFile1, 1); 
	PuzzleView lv= new PuzzleView(lm); 

	@Override
	public void setUp(){
		System.out.println("setting it up"); 
		this.window = new BuilderWindow(model);
		this.model.setCurrentLevelNumber(1); 
	}
	@Override 
	public void tearDown(){
		window.setVisible(false);
	}
	
//	public void testReturnButton(){
//		JButton SaveButton = this.lv.getSaveButton(); 
//		SaveButtonController DBC = new SaveButtonController(this.lv);
//		ActionEvent e = new ActionEvent(SaveButton, ActionEvent.ACTION_PERFORMED, "cmd");
//		DBC.actionPerformed(e);
//		JButton ReturnButton = this.lv.getReturnButton(); 
//		ReturnButtonController RBC = new ReturnButtonController(this.lv);
//		ActionEvent ae = new ActionEvent(ReturnButton, ActionEvent.ACTION_PERFORMED, "cmd");
//		//RBC.actionPerformed(ae);
//	}
}
**/