package logics.room.works;

import java.util.Random;

import logics.game_object.entity.Player;
import logics.room.type.BigRoom;
import logics.room.type.RandomRoom;
import logics.room.type.SmallRoom;
import utilities.Pair;
import utilities.RoomConstant;

/**
 * 
 * Factory to create new rooms.
 *
 */
public class RoomFactoryImpl implements RoomFactory {

	private Player player;
	private final Pair<Integer, Integer> maxSize = new Pair<Integer, Integer>(RoomConstant.MAX_X, RoomConstant.MAX_Y);
	private final Pair<Integer, Integer> minSize = new Pair<Integer, Integer>(RoomConstant.MIN_X, RoomConstant.MIN_Y);

	public RoomFactoryImpl(Player player) {
		this.player = player;
	}

	/**
	 * {@inheritDoc}
	 */
	public Room createBigRoom() {
		return new BigRoom(maxSize, player);
	}

	/**
	 * {@inheritDoc}
	 */
	public Room createSmallRoom() {
		return new SmallRoom(minSize, player);
	}

	/**
	 * {@inheritDoc}
	 */
	public Room createRandomRoom() {
		Pair<Integer, Integer> randomSize = new Pair<Integer, Integer>(
				new Random().ints(minSize.getX(), maxSize.getX()).findFirst().getAsInt(),
				new Random().ints(minSize.getY(), maxSize.getY()).findFirst().getAsInt());
		return new RandomRoom(randomSize, player);
	}
}
