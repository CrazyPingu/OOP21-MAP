package model.game_object;

import model.strategy.movement.Movement;
import utilities.Pair;

/**
 * 
 * Declare the common method for the game_oject that can change their position
 * in the game grid
 *
 */
public interface MovingObject {

  /**
   * 
   * @param pos the new game object position
   */
  void setPos(Pair<Integer, Integer> pos);

  /**
   * 
   * @return the current game object position
   */
  Pair<Integer, Integer> getPos();

  /**
   * 
   * @return the movement System of the game object
   */
  Movement getMovementSystem();
}
