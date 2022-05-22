package view.game.action.action_button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ActionMenuController;

public class MoveAction implements ActionListener {
    ActionMenuController menucontroller;

    /**
     * 
     * @param menucontroller : the ActionMenuController
     * @param button
     */
    public MoveAction(final ActionMenuController menucontroller) {
        this.menucontroller = menucontroller;
    }

    /**
     * Call the move method in ActionMenuController
     */
    public void actionPerformed(final ActionEvent e) {
        this.menucontroller.setMove();
    }

}
