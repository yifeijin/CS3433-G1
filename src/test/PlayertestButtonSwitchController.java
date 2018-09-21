package test;

import static org.junit.Assert.*;
import player.view.PuzzleView;
import player.view.ThemeView;
import sun.security.krb5.internal.PAData;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JButton;
import junit.framework.TestCase;
import player.contorller.ButtonSwitchController;
import player.model.Level;
import player.model.LightningLevel;
import player.model.PuzzleLevel;
import player.model.ThemeLevel;
import player.view.GameWindow;
import player.view.LevelSelection;
import player.view.LightningView;

import org.junit.Test;

import com.sun.org.apache.bcel.internal.generic.NEW;


public class PlayertestButtonSwitchController extends TestCase{
	GameWindow gw =  new GameWindow();
	PuzzleView pv = new PuzzleView(1);
	PuzzleLevel pl = new PuzzleLevel(1, null, false, null, null, 0, 10);
	LightningView ltnv = new LightningView(2);
	LightningLevel ltnl =  new LightningLevel(2, null, false, null, null, 0, 60);
	ThemeView tv = new ThemeView(3);
	ThemeLevel tl = new ThemeLevel(3, null, false, null, null, "color", null, 0);
	

	@Override
	public void setUp(){
		System.out.println("setting it up"); 
		this.gw = new GameWindow();
	}
	@Override 
	public void tearDown(){
		gw.setVisible(false);
	}

	public void testLevel1Button() {
		ButtonSwitchController bsc =  new ButtonSwitchController(gw, pv, pl);
		JButton level1button = new JButton("Level 1");
		ActionEvent e = new ActionEvent(level1button, ActionEvent.ACTION_PERFORMED, "cmd");
		bsc.actionPerformed(e);
	}
	
	public void testLevel2Button() {
		ButtonSwitchController bsc =  new ButtonSwitchController(gw, pv, pl);
		JButton level2button = new JButton("Level 2");
		ActionEvent e = new ActionEvent(level2button, ActionEvent.ACTION_PERFORMED, "cmd");
		bsc.actionPerformed(e);
	}
	public void testLevel3Button() {
		ButtonSwitchController bsc =  new ButtonSwitchController(gw, pv, pl);
		JButton level3button = new JButton("Level 3");
		ActionEvent e = new ActionEvent(level3button, ActionEvent.ACTION_PERFORMED, "cmd");
		bsc.actionPerformed(e);
		bsc.getLevelType(level3button); 
	}
	public void testQuitButton() {
		ButtonSwitchController bsc =  new ButtonSwitchController(gw, pv, pl);
		JButton quitbutton = new JButton("quit");
		ActionEvent e = new ActionEvent(quitbutton, ActionEvent.ACTION_PERFORMED, "QUIT");
		System.out.println(e.getActionCommand()); 
		bsc.actionPerformed(e);
		
	}

}
