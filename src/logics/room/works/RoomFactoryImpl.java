package logics.room;

import java.util.Random;

import utilis.Constant;
import utilis.Pair;

/**
 * 
 * Factory to create new rooms.
 *
 */
public class RoomFactoryImpl implements RoomFactory {

	private final int maxX = Constant.GAME_WIDTH / Constant.horizontalAspectRatio(Constant.GAME_WIDTH / 15);
	private final int maxY = Constant.TOP_HEIGHT / Constant.verticalAspectRatio(Constant.TOP_HEIGHT / 10);
	private final Pair<Integer, Integer> maxSize = new Pair<Integer, Integer>(maxX, maxY);

	private final int minX = Constant.GAME_WIDTH / Constant.horizontalAspectRatio(Constant.GAME_WIDTH / 6);
	private final int minY = Constant.TOP_HEIGHT / Constant.verticalAspectRatio(Constant.TOP_HEIGHT / 5);
	private final Pair<Integer, Integer> minSize = new Pair<Integer, Integer>(minX, minY);

	/**
	 * {@inheritDoc}
	 */
	public Room createBigRoom() {
		Pair<Integer, Integer> playerPos = new Pair<Integer, Integer>(2, maxSize.getY() / 2);
		return new RoomImpl(maxSize, playerPos, new RandomEnemyMap(maxSize));
	}

	/**
	 * {@inheritDoc}
	 */
	public Room createSmallRoom() {
		Pair<Integer, Integer> playerPos = new Pair<Integer, Integer>(1, minSize.getY() / 2);
		return new RoomImpl(minSize, playerPos, new RandomEnemyMap(minSize));
	}

	/**
	 * {@inheritDoc}
	 */
	public Room createRandomRoom() {
		Pair<Integer, Integer> randomSize = new Pair<Integer, Integer>(
				new Random().ints(minSize.getX(), maxSize.getX()).findFirst().getAsInt(),
				new Random().ints(minSize.getY(), maxSize.getY()).findFirst().getAsInt());
		Pair<Integer, Integer> playerPos = new Pair<Integer, Integer>(0, randomSize.getY() / 2);
		return new RoomImpl(randomSize, playerPos, new RandomEnemyMap(randomSize));
	}
}
