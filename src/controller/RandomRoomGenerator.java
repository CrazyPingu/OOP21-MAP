package controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import logics.game_object.entity.Player;
import logics.room.Room;
import logics.room.RoomFactoryImpl;

public class RandomRoomGenerator {
  public Room generateRoom(final Player player) {
    final RoomFactoryImpl roomFactory = new RoomFactoryImpl(player);
    Room room = null;
    try {
      room = (Room) roomFactory.getClass().getDeclaredMethods()[new Random()
          .ints(0, roomFactory.getClass().getDeclaredMethods().length).findAny().getAsInt()].invoke(roomFactory);
    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | SecurityException e) {
      e.printStackTrace();
      System.out.println("Error during room generation");
    }
    return room;
  }
}
