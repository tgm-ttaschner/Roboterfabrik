package testing;

import static org.junit.Assert.*;

import org.junit.*;

import build.Secretary;

/**
 * 
 * Tests the abilities of 'secretary' to give an employee or robot a unique, random ID.
 * 
 * @author Michael Weinberger 4AHITT
 * @version 2014-09-28
 *
 */
public class TestSecretary {
	
	Secretary obj;
	Long output;
	
	@Before
	public void setup() {
		obj = new Secretary(100);
	}
	
	/**
	 * Requests an ID.
	 */
	@Test
	public void testGetID()	{
		output = obj.getID();
		
		assertNotNull(output);
	}
	
	/**
	 * Requests an ID.
	 */
	@Test
	public void testGetID100times()	{
		for (int i = 0; i < 110; i++) {
			output = obj.getID();
		}
		
		Long l = -1l;
		
		assertEquals(l, output);
	}
	
}
