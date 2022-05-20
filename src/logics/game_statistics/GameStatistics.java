package logics.game_statistics;

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
	 * Increase attack action counter.
	 */
	public void increaseAttackActionCounter();
	/**
	 * Increase move action counter.
	 */
	public void increaseMoveActionCounter();
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
	 * @return attack action counter.
	 */
	public int getAttackActionCounter();
	/**
	 * @return move action counter.
	 */
	public int getMoveActionCounter();
	/**
	 * @return a string with all fields
	 */
	public String toString();
}
