package logics.room.works;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import logics.game_object.entity.Player;
import logics.game_object.entity.SimpleEnemy;
import logics.game_object.entity.enemy.EnemyFactoryImpl;
import utilities.Pair;
import utilities.RoomConstant;

/**
 * 
 * Class that is a random generated List that contains SimpleEntity
 *
 */
public class RandomEnemyList extends ArrayList<SimpleEnemy> {

	private static final long serialVersionUID = -1346040616337955961L;
	private final EnemyFactoryImpl enemyFactory = new EnemyFactoryImpl();
	private final int possibleZombieNumber = enemyFactory.getClass().getDeclaredMethods().length;

	/**
	 * @param size the size of the room
	 */
	public RandomEnemyList(Pair<Integer, Integer> size, Player player, List<Pair<Integer, Integer>> door) {
		Pair<Integer, Integer> zombieSpawn;
		for (int i = 0; i < size.getX() * size.getY() / RoomConstant.SPAWNING_RATIO; i++) {
			do {
				zombieSpawn = new Pair<Integer, Integer>(
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
	private SimpleEnemy generateRandomEnemy(Pair<Integer, Integer> pos) {
		int random = new Random().ints(0, possibleZombieNumber).findAny().getAsInt();
		SimpleEnemy generatedEnemy = null;
		try {
			generatedEnemy = (SimpleEnemy) enemyFactory.getClass().getDeclaredMethods()[random].invoke(enemyFactory,
					pos);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error enemy generation at the position " + pos);
			System.exit(0);
		}
		return generatedEnemy;
	}

}
