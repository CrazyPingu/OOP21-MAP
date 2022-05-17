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
     * @param totalpanel : panel that contains all the game screen
     */
    public ActionMenuController(TotalPanel totalpanel, PageController controller) {
        this.totalPanel = totalpanel;
        this.totalPanel.setActionMenu(new ActionMenu(controller, this));
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
     * Move the player to a new position
     */
    public void move(Pair<Integer, Integer> newpos) {
        this.totalPanel.getGameArea().moveGameObject(player.getPos(), newpos);
        this.decreaseAction();
    }

    /**
     * Skip to the next turn
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
    }
    
    /**
     * 
     * @return the ActionFlag
     */
    public ActionFlag getActionFlag() {
        return this.actionFlag;
    }
}
