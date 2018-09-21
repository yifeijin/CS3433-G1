package test;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import junit.framework.TestCase;
import player.contorller.RestartGameController;
import player.view.GameWindow;

public class PlayertestRestartGameController extends TestCase{
	
	GameWindow gw = new GameWindow();
	
	@Override
	public void setUp(){
		System.out.println("setting it up"); 
		this.gw = new GameWindow();
	}
	@Override 
	public void tearDown(){
		gw.setVisible(false);
	}
	
	public void testRestartGameButton() {
		RestartGameController rgc =  new RestartGameController(gw);
		JButton restartGameButton = new JButton("Restart");
		ActionEvent e = new ActionEvent(restartGameButton, ActionEvent.ACTION_PERFORMED, "cmd");
		rgc.actionPerformed(e);
	}

}
