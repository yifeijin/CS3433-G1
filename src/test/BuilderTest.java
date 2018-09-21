package test;
import junit.framework.TestCase;
import sun.applet.Main;

public class BuilderTest extends TestCase {
	
	public void test() {
		Main bl = new Main(); 
		String[] args = new String[0];
		Main.main(args);
	}
}
