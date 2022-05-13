package controller;

import logics.room.works.Room;
import view.game.TotalPanel;

public class ActionMenuController {

    private int currentActionNumber;
    private TotalPanel totalPanel;

    public ActionMenuController(TotalPanel totalpanel) {
        this.totalPanel = totalpanel;
    }

    public void setActionNumber(int currentActionNumber) {
        this.currentActionNumber = currentActionNumber;
    }

    private void decreaseAction() {
        this.currentActionNumber--;
    }

    public void attack() {
        this.totalPanel.getGameArea();
        this.decreaseAction();
    }

    public void move() {

        this.decreaseAction();
    }

    public void skip() {
        this.decreaseAction();
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
