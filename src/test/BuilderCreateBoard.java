package test;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;

import javax.swing.JButton;

import junit.framework.TestCase;
import model.BuilderModel;
import view.BuilderWindow;
import view.LaunchWindow;

public class BuilderCreateBoard extends TestCase {
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
			r.mouseMove(41, 587);
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	public void test2(){
		Robot r; 
		try {
			r = new Robot();
			r.setAutoDelay(40);
			r.setAutoWaitForIdle(true);

			r.mouseMove(265,587);
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);

		}catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void test3(){
		Robot r; 
		try {
			r = new Robot();
			r.setAutoDelay(40);
			r.setAutoWaitForIdle(true);

			r.mouseMove(523,587);
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);

		}catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void test4() {
		Robot r;
		try {
			r = new Robot();
			r.setAutoDelay(40);
			r.setAutoWaitForIdle(true);
			r.mouseMove(40, 587);
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);

			for (int i = 670; i < 670 + 25 * 6; i = i +25){
				r.mouseMove(i, 370);
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
			}
			r.mouseMove(150, 640);
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);

			for (int i = 670; i < 670 + 25 * 6; i = i +25){
				r.mouseMove(i, 370);
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
			}

			r.mouseMove(1000, 450);
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);
			
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}


}
