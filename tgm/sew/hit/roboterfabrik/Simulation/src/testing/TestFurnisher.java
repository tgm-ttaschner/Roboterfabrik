package testing;

import static org.junit.Assert.*;

import org.junit.*;

import threading.*;
import build.*;

/**
 * 
 * Checks if the furnisher furnishes properly.
 * 
 * @author Michael Weinberger 4AHITT
 * @version 2014-09-28
 *
 */
public class TestFurnisher {
	
	/**
	 * Refills the storage.
	 * Deletes the old files, creates new ones and fills them up with parts.
	 */
	@Test
	public void testfillUp() throws InterruptedException {
		CLI.lagerVerzeichnis = "/src/testing/IOplayground/csv";
		
		IO arm = new IO(IO.getWorkingDir() +CLI.lagerVerzeichnis +"/arm.csv");
		IO eye = new IO(IO.getWorkingDir() +CLI.lagerVerzeichnis +"/eye.csv");
		IO torso = new IO(IO.getWorkingDir() +CLI.lagerVerzeichnis +"/torso.csv");
		IO chaindrive = new IO(IO.getWorkingDir() +CLI.lagerVerzeichnis +"/chaindrive.csv");
		
		arm.overWrite("");
		eye.overWrite("");
		torso.overWrite("");
		chaindrive.overWrite("");
		
		Thread t = new Thread(new Furnisher());
		t.start();
		t.join();
	}
	
	/**
	 * Checks if the OneRow method behaves correctly if an invalid part is entered.
	 */
	@Test
	public void testOneRow() {
		CLI.lagerVerzeichnis = "/src/testing/IOplayground/csv";
		
		Furnisher f = new Furnisher();
		String out = f.OneRow(42);
		assertEquals(null, out);
	}
}
