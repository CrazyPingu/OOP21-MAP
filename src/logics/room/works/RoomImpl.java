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

	/**
	 * @param size         the size of the room.
	 * @param player       the player of the game
	 * @param newPosPlayer the new position of the player
	 */
	public RoomImpl(Pair<Integer, Integer> size, Player player, Pair<Integer, Integer> newPosPlayer) {
		this.size = size;
		this.player = player;
		this.cells = new ArrayList<>();
		this.enemyList = new RandomEnemyList(size);
		this.artefactList = new RandomArtefactList(size);
		player.setPos(newPosPlayer);
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
		} else {
			this.player.setPos(newPos);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeObject(Pair<Integer, Integer> pos) {
		if(RoomConstant.searchEnemy(pos, enemyList) != null) {
			enemyList.remove(RoomConstant.searchEnemy(pos, enemyList));
		}else if(RoomConstant.searchArtefact(pos, artefactList) != null){
			artefactList.remove(RoomConstant.searchArtefact(pos, artefactList));
		}else if(player.getPos().equals(pos)){
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
}
