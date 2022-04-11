package logics.room;

import java.util.Map;
import logics.entity.Entity;
import utilis.Pair;

/**
 * 
 * Create the room designed by the passed value implementing the room interface.
 *
 */
public class RoomImpl implements Room {
	private Pair<Integer, Integer> size;
	private Pair<Integer, Integer> posPlayer;
	private Map<Pair<Integer, Integer>, Entity> posEnemy;

	/**
	 * @param size      : the size of the room.
	 * @param posPlayer : the position of the player inside the room.
	 * @param posEnemy  : the position of the enemy inside the room and their type.
	 */
	public RoomImpl(Pair<Integer, Integer> size, Pair<Integer, Integer> posPlayer,
			Map<Pair<Integer, Integer>, Entity> posEnemy) {
		this.size = size;
		this.posPlayer = posPlayer;
		this.posEnemy = posEnemy;
	}

	/**
	 * {@inheritDoc}
	 */
	public Pair<Integer, Integer> getSize() {
		return size;
	}

	/**
	 * {@inheritDoc}
	 */
	public Pair<Integer, Integer> getPosPlayer() {
		return posPlayer;
	}

	/**
	 * {@inheritDoc}
	 */
	public Map<Pair<Integer, Integer>, Entity> getPosEnemy() {
		return posEnemy;
	}

	/**
	 * {@inheritDoc}
	 */
	public void updatePosPlayer(Pair<Integer, Integer> newPosPlayer) {
		this.posPlayer = newPosPlayer;
	}

	/**
	 * {@inheritDoc}
	 */
	public void updatePosEnemy(Pair<Integer, Integer> currentPos, Pair<Integer, Integer> futurePos) {
		posEnemy.put(futurePos, posEnemy.get(currentPos));
		posEnemy.remove(currentPos);
	}
}
