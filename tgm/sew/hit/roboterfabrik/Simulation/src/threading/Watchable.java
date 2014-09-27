package threading;

/**
 * This is an interface for the WatchDog.
 * The only method to be implemented is shutdown().
 * 
 * @author Thomas Taschner
 * @version 27.09.2014
 *
 */
public interface Watchable	{
	public void shutdown();
}