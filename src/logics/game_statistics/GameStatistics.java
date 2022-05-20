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
	public void increasePassedRooms();
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
	public int getPassedRoom();
	/**
	 * @return collected artefacts counter.
	 */
	public int getCollectedArtefacts();
	
}
