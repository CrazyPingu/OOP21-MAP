package controller;

import java.util.List;

import logics.game_object.entity.Player;
import logics.game_object.entity.SimpleEnemy;
import logics.room.works.Room;
import view.game.central.GameArea;

public class GameAreaController {
    
    Player player;
    
    public GameAreaController(ActionMenuController actionMenuController, Player player, List<SimpleEnemy> enemyList, GameArea gameArea) {
        this.player = player;
    }
    
    /**
     * create a new Room.
     */
    public Room newRoom() {
        return new RandomRoomGenerator().generateRoom(player);
        //così dovrebbe essere a posto
    }
    
    public void chosenAction() {
        
    }
    
    public void attackChoice() {
        
    }
    
    public void moveChoice() {
        
    }
    
    
}
