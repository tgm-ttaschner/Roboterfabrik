package build;

import java.util.*;

/**
 * 
 * This class generates random numbers which are unique (cannot be generated twice).
 * Possible values are 0-2^63-1.
 * Values are stored in a HashSet which disallows duplicate entries to be stored.
 * 
 * @author Thomas Taschner
 * @version 27.09.2014
 *
 */
public class UniqueNumbers {

	private HashSet<Long> hs;
	private Iterator<Long> iterator;

	/**
	 * The constructor for UniqueNumbers.
	 * It initializes the HashSet.
	 */
	public UniqueNumbers()	{
		hs = new HashSet<Long>();
	}

	/**
	 * Adds one random number to the HashSet.
	 * The number gets multiplied by -1 if it is smaller than 0.
	 * Finally the HashSet with the new number gets returned.
	 */
	public void add()	{

		long random = new Random().nextLong();

		if (random < 0)	{
			random = random*(-1);
		}

		hs.add(random);
	}

	/**
	 * @param count Counter which allows you to set the amount of UniqueNumbers you need
	 * @throws IllegalArgumentException is thrown if count is smaller than 1
	 * Works like add() except you can specify how many numbers you need.
	 */
	public void add(int count)	{

		if (count < 1)	{
			throw new IllegalArgumentException("Geben Sie eine Zahl > 0 an");
		}

		for (int i = 0; i < count; i++)	{
			this.add();
		}
	}

	/**
	 * @return Returns a long Array containing unique random numbers
	 * An Iterator iterates over the HashSet.
	 * Every value returned by the Iterator is stored in a long Array which then gets returned.
	 */
	public Long[] getRandomNumbers()	{
		iterator = hs.iterator();
		Long[] ausg = new Long[hs.size()];
		int i = 0;

		while (iterator.hasNext())	{
			ausg[i] = (Long) iterator.next();
			i++;
		}
		return ausg;
	}
}