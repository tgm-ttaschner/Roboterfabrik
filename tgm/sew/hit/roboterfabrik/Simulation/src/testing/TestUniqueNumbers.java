package testing;

import static org.junit.Assert.*;

import org.junit.*;

import build.UniqueNumbers;

/**
 * The purpose of this class is to test UniqueNumbers
 * 
 * @author Thomas Taschner
 * @version 27.09.2014
 *
 */

public class TestUniqueNumbers {
	
	UniqueNumbers un;

	@Before
	public void setup() {
		un = new UniqueNumbers();
	}
	
	/**
	 * Adds one random number.
	 */
	@Test
	public void addOneNumber()	{
		un.add();
		assertNotNull(un.getRandomNumbers()[0]);
	}
	
	/**
	 * Adds 10 random numbers to the array.
	 */
	@Test
	public void addMoreNumbers()	{
		un.add(10);
		for (int i = 0; i < 10; i++)	{
			assertNotNull(un.getRandomNumbers()[i]);
		}
	}
	
	/**
	 * Checks how the method reacts if '0' new numbers are entered.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void addTooFewNumbers()	{
		un.add(0);
		assertNotNull(un.getRandomNumbers()[0]);
	}
	
	/**
	 * Checks how the method handles negative numbers.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void addTooFewNumbers2()	{
		un.add(-100);
		assertNotNull(un.getRandomNumbers()[0]);
	}
	
	/**
	 * Creates a huge array.
	 */
	@Test
	public void addLotsOfNumbers()	{
		un.add(10000);
		for (int i = 0; i < 10000; i++)	{
			assertNotNull(un.getRandomNumbers()[i]);
		}
	}
}