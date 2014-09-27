package testing;

import static org.junit.Assert.*;

import org.junit.*;

import build.IO;

/**
 * 
 * Test the Input/Output clas which is necessary for 
 * 
 * @author Michael Weinberger 4AHITT
 * @version 2014-09-27
 *
 */
public class TestIO {
	
	@Before
	public void setup() {
		IO io = new IO(IO.getWorkingDir() +"/src/testing/IOplayground/testfile.csv");
	}
	
	@Test
	public void testgetWorkingDirectory() {
		String s = IO.getWorkingDir();
		assertTrue(s.contains("/tgm/sew/hit/roboterfabrik/Simulation/"));
	}
	
	@Test
	public void testRead() {
		String s = IO.getWorkingDir();
		assertTrue(s.contains("/tgm/sew/hit/roboterfabrik/Simulation/"));
	}
}
