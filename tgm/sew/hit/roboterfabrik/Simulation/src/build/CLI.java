package build;

/**
 *
 * This class simulates a Console Line Interface (CLI).
 * The user is welcomed with a welcome message.
 * He also gets informed about the possibility to get some help via help in case he isn't familiar with the program.
 * The user's input is read from the console which results in a String to work with.
 * That String is checked for all neccessary arguments and it's parameters.
 * Finally an error message for each missing parameter and argument is returned.
 *
 *
 * @author Thomas Taschner
 * @version 29.09.2014
 *
 */
public class CLI {

	public static String lagerVerzeichnis;
	public static String logVerzeichnis;
	
	private String arguments;
	private String errors = "";

	private String[] argument = {"help","--lager", "--logs", "--lieferanten", "--monteure", "--laufzeit"};

	private int lieferantenAnzahl;
	private int monteurAnzahl;
	private int laufzeit;

	/**
	 * Constructor
	 */
	public CLI()	{
		
	}

	/**
	 * Contains welcome messages which are displayed after the CLI has started
	 */
	public void welcome()	{
		System.out.println("Herzlich Willkommen zur Roboterfabrik!");
		System.out.println("Um die Roboterfabrik zu starten, geben Sie bitte gültige Parameter an.");
		System.out.println("Für eine Erklärung der Parameter und wie ein gültiger Aufruf aussieht, geben Sie bitte 'help' ein.");
	}

	/**
	 * Contains help messages which are displayed when the user enters help
	 */
	public void help()	{
		System.out.println("\nEin gültiger Aufruf könnte sein (Leerzeichen am Ende beachten!):\n'(java tgm.sew.hit.roboterfabrik.Simulation) --lager storage/roboter --logs logs/roboterfabrik --lieferanten 12 --monteure 25 --laufzeit 10000 '\n");
		System.out.println("--lager: Lagerparameter\nWird gefolgt vom Verzeichnis zum Lager");
		System.out.println("--logs: Logparameter\nWird gefolgt vom Verzeichnis zu den Logs");
		System.out.println("--lieferanten: Lieferantenparameter\nWird gefolgt der Anzahl der Lieferanten in Furnisher");
		System.out.println("--monteure: Monteurparameter\nWird gefolgt von der Anzahl der Monteure Assembler");
		System.out.println("--laufzeit: Laufzeitparameter\nWird gefolgt von der Laufzeit in Millisekunden für den WatchDog");
		System.out.println("\nDie Reihenfolge, in der die Parameter angegeben werden, ist jedoch egal, wichtig ist, dass am Ende ein Leerzeichen vorhanden ist");
	}

	/**
	 * Run allows you to run the CLI.
	 * The user input is read and analyzed.
	 * If the user enters help help gets run otherwise each argument which is stored in a String array gets used for cutting out the corresponding parameter.
	 * The first index consists of: the index of the current argument + the argument's length.
	 * The second index consists of: the index of the first ocurring whitespace after the first index+1 (otherwise the second index would equal the first index).
	 * That's the reason why you have to add a whitespace character after the last argument's parameter.
	 * Finally the input gets checked and some error messages are displayed.
	 * 
	 * @param arguments The users input
	 */
	public void run(String arguments)	{
		
		String s = arguments;

		if (arguments.trim().equals("help"))	{
			this.help();
		} else	{

			for (int i = 0; i < argument.length; i++)	{

				try {
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
				} catch (StringIndexOutOfBoundsException e)	{

				} catch (NumberFormatException ex)	{

				}
			}

			this.check();
		}

	}

	/**
	 * Check allows you to check the user's input.
	 * You don't have to do it since it's already part of run().
	 * If the user input doesn't contain a specific argument or has a faulty parameter, an error message gets stored in errors which gets displayed afer all the checks.
	 */
	public void check()	{

		if (!arguments.trim().contains("--lager") || lagerVerzeichnis == null || lagerVerzeichnis.equals(""))	{
			errors = errors + "Geben Sie den Lagerparameter (--lager) und einen gültigen Pfad (z.B. lager/stuff) zum Lager\n";
		}

		if (!arguments.trim().contains("--logs") || logVerzeichnis == null || logVerzeichnis.equals(""))	{
			errors = errors + "Geben Sie den Logparameter (--logs) und einen gültigen Pfad (z.B. log/stuff) zum Logverzeichnis an\n";
		}

		if (!arguments.trim().contains("--lieferanten") || lieferantenAnzahl < 1)	{
			errors = errors + "Geben Sie den Lieferantenparameter (--lieferanten) und eine gültige Ganzzahl > 0 (z.B. 5) an\n";
		}

		if (!arguments.trim().contains("--monteure") || monteurAnzahl < 1)	{
			errors = errors + "Geben Sie den Monteurparameter (--monteure) und eine gültige Ganzzahl > 0 (z.B. 5) an\n";
		}

		if (!arguments.trim().contains("--laufzeit") || laufzeit < 1)	{
			errors = errors + "Geben Sie den Laufzeitparameter (--laufzeit) und eine gültige Ganzzahl > 0 (z.B. 5) an\n";

		}

		System.out.println(errors);
	}

	/**
	 * Getter for arguments
	 * @return arguments The user input
	 */
	public String getArguments() {
		return arguments;
	}

	/**
	 * Setter for arguments
	 * @param arguments The user input
	 */
	public void setArguments(String arguments) {
		this.arguments = arguments;
	}

	/**
	 * Getter for lagerVerzeichnis
	 * NOTE: Made static by Michael Weinberger for whatever reasons, not me!
	 * @return lagerVerzeichnis Path where the parts are stored
	 */
	public String getLagerVerzeichnis() {
		return lagerVerzeichnis;
	}

	/**
	 * Setter for lagerVerzeichnis
	 * NOTE: Made static by Michael Weinberger for whatever reasons, not me!
	 * @param lagerVerzeichnis Path where the parts are stored
	 */
	public void setLagerVerzeichnis(String lagerVerzeichnis) {
		CLI.lagerVerzeichnis = lagerVerzeichnis;
	}

	/**
	 * Getter for logVerzeichnis
	 * NOTE: Made static by Michael Weinberger for whatever reasons, not me!
	 * @return logVerzeichnis Path where the log files are stored
	 */
	public String getLogVerzeichnis() {
		return logVerzeichnis;
	}

	/**
	 * Setter for logVerzeichnis
	 * NOTE: Made static by Michael Weinberger for whatever reasons, not me!
	 * @param logVerzeichnis Path where the log files are stored
	 */
	public void setLogVerzeichnis(String logVerzeichnis) {
		CLI.logVerzeichnis = logVerzeichnis;
	}

	/**
	 * Getter for lieferantenAnzahl
	 * @return lieferantenAnzahl The amount of delivery guys (furnishers)
	 */
	public int getLieferantenAnzahl() {
		return lieferantenAnzahl;
	}

	/**
	 * Setter for lieferantenAnzahl
	 * @param lieferantenAnzahl The amount of delivery guys (furnishers)
	 */
	public void setLieferantenAnzahl(int lieferantenAnzahl) {
		this.lieferantenAnzahl = lieferantenAnzahl;
	}

	/**
	 * Getter for monteurAnzahl
	 * @return monteurAnzahl The amount of assemblers
	 */
	public int getMonteurAnzahl() {
		return monteurAnzahl;
	}

	/**
	 * Setter for monteurAnzahl
	 * @param monteurAnzahl The amount of assemblers
	 */
	public void setMonteurAnzahl(int monteurAnzahl) {
		this.monteurAnzahl = monteurAnzahl;
	}

	/**
	 * Getter for laufzeit
	 * @return laufzeit The time in milliseconds the WatchDog lets a thread run
	 */
	public int getLaufzeit() {
		return laufzeit;
	}

	/**
	 * Setter for laufzeit
	 * @param laufzeit The time in milliseconds the WatchDog lets a thread run
	 */
	public void setLaufzeit(int laufzeit) {
		this.laufzeit = laufzeit;
	}
}