package build;

import java.util.*;

import org.apache.logging.log4j.*;

/**
 * 
 * The storage provides parts for the assembler.
 * The assembler requests one part each, due to faster handling.
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
	
	private static final Logger log4j = LogManager.getLogger(Furnisher.class);
	
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
				
				log4j.error("arm delivered");
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
				
				log4j.error("torso delivered");
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
				
				log4j.error("chaindrive delivered");
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
				
				log4j.error("eye delivered");
				return output;
				
		}
		
		return null;
	}
}
