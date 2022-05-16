package controller;

import view.game.TotalPanel;

public class ActionMenuController {

    private int currentActionNumber;
    private TotalPanel totalPanel;

    /**
     * 
     * @param totalpanel : panel that contains all the game screen
     */
    public ActionMenuController(TotalPanel totalpanel) {
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
    public void attack() {
        this.totalPanel.getGameArea().moveGameObject(null, null);
        this.decreaseAction();
    }

    /**
     * Move the player to a new position
     */
    public void move() {
        this.totalPanel.getGameArea().moveGameObject(null, null);
        ;
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
     * @param actionFlag choise of action.
     */
    public void setTypeOfActionFlag(ActionFlag actionFlag) {
        if (actionFlag.equals(ActionFlag.ATTACK)) {
            attack();
        } else if (actionFlag.equals(ActionFlag.MOVE)) {
            move();
        }

    }
}
