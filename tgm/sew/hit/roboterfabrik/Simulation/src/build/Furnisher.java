package build;

import java.util.*;
import org.apache.logging.log4j.*;

import build.IO;

/**
 * 
 * The this checks, if invoked, the inventory of the csv-files.
 * 
 * @author Michael Weinberger 4AHITT
 * @version 2014-09-28
 *
 */
public class Furnisher implements Runnable {
	
	private boolean running;
	private static final Logger log4j = LogManager.getLogger(Furnisher.class);
	
	/**
	 * This code should be executed by a thread.
	 */
	public void run() {
		IO arm = new IO(IO.getWorkingDir() +CLI.lagerVerzeichnis +"/arm.csv");
		IO eye = new IO(IO.getWorkingDir() +CLI.lagerVerzeichnis +"/eye.csv");
		IO torso = new IO(IO.getWorkingDir() +CLI.lagerVerzeichnis +"/torso.csv");
		IO chaindrive = new IO(IO.getWorkingDir() +CLI.lagerVerzeichnis +"/chaindrive.csv");
		
		ArrayList<String> alarm = arm.read();
		ArrayList<String> aleye = eye.read();
		ArrayList<String> altor = torso.read();
		ArrayList<String> alcha = chaindrive.read();
		
		int amountarm = alarm.size();
		int amounteye = aleye.size();
		int amounttorso = altor.size();
		int amountchaindrive = alcha.size();
		
		if (amountarm < 2100) {
			arm.overWrite("");
			for (int i = 0; i < 100; i++) {
				arm.writeRow(this.OneRow(Storage.ARM));
				arm.write("" +this.getNumber());
			}
		}
		
		if (amounteye < 2100) {
			eye.overWrite("");
			for (int i = 0; i < 100; i++) {
				eye.writeRow(this.OneRow(Storage.EYE));
				eye.write("" +this.getNumber());
			}
		}
		
		if (amounttorso < 2100) {
			torso.overWrite("");
			for (int i = 0; i < 100; i++) {
				torso.writeRow(this.OneRow(Storage.TORSO));
				torso.write("" +this.getNumber());
			}
		}
		
		if (amountchaindrive < 2100) {
			chaindrive.overWrite("");
			for (int i = 0; i < 100; i++) {
				chaindrive.writeRow(this.OneRow(Storage.CHAINDRIVE));
				chaindrive.write("" +this.getNumber());
			}
		}
	}
	
	public int getNumber() {
		Random generator= new Random();
		return generator.nextInt(999);
	}
	
	public String OneRow(int part) {
		String out = "";
		
		switch(part) {
			case 1:
				out = out +"Arm,";
				
				for (int i = 0; i < 19; i++) {
					out = out + this.getNumber() +",";
				}
				
				log4j.error("One arm row was written to the file.");
				return out;
				
			case 2:
				out = out +"Torso,";
				
				for (int i = 0; i < 19; i++) {
					out = out + this.getNumber() +",";
				}
				
				log4j.error("One torso row was written to the file.");
				return out;
				
			case 3:
				out = out +"Chaindrive,";
				
				for (int i = 0; i < 19; i++) {
					out = out + this.getNumber() +",";
				}
				
				log4j.error("One chaindrive row was written to the file.");
				return out;
				
			case 4:
				out = out +"Eye,";
				
				for (int i = 0; i < 19; i++) {
					out = out + this.getNumber() +",";
				}
				
				log4j.error("One eye row was written to the file.");
				return out;
			
		}
		return null;
	}

}
