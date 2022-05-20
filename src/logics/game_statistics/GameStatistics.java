package logics.game_statistics;

import utilities.counter.CounterImpl;

/**
 * 
 * Contains game's statistics.
 *
 */
public interface GameStatistics {
	/**
	 * Increase killed enemies counter.
	 */
	public void increaseKilledEnemies();
	/**
	 * Increase passed rooms counter.
	 */
	public void increaseCompletedRooms();
	/**
	 * Increase collected artefacts counter.
	 */
	public void increaseCollectedArtefacts();
	/**
	 * @return killed enemies counter.
	 */
	public int getKilledEnemies();
	/**
	 * @return passed rooms counter.
	 */
	public int getCompletedRooms();
	/**
	 * @return collected artefacts counter.
	 */
	public int getCollectedArtefacts();
	/**
	 * @return a string with all fields
	 */
	public String toString();
}
