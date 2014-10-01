

import threading.WatchDog;
import build.*;

public class Simulation {
	public static void main(String[] args) {
		
		int laufzeit;
		CLI c = new CLI();
		Furnisher f = new Furnisher();
		IO io = new IO(IO.getWorkingDir());
		Secretary s = new Secretary(1);
		Storage st = new Storage();
		Assembler a = new Assembler(s,st);
		String s = "";
		WatchDog wd = new WatchDog(laufzeit);
		try {
			for (int i = 0; i < args.length; i++)	{
				s = s + args[i] + " ";
			}
			
			c.setArguments(s);
			if (c.getArguments().equals("help"))	{
				c.help();
			} else	{
				c.run(c.getArguments());
			}
			
			
			String lager = c.getLagerVerzeichnis();
			laufzeit = c.getLaufzeit();
			int lieferantenAnzhal = c.getLieferantenAnzahl();
			String verz = c.getLogVerzeichnis();
			int monteurAnzahl = c.getMonteurAnzahl();
			
			
		} catch (ArrayIndexOutOfBoundsException e)	{
			System.out.println("Um die Roboterfabrik zu starten, geben Sie bitte gültige Parameter an.");
			System.out.println("Für eine Erklärung der Parameter und wie ein gültiger Aufruf aussieht, geben Sie bitte 'help' ein.");
		}
	}
}