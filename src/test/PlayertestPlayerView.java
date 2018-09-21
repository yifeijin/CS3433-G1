package test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import junit.framework.TestCase;
import player.view.GameWindow;
import player.view.LevelSelection;

public class PlayertestPlayerView extends TestCase{
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
