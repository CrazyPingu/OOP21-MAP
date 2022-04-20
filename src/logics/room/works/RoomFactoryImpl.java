package logics.room.works;

import java.util.Random;
import logics.room.type.BigRoom;
import logics.room.type.RandomRoom;
import logics.room.type.SmallRoom;
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
		return new BigRoom(maxSize);
	}

	/**
	 * {@inheritDoc}
	 */
	public Room createSmallRoom() {
		return new SmallRoom(minSize);
	}

	/**
	 * {@inheritDoc}
	 */
	public Room createRandomRoom() {
		Pair<Integer, Integer> randomSize = new Pair<Integer, Integer>(
				new Random().ints(minSize.getX(), maxSize.getX()).findFirst().getAsInt(),
				new Random().ints(minSize.getY(), maxSize.getY()).findFirst().getAsInt());
		return new RandomRoom(randomSize);
	}
}
