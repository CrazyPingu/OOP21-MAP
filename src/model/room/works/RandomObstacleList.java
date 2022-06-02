package model.room.works;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import model.game_object.artefact.Artefact;
import model.game_object.entity.Player;
import model.game_object.entity.SimpleEnemy;
import model.game_object.obstacle.Obstacle;
import model.game_object.obstacle.ObstacleFactory;
import model.game_object.obstacle.ObstacleFactoryImpl;
import utilities.Constant;
import utilities.Pair;
import utilities.RoomConstant;

public class RandomObstacleList extends ArrayList<Obstacle> {

  private static final long serialVersionUID = 4692166580436298238L;

  private ObstacleFactory obstacleFactory = new ObstacleFactoryImpl();
  private final int possibleObstacle;

  public RandomObstacleList(final Pair<Integer, Integer> size, final List<SimpleEnemy> enemyList,
      final List<Artefact> artefactList, final Player player) {
    possibleObstacle = obstacleFactory.getClass().getDeclaredMethods().length;
    Pair<Integer, Integer> obstaclePos;
    for (int i = 0; i < size.getX() * size.getY() / RoomConstant.SPAWNING_RATIO; i++) {
      do {
        obstaclePos = new Pair<>(Constant.RANDOM.ints(0, size.getX() - 2).findFirst().getAsInt(),
            Constant.RANDOM.ints(0, size.getY()).findFirst().getAsInt());
      } while (checkPos(obstaclePos, enemyList, artefactList, player));
      generateObstacle(obstaclePos);
    }
  }

  private void generateObstacle(final Pair<Integer, Integer> pos) {
    Obstacle generateObstacle = null;
    try {
      generateObstacle = (Obstacle) obstacleFactory.getClass().getDeclaredMethods()[Constant.RANDOM
          .ints(0, possibleObstacle).findAny().getAsInt()].invoke(obstacleFactory, pos);
    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | SecurityException e) {
      e.printStackTrace();
      System.out.println("Error obstacle generation at the position " + pos);
    }
    this.add(generateObstacle);
  }

  private int calculateDistance(final Pair<Integer, Integer> p1, final Pair<Integer, Integer> p2) {
    return Math.abs(p1.getX() - p2.getX()) + Math.abs(p1.getY() - p2.getY());
  }

  private boolean checkPos(final Pair<Integer, Integer> pos, final List<SimpleEnemy> enemyList,
      final List<Artefact> artefactList, final Player player) {
    for (final var x : this) {
      if (calculateDistance(pos, x.getPos()) == 1
          || RoomConstant.cellsOccupated(enemyList, artefactList, this, player, pos)) {
        return true;
      }
    }
    return false;
  }

}
