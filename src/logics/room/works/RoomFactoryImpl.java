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

  private final Player player;
  private final Pair<Integer, Integer> maxSize = new Pair<>(RoomConstant.MAX_X, RoomConstant.MAX_Y);
  private final Pair<Integer, Integer> minSize = new Pair<>(RoomConstant.MIN_X, RoomConstant.MIN_Y);

  public RoomFactoryImpl(final Player player) {
    this.player = player;
  }

  @Override
  public Room createBigRoom() {
    return new BigRoom(maxSize, player);
  }

  @Override
  public Room createSmallRoom() {
    return new SmallRoom(minSize, player);
  }

  @Override
  public Room createRandomRoom() {
    return new RandomRoom(
        new Pair<Integer, Integer>(new Random().ints(minSize.getX(), maxSize.getX()).findFirst().getAsInt(),
            new Random().ints(minSize.getY(), maxSize.getY()).findFirst().getAsInt()),
        player);
  }
}
