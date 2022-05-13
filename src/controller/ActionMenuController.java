package controller;

import logics.room.works.Room;
import view.game.TotalPanel;

public class ActionMenuController {

    public ActionMenuController(Room room, TotalPanel totalpanel, int currentActionNumer, ActionFlag typeOfActionFlag) {

    }

    public void setInitialActionNumber() {

    }

    public void decreaseAction() {

    }

    public void attack() {

    }

    public void move() {

    }

    public void skip() {

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
