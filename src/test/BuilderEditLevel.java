package test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;


import junit.framework.TestCase;
import model.BuilderModel;
import view.BuilderWindow;


public class BuilderEditLevel extends TestCase{
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
	public void test() {
		Robot r;
		try {
			r = new Robot();
			r.setAutoDelay(40);
			r.setAutoWaitForIdle(true);
			r.mouseMove(900, 175);
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);
			r.mouseMove(200, 165);
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

}
