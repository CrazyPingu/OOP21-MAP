package controller;

import controller.gameController.GameController;

public class ActionMenuController {

    private GameController controller;

    public ActionMenuController(GameController controller) {
        this.controller = controller;
    }

    /**
     * Skip to the next action
     */
    public void skip() {
        this.controller.skipTurn();
    }
    
    public void setAttack() {
        this.controller.setFlag(ActionFlag.ATTACK);
    }
    
    public void setMove() {
        this.controller.setFlag(ActionFlag.MOVE);
    }


}
