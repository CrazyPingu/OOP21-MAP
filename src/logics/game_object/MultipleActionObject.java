package logics.game_object;

/**
 * 
 * Declare the common method for the object that can perform multiple action in
 * a turns
 *
 */
public interface MultipleActionObject {

  /**
   * 
   * @return the number of action the object can perform in a turn
   */
  int getActionNumber();
}
