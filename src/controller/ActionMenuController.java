package controller;

/**
 * 
 * Class that define the main action that the player can execute
 * 
 */
public class ActionMenuController {

  private final GameLoop gameLoop;

  /**
   * 
   * @param gameLoop the gameLoop of the game
   */
  public ActionMenuController(final GameLoop gameLoop) {
    this.gameLoop = gameLoop;
  }

  /**
   * Skip to the next action
   */
  public void skip() {
    this.gameLoop.skipTurn();
  }

  /**
   * Set the flag of action to Attack
   */
  public void setAttack() {
    this.gameLoop.setFlag(ActionFlag.ATTACK);
  }

  /**
   * Set the flag of action to Move
   */
  public void setMove() {
    this.gameLoop.setFlag(ActionFlag.MOVE);
  }

}
