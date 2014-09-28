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
public class Furnisher implements Runnable {
	
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
		
		System.out.println(amountarm);
		System.out.println(amounteye);
		System.out.println(amounttorso);
		System.out.println(amountchaindrive);
		
		if (amountarm < 2100) {
			arm.overWrite("");
			for (int i = 0; i < 100; i++) {
				arm.writeRow("Arm," 
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
				arm.write("" +Furnisher.getNumber());
			}
		}
		
		if (amounteye < 2100) {
			eye.overWrite("");
			for (int i = 0; i < 100; i++) {
				eye.writeRow("Eye," 
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
				eye.write("" +Furnisher.getNumber());
			}
		}
		
		if (amounttorso < 2100) {
			torso.overWrite("");
			for (int i = 0; i < 100; i++) {
				torso.writeRow("Torso," 
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
				torso.write("" +Furnisher.getNumber());
			}
		}
		
		if (amountchaindrive < 2100) {
			chaindrive.overWrite("");
			for (int i = 0; i < 100; i++) {
				chaindrive.writeRow("Chaindrive," 
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
				chaindrive.write("" +Furnisher.getNumber());
			}
		}
	}
	
	public static int getNumber() {
		Random generator= new Random();
		return generator.nextInt(999);
	}
	
	public static void main(String[] args) {
		Thread t = new Thread(new Furnisher());
		CLI.lagerVerzeichnis = "/src/testing/IOplayground/csv";
		
		t.start();
	}

}
