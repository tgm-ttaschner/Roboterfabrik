package testing;

import org.junit.*;

import build.CLI;

/**
 * This class' purpose is to test CLI.
 * 
 * @author Thomas Taschner
 * @version 29.09.2014
 *
 */
public class TestCLI {

	CLI c;
	
	/**
	 * Sets the CLI up
	 */
	@Before
	public void test() {
		c = new CLI();
	}
	
	/**
	 * Prints the welcome message out
	 */
	@Test
	public void welcome()	{
		c.welcome();
	}
	
	/**
	 * Prints the help message out
	 */
	@Test
	public void help()	{
		c.run("help");
	}
	
	/**
	 * Runs the CLI with a valid input
	 */
	@Test
	public void runOk()	{
		c.setArguments("java tgm.sew.hit.roboterfabrik.Simulation --lager storage/roboter --logs logs/roboterfabrik --lieferanten 12 --monteure 25 --laufzeit 10000 ");
		c.run(c.getArguments());
	}
	
	/**
	 * Runs the CLI with an empty input.
	 * A StringIndexOutOfBoundsException is triggered.
	 */
	@Test
	public void runStringIndexOutOfBoundsException()	{
		c.setArguments("");
		c.run(c.getArguments());
	}
	
	/**
	 * Runs the CLI with an invalid numeric input.
	 * A NumberFormatException is triggered.
	 */
	@Test
	public void runNumberFormatException()	{
		c.setArguments("java tgm.sew.hit.roboterfabrik.Simulation --lager storage/roboter --logs logs/roboterfabrik --lieferanten 12ä --monteure 25l --laufzeit 10000+ ");
		c.run(c.getArguments());
	}
	
	/**
	 * Gets the LagerVerzeichnis
	 */
	@Test
	public void getLagerVerzeichnis()	{
		c.getLagerVerzeichnis();
	}
	
	/**
	 * Gets the LogVerzeichnis
	 */
	@Test
	public void getLogVorzeichnis()	{
		c.getLogVerzeichnis();
	}
	
	/**
	 * Gets the LieferantenAnzahl
	 */
	@Test
	public void getLieferantenAnzahl()	{
		c.getLieferantenAnzahl();
	}
	
	/**
	 * Gets the MonteurAnzahl
	 */
	@Test
	public void getMonteurAnzahl()	{
		c.getMonteurAnzahl();
	}
	
	/**
	 * Gets the Laufzeit
	 */
	@Test
	public void getLaufzeit()	{
		c.getLaufzeit();
	}
}