package build;

import java.io.*;
import java.util.*;

import org.apache.logging.log4j.*;

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
	private static final Logger log4j = LogManager.getLogger(Furnisher.class);
	
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
		log4j.error("Attempt to write.");
		
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
			System.out.println("Fatal Error!\nIOException");
		} catch (NullPointerException e) {
		System.out.println("Fatal Error!\nNullPointerException");
		}
		
		return false;
	}
	
	/**
	 * 
	 * Writes a String value into a file on the HDD, with no line breaks.
	 * Here, it is used to store robots in the storage.
	 * 
	 * @param value A char sequence, which should be written.
	 * @return true in case of success, otherwise false.
	 */
	public boolean writeRow(String value) {
		log4j.error("Attempt to write a single row.");
		
		try {
			char[] sequence = value.toCharArray();
			BufferedWriter buff = new BufferedWriter(new FileWriter(pathfile, true));
			for (int i = 0; i < sequence.length; i++) {
				buff.append(sequence[i]);
			}
			buff.close();
			return true;
			
		} catch (IOException e) {
			System.out.println("Fatal Error!\nIOException");
		} catch (NullPointerException e) {
		System.out.println("Fatal Error!\nNullPointerException");
		}
		
		return false;
	}
	
	/**
	 * 
	 * Writes a String value into a blank file on the HDD.
	 * Here, it is used to store robots in the storage.
	 * 
	 * @param value A char sequence, which should be written.
	 * @return true in case of success, otherwise false.
	 */
	public boolean overWrite(String value) {
		log4j.error("Attempt to overwrite.");
		
		try {
			char[] sequence = value.toCharArray();
			BufferedWriter buff = new BufferedWriter(new FileWriter(pathfile));
			for (int i = 0; i < sequence.length; i++) {
				buff.append(sequence[i]);
			}
			buff.close();
			return true;
			
		} catch (IOException e) {
			System.out.println("Fatal Error!\nIOException");
		} catch (NullPointerException e) {
		System.out.println("Fatal Error!\nNullPointerException");
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
		log4j.error("Attempt to read.");
		
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
	 * Empty csv-files will be created in the directory.
	 * 
	 * 
	 */
	public static void CheckFiles() {
		log4j.error("Check Files ...");
		
		String path = getWorkingDir() + CLI.lagerVerzeichnis;
		
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
			System.out.println("Fatal Error!\nIOException");
		}
	}
	
	/**
	 * 
	 * Checks if the directory, which the user entered is existent, otherwise it will be created. 
	 * 
	 * 
	 * @param path The entered filepath.
	 */
	public static boolean checkDir() {
		log4j.error("Check Directory ...");
		
		String path = getWorkingDir() + CLI.lagerVerzeichnis;
		File f = new File(path);
		boolean dir = f.isDirectory();
		
		if (dir == true) {
			System.out.println("Directory found. Robot Factory is booting....");
			return true;
		} else {
			System.out.println("Directory not found, mkdir in progress...");
			f.mkdir();
			return false;
		}
	}

}
