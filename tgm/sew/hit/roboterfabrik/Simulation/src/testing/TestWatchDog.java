package testing;

import org.junit.*;

import threading.NumberThread;
import threading.Watchdog;

/**
 * In this class WatchDog undergoes certain tests to guarantee a bugfree execution.
 * 
 * @author Thomas Taschner
 * @version 28.09.2014
 *
 */
public class TestWatchDog {

	Watchdog wd;

	@Before
	public void setup() {
		wd = new Watchdog(1);
	}

	@Test
	public void add()	{
		NumberThread t = new NumberThread(1);

		new Thread(t).start();
		wd.add(t);

		new Thread(wd).start();
	}
	
	@Test
	public void addNull()	{
		NumberThread t = null;

		new Thread(t).start();
		wd.add(t);

		new Thread(wd).start();
	}

	@Test
	public void killAll()	{
		NumberThread t = new NumberThread(2);

		new Thread(t).start();
		wd.add(t);

		wd.killAll();

		new Thread(wd).start();
	}

	@Test
	public void run()	{
		NumberThread t = new NumberThread(3);

		new Thread(t).start();
		wd.add(t);

		wd.run();

		new Thread(wd).start();
	}

	@Test
	public void zeroRuntime()	{
		wd = new Watchdog(0);
		NumberThread t = new NumberThread(4);

		new Thread(t).start();
		wd.add(t);

		wd.run();

		new Thread(wd).start();
	}

	@Test (expected = IllegalArgumentException.class)
	public void negativeRuntime()	{
		wd = new Watchdog(-10);
		NumberThread t = new NumberThread(5);

		new Thread(t).start();
		wd.add(t);

		wd.run();

		new Thread(wd).start();
	}

}