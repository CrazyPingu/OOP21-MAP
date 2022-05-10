package logics.room.works;

import java.util.List;

import logics.game_object.GameObject;
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
	public void updateGameObjectPosition(Pair<Integer, Integer> oldPos, Pair<Integer, Integer> newPos);

	/**
	 * @param pos the position of the game object to remove from the game
	 */
	public void removeGameObject(Pair<Integer, Integer> pos);

	/**
	 * @return the cells
	 */
	public List<GameButton> getCells();

	/**
	 * @return a Pair<> that represent the size of the room.
	 */
	public Pair<Integer, Integer> getSize();

	/**
	 * @return a List<GameObject> that contains all the GameObject (like the
	 *         artefact, the enemy and the player)
	 */
	public List<GameObject> getGameObject();
}
