package controller;

import model.game_object.entity.Player;
import model.game_statistics.GameStatisticsImpl;
import model.room.Room;
import utilities.Pair;
import utilities.RoomConstant;
import view.game.central.GameArea;
import view.game.log_stats.ScrollableLog;
import view.game.log_stats.ScrollableStats;

/**
 * 
 * Controller part that manage the game area
 *
 */
public class GameAreaController {

  private final GameLoop loop;
  private final RandomRoomGenerator randomRoomGenerator;

  /**
   * 
   * @param loop the game loop
   */
  public GameAreaController(final GameLoop loop) {
    this.loop = loop;
    this.randomRoomGenerator = new RandomRoomGenerator();
  }

  /**
   * 
   * @param player the player of the game
   * @return a new generated random room
   */
  public Room generateNewRoom(final Player player) {
    return randomRoomGenerator.generateRoom(player);
  }

  /**
   * 
   * @param pos : the position of the pressed cell
   */
  public void makeAction(final Pair<Integer, Integer> pos) {
    this.loop.makeAction(pos);
  }

  /**
   * Method to reove the game object from the game
   * 
   * @param pos the position of the game object to remove
   */
  public void removeGameObject(final Pair<Integer, Integer> pos) {
    if (pos != null && RoomConstant.cellsOccupated(this.loop.getRoom().getEnemyList(),
        this.loop.getRoom().getArtefactList(), null, this.loop.getRoom().getPlayer(), pos)) {
      this.loop.getRoom().getCells().get(pos).removeSprite();
      if (RoomConstant.searchEnemy(pos, this.loop.getRoom().getEnemyList()) != null) {
        this.loop.getRoom().getEnemyList().remove(RoomConstant.searchEnemy(pos, this.loop.getRoom().getEnemyList()));
      } else if (RoomConstant.searchArtefact(pos, this.loop.getRoom().getArtefactList()) != null) {
        this.loop.getRoom().getArtefactList()
            .remove(RoomConstant.searchArtefact(pos, this.loop.getRoom().getArtefactList()));
      }
    }
  }

  /**
   * Update the log appending the passed text
   * 
   * @param log  the ScrollableLog where to put the text
   * @param text the text to write in the log
   */
  public void updateLog(final ScrollableLog log, final String text) {
    log.getLogMessage().update(text);
  }

  /**
   * Refresh the stats with the passed field
   * 
   * @param stats        the ScrollableStats to refresh
   * @param player       the player of the game
   * @param statistic    the statistic of the game
   * @param actionNumber the number of action that remain
   */
  public void updateStats(final ScrollableStats stats, final Player player, final GameStatisticsImpl statistic,
      final int actionNumber) {
    stats.getStatsValues().update(player, statistic, actionNumber);
  }

  /**
   * Method that remove all the highlight
   * 
   * @param gameArea the GameArea to remove the highlight
   */
  public void removeHighlight(final GameArea gameArea) {
    gameArea.removeHighlight();
  }

  /**
   * @param flag     the flag with the color to change
   * @param gameArea the gameArea to highlight
   */
  public void highlightCells(final ActionFlag flag, final GameArea gameArea) {
    gameArea.highlightCells(flag);
  }

  /**
   * Method to move game object around the GameArea
   * 
   * @param oldPos the actual position of the GameObject
   * @param newPos the position that the GameObject will go on
   */
  public void moveGameObject(final Pair<Integer, Integer> oldPos, final Pair<Integer, Integer> newPos) {
    if (oldPos != null && newPos != null) {
      this.loop.getRoom().getCells().get(oldPos).removeSprite();
      this.loop.getRoom().updatePosition(oldPos, newPos);
      if (RoomConstant.searchEnemy(newPos, this.loop.getRoom().getEnemyList()) != null) {
        this.loop.getRoom().getCells().get(newPos)
            .drawGameObject(RoomConstant.searchEnemy(newPos, this.loop.getRoom().getEnemyList()));
      } else {
        this.loop.getRoom().getCells().get(newPos).drawGameObject(this.loop.getRoom().getPlayer());
      }
    }
  }

  /**
   * Method to change the room
   * 
   * @param player   the player of the game
   * @param gameArea the GameArea that is shown
   */
  public void changeRoom(final Player player, final GameArea gameArea) {
    final Room room = this.generateNewRoom(player);
    gameArea.changeRoom(room);
    this.loop.setRoom(room);
  }
}
