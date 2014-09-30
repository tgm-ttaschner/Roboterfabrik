package build;

import org.apache.logging.log4j.*;

/**
 * 
 * The secretary hands out unique numbers for employees & robots.
 * 
 * @author Michael Weinberger 4AHITT
 * @version 2014-09-26
 *
 */
public class Secretary {

	Long[] randomnumbers;
	private int count;
	private int amount;
	private static final Logger log4j = LogManager.getLogger(Furnisher.class);
	
	/**
	 * 
	 * Creates a new Long[] array with a specific length filled with random, unique numbers.
	 * 
	 * @param anzahl
	 */
	public Secretary(int amount) {
		UniqueNumbers random = new UniqueNumbers();
		random.add(amount);
		randomnumbers = random.getRandomNumbers();
		this.amount = amount;
		count = 0;
	}

	/**
	 * 
	 * Returns a Long unique number from the pre-made array.
	 * 
	 * @return out A unique, random number.
	 */
	public Long getID() {
		log4j.error("ID requested");
		
		if (count < amount) {
			Long out =  randomnumbers[count];
			count++;
			
			return out;
		} else {
			return -1l;
		}
		
	}

}
