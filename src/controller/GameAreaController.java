package controller;

import java.util.List;

import logics.game_object.entity.Player;
import logics.game_object.entity.SimpleEnemy;
import logics.room.works.Room;
import utilities.Pair;
import utilities.RoomConstant;
import view.game.central.GameArea;

public class GameAreaController {
    
    private Player player;
    private ActionMenuController actionMenuController;
    private List <SimpleEnemy> enemyList;
    private GameArea gameArea;
    private GameLoop loop;
    
    
    public GameAreaController(GameLoop loop,GameArea gameArea) {
        this.loop = loop;
        this.gameArea = gameArea;
    }
    
    /**
     * create a new Room.
     */
    public Room newRoom() {
        return new RandomRoomGenerator().generateRoom(player);
    }
    
    /**
     * 
     * @param pos : the position of the pressed cell
     */
    public void makeAction(Pair <Integer,Integer> pos) {
        if (this.loop.getFlag().equals(ActionFlag.ATTACK)) {
            this.attack(pos);
        }else if (this.loop.getFlag().equals(ActionFlag.MOVE)) {
            this.move(pos);
        }
    }
    
    /**
     * Attack in a chosen cell by the user
     */
    private void attack(Pair<Integer, Integer> pos) {
        if (RoomConstant.searchEnemy(pos, this.gameArea.getRoom().getEnemyList()) != null) {
            SimpleEnemy enemy = RoomConstant.searchEnemy(pos, this.gameArea.getRoom().getEnemyList());
            enemy.damage(this.gameArea.getRoom().getPlayer().getWeapon().getDamage());
        }
        loop.decreaseAction();
    }

    /**
     * Move in a chosen cell by the user
     * 
     * @param newpos : the new position of the player
     */
    private void move(Pair<Integer, Integer> newpos) {
        if (RoomConstant.searchEnemy(newpos, this.gameArea.getRoom().getEnemyList()) == null) {
            this.gameArea.moveGameObject(player.getPos(), newpos);
            if (RoomConstant.searchArtefact(newpos,
                    this.gameArea.getRoom().getArtefactList()) != null) {
                RoomConstant.searchArtefact(newpos, this.gameArea.getRoom().getArtefactList())
                        .execute(player);
            }
        }
        loop.decreaseAction();
    }
    
    
}
