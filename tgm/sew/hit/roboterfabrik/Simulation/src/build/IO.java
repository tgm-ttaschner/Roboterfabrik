package build;

import java.io.*;
import java.util.*;

/**
 * 
 * This class should simplify the read/write-process of the csv-files.
 * Per file, one IO object has to be generated, so it could be handled easily like 'armfile.write()'.
 * 
 * @author Michael Weinberger 4AHITT
 * @version 2014-09-18
 *
 */
public class IO {
	private String pathfile;
	
	/**
	 * IMPORTANT NOTICE: When initializing an IO object, use the 'getWorkingDir()' method from below first, then enter the user-input directory.
	 * Looks like this: IO showcase = new IO(getWorkingDir() +userinput +"eye.csv");
	 * 
	 * @param path Where the .csv-files are stored.
	 */
	public IO(String path) {
		this.pathfile = path;
	}
	
	/**
	 * 
	 * Writes a String value into a file on the HDD.
	 * Here, it is used to store robots in the storage.
	 * 
	 * @param value A char sequence, which should be written.
	 * @return true in case of success, otherwise false.
	 */
	public boolean write(String value) {
		try {
			char[] sequence = value.toCharArray();
			BufferedWriter buff = new BufferedWriter(new FileWriter(pathfile, true));
			for (int i = 0; i < sequence.length; i++) {
				buff.append(sequence[i]);
			}
			buff.append('\n');
			buff.close();
			return true;
			
		} catch (IOException e) {
			System.out.println("Es ist ein schwerwiegender Fehler aufgetreten!\nIOException");
		}
		
		return false;
	}
	
	/**
	 * 
	 * Reads a file from the HDD and wraps it up into a String array.
	 * Here it is used to get robots out of the storage.
	 * 
	 * @return output The String array with every line of text from the file in it.
	 */
	public ArrayList<String> read() {
		ArrayList<String> output = new ArrayList<String>();
		String[] temp;
		
		try {
			String currline = "";
			BufferedReader buff = new BufferedReader(new FileReader(pathfile));
			while((currline = buff.readLine()) != null) {
				temp = currline.split(",");
				
				Collections.addAll(output, temp);
			}
			
			buff.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Fatal Error!\nFile not found.");
		} catch (IOException e) {
			System.out.println("Fatal Error!\nIOException");
		}
		
		return output;
	}
	
	/**
	 * 
	 * So we actually know, that this code NEVER runs on the exact same system, under perfect circumstances.
	 * This method returns the actual directory, where the executed code was started.
	 * 
	 * @return ready The entire file path.
	 */
	public static String getWorkingDir() {
		String absolutepath = new File("").getAbsolutePath();
		absolutepath = absolutepath.replace("\\", "/");
		String ready = absolutepath +"/tgm/sew/hit/roboterfabrik/Simulation/";
		return ready;
	}
	
	/**
	 * 
	 * Checks if the directory, which the user entered is existent, otherwise it will be created. Empty csv-files will be created in the directory.
	 * 
	 * IMPORTANT NOTICE: Use the 'getWorkingDir()' method first, then enter the user-input directory. 	IO.check(getWorkingDir() +userinput);
	 * 
	 */
	public static void Check(String path) {
		File f = new File(path);
		boolean dir = f.isDirectory();
		
		if (dir == true) {
			System.out.println("Directory found. Robot Factory is booting....");
		} else {
			System.out.println("Directory not found, mkdir in progress...");
			f.mkdir();
		}
		
		try {
			BufferedWriter eye = new BufferedWriter(new FileWriter(path+"/eye.csv"));
			eye.write("");
			eye.close();
			
			BufferedWriter torso = new BufferedWriter(new FileWriter(path+"/torso.csv"));
			torso.write("");
			torso.close();
			
			BufferedWriter arm = new BufferedWriter(new FileWriter(path+"/arm.csv"));
			arm.write("");
			arm.close();
			
			BufferedWriter chaindrive = new BufferedWriter(new FileWriter(path+"/chaindrive.csv"));
			chaindrive.write("");
			chaindrive.close();
			
		} catch (IOException e) {
			
		}
	}
	
	/* --TEST CASES --*/
	public static void main(String[] args) {
		
		IO.Check(getWorkingDir() +"csv/");
		//WRITE
		String teilname = "arm"; //Im Beispiel wird das Teil per Variable uebergeben.
		IO test = new IO(getWorkingDir() +"csv/" +teilname +".csv");
		System.out.println(test.write("auge,1,2,3,4,5,6,7,8,9,10"));
		System.out.println(test.write("auge,11,12,13,14,15,16,17,18,19,20"));
		System.out.println(test.write("auge,21,22,23,24,25,26,27,28,29,30"));
		
		System.out.println("----------------------");

		//READ
		
		ArrayList<String> out = test.read();
		
		Iterator<String> it = out.iterator();
		
		while (it.hasNext()) {
			System.out.println(it.next());
		}		
	}

}
