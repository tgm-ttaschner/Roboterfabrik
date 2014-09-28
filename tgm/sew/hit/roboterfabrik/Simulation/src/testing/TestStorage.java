package testing;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import build.Storage;
import build.CLI;

/**
 * 
 * 
 * 
 * @author Michael Weinberger 4AHITT
 * @version 2014-09-28
 *
 */
public class TestStorage {
	
	String[] out;
	
	@Before
	public void setup() {
		CLI.lagerVerzeichnis = "/src/testing/IOplayground/csv/";
	}
	
	/**
	 * 
	 */
	@Test
	public void testDeliver() {
		Storage test = new Storage();
		
		out = test.deliver(Storage.ARM);
		
		for (int i = 0; i < out.length; i++) {
			System.out.println(out[i]);
		}
	}
	
}
