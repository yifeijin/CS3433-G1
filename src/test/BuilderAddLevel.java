package test;

import javax.swing.JPanel;

import controller.CreateNewLightningController;
import controller.CreateNewPuzzleController;
import controller.CreateNewThemeController;
import junit.framework.TestCase;
import model.BuilderModel;
import view.BuilderWindow;

import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.io.File;
public class BuilderAddLevel extends TestCase {
	BuilderModel model = new BuilderModel();
	BuilderWindow window; 
	
	@Override
	public void setUp(){
		System.out.println("setting it up"); 
		this.window = new BuilderWindow(model);
		//window.setVisible(true); 
	}
	@Override 
	public void tearDown(){
		window.setVisible(false);
	}
	public void test(){
		Robot r; 
		CreateNewPuzzleController CPC = new CreateNewPuzzleController(window); 
		File dataFile1 = new File("data/level1.txt");
		File dataFile2 = new File("data/level2.txt"); 
		File dataFile3 = new File("data/level3.txt"); 
		File dataFile4 = new File("data/level4.txt"); 
		ActionEvent e =null; 
		CPC.actionPerformed(e);
		System.out.println(model.getCurrentLevelNumber()); 
		JPanel contentPane = new JPanel();
		
		window.drawLevelButtons(contentPane);
		
	}public void test2(){
		CreateNewLightningController CLC = new CreateNewLightningController(window); 
		File dataFile1 = new File("data/level1.txt");
		File dataFile2 = new File("data/level2.txt"); 
		File dataFile3 = new File("data/level3.txt"); 
		File dataFile4 = new File("data/level4.txt"); 
		File dataFile5 = new File("data/level5.txt");
		File dataFile6 = new File("data/level6.txt"); 
		File dataFile7 = new File("data/level7.txt"); 
		File dataFile8 = new File("data/level8.txt"); 
		File dataFile9 = new File("data/level9.txt"); 
		ActionEvent e =null; 
		CLC.actionPerformed(e);
		model.getCurrentLevelNumber(); 
		JPanel contentPane = new JPanel();
		
		window.drawLevelButtons(contentPane);
	}
	public void test3(){
		CreateNewThemeController CTC = new CreateNewThemeController(window); 
		File dataFile1 = new File("data/level1.txt");
		File dataFile2 = new File("data/level2.txt"); 
		File dataFile3 = new File("data/level3.txt"); 
		File dataFile4 = new File("data/level4.txt"); 
		File dataFile5 = new File("data/level5.txt");
		File dataFile6 = new File("data/level6.txt"); 
		File dataFile7 = new File("data/level7.txt"); 
		File dataFile8 = new File("data/level8.txt"); 
		File dataFile9 = new File("data/level9.txt"); 
		ActionEvent e =null; 
		CTC.actionPerformed(e);
		model.getCurrentLevelNumber(); 
		JPanel contentPane = new JPanel();
		window.drawLevelButtons(contentPane);
	}
}
