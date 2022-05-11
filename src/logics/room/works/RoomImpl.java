package logics.room.works;

import java.util.ArrayList;
import java.util.List;

import logics.game_object.artefact.Artefact;
import logics.game_object.entity.Player;
import logics.game_object.entity.SimpleEntity;
import utilis.Pair;
import utilis.RoomConstant;
import view.game.central.GameButton;

/**
 * 
 * Create the room designed by the passed value implementing the room interface.
 *
 */
public class RoomImpl implements Room {
	private Pair<Integer, Integer> size;
	private List<GameButton> cells;
	private List<SimpleEntity> enemyList;
	private List<Artefact> artefactList;
	private Player player;
	private List<Pair<Integer, Integer>> door;

	/**
	 * @param size         the size of the room.
	 * @param player       the player of the game
	 * @param newPosPlayer the new position of the player
	 */
	public RoomImpl(Pair<Integer, Integer> size, Player player, Pair<Integer, Integer> newPosPlayer) {
		this.size = size;
		this.player = player;
		this.cells = new ArrayList<>();
		this.door = generateDoor(size);
		this.enemyList = new RandomEnemyList(size, player);
		this.artefactList = new RandomArtefactList(size, enemyList, player);
		player.setPos(newPosPlayer);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean playerOnDoor() {
		return this.door.contains(this.player.getPos());
	}

	/**
	 * {@inheritDoc}
	 */
	public Artefact playerGetArtefact() {
		if (playerOnArtefact()) {
			this.removeObject(player.getPos());
		}
		return RoomConstant.searchArtefact(this.player.getPos(), artefactList);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean playerOnArtefact() {
		return RoomConstant.searchArtefact(this.player.getPos(), artefactList) != null;
	}

	/**
	 * Method that generate the door in the last x position, with the middle y
	 * 
	 * @param size the size of the room
	 * @return a List with the cell of the door
	 */
	private List<Pair<Integer, Integer>> generateDoor(Pair<Integer, Integer> size) {
		List<Pair<Integer, Integer>> tmp = new ArrayList<>();
		tmp.add(new Pair<Integer, Integer>(size.getX() - 1, size.getY() / 2));
		if (size.getY() % 2 == 0) {
			tmp.add(new Pair<Integer, Integer>(size.getX() - 1, (size.getY() / 2) + 1));
		}
		return tmp;
	}

	/**
	 * {@inheritDoc}
	 */
	public void addButtonToCells(GameButton button) {
		this.cells.add(button);
	}

	/**
	 * {@inheritDoc}
	 */
	public void updatePosition(Pair<Integer, Integer> oldPos, Pair<Integer, Integer> newPos) {
		if (RoomConstant.searchEnemy(oldPos, enemyList) != null) {
			RoomConstant.searchEnemy(oldPos, enemyList).setPos(newPos);
		} else if (this.player.getPos().equals(oldPos)) {
			this.player.setPos(newPos);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeObject(Pair<Integer, Integer> pos) {
		if (RoomConstant.searchEnemy(pos, enemyList) != null) {
			enemyList.remove(RoomConstant.searchEnemy(pos, enemyList));
		} else if (RoomConstant.searchArtefact(pos, artefactList) != null) {
			artefactList.remove(RoomConstant.searchArtefact(pos, artefactList));
		} else if (player.getPos().equals(pos)) {
			player = null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<GameButton> getCells() {
		return this.cells;
	}

	/**
	 * {@inheritDoc}
	 */
	public Pair<Integer, Integer> getSize() {
		return this.size;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<SimpleEntity> getEnemyList() {
		return this.enemyList;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Artefact> getArtefactList() {
		return this.artefactList;
	}

	/**
	 * {@inheritDoc}
	 */
	public Player getPlayer() {
		return this.player;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Pair<Integer, Integer>> getDoor() {
		return this.door;
	}

}
