package build;
import java.io.*;

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
	private String[] output;
	
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
			BufferedWriter buff = new BufferedWriter(new FileWriter(pathfile));
			for (int i = 0; i < sequence.length; i++) {
				buff.append(sequence[i]);
			}
			buff.close();
			return true;
			
		} catch (FileNotFoundException e) {
			System.out.println("Es ist ein schwerwiegender Fehler aufgetreten!\nFile nicht gefunden.");
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
	public String[] read() {
		try {
			String currline = "";
			BufferedReader buff = new BufferedReader(new FileReader(pathfile));
			while((currline = buff.readLine()) != null) {
				output = currline.split(",");
			}
			
			buff.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Es ist ein schwerwiegender Fehler aufgetreten!\nFile nicht gefunden.");
		} catch (IOException e) {
			System.out.println("Es ist ein schwerwiegender Fehler aufgetreten!\nIOException");
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
	
	/* --TEST CASES --
	public static void main(String[] args) {


		READ
		
		String teilname = "arm"; //Im Beispiel wird das Teil per Variable uebergeben.
		IO test = new IO(getWorkingDir() +"csv/" +teilname +".csv");
		System.out.println(test.pathfile);
		String[] out = test.read();
		for (int i = 0; i < out.length; i++) {
			System.out.println(out[i]);
		}
		
		System.out.println("----------------------");
		
		WRITE
		
		System.out.println(test.write("Testomatik im File"));
	}
	*/
}
