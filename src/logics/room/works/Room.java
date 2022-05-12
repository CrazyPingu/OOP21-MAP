package logics.room.works;

import java.util.List;

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
	public boolean playerOnDoor();

	/**
	 * Method that check if the player is on an artefact and return the artefact
	 * 
	 * @return an Artefact if the player is on it, and remove it from the list of
	 *         artefact, else null
	 */
	public Artefact playerGetArtefact();

	/**
	 * Method that check if the player is on an artefact
	 * 
	 * @return true if the player is on a artefact
	 */
	public boolean playerOnArtefact();

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
	public List<SimpleEnemy> getEnemyList();

	/**
	 * @return a List<Artefact> that contains all the artefact in the room
	 */
	public List<Artefact> getArtefactList();

	/**
	 * @return the player of the game
	 */
	public Player getPlayer();

	/**
	 * @return the door
	 */
	public List<Pair<Integer, Integer>> getDoor();
}
