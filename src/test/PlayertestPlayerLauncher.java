package test;



import junit.framework.TestCase;
import player.launcher.PlayerLauncher;

public class PlayertestPlayerLauncher extends TestCase{
	public void test() {
		PlayerLauncher pl = new PlayerLauncher(); 
		String[] args = new String[0];
		pl.main(args);
	}


}
