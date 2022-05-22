package logics.room.works;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import logics.game_object.entity.Player;
import logics.game_object.entity.SimpleEnemy;
import logics.game_object.entity.enemy.EnemyFactory;
import logics.game_object.entity.enemy.EnemyFactoryImpl;
import utilities.Pair;
import utilities.RoomConstant;

/**
 * 
 * Class that is a random generated List that contains SimpleEnemy
 *
 */
public class RandomEnemyList extends ArrayList<SimpleEnemy> {

  private static final long serialVersionUID = -1346040616337955961L;
  private final EnemyFactory enemyFactory;
  private final int possibleZombieNumber;

  /**
   * @param size   the size of the room
   * @param player the player of the game
   * @param door   the position of the door
   */
  public RandomEnemyList(final Pair<Integer, Integer> size, final Player player,
      final List<Pair<Integer, Integer>> door) {
    this.enemyFactory = new EnemyFactoryImpl();
    this.possibleZombieNumber = enemyFactory.getClass().getDeclaredMethods().length;
    Pair<Integer, Integer> zombieSpawn;
    for (int i = 0; i < size.getX() * size.getY() / RoomConstant.SPAWNING_RATIO; i++) {
      do {
        zombieSpawn = new Pair<>(
            new Random().ints(RoomConstant.FORBIDDEN_ZOMBIE_SPAWN, size.getX()).findFirst().getAsInt(),
            new Random().ints(0, size.getY()).findFirst().getAsInt());
      } while (RoomConstant.cellsOccupated(this, null, player, zombieSpawn) || door.contains(zombieSpawn));
      this.add(generateRandomEnemy(zombieSpawn));
    }
  }

  /**
   * Function that call a random method of the enemyFactory
   * 
   * @return a random enemy
   */
  private SimpleEnemy generateRandomEnemy(final Pair<Integer, Integer> pos) {
    SimpleEnemy generatedEnemy = null;
    try {
      generatedEnemy = (SimpleEnemy) enemyFactory.getClass().getDeclaredMethods()[new Random()
          .ints(0, possibleZombieNumber).findAny().getAsInt()].invoke(enemyFactory, pos);
    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | SecurityException e) {
      e.printStackTrace();
      System.out.println("Error enemy generation at the position " + pos);
    }
    return generatedEnemy;
  }
}
