package build;

import java.util.*;

/**
 * 
 * 
 * 
 * @author Michael
 * @version 2014-09-28
 *
 */
public class Storage {
	
	public static final int ARM = 1;
	public static final int TORSO = 2;
	public static final int CHAINDRIVE = 3;
	public static final int EYE = 4;

	private IO file;
	private Iterator<String> it;
	private String[] output;
	private int count;
	
	public Storage() {
		
	}
	
	/**
	 * 
	 * Delivers one row (equals one part), stored in an array for better handling.
	 * 
	 * @param part
	 * @return
	 */
	public String[] deliver(int part) {
		
		switch(part) {
		
			case 1:
				output = new String[21];
				file = new IO(IO.getWorkingDir() + CLI.lagerVerzeichnis + "/arm.csv");
				it = file.read().iterator();
				
				count = 0;
				while (it.hasNext() == true && count < 21) {
					output[count] = it.next();
					count++;
				}
				
				file.overWrite("");
				
				while (it.hasNext() == true) {
					for (int i = 0; i < 20; i++) {
						file.writeRow(it.next() + ",");
					}
					file.writeRow(it.next());
					file.write("");
				}
				
				return output;
				
			case 2:
				output = new String[21];
				file = new IO(IO.getWorkingDir() + CLI.lagerVerzeichnis + "/torso.csv");
				it = file.read().iterator();
				
				count = 0;
				while (it.hasNext() == true && count < 21) {
					output[count] = it.next();
					count++;
				}
				
				file.overWrite("");
				
				while (it.hasNext() == true) {
					for (int i = 0; i < 20; i++) {
						file.writeRow(it.next() + ",");
					}
					file.writeRow(it.next());
					file.write("");
				}
				
				return output;
				
			case 3:
				output = new String[21];
				file = new IO(IO.getWorkingDir() + CLI.lagerVerzeichnis + "/chaindrive.csv");
				it = file.read().iterator();
				
				count = 0;
				while (it.hasNext() == true && count < 21) {
					output[count] = it.next();
					count++;
				}
				
				file.overWrite("");
				
				while (it.hasNext() == true) {
					for (int i = 0; i < 20; i++) {
						file.writeRow(it.next() + ",");
					}
					file.writeRow(it.next());
					file.write("");
				}
				
				return output;
				
			case 4:
				output = new String[21];
				file = new IO(IO.getWorkingDir() + CLI.lagerVerzeichnis + "/eye.csv");
				it = file.read().iterator();
				
				count = 0;
				while (it.hasNext() == true && count < 21) {
					output[count] = it.next();
					count++;
				}
				
				file.overWrite("");
				
				while (it.hasNext() == true) {
					for (int i = 0; i < 20; i++) {
						file.writeRow(it.next() + ",");
					}
					file.writeRow(it.next());
					file.write("");
				}
				
				return output;
				
		}
		
		return null;
	}
}
