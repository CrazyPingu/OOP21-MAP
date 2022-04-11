package logics.room;

import utilis.Constant;
import utilis.Pair;

/**
 * 
 * Factory to create new rooms.
 *
 */
public class RoomFactoryImpl implements RoomFactory {

	private final int maxX = Constant.GAME_WIDTH / Constant.horizontalAspectRatio(64);	//15
	private final int maxY = Constant.TOP_HEIGHT / Constant.verticalAspectRatio(72);	//10
	private final Pair<Integer, Integer> max = new Pair<Integer, Integer>(maxX, maxY);

	private final int minX = Constant.GAME_WIDTH / Constant.horizontalAspectRatio(160);	//6
	private final int minY = Constant.TOP_HEIGHT / Constant.verticalAspectRatio(144);	//5
	private final Pair<Integer, Integer> min = new Pair<Integer, Integer>(minX, minY);
	
	/**
	 * {@inheritDoc}
	 */
	public Room createBigRoom() {
		Pair<Integer, Integer> playerPos = new Pair<>(1, max.getY() / 2);
		return new RoomImpl(max, playerPos, new GenerateRandomEnemyMap(max));
	}

	/**
	 * {@inheritDoc}
	 */
	public Room createSmallRoom() {
		Pair<Integer, Integer> playerPos = new Pair<>(1, min.getY() / 2);
		return new RoomImpl(min, playerPos, new GenerateRandomEnemyMap(min));
	}
}
