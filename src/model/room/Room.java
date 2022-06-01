package model.room;

import java.util.List;
import java.util.Map;

import model.game_object.artefact.Artefact;
import model.game_object.entity.Player;
import model.game_object.entity.SimpleEnemy;
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
