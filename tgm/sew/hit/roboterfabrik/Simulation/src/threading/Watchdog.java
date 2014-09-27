package threading;

import java.util.*;

public class Watchdog implements Runnable {
	private int time;
	private HashSet<Watchable> watchables;


	public Watchdog(int time) {
		this.time = time;
		this.watchables = new HashSet<Watchable>();
	}

	public void add(Watchable w)	{
		this.watchables.add(w);
	}

	public void killAll()	{
		for (Watchable watch: watchables) {
			watch.shutdown();
		}
	}

	@Override
	public void run() {
		try	{
			Thread.sleep(time);
		} catch (InterruptedException e)	{
			e.printStackTrace();
		}

		killAll();

	}
}