package controller;


public class ActionMenuController {

    private GameLoop loop;

    public ActionMenuController(GameLoop loop) {
        this.loop = loop;
    }

    /**
     * Skip to the next action
     */
    public void skip() {
        loop.skipTurn();
    }
    
    public void setAttack() {
        loop.setFlag(ActionFlag.ATTACK);
    }
    
    public void setMove() {
        loop.setFlag(ActionFlag.MOVE);
    }


}
