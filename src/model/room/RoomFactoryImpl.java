package model.room;

import model.game_object.entity.Player;
import model.room.type.BigRoom;
import model.room.type.MediumRoom;
import model.room.type.SmallRoom;
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

  /**
   * @param player the player of the game
   */
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
