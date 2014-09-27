package build;

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
	private String lagerVerzeichnis;
	private String logVerzeichnis;

	private int lieferantenAnzahl;
	private int monteurAnzahl;
	private int lagerMitarbeiterAnzahl;
	private int laufzeit;

	public CLI()	{
		
	}
	
	public void start(String arguments) throws NotEnoughArgumentsException	{
		
		this.arguments = arguments;

		if (arguments == null || arguments == "")	{
			throw new NullPointerException("Ihre Angabe darf nicht null oder leer sein!");
		}

		if (!(arguments.trim()).startsWith("java tgm.sew.hit.roboterfabrik.Simulation"))	{
			throw new IllegalArgumentException("Der Aufruf muss mit 'java tgm.sew.hit.roboterfabrik.Simulation' starten!");
		}

		if (!arguments.contains("--lager ") || lagerVerzeichnis == null || lagerVerzeichnis.equals(""))	{
			throw new IllegalArgumentException("Geben Sie den Lagerparameter (--lager) und einen gültigen Pfad (z.B. lager/stuff) zum Lager an");
		}
		
		if (!arguments.contains("--logs ") || logVerzeichnis == null || logVerzeichnis.equals(""))	{
			throw new IllegalArgumentException("Geben Sie den Logparameter (--logs) und einen gültigen Pfad (z.B. log/stuff) zum Logverzeichnis an");
		}
		
		if (!arguments.contains("--lieferanten ") || lieferantenAnzahl < 1)	{
			throw new IllegalArgumentException("Geben Sie den Lieferantenparameter (--lieferanten) und eine gültige Ganzzahl > 0 (z.B. 5) an");
		}

		/*
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Geben Sie etwas ein: ");
		String zeile = "";

		try {
			zeile = console.readLine();
		} catch (IOException e) {

		}

		System.out.println("Ihre Eingabe war: " + zeile);
		 */
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
		this.lagerVerzeichnis = lagerVerzeichnis;
	}

	public String getLogVerzeichnis() {
		return logVerzeichnis;
	}

	public void setLogVerzeichnis(String logVerzeichnis) {
		this.logVerzeichnis = logVerzeichnis;
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

	public static void main(String[] args) throws NotEnoughArgumentsException {
		CLI c = new CLI();
		c.setLagerVerzeichnis("a");
		c.start("java tgm.sew.hit.roboterfabrik.Simulation --lager "+ c.getLagerVerzeichnis() +" --logs "+ c.getLogVerzeichnis() +" --lieferanten "+ c.getLieferantenAnzahl() +" --monteure "+ c.getMonteurAnzahl() +" --laufzeit "+ c.getLaufzeit());
	}
}
