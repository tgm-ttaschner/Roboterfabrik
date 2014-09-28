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
	
	@Before
	public void setup() {
		Secretary obj = new Secretary(100);
	}
	
}
