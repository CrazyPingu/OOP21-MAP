package utilities.counter;

/**
 * 
 * Methods to use a counter.
 *
 */
public interface Counter {
	/**
	 * Increments the counter.
	 */
	public void increment();
	
	/**
	 * @return counter value.
	 */
	public int getCountValue();
}
