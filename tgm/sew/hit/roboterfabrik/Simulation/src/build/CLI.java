package build;
import java.io.*;
/**
 *
 * This class simulates a Console Line Interface (CLI).
 *
 *
 * @author Thomas Taschner
 * @version 27.09.2014
 *
 */
public class CLI {

	private String arguments;
	public static String lagerVerzeichnis;
	public static String logVerzeichnis;

	private static String[] argument = {"--lager","--logs","--lieferanten","--monteure","--laufzeit"};

	private int lieferantenAnzahl;
	private int monteurAnzahl;
	private int lagerMitarbeiterAnzahl;
	private int laufzeit;

	public CLI()	{

	}

	public void welcome()	{
		System.out.println("Herzlich Willkommen zur Roboterfabrik!");
		System.out.println("Um die Roboterfabrik zu starten, geben Sie bitte gültige Parameter an.");
		System.out.println("Für eine Erklärung der Parameter und wie ein gültiger Aufruf aussieht, geben Sie bitte 'help' ein.");
	}

	public String read()	{

		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		System.out.println();

		try {
			arguments = console.readLine();
		} catch (IOException e) {

		}

		return arguments;
	}

	public void check(String arguments) throws NotEnoughArgumentsException	{

		this.arguments = arguments;

		if (arguments == null || arguments == "")	{
			throw new NullPointerException("Ihre Angabe darf nicht null oder leer sein!");
		}

		if (arguments.trim().equals("help"))	{
			this.help();
		} else	{

			if (!(arguments.trim()).startsWith("java tgm.sew.hit.roboterfabrik.Simulation"))	{
				//throw new IllegalArgumentException("Der Aufruf muss mit 'java tgm.sew.hit.roboterfabrik.Simulation' starten!");
				System.out.println("Der Aufruf muss mit 'java tgm.sew.hit.roboterfabrik.Simulation' starten!");
			} else {

				if (!arguments.trim().contains("--lager") || lagerVerzeichnis == null || lagerVerzeichnis.equals("") || lagerMitarbeiterAnzahl < 1)	{
					//throw new IllegalArgumentException("Geben Sie den Lagerparameter (--lager ), einen gültigen Pfad (z.B. lager/stuff) zum Lager  und eine gültige Ganzzahl > 0 (z.B. 5) an");
					System.out.println("Geben Sie den Lagerparameter (--lager), einen gültigen Pfad (z.B. lager/stuff) zum Lager und eine gültige Ganzzahl > 0 (z.B. 5) an");
				} else {

					if (!arguments.trim().contains("--logs ") || logVerzeichnis == null || logVerzeichnis.equals(""))	{
						//throw new IllegalArgumentException("Geben Sie den Logparameter (--logs ) und einen gültigen Pfad (z.B. log/stuff) zum Logverzeichnis an");
						System.out.println("Geben Sie den Logparameter (--logs) und einen gültigen Pfad (z.B. log/stuff) zum Logverzeichnis an");
					} else {

						if (!arguments.trim().contains("--lieferanten") || lieferantenAnzahl < 1)	{
							//throw new IllegalArgumentException("Geben Sie den Lieferantenparameter (--lieferanten ) und eine gültige Ganzzahl > 0 (z.B. 5) an");
							System.out.println("Geben Sie den Lieferantenparameter (--lieferanten) und eine gültige Ganzzahl > 0 (z.B. 5) an");
						} else {

							if (!arguments.trim().contains("--monteure") || monteurAnzahl < 1)	{
								//throw new IllegalArgumentException("Geben Sie den Monteurparameter (--monteure ) und eine gültige Ganzzahl > 0 (z.B. 5) an");
								System.out.println("Geben Sie den Monteurparameter (--monteure) und eine gültige Ganzzahl > 0 (z.B. 5) an");
							} else {

								if (!arguments.trim().contains("--laufzeit") || laufzeit < 1)	{
									//throw new IllegalArgumentException("Geben Sie den Laufzeitparameter (--laufzeit ) und eine gültige Ganzzahl > 0 (z.B. 5) an");
									System.out.println("Geben Sie den Laufzeitparameter (--laufzeit) und eine gültige Ganzzahl > 0 (z.B. 5) an");
								}
							}
						}
					}
				}
			}
		}
	}

	public String getArguments() {
		return arguments;
	}

	public void setArguments(String arguments) {
		this.arguments = arguments;
	}

	public String getLagerVerzeichnis() {
		return lagerVerzeichnis;
	}

	public void setLagerVerzeichnis(String lagerVerzeichnis) {
		CLI.lagerVerzeichnis = lagerVerzeichnis;
	}

	public String getLogVerzeichnis() {
		return logVerzeichnis;
	}

	public void setLogVerzeichnis(String logVerzeichnis) {
		CLI.logVerzeichnis = logVerzeichnis;
	}

	public int getLieferantenAnzahl() {
		return lieferantenAnzahl;
	}

	public void setLieferantenAnzahl(int lieferantenAnzahl) {
		this.lieferantenAnzahl = lieferantenAnzahl;
	}

	public int getMonteurAnzahl() {
		return monteurAnzahl;
	}

	public void setMonteurAnzahl(int monteurAnzahl) {
		this.monteurAnzahl = monteurAnzahl;
	}

	public int getLagerMitarbeiterAnzahl() {
		return lagerMitarbeiterAnzahl;
	}

	public void setLagerMitarbeiterAnzahl(int lagerMitarbeiterAnzahl) {
		this.lagerMitarbeiterAnzahl = lagerMitarbeiterAnzahl;
	}

	public int getLaufzeit() {
		return laufzeit;
	}

	public void setLaufzeit(int laufzeit) {
		this.laufzeit = laufzeit;
	}


	public void help()	{
		System.out.println("\nEin gültiger Aufruf könnte sein:\n'java tgm.sew.hit.roboterfabrik.Simulation --lager storage/roboter 10 --logs logs/roboterfabrik --lieferanten 12 --monteure 25 --laufzeit 10000'");
		System.out.println("\nDie Reihenfolge, in der die Parameter angegeben werden, ist jedoch egal");
	}

	public static void main(String[] args) {
		CLI c = new CLI();

		c.welcome();

		String s = c.read();
		for (int i = 0; i < argument.length; i++)	{
			/*
			if (argument[i].equals("--lager"))	{
				String s1 = s.substring(s.indexOf(argument[i]) + argument[i].length(), s.indexOf(" ", s.indexOf(argument[i]) + argument[i].length()+1)).trim();
				c.setLagerMitarbeiterAnzahl(Integer.parseInt(s.substring(s.indexOf(s1) + s1.length(), s.indexOf(" ", s.indexOf(s1) + s1.length()+1)).trim()));
				c.setLagerVerzeichnis(s1);
				System.out.println("Argument: " + argument[i] + "\nParameter 1: " + s1 + "\nParameter 2: " + c.getLagerMitarbeiterAnzahl() + "\n");
			} else	{
				System.out.println("Argument: " + argument[i] + "\nParameter: " + s.substring(s.indexOf(argument[i]) + argument[i].length(), s.indexOf(" ", s.indexOf(argument[i]) + argument[i].length()+1)).trim() + "\n");
			}
			*/


			switch(argument[i])	{
			
			case "--lager":
				String s1 = s.substring(s.indexOf(argument[i]) + argument[i].length(), s.indexOf(" ", s.indexOf(argument[i]) + argument[i].length()+1)).trim();
				c.setLagerMitarbeiterAnzahl(Integer.parseInt(s.substring(s.indexOf(s1) + s1.length(), s.indexOf(" ", s.indexOf(s1) + s1.length()+1)).trim()));
				c.setLagerVerzeichnis(s1);
				System.out.println("Argument: " + argument[i] + "\nParameter 1: " + s1 + "\nParameter 2: " + c.getLagerMitarbeiterAnzahl() + "\n");
				break;
				
			case "--logs":
				c.setLogVerzeichnis(s.substring(s.indexOf(argument[i]) + argument[i].length(), s.indexOf(" ", s.indexOf(argument[i]) + argument[i].length()+1)).trim());
				System.out.println("Argument: " + argument[i] + "\nParameter: " + c.getLogVerzeichnis() + "\n");
				break;
				
			case "--lieferanten":
				c.setLieferantenAnzahl(Integer.parseInt(s.substring(s.indexOf(argument[i]) + argument[i].length(), s.indexOf(" ", s.indexOf(argument[i]) + argument[i].length()+1)).trim()));
				System.out.println("Argument: " + argument[i] + "\nParameter: " + c.getLieferantenAnzahl() + "\n");
				break;
				
			case "--monteure":
				c.setMonteurAnzahl(Integer.parseInt(s.substring(s.indexOf(argument[i]) + argument[i].length(), s.indexOf(" ", s.indexOf(argument[i]) + argument[i].length()+1)).trim()));
				System.out.println("Argument: " + argument[i] + "\nParameter: " + c.getMonteurAnzahl() + "\n");
				break;
				
			case "--laufzeit":
				c.setLaufzeit(Integer.parseInt(s.substring(s.indexOf(argument[i]) + argument[i].length(), s.indexOf(" ", s.indexOf(argument[i]) + argument[i].length()+1)).trim()));
				System.out.println("Argument: " + argument[i] + "\nParameter: " + c.getLaufzeit() + "\n");
				break;
			}
		}

		//c.start("java tgm.sew.hit.roboterfabrik.Simulation --help --lager "+ c.getLagerVerzeichnis() +" --logs "+ c.getLogVerzeichnis() +" --lieferanten "+ c.getLieferantenAnzahl() +" --monteure "+ c.getMonteurAnzahl() +" --laufzeit "+ c.getLaufzeit());
		try {
			c.check(s);
		} catch (NotEnoughArgumentsException e) {

		}
	}
}