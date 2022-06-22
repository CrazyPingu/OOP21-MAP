package controller.game_controller;

import controller.ActionFlag;
import controller.GameAreaController;
import controller.GameLoop;
import controller.PageController;
import model.game_object.artefact.Artefact;
import model.game_object.entity.SimpleEnemy;
import model.game_statistics.GameStatisticsImpl;
import utilities.Pair;
import utilities.RoomConstant;

/**
 * 
 * Manage Game Loop methods
 * 
 */
public abstract class GameController {

  private final GameAreaController gameAreaController;
  private final PageController pageController;
  private final GameStatisticsImpl gameStats;
  private final GameLoop loop;
  private ActionFlag flag;
  private int currentActionNumber;

  /**
   * 
   * @param gameAreaController the gameAreaController of the game
   * @param pageController     the controller that change the page
   * @param gameStats          the statistic of the game
   * @param loop               the game loop
   */
  public GameController(final GameAreaController gameAreaController, final PageController pageController,
      final GameStatisticsImpl gameStats, final GameLoop loop) {
    this.loop = loop;
    this.pageController = pageController;
    this.gameStats = gameStats;
    this.gameAreaController = gameAreaController;
    this.currentActionNumber = this.loop.getPlayer().getActionNumber();
  }

  /**
   * start a new Enemy Turn.
   */
  public abstract void enemyTurn();

  /**
   * 
   * @return if the door of the room is available
   */
  public abstract boolean isDoorAvailable();

  /**
   * 
   * @return if the player won the game
   */
  public abstract boolean isWon();

  /**
   * 
   * @return the statistics of the game
   */
  public GameStatisticsImpl getGameStats() {
    return this.gameStats;
  }

  /**
   * 
   * @return the controller of the page
   */
  public PageController getPageController() {
    return this.pageController;
  }

  /**
   * Decrease the number of available action
   */
  public void decreaseAction() {
    this.currentActionNumber--;
    this.updateStats();
  }

  /**
   * method to update the stats
   */
  public void updateStats() {
    this.loop.updateStats(this.getGameStats(), this.currentActionNumber);
  }

  /**
   * Skip the turn
   */
  public void skipTurn() {
    this.loop.removeHighlight();
    this.resetActionNumber();
    this.updateStats();
    this.enemyTurn();
  }

  /**
   * Attack in a chosen cell by the user
   */
  private void attack(final Pair<Integer, Integer> pos) {
    final SimpleEnemy enemy = RoomConstant.searchEnemy(pos, this.loop.getRoom().getEnemyList());
    this.updateStats();
    if (enemy != null) {
      enemy.damage(this.loop.getPlayer().getWeapon().getDamage());
      if (enemy.isDead()) {
        this.gameAreaController.removeGameObject(pos);
        this.gameStats.increaseKilledEnemies();
        this.updateStats();
      }
      this.loop.updateLog(enemy.getName() + " got hit");
    } else {
      this.loop.updateLog(this.loop.getPlayer().getName() + " miss the attack");
    }
    this.endPlayerTurn();
  }

  /**
   * Move in a chosen cell by the user
   * 
   * @param newpos : the new position of the player
   */
  private void move(final Pair<Integer, Integer> newpos) {
    this.updateStats();
    if (RoomConstant.searchEnemy(newpos, this.loop.getRoom().getEnemyList()) == null
        && RoomConstant.searchObstacle(newpos, this.loop.getRoom().getObstacleList()) == null) {
      final Artefact artefact = RoomConstant.searchArtefact(newpos, this.loop.getRoom().getArtefactList());
      if (artefact != null) {
        artefact.execute(this.loop.getPlayer());
        this.gameAreaController.removeGameObject(newpos);
        this.gameStats.increaseCollectedArtefacts();
        this.loop.updateLog("Picked up " + artefact.getName() + ".");
        this.updateStats();
      }
      this.loop.moveGameObject(this.loop.getPlayer().getPos(), newpos);
      if (this.loop.getRoom().playerOnDoor()) {
        this.gameStats.increaseCompletedRooms();
        this.loop.changeRoom();
        this.resetActionNumber();
        this.updateStats();
        this.currentActionNumber++;
      }
    }
    this.endPlayerTurn();
  }

  /**
   * 
   * @return if the player is dead
   */
  public boolean isDead() {
    return this.loop.getRoom().getPlayer().isDead();
  }

  /**
   * Specify the type of action to apply to GameArea's chosen cell.
   * 
   * @param flag the actionFlag to be changed
   */
  public void setFlag(final ActionFlag flag) {
    this.flag = flag;
    this.loop.removeHighlight();
    this.loop.highlightCells(this.flag);
  }

  /**
   * 
   * @return the number of action of the player
   */
  public int getCurrentActionNumber() {
    return currentActionNumber;
  }

  /**
   * reset the number of action available by the player
   *
   */
  public void resetActionNumber() {
    this.currentActionNumber = this.loop.getPlayer().getActionNumber();
  }

  /**
   * end the turn of the player
   */
  private void endPlayerTurn() {
    this.loop.removeHighlight();
    this.decreaseAction();
    if (this.getCurrentActionNumber() <= 0) {
      enemyTurn();
    }
    if (isWon()) {
      this.getPageController().showVictory();
    } else if (isDefeated()) {
      this.getPageController().showDefeat();
    }
  }

  /**
   * 
   * @return the current game loop
   */
  public GameLoop getLoop() {
    return this.loop;
  }

  /**
   * 
   * @param pos the pos of the player
   */
  public void makeAction(final Pair<Integer, Integer> pos) {
    if (this.flag.equals(ActionFlag.ATTACK)) {
      this.attack(pos);
      this.gameStats.increaseAttackActionCounter();
      this.updateStats();
    } else if (this.flag.equals(ActionFlag.MOVE)) {
      this.move(pos);
      this.gameStats.increaseMoveActionCounter();
      this.updateStats();
    }
  }

  /**
   * 
   * @return true if the player has been defeated
   */
  public abstract boolean isDefeated();

}
