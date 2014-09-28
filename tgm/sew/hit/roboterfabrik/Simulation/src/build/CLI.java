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
	private String error = "";

	private String[] argument = {"help","--lager", "--logs", "--lieferanten", "--monteure", "--laufzeit"};

	private int lieferantenAnzahl;
	private int monteurAnzahl;
	private int laufzeit;

	public CLI()	{

	}

	public void welcome()	{
		System.out.println("Herzlich Willkommen zur Roboterfabrik!");
		System.out.println("Um die Roboterfabrik zu starten, geben Sie bitte gültige Parameter an.");
		System.out.println("Für eine Erklärung der Parameter und wie ein gültiger Aufruf aussieht, geben Sie bitte 'help' ein.");
	}

	public void help()	{
		System.out.println("\nEin gültiger Aufruf könnte sein:\n'java tgm.sew.hit.roboterfabrik.Simulation --lager storage/roboter --logs logs/roboterfabrik --lieferanten 12 --monteure 25 --laufzeit 10000 '\n");
		System.out.println("--lager: Lagerparameter\nWird gefolgt vom Verzeichnis zum Lager");
		System.out.println("--logs: Logparameter\nWird gefolgt vom Verzeichnis zu den Logs");
		System.out.println("--lieferanten: Lieferantenparameter\nWird gefolgt der Anzahl der Lieferanten in Furnisher");
		System.out.println("--monteure: Monteurparameter\nWird gefolgt von der Anzahl der Monteure Assembler");
		System.out.println("--laufzeit: Laufzeitparameter\nWird gefolgt von der Laufzeit in Millisekunden für den WatchDog");
		System.out.println("\nDie Reihenfolge, in der die Parameter angegeben werden, ist jedoch egal, wichtig ist, dass am Ende ein Leerzeichen vorhanden ist");
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

	public void check(String arguments)	{

		this.arguments = arguments;


		if (!(arguments.trim()).startsWith("java tgm.sew.hit.roboterfabrik.Simulation"))	{
			error = error + "Der Aufruf muss mit 'java tgm.sew.hit.roboterfabrik.Simulation' starten\n";
		}

		if (!arguments.trim().contains("--lager") || lagerVerzeichnis == null || lagerVerzeichnis.equals(""))	{
			error = error + "Geben Sie den Lagerparameter (--lager) und einen gültigen Pfad (z.B. lager/stuff) zum Lager\n";
		}

		if (!arguments.trim().contains("--logs") || logVerzeichnis == null || logVerzeichnis.equals(""))	{
			error = error + "Geben Sie den Logparameter (--logs) und einen gültigen Pfad (z.B. log/stuff) zum Logverzeichnis an\n";
		}

		if (!arguments.trim().contains("--lieferanten") || lieferantenAnzahl < 1)	{
			error = error + "Geben Sie den Lieferantenparameter (--lieferanten) und eine gültige Ganzzahl > 0 (z.B. 5) an\n";
		}

		if (!arguments.trim().contains("--monteure") || monteurAnzahl < 1)	{
			error = error + "Geben Sie den Monteurparameter (--monteure) und eine gültige Ganzzahl > 0 (z.B. 5) an\n";
		}

		if (!arguments.trim().contains("--laufzeit") || laufzeit < 1)	{
			error = error + "Geben Sie den Laufzeitparameter (--laufzeit) und eine gültige Ganzzahl > 0 (z.B. 5) an\n";
			
		}
		
		System.out.println(error);
	}

	public void run()	{

		String s = this.read();

		for (int i = 0; i < argument.length; i++)	{

			if (arguments.trim().equals("help"))	{
				this.help();
				System.exit(0);
			} else	{
				try {

				} catch (StringIndexOutOfBoundsException e)	{
					switch(argument[i])	{

					case "--lager":
						this.setLagerVerzeichnis(s.substring(s.indexOf(argument[i]) + argument[i].length(), s.indexOf(" ", s.indexOf(argument[i]) + argument[i].length()+1)).trim());
						break;

					case "--logs":
						this.setLogVerzeichnis(s.substring(s.indexOf(argument[i]) + argument[i].length(), s.indexOf(" ", s.indexOf(argument[i]) + argument[i].length()+1)).trim());
						break;

					case "--lieferanten":
						this.setLieferantenAnzahl(Integer.parseInt(s.substring(s.indexOf(argument[i]) + argument[i].length(), s.indexOf(" ", s.indexOf(argument[i]) + argument[i].length()+1)).trim()));
						break;

					case "--monteure":
						this.setMonteurAnzahl(Integer.parseInt(s.substring(s.indexOf(argument[i]) + argument[i].length(), s.indexOf(" ", s.indexOf(argument[i]) + argument[i].length()+1)).trim()));
						break;

					case "--laufzeit":
						this.setLaufzeit(Integer.parseInt(s.substring(s.indexOf(argument[i]) + argument[i].length(), s.indexOf(" ", s.indexOf(argument[i]) + argument[i].length()+1)).trim()));
						break;
					}
				}
			}
		}

		this.check(s);
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

	public int getLaufzeit() {
		return laufzeit;
	}

	public void setLaufzeit(int laufzeit) {
		this.laufzeit = laufzeit;
	}

	public static void main(String[] args) {
		CLI c = new CLI();

		c.welcome();
		c.run();

		if (!IO.checkDir())	{
			System.out.println("Fail!");
		}
	}
}