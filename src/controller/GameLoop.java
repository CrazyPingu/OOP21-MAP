package controller;

public class GameLoop {

    private ActionFlag flag;
    private int currentAction;

    /**
     * Specify the type of action to apply to GameArea's chosen cell.
     * 
     * @param actionFlag : set the ActionFlag
     */
    public void setFlag(ActionFlag flag) {
        this.flag = flag;
        this.totalPanel.getGameArea().highlightCells(this.flag);
    }

    /**
     * 
     * @return the ActionFlag
     */
    public ActionFlag getFlag() {
        return this.flag;
    }
    
    public void decreaseAction() {
        this.currentAction--;
    }

    
   

}
