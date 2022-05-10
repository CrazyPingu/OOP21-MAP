package logics.room.works;

import java.util.ArrayList;
import java.util.Random;

import logics.game_object.GameObject;
import logics.game_object.entity.enemy.EnemyFactoryImpl;
import utilis.Constant;
import utilis.Pair;

/**
 * 
 * Class that is a random generated List that contains GameObject
 *
 */
public class RandomEnemyList extends ArrayList<GameObject> {

	private static final long serialVersionUID = -1346040616337955961L;
	private final EnemyFactoryImpl enemyFactory = new EnemyFactoryImpl();
	private final int possibleZombieNumber = enemyFactory.getClass().getDeclaredMethods().length;

	/**
	 * {@inheritDoc}
	 */
	public RandomEnemyList(Pair<Integer, Integer> size) {
		Pair<Integer, Integer> zombieSpawn;
		for (int i = 0; i < size.getX() * size.getY() / Constant.SPAWNING_RATIO; i++) {
			do {
				zombieSpawn = new Pair<Integer, Integer>(
						new Random().ints(Constant.FORBIDDEN_ZOMBIE_SPAWN, size.getX()).findFirst().getAsInt(),
						new Random().ints(0, size.getY()).findFirst().getAsInt());
			} while (Constant.findGameObject(zombieSpawn, this) != null);
			this.add(generateRandomEnemy(zombieSpawn));
		}
	}

	/**
	 * Function that call a random method of the enemyFactory
	 * 
	 * @return a random enemy
	 */
	private GameObject generateRandomEnemy(Pair<Integer, Integer> pos) {
		int random = (int) Math.random() * possibleZombieNumber;
		GameObject generatedEnemy = null;
		try {
			generatedEnemy = (GameObject) enemyFactory.getClass().getDeclaredMethods()[random].invoke(enemyFactory,
					pos);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error enemy generation");
		}
		return generatedEnemy;
	}

}
