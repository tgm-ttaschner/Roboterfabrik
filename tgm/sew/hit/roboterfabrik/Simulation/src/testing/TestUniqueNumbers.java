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
	
	@Test
	public void addOneNumber()	{
		un.add();
		assertNotNull(un.getRandomNumbers()[0]);
	}
	
	@Test
	public void addMoreNumbers()	{
		un.add(10);
		for (int i = 0; i < 10; i++)	{
			assertNotNull(un.getRandomNumbers()[i]);
		}
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void addTooFewNumbers()	{
		un.add(0);
		assertNotNull(un.getRandomNumbers()[0]);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void addTooFewNumbers2()	{
		un.add(-100);
		assertNotNull(un.getRandomNumbers()[0]);
	}
	
	@Test
	public void addLotsOfNumbers()	{
		un.add(10000);
		for (int i = 0; i < 10000; i++)	{
			assertNotNull(un.getRandomNumbers()[i]);
		}
	}
}