package controller;

import java.util.Random;

import logics.game_object.entity.Player;
import logics.room.works.Room;
import logics.room.works.RoomFactoryImpl;

public class RandomRoomGenerator {

    public Room generateRoom(Player player) {
        RoomFactoryImpl roomFactory = new RoomFactoryImpl(player);
        int random = new Random().ints(0, roomFactory.getClass().getMethods().length).findAny().getAsInt();
        Room room = null;
        try {
            room = (Room) roomFactory.getClass().getDeclaredMethods()[random].invoke(roomFactory);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error during room generation");
        }
        return room;
    }

}
