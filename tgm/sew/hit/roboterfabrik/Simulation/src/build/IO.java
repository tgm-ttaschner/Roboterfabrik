package build;
import java.io.*;

/**
 * 
 * Mithilfe dieser Klasse soll das Lesen/Schreiben der CSV-Files vereinfacht werden.
 * Pro entsprechendem File wird ein IO-Objekt erzeugt, dass dann übersichtlich mit z.B. "armfile.write()" verwendet werden kann.
 * 
 * @author Michael Weinberger 4AHITT
 * @version 2014-09-18
 *
 */
public class IO {
	private String pathfile;
	private String[] output;
	
	public IO(String path) {
		this.pathfile = path;
	}
	
	public boolean write(String value) {
		File f = new File(pathfile);
		
		try {
			FileWriter writer = new FileWriter(f, true);
			writer.write(System.getProperty("line.separator"));
			 writer.write(value);
			return true;
		} catch(IOException e) {
			return false;
		}
	}
	
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
	
	public static String getWorkingDir() {
		String absolutepath = new File("").getAbsolutePath();
		absolutepath = absolutepath.replace("\\", "/");
		String ready = absolutepath +"/tgm/sew/hit/roboterfabrik/Simulation/";
		return ready;
	}
	
	public static void main(String[] args) {
		/*
		 * Testfall Lesen
		 */
		
		String teilname = "arm"; //Im Beispiel wird das Teil per Variable uebergeben.
		IO test = new IO(getWorkingDir() +"csv/" +teilname +".csv");
		System.out.println(test.pathfile);
		String[] out = test.read();
		for (int i = 0; i < out.length; i++) {
			System.out.println(out[i]);
		}
		
		System.out.println("-----------Trennstrich-----------");
		
		/*
		 * Testfall Schreiben
		 */
		
		System.out.println(test.write("Testomatik im File"));
	}
}
