package storage.io;
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
	final String pathfile;
	private String[] output;
	
	public IO(String path) {
		this.pathfile = path;
	}
	
	public boolean write(String value) {
		return true;
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
}
