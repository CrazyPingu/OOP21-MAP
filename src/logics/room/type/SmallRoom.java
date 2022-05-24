package logics.room.type;

import logics.game_object.entity.Player;
import logics.room.RoomImpl;
import utilities.Pair;

/**
 * 
 * Class that define the room with the smallest size
 *
 */
public class SmallRoom extends RoomImpl {

  public SmallRoom(final Pair<Integer, Integer> size, final Player player) {
    super(size, player, new Pair<Integer, Integer>(1, size.getY() / 2));
  }
}
