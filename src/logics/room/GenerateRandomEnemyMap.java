package logics.room;

import java.util.HashMap;
import logics.entity.EnemyFactoryImpl;
import logics.entity.Entity;
import utilis.Pair;

public class GenerateRandomEnemyMap extends HashMap<Pair<Integer, Integer>, Entity> {

	private static final long serialVersionUID = -1346040616337955961L;
	private final int spawningRatio = 30;
	private final int forbiddenZombieSpawn = 3;
	private final EnemyFactoryImpl enemyFactory = new EnemyFactoryImpl();
	private final int possibleZombieNumber = enemyFactory.getClass().getDeclaredMethods().length;

	public GenerateRandomEnemyMap(Pair<Integer, Integer> cells) {
		Pair<Integer, Integer> zombieSpawn;
		for (int i = 0; i < cells.getX() * cells.getY() / spawningRatio; i++) {
			do {
				zombieSpawn = new Pair<Integer, Integer>(
						((int) Math.random() * cells.getX() - forbiddenZombieSpawn) + forbiddenZombieSpawn,
						((int) Math.random() * cells.getY()));
			} while (!this.containsKey(zombieSpawn));
			this.put(zombieSpawn, generateRandomEnemy());
		}
	}

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
