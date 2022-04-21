package logics.room.works;

import java.util.Map;

import javax.swing.JButton;

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
	private Map<Pair<Integer, Integer>, JButton> cells;

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
	public void addToCells(Pair<Integer, Integer> pos, JButton button) {
		this.cells.put(pos, button);
	}

	/**
	 * {@inheritDoc}
	 */
	public void updatePosEnemy(Pair<Integer, Integer> currentPos, Pair<Integer, Integer> futurePos) {
		posEnemy.put(futurePos, posEnemy.get(currentPos));
		posEnemy.remove(currentPos);
	}
}
