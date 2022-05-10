package logics.room.works;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import logics.game_object.GameObject;
import logics.game_object.entity.enemy.EnemyFactoryImpl;
import utilis.Pair;
/**
 * 
 * Class that is a random generated map that contains entity associated with Pair
 *
 */
public class RandomEnemyMap extends ArrayList<GameObject> {

	private static final long serialVersionUID = -1346040616337955961L;
	private final int spawningRatio = 30;
	private final int forbiddenZombieSpawn = 3;
	private final EnemyFactoryImpl enemyFactory = new EnemyFactoryImpl();
	private final int possibleZombieNumber = enemyFactory.getClass().getDeclaredMethods().length;

	/**
	 * {@inheritDoc}
	 */
	public RandomEnemyMap(Pair<Integer, Integer> size) {
		Pair<Integer, Integer> zombieSpawn;
		for (int i = 0; i < size.getX() * size.getY() / spawningRatio; i++) {
			do {
				zombieSpawn = new Pair<Integer, Integer>(
						new Random().ints(forbiddenZombieSpawn, size.getX()).findFirst().getAsInt(),
						new Random().ints(0, size.getY()).findFirst().getAsInt());
			} while (!this.containsKey(zombieSpawn));
			this.put(zombieSpawn, generateRandomEnemy());
		}
	}

	/**
	 * Function that call a random method of the enemyFactory
	 * @return a random enemy
	 */
	private GameObject generateRandomEnemy() {
		int random = (int) Math.random() * possibleZombieNumber;
		GameObject generatedEnemy = null;
		try {
			generatedEnemy = (GameObject) enemyFactory.getClass().getDeclaredMethods()[random].invoke(enemyFactory);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error enemy generation");
		}
		return generatedEnemy;
	}

}
