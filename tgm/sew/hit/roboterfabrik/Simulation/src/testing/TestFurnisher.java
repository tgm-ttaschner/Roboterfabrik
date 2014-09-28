package testing;

import static org.junit.Assert.*;

import org.junit.*;

import build.CLI;
import build.Furnisher;
import build.IO;

/**
 * 
 * Checks if the furnisher furnishes properly.
 * 
 * @author Michael Weinberger 4AHITT
 * @version 2014-09-28
 *
 */
public class TestFurnisher {
	
	Thread t;
	
	@Before
	public void setup() {
		CLI.lagerVerzeichnis = "/src/testing/IOplayground/csv";
		Thread t = new Thread(new Furnisher());
		
		IO arm = new IO(IO.getWorkingDir() +CLI.lagerVerzeichnis + "/arm.csv");
		IO eye = new IO(IO.getWorkingDir() +CLI.lagerVerzeichnis + "/eye.csv");
		IO torso = new IO(IO.getWorkingDir() +CLI.lagerVerzeichnis + "/torso.csv");
		IO chaindrive = new IO(IO.getWorkingDir() +CLI.lagerVerzeichnis + "/chaindrive.csv");
		
		arm.overWrite("");
		eye.overWrite("");
		torso.overWrite("");
		chaindrive.overWrite("");
		t.start();
	}
	
	/**
	 * 
	 */
	@Test
	public void testfillUp() {
		
		IO arm = new IO(IO.getWorkingDir() +CLI.lagerVerzeichnis + "/arm.csv");
		assertNotNull(arm.read().iterator().next());
	}
}
