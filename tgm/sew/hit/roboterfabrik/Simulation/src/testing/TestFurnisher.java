package testing;

import static org.junit.Assert.*;

import org.junit.*;

import build.CLI;
import build.Furnisher;

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
	 */
	@Test
	public void testfillUp() {
		CLI.lagerVerzeichnis = "/src/testing/IOplayground/csv";
		Thread t = new Thread(new Furnisher());
		
		t.start();
	}
}
