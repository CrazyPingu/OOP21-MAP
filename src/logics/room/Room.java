package logics.room;

import java.util.Map;
import logics.entity.Entity;
import utilis.Pair;

/**
 * 
 * Interface that declares methods for the room.
 *
 */
public interface Room {

	/**
	 * @return a Pair<> that represent the size of the room.
	 */
	public Pair<Integer, Integer> getSize();

	/**
	 * @return a Pair<> that represent the position of the player.
	 */
	public Pair<Integer, Integer> getPosPlayer();

	/**
	 * @return a Map<Pair<>, Entity> that represent the position of each enemy and
	 *         their type.
	 */
	public Map<Pair<Integer, Integer>, Entity> getPosEnemy();
	
	
	/**
	 * @param newPosPlayer the new player position
	 */
	public void updatePosPlayer(Pair<Integer, Integer> newPosPlayer);
	
	/**
	 * @param currentPos : the current enemy's position
	 * @param futurePos : the position that the enemy will have
	 */
	public void updatePosEnemy(Pair<Integer, Integer> currentPos, Pair<Integer, Integer> futurePos);
}
