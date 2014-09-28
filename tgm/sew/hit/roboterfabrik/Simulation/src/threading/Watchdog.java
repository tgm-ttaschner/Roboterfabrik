package threading;

import java.util.*;

/**
 * This class implements a WatchDog for threads.
 * 
 * @author Thomas Taschner
 * @version 27.09.2014
 *
 */
public class Watchdog implements Runnable {
	private int time;
	private HashSet<Watchable> watchables;


	/**
	 * @param time The time in milliseconds until the WatchDog kills the threads.
	 */
	public Watchdog(int time) {
		this.time = time;
		this.watchables = new HashSet<Watchable>();
	}

	
	/**
	 * @param w Adds a new thread to the HashSet
	 */
	public void add(Watchable w)	{
		this.watchables.add(w);
	}

	/**
	 * Shuts all threads in the HashSet down
	 */
	public void killAll()	{
		for (Watchable watch: watchables) {
			watch.shutdown();
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 * 
	 * Runs the threads and lets them sleep for certain amount of time.
	 * Finally all threads get killed.
	 */
	@Override
	public void run() {
		try	{
			Thread.sleep(time);
		} catch (InterruptedException e)	{
			System.out.println("Thread got interrupted, terminating now!");
		}

		killAll();

	}
}