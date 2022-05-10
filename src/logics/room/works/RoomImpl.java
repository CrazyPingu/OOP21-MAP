package logics.room.works;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import logics.game_object.artefact.Artefact;
import logics.game_object.entity.Player;
import logics.game_object.entity.SimpleEntity;
import utilis.Pair;
import view.game.central.GameButton;

/**
 * 
 * Create the room designed by the passed value implementing the room interface.
 *
 */
public class RoomImpl implements Room {
	private Pair<Integer, Integer> size;
	private Player player;
	private List<SimpleEntity> enemy;
	private List<Artefact> artefact;
	private Map<Pair<Integer, Integer>, GameButton> cells;

	/**
	 * @param size       the size of the room.
	 * @param player     the player of the game
	 * @param enemy      the enemy of the game
	 * @param spawnItems the map that contains all the items to spawn.
	 */
	public RoomImpl(Pair<Integer, Integer> size, Player player) {
		this.size = size;
		this.player = player;
		this.enemy = enemy; //TODO
		this.artefact = artefact;
		this.cells = new HashMap<>();
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
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public List<SimpleEntity> getEnemy() {
		return enemy;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void updatePosPlayer(Pair<Integer, Integer> newPosPlayer) {
		this.player.setPos(newPosPlayer);
	}

	/**
	 * {@inheritDoc}
	 */
	public void updatePosEnemy(SimpleEntity enemy, Pair<Integer, Integer> newPos) {
		this.enemy.forEach(x -> {
			if (x.equals(enemy)) {
				x.setPos(newPos);
			}
		});
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeArtefact(Artefact artefact) {
		this.artefact.remove(artefact);
	}

	/**
	 * {@inheritDoc}
	 */
	public Map<Pair<Integer, Integer>, GameButton> getCells() {
		return cells;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Artefact> getSpawnItems() {
		return this.artefact;
	}

}
