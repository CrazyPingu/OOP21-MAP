package view.game.action.ButtonsAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ActionMenuController;

public class MoveAction implements ActionListener {
    ActionMenuController menucontroller;

    /**
     * 
     * @param menucontroller : the ActionMenuController
     */
    public MoveAction(ActionMenuController menucontroller) {
        this.menucontroller = menucontroller;
    }

    /**
     * Call the move method in ActionMenuController
     */
    public void actionPerformed(ActionEvent e) {
        menucontroller.move();
    }

}
