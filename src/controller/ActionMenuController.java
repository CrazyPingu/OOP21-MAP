package controller;

import logics.game_object.entity.Player;
import logics.game_object.entity.SimpleEnemy;
import logics.game_object.entity.enemy.EnemyFactoryImpl;
import utilities.Pair;
import utilities.RoomConstant;
import view.game.TotalPanel;
import view.game.action.ActionMenu;

public class ActionMenuController {

    private int currentActionNumber;
    private TotalPanel totalPanel;
    private Player player;
    private ActionFlag actionFlag;

    /**
     * 
     * @param totalpanel : add the totalpanel
     */
    public void setTotalPanel(TotalPanel totalpanel) {
        this.totalPanel = totalpanel;
    }

    /**
     * 
     * @param currentActionNumber : the current number of action available
     * 
     *                            Set the number of action available by the player
     */
    public void setActionNumber(int currentActionNumber) {
        this.currentActionNumber = currentActionNumber;
    }

    /**
     * Decrease the number of action available by the player
     */

    private void decreaseAction() {
        this.currentActionNumber--;
    }

    /**
     * Attack in a chosen cell by the user
     */
    public void attack(Pair<Integer, Integer> pos) {
        if (RoomConstant.searchEnemy(pos, this.totalPanel.getGameArea().getRoom().getEnemyList()) != null) {
            SimpleEnemy enemy = RoomConstant.searchEnemy(pos, this.totalPanel.getGameArea().getRoom().getEnemyList());
            enemy.damage(this.totalPanel.getGameArea().getRoom().getPlayer().getWeapon().getDamage());
        }
        this.decreaseAction();
    }

    /**
     * Move in a chosen cell by the user
     * 
     * @param newpos : the new position of the player
     */
    public void move(Pair<Integer, Integer> newpos) {
        if (RoomConstant.searchEnemy(newpos, this.totalPanel.getGameArea().getRoom().getEnemyList()) == null) {
            this.totalPanel.getGameArea().moveGameObject(player.getPos(), newpos);
            if (RoomConstant.searchArtefact(newpos,
                    this.totalPanel.getGameArea().getRoom().getArtefactList()) != null) {
                RoomConstant.searchArtefact(newpos, this.totalPanel.getGameArea().getRoom().getArtefactList())
                        .execute(player);
            }
        }
        this.decreaseAction();
    }

    /**
     * Skip to the next action
     */
    public void skip() {
        this.decreaseAction();
    }

    /**
     * 
     * @return the number of action available by the player
     */
    public int getCurrentActionNumber() {
        return this.currentActionNumber;
    }

    /**
     * Specify the type of action to apply to GameArea's chosen cell.
     * 
     * @param actionFlag : set the ActionFlag
     */
    public void setActionFlag(ActionFlag actionFlag) {
        this.actionFlag = actionFlag;
        this.totalPanel.getGameArea().highlightCells(this.actionFlag);
    }

    /**
     * 
     * @return the ActionFlag
     */
    public ActionFlag getActionFlag() {
        return this.actionFlag;
    }
}
