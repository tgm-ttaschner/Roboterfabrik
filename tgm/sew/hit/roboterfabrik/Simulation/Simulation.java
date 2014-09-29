package testing;

import build.CLI;

public class Simulation {
	public static void main(String[] args) {
		
		CLI c = new CLI();
		String s = "";
		
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
			
		} catch (ArrayIndexOutOfBoundsException e)	{
			System.out.println("Um die Roboterfabrik zu starten, geben Sie bitte gültige Parameter an.");
			System.out.println("Für eine Erklärung der Parameter und wie ein gültiger Aufruf aussieht, geben Sie bitte 'help' ein.");
		}
	}
}