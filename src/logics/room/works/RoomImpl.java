package logics.room.works;

import java.util.ArrayList;
import java.util.List;

import logics.game_object.GameObject;
import logics.game_object.entity.Player;
import utilis.Constant;
import utilis.Pair;
import view.game.central.GameButton;

/**
 * 
 * Create the room designed by the passed value implementing the room interface.
 *
 */
public class RoomImpl implements Room {
	private Pair<Integer, Integer> size;
	private List<GameButton> cells;
	private List<GameObject> gameObjectList;

	/**
	 * @param size         the size of the room.
	 * @param player       the player of the game
	 * @param newPosPlayer the new position of the player
	 */
	public RoomImpl(Pair<Integer, Integer> size, Player player, Pair<Integer, Integer> newPosPlayer) {
		this.size = size;
		this.cells = new ArrayList<>();
		this.gameObjectList = new ArrayList<>();
		player.setPos(newPosPlayer);
		this.gameObjectList.add(player);
		this.gameObjectList.addAll(new RandomEnemyList(size));
		// add enemy and artefact
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
	public void updateGameObjectPosition(Pair<Integer, Integer> oldPos, Pair<Integer, Integer> newPos) {
		Constant.findGameObject(oldPos, this.gameObjectList).setPos(newPos);
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeGameObject(Pair<Integer, Integer> pos) {
		this.gameObjectList.remove(Constant.findGameObject(pos, this.gameObjectList));
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
	public List<GameObject> getGameObject() {
		return this.gameObjectList;
	}

	@Override
	public String toString() {
		return "Room with :" + this.getGameObject().size() + "\nThe room's dimension is " + this.getSize();
	}
}
