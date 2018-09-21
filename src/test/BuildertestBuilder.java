package test;

import junit.framework.TestCase;
import model.BuilderModel;
import view.BuilderWindow;
import view.LaunchWindow;

public class BuildertestBuilder extends TestCase {
	BuilderModel br = new BuilderModel(); 
	public void test(){
		assertEquals(this.br.getNumFilesByType("PUZZLE"), 0); 
		/**assertEquals(br.getNumFilesByType("LIGHTNING"), 2); 
		assertEquals(br.getNumFilesByType("THEME"), 3);**/ 
	}
	public void test2(){
		BuilderModel br = new BuilderModel(); 
		boolean splasher = false; 
		LaunchWindow lw = new LaunchWindow(br); 
		//lw.init();
	}
	public void test3(){
		BuilderModel br = new BuilderModel(); 
		boolean splasher = true; 
		LaunchWindow lw = new LaunchWindow(br); 
		lw.init();
	}
}
