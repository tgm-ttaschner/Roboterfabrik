package build;

import java.util.*;

import build.IO;

/**
 * 
 * The furnisher checks, if invoked, the inventory of the csv-files.
 * 
 * @author Michael Weinberger 4AHITT
 * @version 2014-09-28
 *
 */
public class Furnisher {
	
	/**
	 * This code should be executed by a thread.
	 */
	public static void run() {
		IO arm = new IO(IO.getWorkingDir() +CLI.lagerVerzeichnis +"/arm.csv");
		IO eye = new IO(IO.getWorkingDir() +CLI.lagerVerzeichnis +"/eye.csv");
		IO torso = new IO(IO.getWorkingDir() +CLI.lagerVerzeichnis +"/torso.csv");
		IO chaindrive = new IO(IO.getWorkingDir() +CLI.lagerVerzeichnis +"/chaindrive.csv");
		
		ArrayList<String> alarm = arm.read();
		ArrayList<String> aleye = eye.read();
		ArrayList<String> altor = torso.read();
		ArrayList<String> alcha = chaindrive.read();
		
		int amountarm = alarm.size();
		int amounteye = alarm.size();
		int amounttorso = alarm.size();
		int amountchaindrive = alarm.size();
		
		if (amountarm < 210) {
			arm.overWrite("");
			for (int i = 0; i < 100; i++) {
				arm.write("Arm," 
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
						);
			}
		}
		
		if (amounteye < 210) {
			eye.overWrite("");
			for (int i = 0; i < 100; i++) {
				eye.write("Eye," 
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
						);
			}
		}
		
		if (amounttorso < 210) {
			torso.overWrite("");
			for (int i = 0; i < 100; i++) {
				torso.write("Torso," 
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
							+Furnisher.getNumber() +","
						);
			}
		}
		
		if (amountchaindrive < 210) {
			chaindrive.overWrite("");
			chaindrive.write("Chaindrive," 
						+Furnisher.getNumber() +","
						+Furnisher.getNumber() +","
						+Furnisher.getNumber() +","
						+Furnisher.getNumber() +","
						+Furnisher.getNumber() +","
						+Furnisher.getNumber() +","
						+Furnisher.getNumber() +","
						+Furnisher.getNumber() +","
						+Furnisher.getNumber() +","
						+Furnisher.getNumber() +","
						+Furnisher.getNumber() +","
						+Furnisher.getNumber() +","
						+Furnisher.getNumber() +","
						+Furnisher.getNumber() +","
						+Furnisher.getNumber() +","
						+Furnisher.getNumber() +","
						+Furnisher.getNumber() +","
						+Furnisher.getNumber() +","
						+Furnisher.getNumber() +","
						+Furnisher.getNumber() +","
						);
		}
	}
	
	public static int getNumber() {
		Random generator= new Random();
		return generator.nextInt(100);
	}

}
