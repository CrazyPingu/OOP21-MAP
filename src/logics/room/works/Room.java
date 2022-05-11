package logics.room.works;

import java.util.List;

import logics.game_object.artefact.Artefact;
import logics.game_object.entity.Player;
import logics.game_object.entity.SimpleEntity;
import utilis.Pair;
import view.game.central.GameButton;

/**
 * 
 * Interface that declares methods for the room.
 *
 */
public interface Room {

	/**
	 * @param button the button that will be added to the grid
	 */
	public void addButtonToCells(GameButton button);

	/**
	 * @param currentPos the current game object position
	 * @param futurePos  the position that the game object will have
	 */
	public void updatePosition(Pair<Integer, Integer> oldPos, Pair<Integer, Integer> newPos);

	/**
	 * @param pos the position of the game object to remove from the game
	 */
	public void removeObject(Pair<Integer, Integer> pos);

	/**
	 * @return the cells
	 */
	public List<GameButton> getCells();

	/**
	 * @return a Pair<> that represent the size of the room.
	 */
	public Pair<Integer, Integer> getSize();

	/**
	 * @return a List<SimpleEntity> that contains all the SimpleEntity (the enemy)
	 */
	public List<SimpleEntity> getEnemyList();

	/**
	 * @return a List<Artefact> that contains all the artefact in the room
	 */
	public List<Artefact> getArtefactList();

	/**
	 * @return the player of the game
	 */
	public Player getPlayer();
}
