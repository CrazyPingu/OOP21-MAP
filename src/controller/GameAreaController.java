package controller;

import java.util.List;

import logics.game_object.entity.Player;
import logics.game_object.entity.SimpleEnemy;
import logics.room.works.Room;
import view.game.central.GameArea;

public class GameAreaController {
    
    private Player player;
    private ActionMenuController actionMenuController;
    private List <SimpleEnemy> enemyList;
    private GameArea gameArea;
    
    
    public GameAreaController(ActionMenuController actionMenuController, Player player, List<SimpleEnemy> enemyList, GameArea gameArea) {
        this.player = player;
        this.actionMenuController = actionMenuController;
        this.enemyList = enemyList;
        this.gameArea = gameArea;
    }
    
    /**
     * create a new Room.
     */
    public Room newRoom() {
        return new RandomRoomGenerator().generateRoom(player);
    }
    
    public void chosenAction() {
        
    }
    
    public void attackChoice() {
        
    }
    
    public void moveChoice() {
        
    }
    
    
}
