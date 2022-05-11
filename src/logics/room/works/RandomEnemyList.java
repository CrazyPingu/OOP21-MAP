package logics.room.works;

import java.util.ArrayList;
import java.util.Random;

import logics.game_object.entity.Player;
import logics.game_object.entity.SimpleEntity;
import logics.game_object.entity.enemy.EnemyFactoryImpl;
import utilis.Pair;
import utilis.RoomConstant;

/**
 * 
 * Class that is a random generated List that contains SimpleEntity
 *
 */
public class RandomEnemyList extends ArrayList<SimpleEntity> {

	private static final long serialVersionUID = -1346040616337955961L;
	private final EnemyFactoryImpl enemyFactory = new EnemyFactoryImpl();
	private final int possibleZombieNumber = enemyFactory.getClass().getDeclaredMethods().length;

	/**
	 * @param size the size of the room
	 */
	public RandomEnemyList(Pair<Integer, Integer> size, Player player) {
		Pair<Integer, Integer> zombieSpawn;
		for (int i = 0; i < size.getX() * size.getY() / RoomConstant.SPAWNING_RATIO; i++) {
			do {
				zombieSpawn = new Pair<Integer, Integer>(
						new Random().ints(RoomConstant.FORBIDDEN_ZOMBIE_SPAWN, size.getX()).findFirst().getAsInt(),
						new Random().ints(0, size.getY()).findFirst().getAsInt());
			} while (RoomConstant.cellsOccupated(this, null, player, zombieSpawn));
			this.add(generateRandomEnemy(zombieSpawn));
		}
	}

	/**
	 * Function that call a random method of the enemyFactory
	 * 
	 * @return a random enemy
	 */
	private SimpleEntity generateRandomEnemy(Pair<Integer, Integer> pos) {
		int random = (int) Math.random() * possibleZombieNumber;
		SimpleEntity generatedEnemy = null;
		try {
			generatedEnemy = (SimpleEntity) enemyFactory.getClass().getDeclaredMethods()[random].invoke(enemyFactory,
					pos);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error enemy generation");
		}
		return generatedEnemy;
	}

}
