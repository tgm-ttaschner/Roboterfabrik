package build;

/**
 * 
 * Secretary
 * 
 * @author Michael Weinberger
 * @version 2014-09-26
 *
 */
public class Secretary {

	Long[] randomnumbers;
	private int count;
	private int anzahl;

	public Secretary(int anzahl) {
		UniqueNumbers random = new UniqueNumbers();
		random.add(anzahl);
		randomnumbers = random.getRandomNumbers();
		this.anzahl = anzahl;
		count = 0;
	}

	public Long getID() {
		Long out =  randomnumbers[count];
		count++;
		
		return out;
	}

}
