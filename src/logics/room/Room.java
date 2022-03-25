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
	 * @return a Pair<> that rappresent the size of the room.
	 */
	public Pair<Integer, Integer> getSize();

	/**
	 * @return a Pair<> that rappresent the position of the player.
	 */
	public Pair<Integer, Integer> getPosPlayer();

	/**
	 * @return a Map<Pair<>, Entity> that rappresent the position of each enemy and
	 *         their type.
	 */
	public Map<Pair<Integer, Integer>, Entity> getPosEnemy();
}
