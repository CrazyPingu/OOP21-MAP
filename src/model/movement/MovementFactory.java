package model.movement;

/**
 * 
 * Interface that declares methods for the Movement Factory. Each method returns
 * a different type of movement.
 * The class that implements this interface uses Factory pattern. 
 */
public interface MovementFactory {

  /**
   * 
   * @return a MovementImpl that allow an an entity to move only in the adiacents
   *         cells
   */
  MovementImpl createStepMovement();

  /**
   * 
   * @return a MovementImpl that allow an entity to move in a "+" shape cells with
   *         a distance of 1 from his current position.
   */
  MovementImpl createRunMovement();
}
