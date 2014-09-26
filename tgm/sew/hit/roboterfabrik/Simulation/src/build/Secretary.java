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

	private int assemblerID;
	private int robotID;
	Long[] randomnumbers;
	private int count = 0;

	public void Secretary(int anzahl) {
		UniqueNumbers random = new UniqueNumbers();
		random.add(anzahl);
		Long[] output = random.getRandomNumbers();
	}

	public Long getAssemblerID() {
		Long out =  randomnumbers[count];
		count++;
		
		return out;
	}

	public Long getRobotID() {
		Long out =  randomnumbers[count];
		count++;
		
		return out;
	}

}
