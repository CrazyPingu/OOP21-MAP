package logics.room;

import logics.game_object.entity.Player;
import logics.room.type.BigRoom;
import logics.room.type.MediumRoom;
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
  public Room createMediumRoom() {
    return new MediumRoom(new Pair<Integer, Integer>((RoomConstant.MAX_X + RoomConstant.MIN_X) / 2,
        (RoomConstant.MAX_Y + RoomConstant.MIN_Y) / 2), player);
  }
}
