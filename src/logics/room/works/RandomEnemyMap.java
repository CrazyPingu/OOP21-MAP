package logics.room.works;

import java.util.HashMap;
import java.util.Random;

import logics.entity.EnemyFactoryImpl;
import logics.entity.Entity;
import utilis.Pair;
/**
 * 
 * Class that is a random generated map that contains entity associated with Pair
 *
 */
public class RandomEnemyMap extends HashMap<Pair<Integer, Integer>, Entity> {

	private static final long serialVersionUID = -1346040616337955961L;
	private final int spawningRatio = 30;
	private final int forbiddenZombieSpawn = 3;
	private final EnemyFactoryImpl enemyFactory = new EnemyFactoryImpl();
	private final int possibleZombieNumber = enemyFactory.getClass().getDeclaredMethods().length;

	/**
	 * {@inheritDoc}
	 */
	public RandomEnemyMap(Pair<Integer, Integer> cells) {
		Pair<Integer, Integer> zombieSpawn;
		for (int i = 0; i < cells.getX() * cells.getY() / spawningRatio; i++) {
			do {
				zombieSpawn = new Pair<Integer, Integer>(
						new Random().ints(forbiddenZombieSpawn, cells.getX()).findFirst().getAsInt(),
						new Random().ints(0, cells.getY()).findFirst().getAsInt());
			} while (!this.containsKey(zombieSpawn));
			this.put(zombieSpawn, generateRandomEnemy());
		}
	}

	/**
	 * Function that call a random method of the enemyFactory
	 * @return a random enemy
	 */
	private Entity generateRandomEnemy() {
		int random = (int) Math.random() * possibleZombieNumber;
		Entity generatedEnemy = null;
		try {
			generatedEnemy = (Entity) enemyFactory.getClass().getDeclaredMethods()[random].invoke(enemyFactory);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error enemy generation");
		}
		return generatedEnemy;
	}

}
