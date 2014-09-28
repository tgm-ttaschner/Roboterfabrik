package testing;

import org.junit.*;

import threading.NumberThread;
import threading.WatchDog;

/**
 * In this class WatchDog undergoes certain tests to guarantee a bugfree execution.
 * 
 * @author Thomas Taschner
 * @version 28.09.2014
 *
 */
public class TestWatchDog {

	WatchDog wd;

	/**
	 * Initializes a new WatchDog
	 */
	@Before
	public void setup() {
		wd = new WatchDog(1);
	}

	/**
	 * Adds a new thread to the WatchDog which outputs 1 and runs it.
	 */
	@Test
	public void add()	{
		NumberThread t = new NumberThread(1);

		new Thread(t).start();
		wd.add(t);

		new Thread(wd).start();
	}
	
	/**
	 * Adds a null thread to the WatchDog and runs it
	 */
	@Test
	public void addNull()	{
		NumberThread t = null;

		new Thread(t).start();
		wd.add(t);

		new Thread(wd).start();
	}

	/**
	 * Adds a new thread to the WatchDog which outputs 2 and kills it.
	 */
	@Test
	public void killAll()	{
		NumberThread t = new NumberThread(2);

		new Thread(t).start();
		wd.add(t);

		wd.killAll();

		new Thread(wd).start();
	}

	/**
	 * Adds a new thread to the WatchDog which outputs 3 and runs it via run().
	 */
	@Test
	public void run()	{
		NumberThread t = new NumberThread(3);

		new Thread(t).start();
		wd.add(t);

		wd.run();

		new Thread(wd).start();
	}

	/**
	 * Adds a new thread to the WatchDog which outputs 4 and runs it via run() with the runtime set to 0.
	 */
	@Test
	public void zeroRuntime()	{
		wd = new WatchDog(0);
		NumberThread t = new NumberThread(4);

		new Thread(t).start();
		wd.add(t);

		wd.run();

		new Thread(wd).start();
	}

	/**
	 * Adds a new thread to the WatchDog which outputs 5 and runs it via run() with the runtime set to -10.
	 * An IllegalArgumentException is excepted to be thrown.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void negativeRuntime()	{
		wd = new WatchDog(-10);
		NumberThread t = new NumberThread(5);

		new Thread(t).start();
		wd.add(t);

		wd.run();

		new Thread(wd).start();
	}
}