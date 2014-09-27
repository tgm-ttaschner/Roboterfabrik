package build;

import java.io.*;

public class CLI {

	private String arguments;

	private String lagerVerzeichnis;

	private String logVerzeichnis;

	private int lieferantenAnzahl;

	private int monteurAnzahl;

	private int lagerMitarbeiterAnzahl;

	private int laufzeit;

	private int countargs = 0;

	public CLI(String arguments) throws NotEnoughArgumentsException	{

		this.arguments = arguments;

		if (arguments == null)	{
			throw new NullPointerException("Ihre Angabe darf nicht null sein!");
		}

		if (!(arguments.trim()).startsWith("java"))	{
			throw new IllegalArgumentException("Der Aufruf muss mit 'java' starten!");
		}

		for (int i = 0; i < arguments.length(); i = i + 4)	{
			try {
				if (i+4 < arguments.length())	{
					if (arguments.substring(i, i+4).contains("--"))	{
						countargs++;
					}
				}
			} catch (StringIndexOutOfBoundsException e)	{
				System.out.println("Test");
			}
		}

		if (countargs == 0)	{
			throw new NotEnoughArgumentsException();
		}

		System.out.println(countargs);

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

	public static void main(String[] args) throws NotEnoughArgumentsException {
		new CLI("java tgm.sew.hit.roboterfabrik.Simulation --lager /verzeichnis/zum/lager --logs /verzeichnis/zum/loggen --lieferanten 12 --monteure 25 --laufzeit 10000");
	}
}
