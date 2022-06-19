package model.game_object;

import java.util.List;
import java.util.Optional;
import utilities.Pair;

/**
 * 
 * Declare the common method for the game_oject that can change their position
 * in the game grid. 
 */
public interface MovingObject extends GameObject{

  /**
   * 
   * @param pos the new game object position
   */
  void setPos(Pair<Integer, Integer> pos);

  /**
   * 
   * @param size of the room
   * @return a list of Optional that represent the possible position the game
   *         object can reach
   */
  Optional<List<Pair<Integer, Integer>>> getReachableArea(Pair<Integer, Integer> size);
}
