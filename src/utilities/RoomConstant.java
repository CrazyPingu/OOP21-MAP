package utilities;

import java.awt.Color;
import java.awt.Image;
import java.util.List;

import model.game_object.GameObject;
import model.game_object.artefact.Artefact;
import model.game_object.entity.Player;
import model.game_object.entity.SimpleEnemy;
import model.game_object.obstacle.Obstacle;

/**
 * 
 * Class that contains all of the constant of the room
 *
 */
public final class RoomConstant {

  public static final int MAX_X = Constant.GAME_WIDTH / Constant.horizontalAspectRatio(Constant.GAME_WIDTH / 20);
  public static final int MAX_Y = Constant.TOP_HEIGHT / Constant.verticalAspectRatio(Constant.TOP_HEIGHT / 10);

  public static final int MIN_X = Constant.GAME_WIDTH / Constant.horizontalAspectRatio(Constant.GAME_WIDTH / 12);
  public static final int MIN_Y = Constant.TOP_HEIGHT / Constant.verticalAspectRatio(Constant.TOP_HEIGHT / 7);

  public static final Color ATTACK_HIGHLIGHT = Color.RED;
  public static final Color MOVE_HIGHLIGHT = Color.BLUE;
  public static final Color ENEMY_RANGE = new Color(153, 50, 204);

  public static final Color BASIC_CELL_COLOR = Color.GRAY;
  public static final Color DOOR_CELL_COLOR = new Color(110, 38, 14);

  public static final int SPAWNING_RATIO = (MAX_X + MIN_X) / 2 + (MAX_Y + MIN_Y) / 2;
  public static final int FORBIDDEN_ZOMBIE_SPAWN = 3;

  public static final Image BUTTON_IMAGE = ImageMethod.getImage("room/Button.png");

  public static final Image LOADING_SCREEN = ImageMethod.getImage("loadingScreen/Couch.png");

  private RoomConstant() {

  }

  /**
   * @param pos            the position of the GameObject to be found
   * @param gameObjectList the list of GameObject to search out
   * @return the gameObject if found, else null
   */
  public static GameObject findGameObject(final Pair<Integer, Integer> pos, final List<GameObject> gameObjectList) {
    if (gameObjectList != null && !gameObjectList.isEmpty()) {
      for (final var x : gameObjectList) {
        if (x.getPos().equals(pos)) {
          return x;
        }
      }
    }
    return null;
  }

  /**
   * @param pos  the position of the Artefact to be found
   * @param list the list of artefact to search out
   * @return the artefact if found, else null
   */
  public static Artefact searchArtefact(final Pair<Integer, Integer> pos, final List<Artefact> artefactList) {
    if (artefactList != null && !artefactList.isEmpty()) {
      for (final var x : artefactList) {
        if (x.getPos().equals(pos)) {
          return x;
        }
      }
    }
    return null;
  }

  /**
   * @param pos  the position of the SimpleEntity to be found
   * @param list the list of SimpleEntity to search out
   * @return the SimpleEntity if found, else null
   */
  public static SimpleEnemy searchEnemy(final Pair<Integer, Integer> pos, final List<SimpleEnemy> enemyList) {
    if (enemyList != null && !enemyList.isEmpty()) {
      for (final var x : enemyList) {
        if (x.getPos().equals(pos)) {
          return x;
        }
      }
    }
    return null;
  }

  /**
   * 
   * @param pos  the position of the Obstacle to be found
   * @param list the list of the Obstacle to search out
   * @return the Obstacle if found, else null
   */
  public static Obstacle searchObstacle(final Pair<Integer, Integer> pos, final List<Obstacle> obstacleList) {
    if (obstacleList != null && !obstacleList.isEmpty()) {
      for (final var x : obstacleList) {
        if (x.getPos().equals(pos)) {
          return x;
        }
      }
    }
    return null;

  }

  /**
   * @param enemyList    the list of the enemy
   * @param artefactList the list of the artefact
   * @param obstacleList the list of obstacle
   * @param player       the player
   * @param pos          the position to check
   * @return true if an enemy, the player or a artefact is in that position, else
   *         false
   */
  public static boolean cellsOccupated(final List<SimpleEnemy> enemyList, final List<Artefact> artefactList,
      final List<Obstacle> obstacleList, final Player player, final Pair<Integer, Integer> pos) {
    return player.getPos().equals(pos) || searchEnemy(pos, enemyList) != null
        || searchArtefact(pos, artefactList) != null || searchObstacle(pos, obstacleList) != null;
  }
}
