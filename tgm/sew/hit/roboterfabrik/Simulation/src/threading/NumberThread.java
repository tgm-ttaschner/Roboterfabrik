package threading;

public class NumberThread implements Runnable, Watchable	{
	private boolean running;
	private int output; 

	public NumberThread(int output)	{
		this.running = true;
		this.output = output;
	}

	@Override
	public void run()	{
		while (running) {
			System.out.println(output);
		}
		
		System.err.println("DOWN "+output);
	}

	public void shutdown()	{
		this.running = false;
	}
}