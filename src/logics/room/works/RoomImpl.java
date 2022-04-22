package logics.room.works;

import java.util.HashMap;
import java.util.Map;
import logics.artefact.Artefact;
import logics.entity.Entity;
import utilis.Pair;
import view.game.central.GameButton;

/**
 * 
 * Create the room designed by the passed value implementing the room interface.
 *
 */
public class RoomImpl implements Room {
	private Pair<Integer, Integer> size;
	private Pair<Integer, Integer> posPlayer;
	private Map<Pair<Integer, Integer>, Entity> posEnemy;
	private Map<Pair<Integer, Integer>, GameButton> cells;
	private Map<Pair<Integer, Integer>, Artefact> spawnItems;

	/**
	 * 
	 * @param size       the size of the room.
	 * @param posPlayer  the position of the player inside the room.
	 * @param posEnemy   the position of the enemy inside the room and their type.
	 * @param spawnItems the map that contains all the items to spawn.
	 */
	public RoomImpl(Pair<Integer, Integer> size, Pair<Integer, Integer> posPlayer,
			Map<Pair<Integer, Integer>, Entity> posEnemy, Map<Pair<Integer, Integer>, Artefact> spawnItems) {
		this.size = size;
		this.posPlayer = posPlayer;
		this.posEnemy = posEnemy;
		this.cells = new HashMap<>();
		this.spawnItems = spawnItems;
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
	public void addToCells(Pair<Integer, Integer> pos, GameButton button) {
		this.cells.put(pos, button);
	}

	/**
	 * {@inheritDoc}
	 */
	public void updatePosEnemy(Pair<Integer, Integer> currentPos, Pair<Integer, Integer> futurePos) {
		posEnemy.put(futurePos, posEnemy.get(currentPos));
		posEnemy.remove(currentPos);
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeItem(Pair<Integer, Integer> pos) {
		spawnItems.remove(pos);
	}

}
