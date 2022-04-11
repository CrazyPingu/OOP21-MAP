package logics.room;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import logics.entity.EnemyFactoryImpl;
import logics.entity.Entity;
import utilis.Pair;

public class GenerateRandomEnemyMap extends HashMap<Pair<Integer, Integer>, Entity> {

	private static final long serialVersionUID = -1346040616337955961L;
	private static final EnemyFactoryImpl enemyFactory = new EnemyFactoryImpl();
	private static int possibleZombieNumber = enemyFactory.getClass().getDeclaredMethods().length;

	public GenerateRandomEnemyMap(Pair<Integer, Integer> cells) {
		for (int i = 0; i < cells.getX() * cells.getY() / 30; i++) {
			this.put(new Pair<Integer, Integer>(((int) Math.random() * cells.getX() - 3) + 3,
					((int) Math.random() * cells.getY())), generateRandomEnemy());
		}
	}

	private Entity generateRandomEnemy() {
		int random = (int) Math.random() * possibleZombieNumber;
		Entity generatedEnemy = null;
			try {
				generatedEnemy = (Entity)enemyFactory.getClass().getDeclaredMethods()[random].invoke(enemyFactory);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| SecurityException e) {
				e.printStackTrace();
				System.out.println("Error enemy generation");
			}
		return generatedEnemy;
	}

}
