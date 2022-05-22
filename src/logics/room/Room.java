package logics.room;

import java.util.List;
import java.util.Map;

import logics.game_object.artefact.Artefact;
import logics.game_object.entity.Player;
import logics.game_object.entity.SimpleEnemy;
import utilities.Pair;
import view.game.central.GameButton;

/**
 * 
 * Interface that declares methods for the room.
 *
 */
public interface Room {

	/**
	 * @return true if the player is on the door, else false
	 */
	boolean playerOnDoor();

	/**
	 * Method that check if the player is on an artefact and return the artefact
	 * 
	 * @return an Artefact if the player is on it, and remove it from the list of
	 *         artefact, else null
	 */
	Artefact playerGetArtefact();

	/**
	 * Method that check if the player is on an artefact
	 * 
	 * @return true if the player is on a artefact
	 */
	boolean playerOnArtefact();

	/**
	 * @param button the button that will be added to the grid
	 * @param pos    the position of the button in the grid
	 */
	void addButtonToCells(Pair<Integer, Integer> pos, GameButton button);

	/**
	 * @param currentPos the current game object position
	 * @param futurePos  the position that the game object will have
	 */
	void updatePosition(Pair<Integer, Integer> oldPos, Pair<Integer, Integer> newPos);

	/**
	 * @param pos the position of the game object to remove from the game
	 */
	void removeObject(Pair<Integer, Integer> pos);

	/**
	 * @return the cells
	 */
	Map<Pair<Integer, Integer>, GameButton> getCells();

	/**
	 * @return a Pair<> that represent the size of the room.
	 */
	Pair<Integer, Integer> getSize();

	/**
	 * @return a List<SimpleEntity> that contains all the SimpleEntity (the enemy)
	 */
	List<SimpleEnemy> getEnemyList();

	/**
	 * @return a List<Artefact> that contains all the artefact in the room
	 */
	List<Artefact> getArtefactList();

	/**
	 * @return the player of the game
	 */
	Player getPlayer();

	/**
	 * @return the door
	 */
	List<Pair<Integer, Integer>> getDoor();
}
