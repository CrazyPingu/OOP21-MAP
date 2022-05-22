package controller;

public class ActionMenuController {

    private final GameLoop gameLoop;

    public ActionMenuController(final GameLoop gameLoop) {
        this.gameLoop = gameLoop;
    }

    /**
     * Skip to the next action
     */
    public void skip() {
        this.gameLoop.skipTurn();
    }

    public void setAttack() {
        this.gameLoop.setFlag(ActionFlag.ATTACK);
    }

    public void setMove() {
        this.gameLoop.setFlag(ActionFlag.MOVE);
    }

}
